import java.util.ArrayList;
public class Birim {
    private String isim;
    protected ArrayList<Doktor> birimdekiDoktorlarinListesi=new ArrayList<Doktor>();
    public static ArrayList<Birim> birimListesi=new ArrayList<Birim>();

    public ArrayList<Hasta> birimeAitHastaListesi=new ArrayList<Hasta>();

    public Birim(String isim) {
        this.isim = isim;
        birimListesi.add(this);
    }

    public String getIsim() {
        return isim;
    }

    public void setIsim(String isim) {
        this.isim = isim;
    }
}
