import java.util.ArrayList;

public class Hemsire extends AbsractKisi {
    public static ArrayList<Hemsire> hemsireArrayList = new ArrayList<>();


    public Hemsire(String isim, String soyisim, int maas) {
        this.isim = isim;
        this.soyisim = soyisim;
        this.maas = maas;
        hemsireArrayList.add(this);
    }
}
