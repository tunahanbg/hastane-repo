import java.io.*;

public class VeriOkumaIslemleri {

    // txt dosyalarından hasta verilerini çekme
    public static void hastaVerileriniCekme() {
        File dosya = new File("HastaListesi.txt");
        String dosyaYolu = dosya.getAbsolutePath();
        String isim2,soyisim2,TC2,telefonNo2;

        try {
            BufferedReader okuyucu = new BufferedReader(new FileReader(dosyaYolu));
            String satir;

            while((satir= okuyucu.readLine()) != null){
                String[] veri = satir.split(",");
                isim2 = veri[0];
                soyisim2 = veri[1];
                TC2 = veri[2];
                telefonNo2 = veri[3];
                Hasta h = new Hasta(isim2,soyisim2,TC2,telefonNo2);
            }
            okuyucu.close();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        catch (IOException e){
            e.printStackTrace();
        }

        //Hastaların birimlere atanması
        int sayac=0;
        int k=0;
        for (int i=0;i<Birim.birimListesi.size();i++){
            for(   ; k<Hasta.hastaListesi.size() ;k++){
                Birim.birimListesi.get(i).birimeAitHastaListesi.add(Hasta.hastaListesi.get(k));
                sayac++;
                if(sayac%3==0){
                    break;
                }
            }
            k++;
        }
    }

    // txt dosyalarından doktor bilgilerini çekme
    public static void doktorVerileriniCekme() {

        File dosya = new File("DoktorListesi.txt");
        String dosyaYolu = dosya.getAbsolutePath();
        String isim, soyisim, TC;
        int maas;

        try {
            BufferedReader okuyucu = new BufferedReader(new FileReader(dosyaYolu));
            String satir;

            while((satir = okuyucu.readLine()) != null){
                String[] veri = satir.split(",");
                isim = veri[0];
                soyisim = veri[1];
                TC = veri[2];
                maas = Integer.parseInt(veri[3]);

                Doktor d = new Doktor(isim, soyisim, TC, maas);
                boolean flag = false;

                for(int i = 0; i < Doktor.doktorListesi.size(); i++){
                    if(d.id == Doktor.doktorListesi.get(i).id){
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
        int sayac2=0;
        int k2=0;
        for (int i=0;i<Birim.birimListesi.size();i++){
            for(   ; k2<Doktor.doktorListesi.size() ;k2++){
                Birim.birimListesi.get(i).birimdekiDoktorlarinListesi.add(Doktor.doktorListesi.get(k2));
                sayac2++;
                if(sayac2%3==0){
                    break;
                }
            }
            k2++;
        }

    }


    // txt dosyalarından ilaç isimlerini çekme işlemi
    public static void ilaciVerileriniCekme() {

        int i = 0;
        String[] pathnames = {"a_Ilaclari.txt", "b_Ilaclari.txt", "c_Ilaclari.txt", "d_Ilaclari.txt",};

        for (String pathname : pathnames) {
            File dosya = new File(pathname);
            String dosyaYolu = dosya.getAbsolutePath();
            String ilacIsmi;

            try {

                BufferedReader okuyucu = new BufferedReader(new FileReader(dosyaYolu));
                String satir;

                while ((satir = okuyucu.readLine()) != null) {
                    ilacIsmi = satir;
                    Ilaclar.tumKatagorilerIlaclariList[i].add(ilacIsmi);
                }
                okuyucu.close();

            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            } catch (IOException e) {
                e.printStackTrace();
            }
            i++;
        }
    }

    public static void hemsireVerileriniCekme(){
        File dosya = new File("HemsireListesi.txt");
        String dosyaYolu = dosya.getAbsolutePath();
        String isim, soyisim;
        int maas;

        try {
            BufferedReader okuyucu = new BufferedReader(new FileReader(dosyaYolu));
            String satir;

            while((satir = okuyucu.readLine()) != null){
                String[] veri = satir.split(",");
                isim = veri[0];
                soyisim = veri[1];
                maas = Integer.parseInt(veri[2]);

                Hemsire h = new Hemsire(isim, soyisim, maas);
            }
            okuyucu.close();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }
}
