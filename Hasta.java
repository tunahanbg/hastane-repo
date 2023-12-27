import java.util.ArrayList;

public class Hasta extends AbsractKisi{
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
}
