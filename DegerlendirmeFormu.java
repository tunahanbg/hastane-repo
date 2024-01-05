import java.util.*;
//Yukardaki ifade ile gerekli tüm java.util paketleri alınır

public class DegerlendirmeFormu {


    static int sayici = 0;
    static int degerledirmeyeKatilanHastaSayisi = 0;


    static Scanner tarayici = new Scanner(System.in);

    //int List türünden bir Sıkalalar listesi oluşturulur
    List<Integer> derecelendirmeler = Arrays.asList(1, 2, 3, 4, 5);

    // DegerlendirmeKatagori türünden bir List nesnesi olan katagoriler adlı değişkeni oluşturur
    private static List<DegerlendirmeKatagori> katagoriler;

    //DegerlendirmeFormu sınıfının yapıcı metodu
    public DegerlendirmeFormu() {
        katagoriler = Arrays.asList(DegerlendirmeKatagori.values());
    }


    //Değerlendirme formunun doldurulması sağlanır.Try Catch ile yanlış girilen değer bulunur ve hata döndürülür.Eğer uygun ise değerleri ait oldukları anahtarlara değer olarak ekler.
    public void hastaninDerelecelendirmesiniDoldur(Hasta hasta) {


        System.out.println("Derecelendirme sıkalası: '1,2,3,4,5' . Lütfen bu aralıkta bir değer giriniz.");

        sayici++;

        //Katagoriler arasında gezer
        for (DegerlendirmeKatagori katagori : katagoriler) {

            //Hastanıngirdiği değerin doğru olup olmadığı kontrol edilir değilse hata fırlatılır ve tekrar girmesi istenir
            boolean girilenderecelendirmeHataKontrolu;
            do {

                girilenderecelendirmeHataKontrolu = false;
                System.out.println("Lütfen " + katagori + " için bir derecenlirme verin.");
                try {

                    int derecelendirme = tarayici.nextInt();
                    if (!derecelendirmeler.contains(derecelendirme)) {
                        throw new IllegalArgumentException("Lütfen belirlenen değer aralığından bir sayı giriniz.\n");
                    }
                    hasta.degerler.put(katagori, derecelendirme);

                }
                catch (IllegalArgumentException e) {
                    girilenderecelendirmeHataKontrolu = true;
                    System.out.println(e.getMessage());
                }

            } while (girilenderecelendirmeHataKontrolu);

        }
    }



    public static void hastaDegerlendirmeFormu () {

        DegerlendirmeFormu form = new DegerlendirmeFormu();
        System.out.println("Değerlendirme için lütfen İD numaranızı giriniz : ");
        int degerlendiriciId = tarayici.nextInt();
        degerledirmeyeKatilanHastaSayisi++;
        form.hastaninDerelecelendirmesiniDoldur(Hasta.hastaListesi.get(degerlendiriciId));
        System.out.println("Değerlendirmeniz alındı. \n İyi günler dileriz :) ");

    }



    //Her katagorinin toplam puanlarını, ve katagorilerin değerlendirme ortalamalarını bulur bulan fonksiyon
    public static void katagoriOrtalamaDegerlendirmeleri() {


        if (katagoriler == null) {
            // Eğer katagoriler null ise, hata oluşturur, bu durum kontrol edilir
            throw new IllegalStateException("Katagoriler değerlendirilmemiş lütfen değerlendiriniz.");
        }

        int katagoriSecimSayaci =0;
        double toplam = 0;
        double katagoriOrtalama;

        // Her bir kategorinin ortalamasını tutan bir liste
        List<Double> ortalamalar = new ArrayList<>();

        // Tüm kategorileri tarar . Her bir kategorinin değerini toplam değişkenine ekler ve ortalama hesaplar
        for (DegerlendirmeKatagori katagori : katagoriler) {

            toplam = 0;

            //degerler haritasında katagori var mı diye kontrol eder eğer varsa o katagoriye ait değer alınır ve toplam değişkenine ekler
            if (Hasta.degerler.containsKey(katagori)) {
                for (int i = 0; i < degerledirmeyeKatilanHastaSayisi; i++) {
                    int derece = Hasta.degerler.get(katagori);
                    toplam += derece;
                }

                //İlgili katagorinin ortalama puan değerleri bulunur ve düşük olan katagori puanaı üzerinden katagorinin geliştirilmesi gerekteiğine karar verilir

                katagoriOrtalama = toplam / sayici ;

                switch (katagoriSecimSayaci){
                    case 0:
                        DegerlendirmeKatagori.setDerece(0,katagoriOrtalama );
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
                    default:
                        break;
                }

                katagoriSecimSayaci++;
                //Ortalamayı listeye ekler
                ortalamalar.add(katagoriOrtalama);

                System.out.println("\n"+katagori + " değerlendirme katagorisinin ortalama  değerleri : " + katagoriOrtalama+"\n");

            }
        }

        //Katagorilerin  toplam ortalamalarını bulur
        double toplamOrtalamalar = 0;
        for (double ortalama : ortalamalar) {

            toplamOrtalamalar += ortalama;
        }

        //ortalama değerlerinin ortalamasını hesaplar
        double ortalamalarinOrtalamasi = toplamOrtalamalar / katagoriler.size();
        System.out.println("\n\n Tüm katagorilerin ortalamalarının ortalaması : " + ortalamalarinOrtalamasi +  "\n\n");

        //katagori ortalmasının olması gereken minimum değer hesaplanır
        double sinirOrtalamalarinOrtalamasi = ortalamalarinOrtalamasi * 0.3 ;

        //DegerlendirmeKatagori sınıfının dereceler dizisi erişilmek için kopyalanır
        double[] dereceler = DegerlendirmeKatagori.dereceler;


        //İstenen sınır değerinden düşük olan ortalamaya uyarı verir
        for (int i = 0; i < dereceler.length; i++){
            if (dereceler[i] < sinirOrtalamalarinOrtalamasi){
                System.out.println("\n\n" +DegerlendirmeKatagori.values()[i] +" Katagorisinin " +  dereceler[i] +" puanlı derecelendirmesi yetersizdir.Alanın geliştirilmesi gerekiyor\n\n");}
        }

    }

}

