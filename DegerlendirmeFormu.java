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


    // !!!!!!!Girilen değer yanlış olduğunda başa dönmüyor ve değer eklenmemiş oluyor bu yüzden hastaninFormunuYazdirma fonksiyonunda değeri boş katagori gösterilmiyor  bunu düzeltttt !!!!!!!!!!!!!
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


}

