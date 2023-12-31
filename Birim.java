import java.util.ArrayList;
public class Birim {
    private String isim;
    private int hastaKapasite;
    protected ArrayList<Doktor> birimdekiDoktorlarinListesi=new ArrayList<Doktor>();
    public static ArrayList<Birim> birimListesi=new ArrayList<Birim>();

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


    //bunlar hasta doluluk oranı fonksiyonu açılınca tekrar açılacak
    /*public int getHastaKapasite() {
        return hastaKapasite;
    }

    public void setHastaKapasite(int hastaKapasite) {
        this.hastaKapasite = hastaKapasite;
    }*/
}
