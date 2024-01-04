import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;


public class Hasta extends AbsractKisi{

    //Map değişkeni : Verileri ANAHTAR(derecelendirmenin katagorisi)--DEĞER(derecelendirmenin değeri)
    //çiftleri şeklinde depolamak için kullanılan bir veri yapısı
    public static Map<DegerlendirmeKatagori, Integer> degerler = new HashMap<>();
    static Scanner tarayici = new Scanner(System.in);
    public static ArrayList<Hasta> hastaListesi=new ArrayList<Hasta>();

    public Hasta(String isim, String soyisim, String TC, String dogumTarihi, int id, int telefonNo, String dogumYeri) {
        this.isim=isim;
        this.soyisim=soyisim;
        this.TC=TC;
        this.dogumTarihi=dogumTarihi;
        this.id=id;
        this.telefonNo=telefonNo;
        this.dogumYeri=dogumYeri;
        hastaListesi.add(this);
    }




}
