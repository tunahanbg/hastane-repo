import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class DegerlendirmeFormu {

    static Scanner tarayici = new Scanner(System.in);

    //Skalalar oluşturulur
    int[] skalalar = {1, 2, 3, 4, 5};

    // DegerlendirmeKatagori türünden bir List nesnesi olan katagoriler adlı değişkeni oluşturur
    private final List<DegerlendirmeKatagori> katagoriler;

    //DegerlendirmeFormu sınıfının yapıcı metodu
    public DegerlendirmeFormu() {
        katagoriler = Arrays.asList(DegerlendirmeKatagori.values());
    }

    public void doldur(Hasta hasta) {

        System.out.println("Derecelendirme sklası: '1,2,3,4,5' . Lütfen bu aralıkta bir değer giriniz.");

        //Hastanın  derecelendirmeleri doldurulur
        for (DegerlendirmeKatagori katagori : katagoriler) {
            System.out.println("Lütfen " + katagori + "için bir derecenlirme verin.");
            int derecelendirme = tarayici.nextInt();
            hasta.degerler.put(katagori, derecelendirme);
        }
    }

    public static void hastaDegerlendirmeFormu () {

        DegerlendirmeFormu form = new DegerlendirmeFormu();
        System.out.println("Değerlendirme için lütfen İD numaranızı giriniz : ");
        int degerlendiriciId = tarayici.nextInt();
        form.doldur(Hasta.hastaListesi.get(degerlendiriciId));
        System.out.println("Değerlendirmeniz alındı. \n İyi günler dileriz :) ");

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
