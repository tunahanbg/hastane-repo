import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

public class Randevu {
    static Scanner tarayici=new Scanner(System.in);
    private int ID;
    public static int farkliID=0;//Oluşturulan her Randevunun ID'sinin farklı olması için bu değişkeni oluşturdum.Her oluşturulan randevuda değer önce o an oluşturulan randevu nesnesine aktarılacak sonrasında ise değer arttırılacak.Static tanımladığım için de tekrar sıfırlanmadan ya da sabit kalmadan değerini arttırabileceğim.
    private String randevuTarihi;
    private Doktor doktor;
    private  Hasta hasta;
    public static ArrayList<Randevu> randevuListesi=new ArrayList<Randevu>();

    //Bu constructor'ı bizim önceden oluşturduğumuz veriler için oluşturdum.
    public Randevu(Doktor doktor, Hasta hasta) {
        this.doktor = doktor;
        this.hasta = hasta;
        this.ID=farkliID;//veya farkliID++
        farkliID++;
    }

    public Randevu(){
        this.ID=farkliID;
        farkliID++;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public Doktor getDoktor() {
        return doktor;
    }

    public void setDoktor(Doktor doktor) {
        this.doktor = doktor;
    }

    public String getRandevuTarihi() {
        return randevuTarihi;
    }

    public void setRandevuTarihi(String randevuTarihi) {
        this.randevuTarihi=randevuTarihi;
    }

    public Hasta getHasta() {
        return hasta;
    }

    public void setHasta(Hasta hasta) {
        this.hasta = hasta;
    }

    public static void randevuOlustur(){
        Randevu yeniRandevu=new Randevu();
        //Randevuya hastanın atanması:
        while(true){
            System.out.print("TC Kimlik Numaranızı giriniz:");
            String TCNO=tarayici.nextLine();
            boolean flag4=false;
            for(int i=0;i<Hasta.hastaListesi.size();i++){
                if(Hasta.hastaListesi.get(i).TC.equals(TCNO)){
                    yeniRandevu.setHasta(Hasta.hastaListesi.get(i));
                    flag4=true;
                }
            }
            if(flag4){
                System.out.println("Randevuya atandınız.");
                break;
            }
            else{
                System.out.println("TC Kimlik Numaranızı yanlış girdiniz.");
            }
        }

        //Hastanın istediği doktoru seçmesi:

        String birimSecim="";
        boolean flag=true;
        while(flag){
            System.out.println("Doktorları görüntüleme seçenekleri:");
            System.out.println("1-Belirli birime ait doktorları görüntüle");
            System.out.println("2-Tüm doktorları görüntüle");
            System.out.print("Seçiminiz:");
            int secim=tarayici.nextInt();
            switch (secim){
                case 1:
                    System.out.println("Birimler:");
                    System.out.println("1-Pediatri\n2-Üroloji\n3-Ortopedi\n4-Kardiyoloji\n5-Nöroloji\n6-Dahiliye\n7-Cerrahi");
                    System.out.print("Seçtiğiniz birimin ismi:");
                    birimSecim=tarayici.next();
                    for(int i=0;i<Birim.birimListesi.size();i++){
                        if(Birim.birimListesi.get(i).getIsim().equals(birimSecim)){
                            for(int j=0;j<Birim.birimListesi.get(i).birimdekiDoktorlarinListesi.size();j++){
                                System.out.println(Birim.birimListesi.get(i).birimdekiDoktorlarinListesi.get(j).id+" "+Birim.birimListesi.get(i).birimdekiDoktorlarinListesi.get(j).isim+" "+Birim.birimListesi.get(i).birimdekiDoktorlarinListesi.get(j).soyisim);
                            }
                            break;
                        }
                    }
                    flag=false;
                    break;
                case 2:
                    for (int i=0;i<Doktor.doktorListesi.size();i++){
                        System.out.println(Doktor.doktorListesi.get(i).id+" "+Doktor.doktorListesi.get(i).isim+" "+Doktor.doktorListesi.get(i).soyisim);
                    }
                    flag=false;
                    break;
                default:
                    System.out.println("Yanlış seçim yaptınız.");
                    break;
            }
        }

        boolean flag2=true;
        boolean flag3=false;//id'lerin eşleştiğini kontrol etmek için koyduğum flag
        while(flag2){
            System.out.println("Randevuyu almak istediğiniz doktorun ID bilgisini giriniz:");
            int doktorID= tarayici.nextInt();
            for (int i=0;i<Doktor.doktorListesi.size();i++){
                if (Doktor.doktorListesi.get(i).id==doktorID){
                    yeniRandevu.setDoktor(Doktor.doktorListesi.get(i));
                    for(int j=0;j<Birim.birimListesi.size();j++){
                        if(birimSecim.equals(Birim.birimListesi.get(j).getIsim())){
                            Birim.birimListesi.get(j).birimeAitHastaListesi.add(yeniRandevu.getHasta());
                        }
                    }
                    flag2=false;
                    flag3=true;
                }
            }
            if(flag3){
                System.out.println("Seçtiğiniz doktor randevuya atandı.");
            }
            else{
                System.out.println("Girmiş olduğunuz ID herhangi bir doktorla eşleşmedi.");
            }
        }

        tarihBelirle(yeniRandevu);

        randevuListesi.add(yeniRandevu);
    }

    public void randevuBilgileriYazdir(){
        System.out.println("Randevu ID:"+ID+"\nRandevu Tarihi ve Saati:"+randevuTarihi+"\nDoktor:"+doktor.isim+" "+doktor.soyisim+"\nHasta:"+hasta.isim+" "+hasta.soyisim);
    }

    public static void tarihBelirle(Randevu yeniRandevu){
        //Randevu Tarihinin kullanıcı tarafından belirlenmesi:
        int gun=0,ay=0,yil=0;
        String tarih="";
        boolean tarihDogruMu=true;
        boolean formatDogruMu=true;
        while(tarihDogruMu){
            while(formatDogruMu){
                System.out.print("Randevu tarihini giriniz (gün ay yıl):");
                gun= tarayici.nextInt();
                ay= tarayici.nextInt();
                yil= tarayici.nextInt();
                if(gun<1 || gun>31){
                    System.out.println("Gün bilgisi 1-31 arasında olmalı.");
                }
                else if(ay<0 || ay>12){
                    System.out.println("Ay bilgisi 1-12 arasında olmalı.");
                }
                else if(yil<2024){
                    System.out.println("Geçmişte bir tarihe randevu alamazsınız.");
                }
                else{
                    tarih=(gun+" "+ay+" "+yil);
                    formatDogruMu=false;
                }
            }

            boolean ayniTarihVarMi=false;
            for(int i=0;i<randevuListesi.size();i++){
                if(randevuListesi.get(i).randevuTarihi.equals(tarih)){
                    System.out.println("Aynı tarihte zaten bir randevu tanımlanmış, lütfen başka bir tarihe randevu alınız.");
                    ayniTarihVarMi=true;
                    formatDogruMu=true;
                }
            }

            if (!ayniTarihVarMi){
                yeniRandevu.setRandevuTarihi(tarih);
                System.out.println("Tarih ataması yapıldı.");
                randevuListesi.add(yeniRandevu);
                tarihDogruMu=false;
            }

        }



    }
}
