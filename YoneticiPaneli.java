import java.util.*;

public class YoneticiPaneli {
    static Scanner tarayici = new Scanner(System.in);


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

        System.out.println(" Hasta doğum tarihi : ");
        String dogumTarihi = tarayici.nextLine();

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
        System.out.println("Muhasebe İşlemlerine Hoşgeldiniz. Yapmak istediğinizişlemi seçiniz :");
        System.out.println(" 1: Toplam Kâr");
        System.out.println(" 2: Toplam Gelirler");
        System.out.println(" 3: Toplam Giderler");
        int secim=tarayici.nextInt();

        switch (secim){
            case 1:Muhasebe.toplamKarHesapla();
                break;
            case 2:Muhasebe.gelirleriHesapla();
                break;
            case 3:Muhasebe.giderHesaplama();
            default:
                System.out.println("Yanlış değer girdiniz , lütfen verilen seçeneklere uygun değer giriniz.");
                break;
        }
    }

    //Değerleme formunu dolduran hastanın form girdilerini yazdırma:
    public static void hastaninFormunuYazdirma () {
        System.out.println("Formunu görmek istediğiniz hastanın İd numarsını giriniz : ");
        int degerlemesiIstenenHastaId = tarayici.nextInt();


        // Bu hastanın değerlendirme değerlerinin anahtarlarını(değerlendirme katagorisi"1,2,3,4,5") bir `Set` olarak alır.
        Set<DegerlendirmeKatagori> anahtarlar = Hasta.hastaListesi.get(degerlemesiIstenenHastaId).degerler.keySet();

        //Alınan değerleri bir for döngüsü ile gezer.
        for (DegerlendirmeKatagori anahtar : anahtarlar) {
            System.out.println("Katagori : " + anahtar + ", Verilen Skala değerleri : " + Hasta.hastaListesi.get(degerlemesiIstenenHastaId).degerler.get(anahtar));
        }

    }



    //TNG daha bitmedi yapım aşamasındaaa
    /*public static void birimHastaDolulukOrani(){
        for (int i = 0; i < Birim.birimListesi.size(); i++) {
            int randevuSayisi = 0;       // Her bir birim için randevu sayısını sıfırla
            int birimHastaKapasitesi = Birim.birimListesi.get(i).getHastaKapasite();       // i indeksi gelen birimin kapasitesini birimHastaKapasitesi'e atar

            for (Randevu randevu : Randevu.randevuListesi) {                               // Randevu sınıfındaki randevuListesi ArrayList'ini dolaşılır.
                if (randevu.getBirimAdi().equals(Birim.birimListesi.get(i).getIsim())) {   // randevu değişkeninin içindeki birim adını, Birim sınıfındaki birimListesi ArrayListinde i. indeksteki birimin ismine eşit olup olmadığını kontrol eder.
                    randevuSayisi++;
                }
            }
            float dolulukOrani = ((float) randevuSayisi / birimHastaKapasitesi) * 100;     // Yüzdelik çevirme işlemi yapılır

            String formatliDolulukOrani = String.format("%.2f", dolulukOrani);              // String.format kullanarak float değeri istenen formata çevirir

            System.out.println(Birim.birimListesi.get(i).getIsim() + " \n\nbiriminin toplam randevu sayısı: " + randevuSayisi);
            System.out.println("\n" +birimHastaKapasitesi + "birimin hasta kapasitesi \n");
            System.out.println("\n" + Birim.birimListesi.get(i).getIsim() + " - " +" Doluluk oranı %" + formatliDolulukOrani);
        }*/
    }




















