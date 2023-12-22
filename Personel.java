import java.util.ArrayList;

public class Personel extends AbsractKisi{
    public static ArrayList<Personel> personelArrayList = new ArrayList<>();

    public Personel() {
        super();
        personelArrayList.add(this);
    }
}
