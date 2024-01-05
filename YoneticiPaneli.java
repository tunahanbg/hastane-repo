import java.util.Scanner;
import java.util.Set;

public class YoneticiPaneli {
    static Scanner tarayici = new Scanner(System.in);

    public static void muhasebeIslemleri() {
        int secim=tarayici.nextInt();
        System.out.println(" Yapmak istediğinizişlemi seçiniz :");
        System.out.println(" 1: Toplam Kâr");
        System.out.println(" 2: Toplam Gelirler");
        System.out.println(" 3: Toplam Giderler");


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


        // Bu hastanın değerlendirme değerlerinin anahtarlarını bir `Set` olarak alır.
        Set<DegerlendirmeKatagori> anahtarlar = Hasta.hastaListesi.get(degerlemesiIstenenHastaId).degerler.keySet();

        //Alınan değerleri bir for döngüsü ile gezer.
        for (DegerlendirmeKatagori anahtar : anahtarlar) {
            System.out.println("Katagori : " + anahtar + ", Verilen Skala değerleri : " + Hasta.hastaListesi.get(degerlemesiIstenenHastaId).degerler.get(anahtar));
        }
    }
}
