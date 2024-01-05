import java.util.ArrayList;
public class Birim {
    private final int hastaKapasite;
    private String isim;

    //Protected olan değer public olarak değiştirildi çünkü yönetici panlinde kullanılacak--TNG
    public ArrayList<Doktor> birimdekiDoktorlarinListesi=new ArrayList<Doktor>();
    public static ArrayList<Birim> birimListesi=new ArrayList<Birim>();
    public static ArrayList<Hasta> birimeAitHastaListesi=new ArrayList<Hasta>();

    public Birim(String isim,int hastaKapasite) {
        this.isim = isim;
        this.hastaKapasite = hastaKapasite;
        birimListesi.add(this);
    }

    // privat değişkenler için gerekli olan encapsulation işlemleri yapılır.
    public String getIsim() {
        return isim;
    }

    public void setIsim(String isim) {
        this.isim = isim;
    }

    public int getHastaKapasite() {
        return hastaKapasite;
    }
}
