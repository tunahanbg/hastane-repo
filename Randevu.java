import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class Randevu {
    static Scanner tarayici=new Scanner(System.in);
    private int ID;
    public static int farkliID=0;//Oluşturulan her Randevunun ID'sinin farklı olması için bu değişkeni oluşturdum.Her oluşturulan randevuda değer önce o an oluşturulan randevu nesnesine aktarılacak sonrasında ise değer arttırılacak.Static tanımladığım için de tekrar sıfırlanmadan ya da sabit kalmadan değerini arttırabileceğim.
    private Date randevuTarihi=new Date();
    private Doktor doktor;
    private  Hasta hasta;

    //private  String birimAdi; // Bu değişken eklenerek her oluşturulan randevunun hangi birimie ait olduğu bilinebilecek bu sayede dolulluk oranı heasabı için kullanılabilecek

    public static ArrayList<Randevu> randevuListesi=new ArrayList<Randevu>();

    //Bu constructor'ı bizim önceden oluşturduğumuz veriler için oluşturdum.
    public Randevu(Date randevuTarihi,Doktor doktor, Hasta hasta) {
        this.randevuTarihi=randevuTarihi;
        this.doktor = doktor;
        this.hasta = hasta;
        this.ID=farkliID;
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

    public Date getRandevuTarihi() {
        return randevuTarihi;
    }

    public void setRandevuTarihi(Date randevuTarihi) {
        this.randevuTarihi = randevuTarihi;
    }

    public Doktor getDoktor() {
        return doktor;
    }

    public void setDoktor(Doktor doktor) {
        this.doktor = doktor;
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

    public void randevuOlustur(){
        Randevu yeniRandevu=new Randevu();
        //Randevuya hastanın atanması:
        while(true){
            System.out.print("TC Kimlik Numaranızı giriniz:");
            String TCNO=tarayici.nextLine();
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
                System.out.println("TC Kimlik Numaranızı yanlış girdiniz.");
            }
        }

        //Randevu Tarihinin kullanıcı tarafından belirlenmesi:
        System.out.print("Randevu almak istediğiniz tarihi giriniz (gg aa yyyy):");
        int gun=tarayici.nextInt();
        int ay=tarayici.nextInt();
        int yil=tarayici.nextInt();
        System.out.print("Randevu almak istediğiniz saati giriniz (ss dd):");
        int saat=tarayici.nextInt();
        int dakika=tarayici.nextInt();
        yeniRandevu.randevuTarihi.setTime(new Date(yil,ay,gun,saat,dakika).getTime());
        yeniRandevu.randevuTarihi.setYear(yeniRandevu.randevuTarihi.getYear()-1900);//SimpleDateFormat sınıfının format() yöntemi, tarih değerini yazdırırken, tarih değerinin yıl bölümünü 1900'den itibaren saymaya başladığı için 1900 çıkarıyorum.

        //Hastanın istediği doktoru seçmesi:

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
                    String birimSecim=tarayici.next();
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

        randevuListesi.add(yeniRandevu);
    }

    public void randevuBilgileriYazdir(){
        System.out.println("Randevu ID:"+ID+"\nRandevu Tarihi ve Saati:"+randevuTarihi+"\nDoktor:"+doktor.isim+" "+doktor.soyisim+"\nHasta:"+hasta.isim+" "+hasta.soyisim);
    }
}
