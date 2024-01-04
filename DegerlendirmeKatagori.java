/*public enum DegerlendirmeKatagori {


        //Hasta değerlendirme katagorileri
        BILGIDUZEYI,
        ILETISIMBECERILERI,
        HASTAKARSITUTUMU,
        GENELMEMNUNLUK,
        ;


        //Katagorilerin alacakları değerlendirme ortalamaları (sonradan katagori ortalamaları hesaplanınca değiştirilecekler)
        public static double[] dereceler = {5.0, 4.0, 3.0, 2.0};
        //public double[] derece;

        //ordinal() metodu sayeesinde enum'un değerinin dizide hangi konumda olduğunu bulunur ve bu konumu kullanarak, dereceler dizisindeki ilgili değeri döndürür.
        public double derece() {
                return dereceler[ordinal()];
        }

}*/




public enum DegerlendirmeKatagori {

    BILGIDUZEYI,
    ILETISIMBECERILERI,
    HASTAKARSITUTUMU,
    GENELMEMNUNLUK;


    //Dereceler adında statik bir double dizisi tanımlanır. Bu dizi, her kategori için bir değerlendirme ortalaması içerir.
    public static double[] dereceler = {5.0, 4.0, 3.0, 2.0};

    //her kategorinin derecesini hesaplamak için kullanılan bir metot tanımlanmıştır.
    // Bu metot, enum değerinin sırasını kullanarak, dereceler dizisinden ilgili değeri döndürür.
        /*public double derece() {
                return dereceler[ordinal()];
        }*/


    //dereceler dizisinin bir değerini değiştirir.Metod, indeks ve değer parametrelerini alır.
    // Metod, indeksin 0 ile dereceler dizisinin uzunluğu arasında olduğundan emin olur.
    // İndeks bu aralıkta ise, dereceler dizisinin ilgili değerini değer parametresiyle değiştirir. İndeks bu aralıkta değilse, bir hata oluşturur.
    public static void setDerece(int index, double value) {
        if (index >= 0 && index < dereceler.length) {
            dereceler[index] = value;
        } else {
            // Hata durumunda yapılacak işlemi buraya yazabilirsiniz
            throw new IllegalArgumentException("Geçersiz indeks");
        }
    }
}
