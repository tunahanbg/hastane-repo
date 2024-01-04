import java.util.*;
//Yukardaki ifade ile gerekli tüm java.util paketleri alınır

public class DegerlendirmeFormu {

    static int sayici = 0;

    static Scanner tarayici = new Scanner(System.in);

    //int List türünden bir Sıkalalar listesi oluşturulur
    List<Integer> derecelendirmeler = Arrays.asList(1, 2, 3, 4, 5);

    // DegerlendirmeKatagori türünden bir List nesnesi olan katagoriler adlı değişkeni oluşturur
    private static List<DegerlendirmeKatagori> katagoriler;

    //DegerlendirmeFormu sınıfının yapıcı metodu
    public DegerlendirmeFormu() {
        katagoriler = Arrays.asList(DegerlendirmeKatagori.values());
    }


    // !!!!!!!Girilen değer yanlış olduğunda başa dnmüyor bunu düzeltttt !!!!!!!!!!!!!
    //<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>

    //Değerlendirme formunun doldurulması sağlanır.Try Catch ile yanlış girilen değer bulunur ve hata döndürülür.Eğer uygun ise değerleri ait oldukları anahtarlara değer olarak ekler.
    public void doldur(Hasta hasta) {

        System.out.println("Derecelendirme sıkalası: '1,2,3,4,5' . Lütfen bu aralıkta bir değer giriniz.");

        sayici++;

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



    //Her katagorinin toplam puanlarını bulan fonksiyon
    public static double katagoriOrtalamaDegerlendirmeleri() {


        if (katagoriler == null) {
            // Eğer katagoriler null ise, hata oluşturur, bu durum kontrol edilir
            throw new IllegalStateException("Katagoriler listesi henüz başlatılmamış.");
        }

        double toplam = 0;
        double katagoriOrtalama;

        // Her bir kategorinin ortalamasını tutan bir liste
        List<Double> ortalamalar = new ArrayList<>();

        // Tüm kategorileri tarar . Her bir kategorinin değerini toplam değişkenine ekler ve ortalama hesaplar
        for (DegerlendirmeKatagori katagori : katagoriler) {

            int i =0;


            //degerler haritasında katagori var mı diye kontrol eder eğer varsa o katagoriye ait değer alınır ve toplam değişkenine ekler
            if (Hasta.degerler.containsKey(katagori)) {
                int derece = Hasta.degerler.get(katagori);
                toplam += derece;

                System.out.println("\n\n\n\n"+katagori + "değerlendirme katagorisinin toplam  değerleri : " + toplam+"\n\n");

                //İlgili katagorinin ortalama puan değerleri bulunur ve düşük olan katagori puanaı üzerinden katagorinin geliştirilmesi gerekteiğine karar verilir

                katagoriOrtalama = toplam / sayici ;

                switch (i){
                    case 0:
                        DegerlendirmeKatagori.setDerece(0,katagoriOrtalama );
                        System.out.println("\n\n\n\n\n\n\n\n\n"+katagori + "değerlendirme katagorisinin ortalama  değerleri : " + katagoriOrtalama+"\n\n\n\n\n\n\n\n\n");
                        break;
                    case 1:
                        DegerlendirmeKatagori.setDerece(1,katagoriOrtalama );
                        break;
                    case 2:
                        DegerlendirmeKatagori.setDerece(2,katagoriOrtalama );
                        break;
                    case 3:
                        DegerlendirmeKatagori.setDerece(3,katagoriOrtalama );
                        break;

                }

                i++;
                //Ortalamayı listeye ekler
                ortalamalar.add(katagoriOrtalama);

                System.out.println("\n\n"+katagori + " değerlendirme katagorisinin ortalama  değerleri : " + katagoriOrtalama+"\n\n");

            }


        }
        //Katagorilerin  toplam ortalamalarını bulur
        double toplamOrtalamalar = 0;
        for (double ortalama : ortalamalar) {

            toplamOrtalamalar += ortalama;
        }
        double ortalamalarinOrtalamasi = toplamOrtalamalar / katagoriler.size();
        System.out.println("\n\n\n\n tüm katagorilerin toplam ortalaması : " + ortalamalarinOrtalamasi +  "\n\n\n\n");


        double sinirOrtalamalarinOrtalamasi = ortalamalarinOrtalamasi * 0.3 ;

        for (DegerlendirmeKatagori katagori : katagoriler){


        }

        return toplam;
    }

}

