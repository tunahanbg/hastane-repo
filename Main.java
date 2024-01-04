import java.text.SimpleDateFormat;

public class Main {
    public static void main(String[] args) {
        Hasta h1=new Hasta("aaaaa","aaaaa","123","10.10.1974",1,123,"Ankara");
        Hasta h2=new Hasta("bbbbb","bbbbb","456","10.10.1974",2,456,"İstanbul");

        Doktor d1=new Doktor("YAprak","Gök","123","10.10.1974",123,"Ankara");
        Doktor d2=new Doktor("Baran","Bilal","123","10.10.1974",123,"Ankara");
        Doktor d3=new Doktor("Tuna","KB","123","10.10.1974",123,"Ankara");

        //d1.receteYaz();
        //d1.receteYaz();

        Birim birim1=new Birim("Pediatri");
        Birim birim2=new Birim("Üroloji");
        Birim birim3=new Birim("Ortopedi");
        Birim birim4=new Birim("Kardiyoloji");
        Birim birim5=new Birim("Nöroloji");
        Birim birim6=new Birim("Dahiliye");
        Birim birim7=new Birim("Cerrahi");
        Birim.birimListesi.add(birim1);
        Birim.birimListesi.add(birim2);
        Birim.birimListesi.add(birim3);
        Birim.birimListesi.add(birim4);
        Birim.birimListesi.add(birim5);
        Birim.birimListesi.add(birim6);
        Birim.birimListesi.add(birim7);
        birim1.birimdekiDoktorlarinListesi.add(d1);
        birim1.birimdekiDoktorlarinListesi.add(d2);
        birim1.birimdekiDoktorlarinListesi.add(d3);



        Randevu r1=new Randevu();
        r1.setRandevuTarihi("10 3 2024");
        Randevu.randevuListesi.add(r1);

        Randevu r2=new Randevu();
        r2.setRandevuTarihi("11 3 2024");
        Randevu.randevuListesi.add(r2);

        Randevu r3=new Randevu();
        r3.setRandevuTarihi("12 3 2024");
        Randevu.randevuListesi.add(r3);

        Randevu r4=new Randevu();
        r4.setRandevuTarihi("13 3 2024");
        Randevu.randevuListesi.add(r4);

        System.out.println(Randevu.randevuListesi.get(0).getRandevuTarihi());
        System.out.println(Randevu.randevuListesi.get(1).getRandevuTarihi());
        System.out.println(Randevu.randevuListesi.get(2).getRandevuTarihi());
        System.out.println(Randevu.randevuListesi.get(3).getRandevuTarihi());

        Randevu.randevuOlustur();
        System.out.println(Randevu.randevuListesi.get(Randevu.randevuListesi.size()-1).getRandevuTarihi());

        System.out.println(birim1.birimeAitHastaListesi.get(0).isim+" "+birim1.birimeAitHastaListesi.get(0).soyisim);








    }
}
