import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner userInput = new Scanner(System.in);

        Birim birim1=new Birim("Pediatri", 5);
        Birim birim2=new Birim("Üroloji",6);
        Birim birim3=new Birim("Ortopedi",7);
        Birim birim4=new Birim("Kardiyoloji", 6);
        Birim birim5=new Birim("Nöroloji", 5);
        Birim birim6=new Birim("Dahiliye", 8);
        Birim birim7=new Birim("Cerrahi", 5);

        //Doktorların txt dosyasından alınması (MBB):
        VeriOkumaIslemleri.doktorVerileriniCekme();

        //Hastaların txt dosyasından alınması (MBB):
        VeriOkumaIslemleri.hastaVerileriniCekme();

        //İlaçların txt dosyasından alınması (Tuna):
        VeriOkumaIslemleri.ilaciVerileriniCekme();

        //Hemşirelerin txt dosyasından çekilmesi
        VeriOkumaIslemleri.hemsireVerileriniCekme();




        // HASTANE PANELİ
        boolean flag1 = true;
        while(flag1){
            Paneller.girisPaneli();
            System.out.print("Seçiminizi giriniz:");
            String userChoice = userInput.next();
            switch (userChoice){
                // Hasta/Kullanıcı Girişi
                case "1":
                    Paneller.kullaniciGirisEkrani();
                    String tcNo;
                    while(true){
                        tcNo=userInput.next();
                        if(tcNo.length() != 11){
                            System.out.println("TC Kimlik Numaranısı 11 haneden oluşmalı.");
                        }
                        else{
                            break;
                        }
                    }

                    boolean hastaBulunmuyor=true;
                    for(int i=0;i<Hasta.hastaListesi.size();i++){
                        if(tcNo.equals(Hasta.hastaListesi.get(i).TC)){
                            System.out.println("Sisteme giriş başarılı.Hoşgeldiniz Sayın"+" "+Hasta.hastaListesi.get(i).isim+" "+Hasta.hastaListesi.get(i).soyisim+" .");
                            hastaBulunmuyor=false;
                        }
                    }
                    if (hastaBulunmuyor){
                        System.out.println("Girmiş olduğunuz TC Kimlik Numarasıyla sisteme kayıtlı hasta bulunmamaktadır.");
                        System.out.println("Tekrar Ana Menüye yönlendiriliyorsunuz.");
                        break;
                    }

                    boolean kullaniciPaneliKontrol=true;
                    while(kullaniciPaneliKontrol){
                        Paneller.kullaniciPaneli();
                        System.out.println("Seçiminiz:");
                        String kullaniciPaneliSecim=userInput.next();
                        switch (kullaniciPaneliSecim){
                            case "1":
                                for(int i=0;i<Birim.birimListesi.size();i++){
                                    System.out.println(Birim.birimListesi.get(i).getIsim());
                                }
                                break;
                            case "2":
                                for (int i=0;i<Doktor.doktorListesi.size();i++){
                                    System.out.println(Doktor.doktorListesi.get(i).id+" "+Doktor.doktorListesi.get(i).isim+" "+Doktor.doktorListesi.get(i).soyisim);
                                }
                                break;
                            case "3":
                                Randevu.randevuOlustur();
                                DegerlendirmeFormu.hastaDegerlendirmeFormu();
                                break;
                            case "4":
                                //BURASI GERİ DÖNÜŞ BİLDİR KISMI
                                break;
                            case"5":
                                System.out.println("Kullanıcı panelinden çıkış yapılıyor...");
                                kullaniciPaneliKontrol=false;
                                break;
                            default:
                                System.out.println("Yanlış seçim yaptınız.");
                                break;
                        }

                    }
                    break;


                //Doktor Girişi
                case "2":
                    Paneller.kullaniciGirisEkrani();
                    String tcNoDoktor;
                    while(true){
                        tcNoDoktor=userInput.next();
                        if(tcNoDoktor.length() != 11){
                            System.out.println("TC Kimlik Numaranısı 11 haneden oluşmalı.");
                        }
                        else{
                            break;
                        }
                    }

                    boolean doktorBulunmuyor=true;
                    for(int i=0;i<Doktor.doktorListesi.size();i++){
                        if(tcNoDoktor.equals(Doktor.doktorListesi.get(i).TC)){
                            System.out.println("Sisteme giriş başarılı.Hoşgeldiniz Sayın"+" "+Doktor.doktorListesi.get(i).isim+" "+Doktor.doktorListesi.get(i).soyisim+" .");
                            doktorBulunmuyor=false;
                        }
                    }
                    if (doktorBulunmuyor){
                        System.out.println("Girmiş olduğunuz TC Kimlik Numarasıyla sisteme kayıtlı doktor bulunmamaktadır.");
                        System.out.println("Tekrar Ana Menüye yönlendiriliyorsunuz.");
                        break;
                    }

                    boolean doktorPaneliKontrol=true;
                    while(doktorPaneliKontrol){
                        Paneller.doktorPaneli();
                        System.out.print("Seçiminiz:");
                        String doktorPaneliSecimi=userInput.next();
                        switch (doktorPaneliSecimi){
                            case "1":
                                if(Randevu.randevuListesi.isEmpty()){
                                    System.out.println("Şuanda herhangi bir doktora atanmış randevu bulunmamaktadır.");
                                    break;
                                }
                                boolean randevuVarMi=true;
                                for(int i=0;i<Randevu.randevuListesi.size();i++){
                                    if(tcNoDoktor.equals(Randevu.randevuListesi.get(i).getDoktor().TC)){
                                        System.out.println("Randevu ID:"+Randevu.randevuListesi.get(i).getID());
                                        System.out.println("Randevu Tarihi:"+Randevu.randevuListesi.get(i).getRandevuTarihi());
                                        System.out.println("Doktor:"+Randevu.randevuListesi.get(i).getDoktor().isim+" "+Randevu.randevuListesi.get(i).getDoktor().soyisim);
                                        System.out.println("Hasta:"+Randevu.randevuListesi.get(i).getHasta().isim+" "+Randevu.randevuListesi.get(i).getHasta().soyisim);
                                    }
                                    else{
                                        randevuVarMi=false;
                                    }
                                }
                                if (!randevuVarMi){
                                    System.out.println("Atanmış randevunuz bulunmamaktadır.");
                                }
                                break;
                            case "2":
                                for (int i=0;i<Doktor.doktorListesi.size();i++){
                                    if(Doktor.doktorListesi.get(i).TC.equals(tcNoDoktor)){
                                        Doktor.doktorListesi.get(i).hastaGoruntule();
                                    }
                                }
                                break;
                            case "3":
                                Doktor doktor=new Doktor();
                                for (int i=0;i<Doktor.doktorListesi.size();i++){
                                    if (Doktor.doktorListesi.get(i).TC.equals(tcNoDoktor)){
                                          doktor=Doktor.doktorListesi.get(i);
                                    }
                                }
                                doktor.receteYaz();
                                break;
                            case "4":
                                System.out.println("Doktor Panelinden çıkış yapılıyor.");
                                doktorPaneliKontrol=false;
                                break;
                        }
                    }
                    break;


                // Yönetici Girişi  ---------DÜZELTİLMESİ GEREKİYOR------------
                case "3":
                    Admin admin = new Admin();
                    System.out.println("Yönetici İşlemlerine Hoşgeldiniz. Yapmak istediğinizişlemi seçiniz :");
                    System.out.println(" 1: Maliye işlemleri");
                    System.out.println(" 2: Hasta işlemleri");
                    System.out.println(" 3: Analizler ");
                    System.out.println(" 4: Birimlerin Doluluk oranı ");

                    String yapilmakIstenenIslem = userInput.next();
                    switch (yapilmakIstenenIslem){
                        case "1":
                            YoneticiPaneli.muhasebeIslemleri();
                            break;
                        case "2":
                            YoneticiPaneli.hastaFonksiyonlariYonetimi();
                            break;
                        case "3"://Değerlendirme katagorilerinin aldıkları değerlerin toplamı
                            DegerlendirmeFormu.katagoriOrtalamaDegerlendirmeleri();
                            break;
                        case "4"://Birimlerin doluluk oranlarını hesaplar
                            YoneticiPaneli.birimHastaDolulukOrani();
                            break;
                        default:
                            break;
                    }

                    break;
                case "4":
                    System.out.println("Çıkış yapılıyor...");
                    flag1 = false;
                    break;
                default:
                    System.out.println("Hatalı giriş yaptınız. Lütfen tekrar deneyiniz.");
                    break;
            }

        }




        /*Randevu r1=new Randevu();
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
        System.out.println(Randevu.randevuListesi.get(3).getRandevuTarihi());*/

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
