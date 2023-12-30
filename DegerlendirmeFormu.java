import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

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

        //Hastanın  derecelendirmeleri doldurulur
        for (DegerlendirmeKatagori katagori : katagoriler) {
            System.out.println("Lütfen " + katagori + "için bir derecenlirme verin.");
            int derecelendirme = tarayici.nextInt();
            hasta.degerler.put(katagori, derecelendirme);
        }
    }
}
