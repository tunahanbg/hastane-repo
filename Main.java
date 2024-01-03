import java.text.SimpleDateFormat;
import java.util.Scanner;

public class Main {

    static Scanner tarayici = new Scanner(System.in);

    public static void main(String[] args) {
//        Hasta h1=new Hasta("aaaaa","aaaaa","123","10.10.1974",1,123,"Ankara");
//        Hasta h2=new Hasta("bbbbb","bbbbb","456","10.10.1974",2,456,"İstanbul");
//
//        Doktor d1=new Doktor("YAprak","Gök","123","10.10.1974",123,"Ankara");
//        Doktor d2=new Doktor("Baran","Bilal","123","10.10.1974",123,"Ankara");
//        Doktor d3=new Doktor("Tuna","KB","123","10.10.1974",123,"Ankara");
//
//        //d1.receteYaz();
//        //d1.receteYaz();
//
//        Birim birim1=new Birim("Pediatri",50);
//        Birim birim2=new Birim("Üroloji",20);
//        Birim birim3=new Birim("Ortopedi",30);
//        Birim birim4=new Birim("Kardiyoloji",40);
//        Birim birim5=new Birim("Nöroloji",50);
//        Birim birim6=new Birim("Dahiliye",30);
//        Birim birim7=new Birim("Cerrahi",10);
//        Birim.birimListesi.add(birim1);
//        Birim.birimListesi.add(birim2);
//        Birim.birimListesi.add(birim3);
//        Birim.birimListesi.add(birim4);
//        Birim.birimListesi.add(birim5);
//        Birim.birimListesi.add(birim6);
//        Birim.birimListesi.add(birim7);
//        birim1.birimdekiDoktorlarinListesi.add(d1);
//        birim1.birimdekiDoktorlarinListesi.add(d2);
//        birim1.birimdekiDoktorlarinListesi.add(d3);
//
//
//
//        Randevu r1=new Randevu();
//        r1.randevuOlustur();
//
//
//
//        Randevu.randevuListesi.get(0).randevuBilgileriYazdir();
//
//
//        //Hasta değerlendirme formu :
//        DegerlendirmeFormu.hastaDegerlendirmeFormu();
//
//
//        //Yönetici Paneli\\
//
//        //Değerleme formunu dolduran hastanın form girdilerini yazdırma:
//        YoneticiPaneli.hastaninFormunuYazdirma();
//        //Muahsebe İşlemleri
//        YoneticiPaneli.muhasebeIslemleri();


        Ilaclar.ilaclariOlustur();
        Ilaclar.ilaclariGoruntule();
        Ilaclar.katagoriSec();
        Ilaclar.ilaclariGoruntule();

        //Birim hasta doluluk oranını yazdırma;
        //Analizler.birimHastaDolulukOrani(); //-----> maalesef bitmedi ve devamını getiremedim
        //yukardaki fonksiyon yüzünden yorum satırına eklenen yerler :
        // Birim -> 24-31      Randevu sınıfında birkaç tane var
    }
}
