import javax.imageio.IIOException;
import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Doktor extends AbsractKisi implements IHemsireAlabilenler{
    Scanner tarayici=new Scanner(System.in);

    Hasta hasta = new Hasta();
    public static int farkliID=0;

    public static ArrayList<Doktor> doktorListesi=new ArrayList<Doktor>();
    //Her nesnenin bir doktor listesine sahip olması saçma olurdu.Doktor listesi nesneden bağımsız sınıfa ait yani static olarak tanımlandığında her değişikliği yansıtacaktır.public tanımlamamın nedeni ise Yönetim sınıfının da operasyonlarında bu listeye erişimini sağlayabilmek.

    public Doktor(String isim,String soyisim,String TC,String dogumTarihi,String telefonNo,String dogumYeri) {
        this.isim=isim;
        this.soyisim=soyisim;
        this.TC=TC;
        this.dogumTarihi=dogumTarihi;
        this.id=++farkliID;
        this.telefonNo=telefonNo;
        this.dogumYeri=dogumYeri;
        //Yukarıda "this." ile ulaştığımız alanlar aslında kalıtım aldığımız AbstractKisi sınıfındaki alanları işaret eder, referans gösterir.
        //Aşağıdaki kodda ise oluşturduğumuz Doktor nesnesini doktorListesi arraylistine ekliyoruz.Burada this yeni oluşturduğumuz Doktor nesnesini referans ediyor.
        doktorListesi.add(this);
    }

    //Encapsulation(Kapsülleme)

    public void hastaGoruntule(){
        for(int i=0;i<Hasta.hastaListesi.size();i++){
            System.out.println(Hasta.hastaListesi.get(i).id+"-"+" Hastanın İsmi:"+Hasta.hastaListesi.get(i).isim+" Hastanın Soyismi"+Hasta.hastaListesi.get(i).soyisim+" Hastanın TC'si:"+Hasta.hastaListesi.get(i).TC);
        }
    }

    //Reçeteyi hangi hastaya yazacağını hasta id'si ile karar versin, Randeveu görüntüle kısmından veya tüm hastaları görüntüleyerek hasta id'sine ulaşabiliriz.
    public void receteYaz(){

        System.out.print("Reçete yazmak istediğiniz hastanın id'si:");
        int hastaID = tarayici.nextInt();

        System.out.print("Reçete:");
        String recete = tarayici.nextLine();
        String metinDosyasiAdi = "";

        for(int i = 0; i < Hasta.hastaListesi.size(); i++){
            if(Hasta.hastaListesi.get(i).id == hastaID){
                metinDosyasiAdi = Hasta.hastaListesi.get(i).isim + " " + Hasta.hastaListesi.get(i).soyisim + ".txt";
            }
        }

        ArrayList<String> hastaninIlaclari=receteIslemleri(hastaID);
        String yazilanIlaclar="";
        for (int i=0;i<hastaninIlaclari.size();i++){
            yazilanIlaclar=(yazilanIlaclar+" "+hastaninIlaclari.get(i)+" ");
        }
        recete=(recete+" Yazılan İlaçlar: "+yazilanIlaclar);

        String dosyaYolu = "C:\\Users\\mahfu\\IdeaProjects\\hastane-repo\\out\\" + metinDosyasiAdi;

        try{
            File dosya = new File(dosyaYolu);
            if(!dosya.exists()){
                dosya.createNewFile();
            }
        }
        catch (IOException e){
            e.printStackTrace();
        }

        PrintWriter yazici = null;

        try{
            yazici = new PrintWriter(new FileWriter(dosyaYolu,true));
            yazici.println(recete);
            yazici.close();
        }
        catch (FileNotFoundException e){
            System.out.println("Dosya oluşturulurken hata oluştu.");
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }


    public void aIlaciEkle(String userChoice){

        for (String a : Ilaclar.aKatagorisiIlaclariList) {
            if (a.equals(userChoice)) {
                hasta.recetedekiIlaclar.add(userChoice);
            }
        }
    }

    public void bIlaciEkle(String userChoice){

        for (String b : Ilaclar.bKatagorisiIlaclariList) {
            if (b.equals(userChoice)) {
                hasta.recetedekiIlaclar.add(userChoice);
            }
        }
    }

    public void cIlaciEkle(String userChoice){

        for (String c : Ilaclar.cKatagorisiIlaclariList) {
            if (c.equals(userChoice)) {
                hasta.recetedekiIlaclar.add(userChoice);
            }
        }
    }

    public void dIlaciEkle(String userChoice){

        for (String s : Ilaclar.dKatagorisiIlaclariList) {
            if (s.equals(userChoice)) {
                hasta.recetedekiIlaclar.add(userChoice);
            }
        }
    }

    public void receteyeIlacYaz(){
        Scanner userInput = new Scanner(System.in);

        System.out.println("Hangi Katagorideki İlaçdan Seçim Yapmak istersiniz?");
        System.out.println("1-) A Katagorisi\n2-) B Katagorisi\n3-) C Katagorisi\n4-) D Katagorisi");

        int userChoice = userInput.nextInt();

        boolean flag = true;

        while (flag){
            switch (userChoice){

                case 1:
                    System.out.println("İlaç ismini giriniz: ");
                    String ilacSecimi = userInput.next();

                    if (Ilaclar.aKatagorisiIlaclariList.contains(ilacSecimi)){
                        aIlaciEkle(ilacSecimi);
                        System.out.println("İlaç reçeteye başarıyla eklenmiştir.");
                        flag = false;
                        break;
                    }

                    else {
                        System.out.println("Hatalı ilaç ismi girdiniz. Lütfen tekrar deneyiniz.");
                        continue;
                    }


                case 2:
                    System.out.println("İlaç ismini giriniz: ");
                    String ilacSecimi1 = userInput.next();

                    if (Ilaclar.bKatagorisiIlaclariList.contains(ilacSecimi1)){
                        bIlaciEkle(ilacSecimi1);
                        System.out.println("İlaç reçeteye başarıyla eklenmiştir.");
                        flag = false;
                        break;
                    }

                    else {
                        System.out.println("Hatalı ilaç ismi girdiniz. Lütfen tekrar deneyiniz.");
                        continue;
                    }


                case 3:
                    System.out.println("İlaç ismini giriniz: ");
                    String ilacSecimi2 = userInput.next();

                    if (Ilaclar.cKatagorisiIlaclariList.contains(ilacSecimi2)){
                        cIlaciEkle(ilacSecimi2);
                        System.out.println("İlaç reçeteye başarıyla eklenmiştir.");
                        flag = false;
                        break;
                    }

                    else {
                        System.out.println("Hatalı ilaç ismi girdiniz. Lütfen tekrar deneyiniz.");
                        continue;
                    }


                case 4:
                    System.out.println("İlaç ismini giriniz: ");
                    String ilacSecimi3 = userInput.next();

                    if (Ilaclar.dKatagorisiIlaclariList.contains(ilacSecimi3)){
                        dIlaciEkle(ilacSecimi3);
                        System.out.println("İlaç reçeteye başarıyla eklenmiştir.");
                        flag = false;
                        break;
                    }

                    else {
                        System.out.println("Hatalı ilaç ismi girdiniz. Lütfen tekrar deneyiniz.");
                        continue;
                    }

                default:
                    System.out.println("Hatalı giriş yaptınız. Lütfen tekrar deneyin.");
                    break;
            }
        }
    }

    public ArrayList<String> receteIslemleri(int hastaID){
        Scanner userInput = new Scanner(System.in);

        hastaSecimIslemi(hastaID);

        boolean flag = true;

        while (flag){

            System.out.println("|——————————————————————————————————————————————————|");
            System.out.println("Yapmak İstediğiniz İşlemi Giriniz:");
            System.out.println("1-) İlaçları Görüntüle");
            System.out.println("2-) İlaç Yaz");
            System.out.println("3-) Reçeteye Yazılan İlaçları Görüntüle");
            System.out.println("4-) Yan Etkileri Kontrol Et");
            System.out.println("5-) Çıkış");
            System.out.println("|——————————————————————————————————————————————————|");

            int userChoice = userInput.nextInt();

            switch (userChoice){
                case 1:
                    Ilaclar.ilaclariGoruntule();
                    continue;

                case 2:
                    System.out.println("|——————————————————————————————————————————————————|");
                    receteyeIlacYaz();
                    System.out.println("|——————————————————————————————————————————————————|");
                    continue;

                case 3:
                    System.out.println("|==================================================|");
                    for (int i = 0; i < hasta.recetedekiIlaclar.size(); i++){
                        System.out.println("—> " + hasta.recetedekiIlaclar.get(i));
                    }
                    System.out.println("|==================================================|");
                    continue;

                case 4:
                    yanEtkiKontrolu();
                    continue;

                case 5:
                    flag = false;
                    break;

                default:
                    System.out.println("Hatalı giriş yaptınız. Lütfen tekrar deneyiniz.");
                    break;
            }
        }
        return hasta.recetedekiIlaclar;
    }

    public void yanEtkiKontrolu(){

        int sayacA = 0;
        int sayacB = 0;
        int sayacC = 0;
        int sayacD = 0;

        for (int j = 1; j < 16; j++){

            // A ve B varsa yan etki kontrolü
            if (hasta.recetedekiIlaclar.contains("aIlaci" + j)){
                sayacA++;
            }

            if (hasta.recetedekiIlaclar.contains("bIlaci" + j )) {
                sayacB++;
            }

            if (hasta.recetedekiIlaclar.contains("cIlaci" + j )) {
                sayacC++;
            }

            if (hasta.recetedekiIlaclar.contains("dIlaci" + j )) {
                sayacD++;
            }
        }

        if (sayacA != 0 && sayacB != 0){
            System.out.println("A ve B ilaçları birlikte kullanılırsa ciltte kızarıklık yapabilir. ");
        }

        if (sayacA != 0 && sayacD != 0){
            System.out.println("A ve D ilaçları birlikte kullanılırsa uyku düzeninizi kötü etkileyebilir. ");
        }

        if (sayacC != 0 && sayacD != 0){
            System.out.println("C ve D ilaçları birlikte kullanılırsa mide bulantısı yapabilir. ");
        }

        else {
            System.out.println("Yan etki oluşturacak herhangi bir durum yoktur.");
        }
    }

    public void hastaSecimIslemi(int hastaID){
        int secilenHastaId = hastaID;

        for(int i = 0; i < Hasta.hastaListesi.size(); i++){
            if(Hasta.hastaListesi.get(i).id == secilenHastaId){
                this.hasta = Hasta.hastaListesi.get(i);
            }
        }
    }
}
