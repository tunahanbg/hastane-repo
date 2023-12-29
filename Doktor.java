import javax.imageio.IIOException;
import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Doktor extends AbsractKisi implements IHemsireAlabilenler{
    Scanner tarayici=new Scanner(System.in);
    public static int farkliID=0;

    public static ArrayList<Doktor> doktorListesi=new ArrayList<Doktor>();
    //Her nesnenin bir doktor listesine sahip olması saçma olurdu.Doktor listesi nesneden bağımsız sınıfa ait yani static olarak tanımlandığında her değişikliği yansıtacaktır.public tanımlamamın nedeni ise Yönetim sınıfının da operasyonlarında bu listeye erişimini sağlayabilmek.

    public Doktor(String isim,String soyisim,String TC,String dogumTarihi,int telefonNo,String dogumYeri) {
        this.isim=isim;
        this.soyisim=soyisim;
        this.TC=TC;
        this.dogumTarihi=dogumTarihi;
        this.id=++farkliID;
        this.telefonNo=telefonNo;
        this.dogumYeri=dogumYeri;
        //Yukarıda "this." ile ulaştığımız alanlar aslında kalıtım aldığımız AbstractKisi sınıfındaki alanları işaret eder, referans gösterir.
        //Aşağıdaki kodda ise oluşturduğumuz Doktor nesnesini doktorListesi arraylistine ekliyoruz.Burada this yeni oluşturduğumuz Doktor nesnesini referans ediyor.
        doktorListesi.add(this);
    }

    //Encapsulation(Kapsülleme)

    public void hastaGoruntule(){
        for(int i=0;i<Hasta.hastaListesi.size();i++){
            System.out.println(Hasta.hastaListesi.get(i).id+"-"+" Hastanın İsmi:"+Hasta.hastaListesi.get(i).isim+" Hastanın Soyismi"+Hasta.hastaListesi.get(i).soyisim+" Hastanın TC'si:"+Hasta.hastaListesi.get(i).TC);
        }
    }

    //Reçeteyi hangi hastaya yazacağını hasta id'si ile karar versin, Randeveu görüntüle kısmından veya tüm hastaları görüntüleyerek hasta id'sine ulaşabiliriz.
    public void receteYaz(){
        System.out.print("Reçete yazmak istediğiniz hastanın id'si:");
        int hastaID=tarayici.nextInt();
        System.out.print("Reçete:");
        String recete=tarayici.nextLine();
        String metinDosyasiAdi="";
        for(int i=0;i<Hasta.hastaListesi.size();i++){
            if(Hasta.hastaListesi.get(i).id==hastaID){
                metinDosyasiAdi=Hasta.hastaListesi.get(i).isim+" "+Hasta.hastaListesi.get(i).soyisim+".txt";
            }
        }
        String dosyaYolu="C:\\Users\\mahfu\\IdeaProjects\\hastane-repo\\out\\"+metinDosyasiAdi;
        try{
            File dosya=new File(dosyaYolu);
            if(!dosya.exists()){
                dosya.createNewFile();
            }
        }
        catch (IOException e){
            e.printStackTrace();
        }

        PrintWriter yazici=null;
        try{
            yazici=new PrintWriter(new FileWriter(dosyaYolu,true));
            yazici.println(recete);
            yazici.close();
        }
        catch (FileNotFoundException e){
            System.out.println("Dosya oluşturulurken hata oluştu.");
        }
        catch (IOException e){
            e.printStackTrace();
        }


    }
}
