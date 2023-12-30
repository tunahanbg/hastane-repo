import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;



public class Hasta extends AbsractKisi{

    //Map değişkeni : Verileri ANAHTAR(derecelendirmenin katagorisi)--DEĞER(derecelendirmenin değeri)
    //çiftleri şeklinde depolamak için kullanılan bir veri yapısı
    public Map<DegerlendirmeKatagori, Integer> degerler = new HashMap<>();
    static Scanner tarayici = new Scanner(System.in);
    public static ArrayList<Hasta> hastaListesi=new ArrayList<Hasta>();



    public Hasta(String isim,String soyisim,String TC,String dogumTarihi,int id,int telefonNo,String dogumYeri) {
        this.isim=isim;
        this.soyisim=soyisim;
        this.TC=TC;
        this.dogumTarihi=dogumTarihi;
        this.id=id;
        this.telefonNo=telefonNo;
        this.dogumYeri=dogumYeri;
        hastaListesi.add(this);
    }



    // Hasta kayıt silme fonksiyonu
    public static void hastaSil(){

        System.out.println("Silmek istenen hastanın İD'sini giriniz ");
        int silinenHastaId = tarayici.nextInt();

        //Hastanın olup olmama furmuna göre flag ile kontrol edilir.
        boolean flag= false;

        // id ile tüm hastalar araında arama yaparak istenen hasta silinir.
        for (int i = 0; i < Hasta.hastaListesi.size(); i++) {
            if (Hasta.hastaListesi.get(i).id==silinenHastaId){
                Hasta.hastaListesi.remove(Hasta.hastaListesi.get(i));
                System.out.println(
                        Hasta.hastaListesi.get(i).isim + " isimli ve " +
                        Hasta.hastaListesi.get(i).id + " İd numaralı Hasta silindi. ");
                flag = true;
            }
        }
        if (!flag){System.out.println("Aradığınız kullanıcı bulunmamaktadır.");}

    }



    // Hasta Ekleme Fonksiyonu

    public static void hastaEkle() {

        //Eklenmek istenen hastanın gerkli bilgileri girilir
        System.out.println("Gerekli hasta bilgilerini giriniz : ");
        System.out.println(" Hasta ismi : ");
        String isim = tarayici.nextLine();

        System.out.println(" Hasta soyismi : ");
        String soyisim = tarayici.nextLine();

        System.out.println(" Hasta Tc : ");
        String tc = tarayici.nextLine();

        System.out.println(" Hasta doğum tarihi : ");
        String dogumTarihi = tarayici.nextLine();

        System.out.println(" Hasta telefon numarası : ");
        int telefonNumarasi = tarayici.nextInt();

        System.out.println(" Hasta doğum yeri : ");
        String dogumYeri = tarayici.nextLine();

        //id numarası liste boyutuna göre belirlenir
        int id = Hasta.hastaListesi.size();
        id++;

        // Yapıcı metot listeye ekler
        Hasta h = new Hasta(isim,soyisim,tc,dogumTarihi,id,telefonNumarasi,dogumYeri);


    }
}
