import java.io.*;
import java.util.*;

public class YoneticiPaneli implements GoruntulemeIslemleri{
    static Scanner tarayici = new Scanner(System.in);

    public static void hastaFonksiyonlariYonetimi() {


        System.out.println("Hasta Yönetim İşlemlerine Hoşgeldiniz. Yapmak istediğinizişlemi seçiniz :");
        System.out.println(" 1: Hasta Ekle");
        System.out.println(" 2: Hasta Sil");
        System.out.println(" 3: Hastanın Değerlendirme Formunu Yazdırma");

        String yapilmakIstenenI = tarayici.next();
        switch (yapilmakIstenenI){
            case "1":YoneticiPaneli.hastaEkle();
                break;
            case "2":YoneticiPaneli.hastaSil();
                break;
            case "3":YoneticiPaneli.hastaninFormunuYazdirma();
                break;
            default:
                break;
        }

    }


    // Hasta Ekleme Fonksiyonu

    public static void hastaEkle() {

        //Eklenmek istenen hastanın gerkli bilgileri girilir
        System.out.println("Eklemek istediğiniz hastanın gerekli hasta bilgilerini giriniz : ");
        System.out.println(" Hasta ismi : ");
        String isim = tarayici.nextLine();

        System.out.println(" Hasta soyismi : ");
        String soyisim = tarayici.nextLine();

        System.out.println(" Hasta Tc : ");
        String tc = tarayici.nextLine();

        System.out.println(" Hasta telefon numarası : ");
        String telefonNumarasi = tarayici.nextLine();

        //id numarası liste boyutuna göre belirlenir
        int id = Hasta.hastaListesi.size();
        id++;

        // Yapıcı metot listeye ekler
        Hasta h = new Hasta(isim,soyisim,tc,telefonNumarasi);
    }



    // Hasta silme fonksiyonu
    public static void hastaSil(){

        System.out.println("Silmek istenen hastanın İD'sini giriniz ");
        int silinenHastaId = tarayici.nextInt();

        //Hastanın olup olmama furmuna göre flag ile kontrol edilir.
        boolean flag= false;

        // id ile tüm hastalar araında arama yaparak istenen hasta silinir.
        for (int i = 0; i < Hasta.hastaListesi.size(); i++) {
            if (Hasta.hastaListesi.get(i).id==silinenHastaId){
                Hasta.hastaListesi.remove(Hasta.hastaListesi.get(i));
                System.out.println(
                        Hasta.hastaListesi.get(i).isim + " isimli ve " +
                                Hasta.hastaListesi.get(i).id + " İd numaralı Hasta silindi. ");
                flag = true;
            }
        }
        if (!flag){System.out.println("Aradığınız kullanıcı bulunmamaktadır.");}
    }



    //Muhasebe işlmelerinin kontrol edilmesini sağlayan fonksiyon
    public static void muhasebeIslemleri() {

        boolean flag = true;

        while(flag){
            System.out.println("|——————————————————————————————————————————————|");
            System.out.println("Yapmak istediğinizişlemi seçiniz :");
            System.out.println(" 1: Toplam Kâr");
            System.out.println(" 2: Toplam Gelirler");
            System.out.println(" 3: Toplam Giderler");
            System.out.println(" 4: Çıkış");
            System.out.println("|——————————————————————————————————————————————|");

            String secim = tarayici.next();
            switch (secim){
                case "1":
                    Muhasebe.toplamKarHesapla();
                    continue;
                case "2":
                    Muhasebe.gelirleriHesapla();
                    continue;
                case "3":
                    Muhasebe.giderHesaplama();
                    continue;
                case "4":
                    System.out.println("Çıkış yapılıyor...");
                    flag = false;
                    break;
                default:
                    System.out.println("Yanlış değer girdiniz , lütfen verilen seçeneklere uygun değer giriniz.");
                    break;
            }

        }

    }



