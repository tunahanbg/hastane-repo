import java.util.*;
//Yukardaki ifade ile gerekli tüm java.util paketleri alınır


public class DegerlendirmeFormu {

    static Scanner tarayici = new Scanner(System.in);

    //int List türünden bir Sıkalalar listesi oluşturulur
    List<Integer> derecelendirmeler = Arrays.asList(1, 2, 3, 4, 5);

    // DegerlendirmeKatagori türünden bir List nesnesi olan katagoriler adlı değişkeni oluşturur
    private final List<DegerlendirmeKatagori> katagoriler;

    //DegerlendirmeFormu sınıfının yapıcı metodu
    public DegerlendirmeFormu() {
        katagoriler = Arrays.asList(DegerlendirmeKatagori.values());
    }


    // !!!!!!!Girilen değer yanlış olduğunda başa dnmüyor bunu düzeltttt !!!!!!!!!!!!!
    //<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>

    //Değerlendirme formunun doldurulması sağlanır.Try Catch ile yanlış girilen değer bulunur ve hata döndürülür.Eğer uygun ise değerleri ait oldukları anahtarlara değer olarak ekler.
    public void doldur(Hasta hasta) {

        System.out.println("Derecelendirme sıkalası: '1,2,3,4,5' . Lütfen bu aralıkta bir değer giriniz.");

        //Hastanın  derecelendirmeleri doldurulur
        for (DegerlendirmeKatagori katagori : katagoriler) {
            System.out.println("Lütfen " + katagori + " için bir derecenlirme verin.");
            try {
                int derecelendirme = tarayici.nextInt();
                if (!derecelendirmeler.contains(derecelendirme)) {
                    throw new IllegalArgumentException("Lütfen belirlenen değer aralığından bir sayı giriniz.\n");
                }
                hasta.degerler.put(katagori, derecelendirme);

            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
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

