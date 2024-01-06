import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class Randevu {
    static Scanner tarayici=new Scanner(System.in);
    private int ID;
    public static int farkliID=0;//Oluşturulan her Randevunun ID'sinin farklı olması için bu değişkeni oluşturdum.Her oluşturulan randevuda değer önce o an oluşturulan randevu nesnesine aktarılacak sonrasında ise değer arttırılacak.Static tanımladığım için de tekrar sıfırlanmadan ya da sabit kalmadan değerini arttırabileceğim.
    private String randevuTarihi;
    private Doktor doktor;
    private  Hasta hasta;

    //private  String birimAdi; // Bu değişken eklenerek her oluşturulan randevunun hangi birimie ait olduğu bilinebilecek bu sayede dolulluk oranı heasabı için kullanılabilecek

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

    /*public void setBirimAdi(String birimAdi) {
        this.birimAdi = birimAdi;
    }

    public String getBirimAdi() {
        return birimAdi;
    }*/

    public void setHasta(Hasta hasta) {
        this.hasta = hasta;
    }


    public static void randevuOlustur(){
        Randevu yeniRandevu=new Randevu();
        int doktorID = 0;

        //Randevuya hastanın atanması:
        String TCNO;
        while(true){
            while(true){
                System.out.print("TC Kimlik Numaranızı giriniz:");
                TCNO=tarayici.nextLine();
                if(TCNO.length() != 11){
                    System.out.println("TC Kimlik Numaranısı 11 haneden oluşmalı.");
                }
                else{
                    break;
                }
            }

            boolean flag4=false;
            for(int i=0;i<Hasta.hastaListesi.size();i++){
                if(Hasta.hastaListesi.get(i).TC.equals(TCNO)){
                    //Randevu randevu = new Randevu();
                    //randevu.setBirimAdi(birimAdi);
                    //Birim.birimListesi.get(i).birimdekiDoktorlarinListesi.size()
                    yeniRandevu.setHasta(Hasta.hastaListesi.get(i));
                    flag4=true;
                }
            }
            if(flag4){
                System.out.println("Randevuya atandınız.");
                break;
            }
            else{
                System.out.println("Girmiş olduğunuz TC Kimlik Numarasıyla kayıtlı hasta bulunmamaktadır.");
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
            String secim = tarayici.next();
            switch (secim){
                case "1":
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
                case "2":
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

            // Hatalı giriş kontrolü (Tuna)
            while (true){
                try {
                    doktorID = tarayici.nextInt();

                } catch (InputMismatchException e) {
                    System.out.println("Hatalı giriş yaptınız. Lütfen tekrar deneyiniz.");
                    tarayici.nextLine();
                    continue;
                }
                break;
            }

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
        yeniRandevu.randevuBilgileriYazdir();
        randevuListesi.add(yeniRandevu);
    }

    public void randevuBilgileriYazdir(){
        System.out.println("==============================================");
        System.out.println("Randevu bilgileriniz aşağıdaki gibidir:");
        System.out.println("Randevu ID:"+ID+"\nRandevu Tarihi ve Saati:"+randevuTarihi+"\nDoktor:"+doktor.isim+" "+doktor.soyisim+"\nHasta:"+hasta.isim+" "+hasta.soyisim);
        System.out.println("==============================================");

    }

    public static void tarihBelirle(Randevu yeniRandevu){
        //Randevu Tarihinin kullanıcı tarafından belirlenmesi:
        int gun=0,ay=0,yil=0;
        String tarih="";
        boolean tarihDogruMu=true;
        boolean formatDogruMu=true;
        Calendar bugun=new GregorianCalendar();
        while(tarihDogruMu){
            while(formatDogruMu){
                System.out.print("Randevu tarihini giriniz (gün ay yıl):");

                while (true){
                    try{
                        gun= tarayici.nextInt();
                    } catch (InputMismatchException e) {
                        System.out.println("Hatalı giriş yaptınız. Lütfen tekrar deneyiniz.");
                        tarayici.nextLine();
                        continue;
                    }
                    break;
                }

                while (true){
                    try{
                        ay= tarayici.nextInt();
                    } catch (InputMismatchException e) {
                        System.out.println("Hatalı giriş yaptınız. Lütfen tekrar deneyiniz.");
                        tarayici.nextLine();
                        continue;
                    }
                    break;
                }

                while (true){
                    try{
                        yil= tarayici.nextInt();
                    } catch (InputMismatchException e) {
                        System.out.println("Hatalı giriş yaptınız. Lütfen tekrar deneyiniz.");
                        tarayici.nextLine();
                        continue;
                    }
                    break;
                }

                if(gun<1 || gun>31){
                    System.out.println("Gün bilgisi 1-31 arasında olmalı.");
                }
                else if(ay<0 || ay>12){
                    System.out.println("Ay bilgisi 1-12 arasında olmalı.");
                }
                else if(yil<bugun.getTime().getYear()+1900){
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
