import java.io.*;
import java.util.*;


public class Hasta extends AbsractKisi{

    //Map değişkeni : Verileri ANAHTAR(derecelendirmenin katagorisi)--DEĞER(derecelendirmenin değeri)
    //çiftleri şeklinde depolamak için kullanılan bir veri yapısı
    public static Map<DegerlendirmeKatagori, Integer> degerler = new HashMap<>();
    static Scanner tarayici = new Scanner(System.in);
    public static ArrayList<Hasta> hastaListesi=new ArrayList<Hasta>();

    public ArrayList <String> recetedekiIlaclar = new ArrayList<>();

    public Hasta(){}

    public static int farkliID=1;
    public Hasta(String isim,String soyisim,String TC,String telefonNo) {
        this.isim=isim;
        this.soyisim=soyisim;
        this.TC=TC;
        this.id=farkliID++;
        this.telefonNo=telefonNo;
        hastaListesi.add(this);
    }



    // Hasta kayıt silme fonksiyonu
    public static void hastaSil(){

        int silinenHastaId;

        while(true){
            System.out.println("Silmek istenen hastanın İD'sini giriniz ");

            try {
                silinenHastaId = tarayici.nextInt();
            }
            catch (InputMismatchException e){
                System.out.println("Hatalı giriş yaptınız. Lütfen tekrar deneyiniz.");
                tarayici.nextLine();
                continue;
            }
            break;

        }

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
        String telefonNumarasi = tarayici.nextLine();

        System.out.println(" Hasta doğum yeri : ");
        String dogumYeri = tarayici.nextLine();

        //id numarası liste boyutuna göre belirlenir
        int id = Hasta.hastaListesi.size();
        id++;

        // Yapıcı metot listeye ekler
        Hasta h = new Hasta(isim,soyisim,tc,telefonNumarasi);
    }

    //Hastanın reçetesini görüntülemesi MBB
    public void receteGoruntule(){
        System.out.print("TC Kimlik Numaranız:");
        String tcKimlik=tarayici.nextLine();

        String dosyaIsmi="";
        for (int i=0;i<hastaListesi.size();i++){
            if(hastaListesi.get(i).TC.equals(tcKimlik)){
                dosyaIsmi=(hastaListesi.get(i).isim+" "+hastaListesi.get(i).soyisim+".txt");
            }
        }

        File dosya=new File(dosyaIsmi);
        String dosyaYolu=dosya.getAbsolutePath();
        try {
            BufferedReader okuyucu=new BufferedReader(new FileReader(dosyaYolu));
            String satir;
            while((satir= okuyucu.readLine()) != null){
                System.out.println(satir);
            }
            okuyucu.close();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }
}
