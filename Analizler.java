public class Analizler {




//bunu yapacağım !!!!!!!!!!!!!!!!!!







    //Aşşadaki üç fonksiyon da aynı görevi yapmak için oluşturuldular ama bir türlü birimdeki hasta sayısını bulamadım
    /*public static void birimHastaDolulukOrani() {

        for (int i = 0; i < Birim.birimListesi.size(); i++) {
            int birimHastaKapasitesi = Birim.birimListesi.get(i).getHastaKapasite();
            int randevuSayisi = Randevu.randevuListesi.size();

            float dolulukOrani = ((float) randevuSayisi / birimHastaKapasitesi) * 100;

            // String.format kullanarak float değeri istenen formata çevirme
            String formatliDolulukOrani = String.format("%.2f", dolulukOrani);

            System.out.println("\n" + Birim.birimListesi.get(i).getIsim() + " - " +" Doluluk oranı %" + formatliDolulukOrani);
        }

    }*/


    /*//Birimlerin hasta kapasitelerine göre yüzdelik doluluk oranlarını ve her bir birimin toplam randevu sayısını hesaplar
    public static void birimHastaDolulukOrani() {

        int randevuSayisi = 0;
        for (int i = 0; i < Birim.birimListesi.size(); i++) {                              // Birim sınıfının birimListesi ArrayList'ini dolaşır
            int birimHastaKapasitesi = Birim.birimListesi.get(i).getHastaKapasite();       // i indeksi gelen birimin kapasitesini birimHastaKapasitesi'e atar
            for (Randevu randevu : Randevu.randevuListesi) {                               // Randevu sınıfındaki randevuListesi ArrayList'ini dolaşılır.
                if (randevu.getHasta().isim.equals(Birim.birimListesi.get(i).getIsim())) { // randevu değişkeninin hasta özelliğindeki ismin, Birim sınıfındaki birimListesi ArrayListinde i. indeksteki birimin ismine eşit olup olmadığını kontrol eder.
                    randevuSayisi++;
                }
            }
            float dolulukOrani = ((float) randevuSayisi / birimHastaKapasitesi) * 100;     // Yüzdelik çevirme işlemi yapılır

            String formatliDolulukOrani = String.format("%.2f", dolulukOrani);              // String.format kullanarak float değeri istenen formata çevirir

            System.out.println(Birim.birimListesi.get(i).getIsim() + " \n\nbiriminin toplam randevu sayısı: " + randevuSayisi);
            System.out.println("\n" +birimHastaKapasitesi + "birimin hasta kapasitesi \n");
            System.out.println("\n" + Birim.birimListesi.get(i).getIsim() + " - " +" Doluluk oranı %" + formatliDolulukOrani);
        }
    }*/

    /*public static void birimHastaDolulukOrani(){
        for (int i = 0; i < Birim.birimListesi.size(); i++) {
            int randevuSayisi = 0;       // Her bir birim için randevu sayısını sıfırla
            int birimHastaKapasitesi = Birim.birimListesi.get(i).getHastaKapasite();       // i indeksi gelen birimin kapasitesini birimHastaKapasitesi'e atar

            for (Randevu randevu : Randevu.randevuListesi) {                               // Randevu sınıfındaki randevuListesi ArrayList'ini dolaşılır.
                if (randevu.getBirimAdi().equals(Birim.birimListesi.get(i).getIsim())) {   // randevu değişkeninin içindeki birim adını, Birim sınıfındaki birimListesi ArrayListinde i. indeksteki birimin ismine eşit olup olmadığını kontrol eder.
                    randevuSayisi++;
                }
            }
            float dolulukOrani = ((float) randevuSayisi / birimHastaKapasitesi) * 100;     // Yüzdelik çevirme işlemi yapılır

            String formatliDolulukOrani = String.format("%.2f", dolulukOrani);              // String.format kullanarak float değeri istenen formata çevirir

            System.out.println(Birim.birimListesi.get(i).getIsim() + " \n\nbiriminin toplam randevu sayısı: " + randevuSayisi);
            System.out.println("\n" +birimHastaKapasitesi + "birimin hasta kapasitesi \n");
            System.out.println("\n" + Birim.birimListesi.get(i).getIsim() + " - " +" Doluluk oranı %" + formatliDolulukOrani);

        }

    }*/


}


