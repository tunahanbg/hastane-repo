import java.util.Scanner;

public class Muhasebe {

    private final static int toplamButce = 100000;
    private static int gelirler;
    private static double giderler;
    private static int toplamHastaSayisi = Hasta.hastaListesi.size();
    private static int hastaMuayeneUcreti = 1000;
    private static int devletHastaDestegi = 800;
    private static int devletCalisanDestegi = 500;
    private static int toplamHemsireMaas;
    private static int toplamDoktorMaas;
    private static double toplamKar ;

    public static void gelirleriHesapla() {
        gelirler = toplamButce+toplamHastaSayisi*(hastaMuayeneUcreti+devletHastaDestegi) + devletCalisanDestegi * (Doktor.doktorListesi.size()+Hemsire.hemsireArrayList.size());
        System.out.println(
                "\n\n==================Hastane Gelirleri=================="+
                        "\nToplam bulunan hastane bütçesi "+ toplamButce +
                        "\nToplam "+ toplamHastaSayisi + " tane hastadan gelen bütçe : "+ toplamHastaSayisi*(hastaMuayeneUcreti+devletHastaDestegi) +
                        "\nToplam "+ (Doktor.doktorListesi.size()+Hemsire.hemsireArrayList.size()) + " tane çalışandan gelen devlet desteği : "+ (devletCalisanDestegi * (Doktor.doktorListesi.size()+Hemsire.hemsireArrayList.size())) +
                        "\nToplam "+ (Doktor.doktorListesi.size()+Hemsire.hemsireArrayList.size()) + " tane çalışandan gelen devlet desteği : "+ (devletCalisanDestegi * (Doktor.doktorListesi.size()+Hemsire.hemsireArrayList.size())) +
                        "\n\nHastane toplam geliri : " + gelirler +"$");
    }

    public static void giderHesaplama() {
        double receteGiderleri = Randevu.randevuListesi.size() * 0.2;
        toplamDoktorMaasHesapla();
        toplamHemsireMaasHesapla();
        int toplamCalisanMaaslari = toplamDoktorMaas + toplamHemsireMaas;
        double hastaBasiMaaliyet = toplamHastaSayisi*13;
        int temizlikGiderleri = Birim.birimListesi.size() * 30;

        giderler = receteGiderleri + toplamCalisanMaaslari + hastaBasiMaaliyet + temizlikGiderleri;
        System.out.println(
                "\n\n==================Hastane Giderleri=================="+
                        "\nToplam "+ toplamHastaSayisi + "  tane hastadan oluşan masraf : "+ hastaBasiMaaliyet+
                        "\nToplam "+ Birim.birimListesi.size() + " tane birimden oluşan temizlik masrafı : "+ temizlikGiderleri+
                        "\nToplam "+ Randevu.randevuListesi.size() + " tane reçeteden oluşan temizlik masrafı : "+ receteGiderleri+
                        "\nToplam "+ (Doktor.doktorListesi.size()+Hemsire.hemsireArrayList.size()) + " tane çalışandan oluşan maaş masrafı : "+ toplamCalisanMaaslari+
                        "\n\nHastane Toplam Giderleri : " + giderler +"$");

    }

    public static void toplamKarHesapla() {
        toplamKar = gelirler - giderler;
        System.out.println(
                "\n\n==================Hastane Karlılık Durumu=================="+
                        "Hastanenin toplam başlangıç bütçesi : " + toplamButce +
                        "\nToplam geliri : " + gelirler +
                        "\nToplam gideri : " + giderler);
        if (gelirler > giderler){
            System.out.println("\n\n Hastane karlı pozisyonda.\nToplam kar : "+toplamKar+"$");
        }
        else if (gelirler < giderler){
            System.out.println("\n\n Hastane zarar pozisyonunda. \nToplam zarar : "+toplamKar+"$");
        }
        else System.out.println("\n\n Hastane gelir getirmiyor ama zararı da yok");

    }



    public static void toplamDoktorMaasHesapla() {
        for (int i = 0; i < Doktor.doktorListesi.size(); i++) {
            toplamDoktorMaas = Doktor.doktorListesi.get(i).maas;
        }
    }

    public static void toplamHemsireMaasHesapla() {
        for (int i = 0; i < Hemsire.hemsireArrayList.size(); i++) {
            toplamHemsireMaas = Hemsire.hemsireArrayList.get(i).maas;
        }
    }



}