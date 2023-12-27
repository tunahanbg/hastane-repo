import java.util.ArrayList;

public class Hemsire extends AbsractKisi {
    public static ArrayList<Hemsire> hemsireArrayList = new ArrayList<>();
    public boolean atamaDurumu;

    public Hemsire(String isim, String soyisim, String TC, String dogumTarihi, int id, String telefonNo, String dogumYeri, boolean atamaDurumu) {
        super();
        this.atamaDurumu = atamaDurumu;
        hemsireArrayList.add(this);
    }
}
