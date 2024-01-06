import java.util.ArrayList;

public class Personel extends AbsractKisi{
    public static ArrayList<Personel> personelArrayList = new ArrayList<>();

    public Personel(String isim, String soyisim) {
        super();
        personelArrayList.add(this);
    }
}