    //Değerleme formunu dolduran hastanın form girdilerini yazdırma:
    public static void hastaninFormunuYazdirma () {
        int degerlemesiIstenenHastaId = 0;
        System.out.println("Formunu görmek istediğiniz hastanın İd numarsını giriniz : ");
        while(true){
            try{
                degerlemesiIstenenHastaId = tarayici.nextInt();
            }catch (InputMismatchException e){
                System.out.println("Hatalı giriş yaptınız. Lütfen tekrar deneyiniz.");
                tarayici.nextLine();
                continue;
            }
            break;
        }


        // Bu hastanın değerlendirme değerlerinin anahtarlarını(değerlendirme katagorisi"1,2,3,4,5") bir `Set` olarak alır.
        Set<DegerlendirmeKatagori> anahtarlar = Hasta.hastaListesi.get(degerlemesiIstenenHastaId).degerler.keySet();

        //Alınan değerleri bir for döngüsü ile gezer.
        for (DegerlendirmeKatagori anahtar : anahtarlar) {
            System.out.println("Katagori : " + anahtar + ", Verilen Skala değerleri : " + Hasta.hastaListesi.get(degerlemesiIstenenHastaId).degerler.get(anahtar));
        }

    }


    public static void birimHastaDolulukOrani(){

        //Birimleri dolaşır
        for (int i = 0; i < Birim.birimListesi.size(); i++) {

            // i indeksi gelen birimin kapasitesini birimHastaKapasitesi'e atar
            int birimHastaKapasitesi = Birim.birimListesi.get(i).getHastaKapasite();

            // Yüzdelik çevirme işlemi yapılır
            float dolulukOrani = ((float) Birim.birimListesi.get(i).birimeAitHastaListesi.size() / birimHastaKapasitesi) * 100;

            // String.format kullanarak float değeri istenen formata çevirir
            String formatliDolulukOrani = String.format("%.2f", dolulukOrani);

            System.out.println(Birim.birimListesi.get(i).getIsim() + " \n\nbiriminin toplam randevu sayısı: " + Birim.birimListesi.get(i).birimeAitHastaListesi.size());
            System.out.println("\n" +birimHastaKapasitesi + "birimin hasta kapasitesi \n");
            System.out.println("\n" + Birim.birimListesi.get(i).getIsim() + " - " +" Doluluk oranı %" + formatliDolulukOrani+ "\n");
        }
    }


    @Override
    public void receteGoruntule(){
        boolean receteBulunduMu = true;
        String tcKimlik = "";
        while(receteBulunduMu){
            while(true){
                System.out.print("Hastanın TC Kimlik Numarası:");
                tcKimlik = tarayici.nextLine();
                if(tcKimlik.length() != 11){
                    System.out.println("TC Kimlik Numaranısı 11 haneden oluşmalı.");
                }
                else{
                    break;
                }
            }

            boolean flag4 = false;
            for(int i=0;i<Hasta.hastaListesi.size();i++){
                if(Hasta.hastaListesi.get(i).TC.equals(tcKimlik)){
                    flag4=true;
                }
            }
            if(flag4){
                System.out.println("Hastaya ait reçete bulundu.");
            }
            else{
                System.out.println("Girmiş olduğunuz TC Kimlik Numarasıyla kayıtlı hasta bulunmamaktadır.");
                continue;
            }

            String dosyaIsmi="";
            for (int i = 0 ; i < Hasta.hastaListesi.size(); i++){
                if(Hasta.hastaListesi.get(i).TC.equals(tcKimlik)){
                    dosyaIsmi=("out"+Hasta.hastaListesi.get(i).isim+" "+Hasta.hastaListesi.get(i).soyisim+".txt");
                }
            }

            File dosya = new File(dosyaIsmi);
            String dosyaYolu=dosya.getAbsolutePath();
            try {
                BufferedReader okuyucu = new BufferedReader(new FileReader(dosyaYolu));
                String satir;
                while((satir= okuyucu.readLine()) != null){
                    System.out.println(satir);
                }
                okuyucu.close();
                receteBulunduMu = false;
            } catch (FileNotFoundException e) {
                System.out.println("Hastaya ait reçete bulunmamaktadır.");
                continue;
            }
            catch (IOException e){
                e.printStackTrace();
            }
        }
    }

    @Override
    public void doktorGoruntule() {
        for (int i=0;i<Doktor.doktorListesi.size();i++){
            System.out.println(Doktor.doktorListesi.get(i).id+" "+Doktor.doktorListesi.get(i).isim+" "+Doktor.doktorListesi.get(i).soyisim);
        }
    }
}




















