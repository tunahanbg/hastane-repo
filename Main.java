import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner userInput = new Scanner(System.in);

        //Doktorların txt dosyasından alınması (MBB):
        VeriOkumaIslemleri.doktorVerileriniCekme();

        //Hastaların txt dosyasından alınması (MBB):
        VeriOkumaIslemleri.hastaVerileriniCekme();

        //İlaçların txt dosyasından alınması (Tuna):
        VeriOkumaIslemleri.ilaciVerileriniCekme();

        Paneller.girisPaneli();


        boolean flag1 = true;
        while(flag1){

            String userChoice = userInput.next();
            switch (userChoice){
                case "1":
                    flag1 = false;
                    break;

                case "2":
                    flag1 = false;
                    break;

                case "3":
                    flag1 = false;
                    break;
                default:
                    System.out.println("Hatalı giriş yaptınız. Lütfen tekrar deneyiniz.");
                    break;
            }

        }









        Birim birim1=new Birim("Pediatri", 1);
        Birim birim2=new Birim("Üroloji",2);
        Birim birim3=new Birim("Ortopedi",2);
        Birim birim4=new Birim("Kardiyoloji", 0);
        Birim birim5=new Birim("Nöroloji", 0);
        Birim birim6=new Birim("Dahiliye", 0);
        Birim birim7=new Birim("Cerrahi", 0);





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

//        Randevu.randevuOlustur();

        

//        System.out.println(Birim.birimListesi.get(0).birimdekiDoktorlarinListesi.size());
//        for(int i=0;i<Hasta.hastaListesi.size();i++){
//            System.out.println(Hasta.hastaListesi.get(i).id+" "+Hasta.hastaListesi.get(i).isim+" "+Hasta.hastaListesi.get(i).soyisim);
//        }
//        for(int i=0;i<birim1.birimeAitHastaListesi.size();i++){
//            System.out.println(birim1.birimeAitHastaListesi.get(i).isim);
//        }
//
//        for (int i = 0; i < Doktor.doktorListesi.size(); i++){
//            System.out.println(Doktor.doktorListesi.get(i).isim + " " + Doktor.doktorListesi.get(i).soyisim);
//        }








    }
}
