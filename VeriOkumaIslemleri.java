import java.io.*;

public class VeriOkumaIslemleri {
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
        int sayac = 0;
        for (int i=0;i<Birim.birimListesi.size();i++){
            for(int k=0;k<Hasta.hastaListesi.size();k++){
                Birim.birimListesi.get(i).birimeAitHastaListesi.add(Hasta.hastaListesi.get(k));
                sayac++;
                if(sayac % 3 == 0){
                    break;
                }
            }
        }
    }

    public static void doktorVerileriniCekme() {

        File dosya = new File("DoktorListesi.txt");
        String dosyaYolu=dosya.getAbsolutePath();
        String isim, soyisim, TC, telefonNo;

        try {
            BufferedReader okuyucu=new BufferedReader(new FileReader(dosyaYolu));
            String satir;

            while((satir = okuyucu.readLine()) != null){
                String[] veri = satir.split(",");
                isim = veri[0];
                soyisim = veri[1];
                TC = veri[2];
                telefonNo = veri[3];

                Doktor d = new Doktor(isim, soyisim, TC, telefonNo);
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
    }

    public void ilacVerileriniCekme() {
        
    }
}
