public class Muhasebe {

    private final static int toplamButce = 100000;
    public static int gelirler;
    public static double giderler;
    public static int toplamHastaSayisi = Hasta.hastaListesi.size();
    public static int hastaMuayeneUcreti = 10;
    public static int devletDestegi = 3;
    public static double toplamKar ;




    public static void gelirleriHesapla() {
        gelirler = toplamHastaSayisi*(hastaMuayeneUcreti+devletDestegi);
        System.out.println("Toplam "+ toplamHastaSayisi + "tane hastadan \n"+"Hastane toplam geliri :  " + gelirler);
    }


    public static void giderHesaplama() {
        double receteGiderleri = Randevu.randevuListesi.size() * 0.2;
        int toplamCalisanMaaslari = 55000; // Bunu rastgele verdim gerekli eklemeler yapıldığında tekrar düzenlenecek
        double hastaBasiMaaliyet = toplamHastaSayisi*1.3;
        int temizlikGiderleri = Birim.birimListesi.size() * 3;

        giderler = receteGiderleri + toplamCalisanMaaslari + hastaBasiMaaliyet + temizlikGiderleri;
        System.out.println("Toplam "+ toplamHastaSayisi + "tane hasta ,\n"+"Toplam "+ Birim.birimListesi.size() + "tane birim. \n"  +"Hastane Toplam Giderleri :  " + giderler);

    }


    public static void toplamKarHesapla() {
        toplamKar = toplamButce + gelirler - giderler;
        System.out.println("Hastanenin toplam başlangıç bütçesi : " + toplamButce +
                "\n toplam geliri : " + gelirler +
                "\n toplam gideri : " + giderler +
                "\n toplam kâr : " + toplamKar);
    }

}