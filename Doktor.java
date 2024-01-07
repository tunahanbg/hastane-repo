import java.io.*;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Doktor extends AbsractKisi {
    Scanner tarayici = new Scanner(System.in);
    Hasta hasta = new Hasta();
    public static int farkliID = 0;

    public static ArrayList<Doktor> doktorListesi=new ArrayList<Doktor>();
    //Her nesnenin bir doktor listesine sahip olması saçma olurdu.Doktor listesi nesneden bağımsız sınıfa ait yani static olarak tanımlandığında her değişikliği yansıtacaktır.public tanımlamamın nedeni ise Yönetim sınıfının da operasyonlarında bu listeye erişimini sağlayabilmek.

    public Doktor(String isim,String soyisim,String TC, int maas) {
        this.isim=isim;
        this.soyisim=soyisim;
        this.TC=TC;
        this.id=++farkliID;
        this.maas = maas;
        //Yukarıda "this." ile ulaştığımız alanlar aslında kalıtım aldığımız AbstractKisi sınıfındaki alanları işaret eder, referans gösterir.
        //Aşağıdaki kodda ise oluşturduğumuz Doktor nesnesini doktorListesi arraylistine ekliyoruz.Burada this yeni oluşturduğumuz Doktor nesnesini referans ediyor.
        doktorListesi.add(this);
    }

    //Reçete yazma işlemlerinde TC ile eşleşen doktoru atamak için bu constructorı kurdum.Diğer constructor kullanılırsa aynı doktoru listeye tekrar ekler.(MBB)
    public Doktor(){}


    public void hastaGoruntule(){
        System.out.println("|——————————————————————————————————————————————|");
        for(int i=0;i<Hasta.hastaListesi.size();i++){
            System.out.println(Hasta.hastaListesi.get(i).id+"-) " + "Hastanın İsmi: " + Hasta.hastaListesi.get(i).isim + " | " + "Hastanın Soyismi: " + Hasta.hastaListesi.get(i).soyisim + " | " + "Hastanın TC'si:" + Hasta.hastaListesi.get(i).TC);
        }
        System.out.println("|——————————————————————————————————————————————|");
    }

    public void hastaSecimIslemi(int hastaID){
        for(int i = 0; i < Hasta.hastaListesi.size(); i++){
            if(Hasta.hastaListesi.get(i).id == hastaID){
                this.hasta = Hasta.hastaListesi.get(i);
            }
        }
    }

    //Reçeteyi hangi hastaya yazacağını hasta id'si ile karar versin, Randeveu görüntüle kısmından veya tüm hastaları görüntüleyerek hasta id'sine ulaşabiliriz.
    public void receteYaz(){

        int hastaID;

        while(true){

            System.out.print("Reçete yazmak istediğiniz hastanın id'si:");

            try {
                hastaID = tarayici.nextInt();
            }
            catch (InputMismatchException e){
                System.out.println("Hatalı giriş yaptınız. Lütfen tekrar deneyiniz.");
                tarayici.nextLine();
                continue;
            }
            break;
        }

        System.out.print("Reçete: ");
        tarayici.nextLine();
        String recete = tarayici.nextLine();
        String metinDosyasiAdi = "";

        for(int i = 0; i < Hasta.hastaListesi.size(); i++){
            if(Hasta.hastaListesi.get(i).id == hastaID){
                metinDosyasiAdi = Hasta.hastaListesi.get(i).isim + " " + Hasta.hastaListesi.get(i).soyisim + ".txt";
            }
        }

        ArrayList<String> hastaninIlaclari = receteIslemleri(hastaID);
        String yazilanIlaclar="";
        for (int i=0;i<hastaninIlaclari.size();i++){
            yazilanIlaclar=(yazilanIlaclar+" "+hastaninIlaclari.get(i)+" ");
        }
        recete=(recete + " —> " + "Yazılan İlaçlar: "+yazilanIlaclar);

        //String dosyaYolu = "C:\\Users\\mahfu\\IdeaProjects\\hastane-repo\\out" + metinDosyasiAdi;
        String dosyaYolu = "/Users/tunahanbg/Documents/GitHub/hastane-repo/out" + metinDosyasiAdi;

        try{
            File dosya = new File(dosyaYolu);
            if(!dosya.exists()){
                dosya.createNewFile();
                System.out.println("Reçete oluşturuldu.");
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

        int userChoice;

        while (true){
            System.out.println("|——————————————————————————————————————————————|");
            System.out.println("Hangi Katagorideki İlaçdan Seçim Yapmak istersiniz?");
            System.out.println("1-) A Katagorisi\n2-) B Katagorisi\n3-) C Katagorisi\n4-) D Katagorisi");
            System.out.println("|——————————————————————————————————————————————|");

            try {
                userChoice = userInput.nextInt();

            } catch (InputMismatchException e) {
                System.out.println("Hatalı giriş yaptınız. Lütfen tekrar deneyiniz.");
                userInput.nextLine();
                continue;
            }
            break;
        }

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

    public void recetedenIlacSil(String silinecekIlac){
        if(hasta.recetedekiIlaclar.contains(silinecekIlac)){
            for (int i = 0; i < hasta.recetedekiIlaclar.size(); i++){
                if(silinecekIlac.equals(hasta.recetedekiIlaclar.get(i))){
                    hasta.recetedekiIlaclar.remove(i);
                }
            }
            System.out.println("İlaç başarıyla silinmiştir.");
        }

        else {
            System.out.println("Yazdığınız ilaç reçetede bulunmuyor.");
        }
    }

    public void recetedekiIlaclariGoruntule(){

        if (hasta.recetedekiIlaclar.isEmpty()){
            System.out.println("Reçetede herhangi bir ilaç bulunmamaktadır.");
        }

        else {
            for (int i = 0; i < hasta.recetedekiIlaclar.size(); i++){
                System.out.println("—> " + hasta.recetedekiIlaclar.get(i));
            }
        }
    }

    public ArrayList<String> receteIslemleri(int hastaID){
        Scanner userInput = new Scanner(System.in);

        hastaSecimIslemi(hastaID);

        int userChoice;
        boolean flag = true;

        while (flag){

            while (true){
                System.out.println("|——————————————————————————————————————————————————|");
                System.out.println("Yapmak İstediğiniz İşlemi Giriniz:");
                System.out.println("1-) İlaçları Görüntüle");
                System.out.println("2-) İlaç Yaz");
                System.out.println("3-) Reçeteye Yazılan İlaçları Görüntüle");
                System.out.println("4-) Yan Etkileri Kontrol Et");
                System.out.println("5-) Reçeteden İlaç Sil");
                System.out.println("6-) Çıkış");
                System.out.println("|——————————————————————————————————————————————————|");

                try {
                    userChoice = userInput.nextInt();
                }

                catch (InputMismatchException e) {
                    System.out.println("Hatalı giriş yaptınız. Lütfen tekrar deneyiniz.");
                    userInput.nextLine();
                    continue;
                }
                break;
            }

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
                    recetedekiIlaclariGoruntule();
                    System.out.println("|==================================================|");
                    continue;

                case 4:
                    yanEtkiKontrolu();
                    continue;

                case 5:
                    System.out.println("Reçeteden silmek istediğiniz ilacın ismini giriniz.");
                    String silinecekIlac = userInput.next();
                    recetedenIlacSil(silinecekIlac);
                    continue;

                case 6:
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
}
