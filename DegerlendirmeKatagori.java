public enum DegerlendirmeKatagori {

    BILGIDUZEYI,
    ILETISIMBECERILERI,
    HASTAKARSITUTUMU,
    GENELMEMNUNLUK;


    //Dereceler adında statik bir double dizisi tanımlanır. Bu dizi, her kategori için bir değerlendirme ortalaması içerir.
    public static double[] dereceler = {5.0, 4.0, 3.0, 2.0};

    //derece dizisindeki değerleri değiştirmeye izin verir.
    public static void setDerece(int index, double value) {
        if (index >= 0 && index < dereceler.length) {
            dereceler[index] = value;
        } else {
            // Hata durumunda yapılacak işlemi buraya yazabilirsiniz
            throw new IllegalArgumentException("Geçersiz indeks");
        }
    }
}
