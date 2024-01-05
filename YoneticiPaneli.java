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
        int telefonNumarasi = tarayici.nextInt();

        System.out.println(" Hasta doğum yeri : ");
        String dogumYeri = tarayici.nextLine();

        //id numarası liste boyutuna göre belirlenir
        int id = Hasta.hastaListesi.size();
        id++;

        // Yapıcı metot listeye ekler
        Hasta h = new Hasta(isim,soyisim,tc,dogumTarihi,id,telefonNumarasi,dogumYeri);


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
}




















