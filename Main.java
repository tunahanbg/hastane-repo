import java.io.*;
import java.text.SimpleDateFormat;

public class Main {
    public static void main(String[] args) {


        Birim birim1=new Birim("Pediatri", 1);
        Birim birim2=new Birim("Üroloji",2);
        Birim birim3=new Birim("Ortopedi",2);
        Birim birim4=new Birim("Kardiyoloji", 0);
        Birim birim5=new Birim("Nöroloji", 0);
        Birim birim6=new Birim("Dahiliye", 0);
        Birim birim7=new Birim("Cerrahi", 0);




        //Doktorların txt dosyasından alınması (MBB):
        File dosya=new File("DoktorListesi.txt");
        String dosyaYolu=dosya.getAbsolutePath();
        String isim,soyisim,TC,telefonNo;
        try {
            BufferedReader okuyucu=new BufferedReader(new FileReader(dosyaYolu));
            String satir;
            while((satir= okuyucu.readLine()) != null){
                String[] veri = satir.split(",");
                isim=veri[0];
                soyisim=veri[1];
                TC=veri[2];
                telefonNo=veri[3];
                Doktor d=new Doktor(isim,soyisim,TC,telefonNo);
                boolean flag=false;
                for(int i=0;i<Doktor.doktorListesi.size();i++){
                    if(d.id==Doktor.doktorListesi.get(i).id){
                        flag=true;
                    }
                }
                if(!flag){
                    Doktor.doktorListesi.add(d);
                }
            }
            okuyucu.close();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        catch (IOException e){
            e.printStackTrace();
        }

        //Birimlere doktor atanması(MBB):
        int sayac=0;
        for (int i=0;i<Birim.birimListesi.size();i++){
            for(int k=0;k<Doktor.doktorListesi.size();k++){
                Birim.birimListesi.get(i).birimdekiDoktorlarinListesi.add(Doktor.doktorListesi.get(k));
                sayac++;
                if(sayac%3==0){
                    break;
                }
            }
        }

        //Hastaların txt dosyasından alınması (MBB):
        File dosya2=new File("HastaListesi.txt");
        String dosyaYolu2=dosya.getAbsolutePath();
        String isim2,soyisim2,TC2,telefonNo2,dogumYeri;
        try {
            BufferedReader okuyucu=new BufferedReader(new FileReader(dosyaYolu));
            String satir;
            while((satir= okuyucu.readLine()) != null){
                String[] veri = satir.split(",");
                isim2=veri[0];
                soyisim2=veri[1];
                TC2=veri[2];
                telefonNo2=veri[3];
                Hasta h=new Hasta(isim2,soyisim2,TC2,telefonNo2);
            }
            okuyucu.close();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        catch (IOException e){
            e.printStackTrace();
        }
        //Hastaların birimlere atanması
        int sayac2=0;
        for (int i=0;i<Birim.birimListesi.size();i++){
            for(int k=0;k<Hasta.hastaListesi.size();k++){
                Birim.birimListesi.get(i).birimeAitHastaListesi.add(Hasta.hastaListesi.get(k));
                sayac2++;
                if(sayac2%3==0){
                    break;
                }
            }
        }




        Randevu r1=new Randevu();
        r1.setRandevuTarihi("10 3 2024");
        Randevu.randevuListesi.add(r1);

        Randevu r2=new Randevu();
        r2.setRandevuTarihi("11 3 2024");
        Randevu.randevuListesi.add(r2);

        Randevu r3=new Randevu();
        r3.setRandevuTarihi("12 3 2024");
        Randevu.randevuListesi.add(r3);

        Randevu r4=new Randevu();
        r4.setRandevuTarihi("13 3 2024");
        Randevu.randevuListesi.add(r4);

        System.out.println(Randevu.randevuListesi.get(0).getRandevuTarihi());
        System.out.println(Randevu.randevuListesi.get(1).getRandevuTarihi());
        System.out.println(Randevu.randevuListesi.get(2).getRandevuTarihi());
        System.out.println(Randevu.randevuListesi.get(3).getRandevuTarihi());

        /*Randevu.randevuOlustur();
        System.out.println(Randevu.randevuListesi.get(Randevu.randevuListesi.size()-1).getRandevuTarihi());

        System.out.println(birim1.birimeAitHastaListesi.get(0).isim+" "+birim1.birimeAitHastaListesi.get(0).soyisim);*/

        //Randevu.randevuOlustur();
        //d1.receteYaz();
        //h1.receteGoruntule();

        //System.out.println(Birim.birimListesi.get(0).birimdekiDoktorlarinListesi.size());
        for(int i=0;i<Hasta.hastaListesi.size();i++){
            System.out.println(Hasta.hastaListesi.get(i).id+" "+Hasta.hastaListesi.get(i).isim+" "+Hasta.hastaListesi.get(i).soyisim);
        }
        for(int i=0;i<birim1.birimeAitHastaListesi.size();i++){
            System.out.println(birim1.birimeAitHastaListesi.get(i).isim);
        }









    }
}
