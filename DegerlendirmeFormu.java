import java.util.*;
//Yukardaki ifade ile gerekli tüm java.util paketleri alınır

public class DegerlendirmeFormu {


    //Değerlendiren hastların id'si depolanır(hastaDegerlendirmeFormu fonksiyonunda erişilir) ve bu sayede diğer yerlerden de erişilir
    static ArrayList<Integer> degerlendirenHastalarId = new ArrayList<>();
    static int sayici = 0;
    static int degerledirmeyeKatilanHastaSayisi = 0;
    static Scanner tarayici = new Scanner(System.in);




    //int List türünden bir derecelendirmeler listesi oluşturulur
    List<Integer> derecelendirmeler = Arrays.asList(1, 2, 3, 4, 5);

    // DegerlendirmeKatagori türünden bir List nesnesi olan katagoriler adlı değişkeni oluşturur
    private static List<DegerlendirmeKatagori> katagoriler;

    //DegerlendirmeFormu sınıfının yapıcı metodu
    public DegerlendirmeFormu() {
        //katagoriler oluşturulur ve DegerlendirmeKatagori sınıfının tüm katagorilerini içeren bir List nesnesi oluşturur.Arrays.asList() yöntemi, verilen bir diziyi bir List nesnesine dönüştürür.DegerlendirmeKatagori.values() yöntemi, DegerlendirmeKatagori sınıfının tüm değerlerini içeren bir dizi döndürür.
        katagoriler = Arrays.asList(DegerlendirmeKatagori.values());
    }




    public static void hastaDegerlendirmeFormu () {

        DegerlendirmeFormu form = new DegerlendirmeFormu();
        System.out.println("\nDeğerlendirme için lütfen İD numaranızı giriniz : ");

        int degerlendiriciId = 0;
        while (true){
            try{
                degerlendiriciId = tarayici.nextInt();

            } catch (InputMismatchException e) {
                System.out.println("\nHatalı giriş yaptınız.Lütfen tekrar deneyiniz.\n");
                tarayici.nextLine();
                continue;
            }
            break;
        }

        for (int i = 0; i < Hasta.hastaListesi.size(); i++){
            if (degerlendiriciId == Hasta.hastaListesi.get(i).id){
                if (Hasta.hastaListesi.get(i).randevuSayisi != 0){
                    degerledirmeyeKatilanHastaSayisi++;
                    form.hastaninDerelecelendirmesiniDoldur(Hasta.hastaListesi.get(degerlendiriciId));

                    //Değerlendiren hastalrın id'si eklenir
                    degerlendirenHastalarId.add(degerlendiriciId);
                    System.out.println("Değerlendirmeniz alındı. \n İyi günler dileriz :) ");

                    //değerlendiriciID kullanabilmek için çağırıldı aslında direk gerekli değil çünkü her hasta formu kaydolurken ortalama hesaplar kısa bir çözüm bu sadece
                    //katagoriOrtalamaDegerlendirmeleri();

                }
                else
                    System.out.println("\nHerhangi bir randevu almadığınız için değerlendirme yapamazsınız.\n");
            }
        }

    }



    //Değerlendirme formunun doldurulması sağlanır.Try Catch ile yanlış girilen değer bulunur ve hata döndürülür.Eğer uygun ise değerleri ait oldukları anahtarlara değer olarak ekler.
    public void hastaninDerelecelendirmesiniDoldur(Hasta hasta) {

        System.out.println("\nDerecelendirme sıkalası: '1,2,3,4,5' . Lütfen bu aralıkta bir değer giriniz.");

        sayici++;

        //Katagoriler listesinde döner arasında gezer
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

                    //Hasta sınıfındaki toplam katagori listesin ekler
                    hasta.getToplamKategoriDegerleri()[katagori.ordinal()] += derecelendirme;                                 // Kategoriye ait toplam değeri artır
                    hasta.degerler.put(katagori, hasta.getToplamKategoriDegerleri()[katagori.ordinal()]);                     // İlgili kategoriye ait değeri hasta nesnesinde saklar

                }
                catch (IllegalArgumentException e) {
                    girilenderecelendirmeHataKontrolu = true;
                    System.out.println(e.getMessage());
                }

            } while (girilenderecelendirmeHataKontrolu);
        }
    }



    //Her katagorinin toplam puanlarını, ve katagorilerin değerlendirme ortalamalarını bulur bulan fonksiyon
    public static void katagoriOrtalamaDegerlendirmeleri() {


        boolean katagoriBosMu = true;
        while(katagoriBosMu){

            // Eğer katagoriler null ise, hata oluşturur, bu durum kontrol edilir

            if (katagoriler == null) {
                System.out.println("\nHerhangi bir değerlendirme yapılmamıştır.\n");
                katagoriBosMu = false;
            }
            else {
                katagoriBosMu = false;
                int katagoriSecimSayaci =0;
                double toplam = 0;
                int derece = 0;
                double katagoriOrtalama;

                // Her bir kategorinin ortalamasını tutan bir liste
                List<Double> ortalamalar = new ArrayList<>();

                // Tüm kategorileri tarar . Her bir kategorinin değerini toplam değişkenine ekler ve ortalama hesaplar
                for (DegerlendirmeKatagori katagori : katagoriler) {

                    toplam = 0;

                    //degerler haritasında katagori var mı diye kontrol eder eğer varsa o katagoriye ait değer alınır ve toplam değişkenine ekler
                    if (Hasta.degerler.containsKey(katagori)) {

                        //toplam += Hasta.degerler.get(katagori);

                        for (int i = 0; i < degerledirmeyeKatilanHastaSayisi; i++) {

                            //değerlendirmeyi yapan hastaya ulaşılıyor.Ulaşılan hastanın içindeki dizi ile ilgili katagori değerini toplam değer,ne atanır.
                            derece = Hasta.hastaListesi.get(degerlendirenHastalarId.get(i)).getToplamKategoriDegerleri()[katagori.ordinal()]; // ordinal() metodu ile ilgili kategorinin dizindeki indeksi alınır.
                            toplam += derece;
                            derece = 0;
                        }

                        //İlgili katagorinin ortalama puan değerleri bulunur
                        katagoriOrtalama = toplam / sayici;


                        //İlgili olan katagoriye ortalama değeri eklenir
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
                for (double ortalama : ortalamalar) {toplamOrtalamalar += ortalama;}


                //ortalama değerlerinin ortalamasını hesaplar
                double ortalamalarinOrtalamasi = toplamOrtalamalar / katagoriler.size();
                System.out.println("\n\nTüm katagorilerin ortalamalarının ortalaması : " + ortalamalarinOrtalamasi +  "\n\n");


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
    }

}

