import java.io.*;
import java.util.*;


public class Hasta extends AbsractKisi implements GoruntulemeIslemleri{

    //Map değişkeni : Verileri ANAHTAR(derecelendirmenin katagorisi)--DEĞER(derecelendirmenin değeri)
    //çiftleri şeklinde depolamak için kullanılan bir veri yapısı
    public static Map<DegerlendirmeKatagori, Integer> degerler = new HashMap<>();

    //Verilen kullanıcı değerlendirmelerini kaydetmek için eklenen dizi.Her değerlendirmede tekrar oluşturulacak ve sonunda her hastanın ilgili değerlendirmesi toplanacak
    private int[] toplamKategoriDegerleri = new int[4];

    public int[] getToplamKategoriDegerleri() {
        return toplamKategoriDegerleri;
    }
    public void setToplamKategoriDegerleri(int[] toplamKategoriDegerleri) {
        this.toplamKategoriDegerleri = toplamKategoriDegerleri;
    }


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

    //Hastanın reçetesini görüntülemesi MBB
    @Override
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

    @Override
    public void doktorGoruntule() {
        for (int i=0;i<Doktor.doktorListesi.size();i++){
            System.out.println(Doktor.doktorListesi.get(i).id+" "+Doktor.doktorListesi.get(i).isim+" "+Doktor.doktorListesi.get(i).soyisim);
        }
    }
}
