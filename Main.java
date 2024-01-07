import java.sql.SQLOutput;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner userInput = new Scanner(System.in);

        Birim birim1 = new Birim("Pediatri", 5);
        Birim birim2 = new Birim("Üroloji",6);
        Birim birim3 = new Birim("Ortopedi",7);
        Birim birim4 = new Birim("Kardiyoloji", 6);
        Birim birim5 = new Birim("Nöroloji", 5);
        Birim birim6 = new Birim("Dahiliye", 8);
        Birim birim7 = new Birim("Cerrahi", 5);

        //Doktorların txt dosyasından alınması (MBB):
        VeriOkumaIslemleri.doktorVerileriniCekme();

        //Hastaların txt dosyasından alınması (MBB):
        VeriOkumaIslemleri.hastaVerileriniCekme();

        //İlaçların txt dosyasından alınması (Tuna):
        VeriOkumaIslemleri.ilaciVerileriniCekme();

        //Hemşirelerin txt dosyasından çekilmesi
        VeriOkumaIslemleri.hemsireVerileriniCekme();


        System.out.println("\n\n<|================= HOŞGELDİNİZ =================|>\n\n");
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
                            System.out.println("\nTC Kimlik Numaranısı 11 haneden oluşmalı.\n");
                        }
                        else{
                            break;
                        }
                    }

                    boolean hastaBulunmuyor=true;
                    for(int i=0;i<Hasta.hastaListesi.size();i++){
                        if(tcNo.equals(Hasta.hastaListesi.get(i).TC)){
                            System.out.println("\nSisteme giriş başarılı. Hoşgeldiniz Sayın"+" "+Hasta.hastaListesi.get(i).isim+" "+Hasta.hastaListesi.get(i).soyisim+" .\n");
                            hastaBulunmuyor = false;
                        }
                    }

                    if (hastaBulunmuyor){
                        System.out.println("\nGirmiş olduğunuz TC Kimlik Numarasıyla sisteme kayıtlı hasta bulunmamaktadır.");
                        System.out.println("Tekrar Ana Menüye yönlendiriliyorsunuz.\n");
                        break;
                    }

                    boolean kullaniciPaneliKontrol=true;
                    while(kullaniciPaneliKontrol){
                        Paneller.kullaniciPaneli();
                        System.out.println("Seçiminiz:");
                        String kullaniciPaneliSecim=userInput.next();
                        switch (kullaniciPaneliSecim){
                            case "1":
                                Paneller.birimleriGorntule();
                                break;
                            case "2":
                                Paneller.doktorlariGoruntule();
                                break;
                            case "3":
                                Randevu.randevuOlustur();
                                break;
                            case "4":
                                //BURASI GERİ DÖNÜŞ BİLDİR KISMI
                                DegerlendirmeFormu.hastaDegerlendirmeFormu();
                                break;
                            case"5":
                                System.out.println("\nKullanıcı panelinden çıkış yapılıyor...\n");
                                kullaniciPaneliKontrol = false;
                                break;
                            default:
                                System.out.println("\nYanlış seçim yaptınız.\n");
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
                            System.out.println("\nSisteme giriş başarılı. Hoşgeldiniz Sayın" + " " + Doktor.doktorListesi.get(i).isim + " " + Doktor.doktorListesi.get(i).soyisim + " .\n");
                            doktorBulunmuyor=false;
                        }
                    }
                    if (doktorBulunmuyor){
                        System.out.println("\nGirmiş olduğunuz TC Kimlik Numarasıyla sisteme kayıtlı doktor bulunmamaktadır.");
                        System.out.println("Tekrar Ana Menüye yönlendiriliyorsunuz.\n");
                        break;
                    }

                    boolean doktorPaneliKontrol=true;
                    while(doktorPaneliKontrol){
                        Paneller.doktorPaneli();
                        System.out.print("Seçiminiz:");
                        String doktorPaneliSecimi = userInput.next();
                        switch (doktorPaneliSecimi){
                            case "1":
                                if(Randevu.randevuListesi.isEmpty()){
                                    System.out.println("\nŞu anda herhangi bir doktora atanmış randevu bulunmamaktadır.\n");
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
                                    System.out.println("\nAtanmış randevunuz bulunmamaktadır.\n");
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
                                System.out.println("\nDoktor Panelinden çıkış yapılıyor.\n");
                                doktorPaneliKontrol=false;
                                break;
                            default:
                                System.out.println("\nHatalı giriş yaptınız. Lütfen tekrar deneyiniz.\n");
                        }
                    }
                    break;


                // Yönetici Girişi
                case "3":
                    Admin admin = new Admin();

                    System.out.println("|——————————————————————————————————————————————|");
                    System.out.println("Yönetici Şifresini Giriniz:");
                    System.out.println("|——————————————————————————————————————————————|");

                    String adminSifreKontrol = userInput.next();

                    if(admin.getAdminSifre().equals(adminSifreKontrol)){

                        boolean yoneticiFlag = true;
                        while(yoneticiFlag){
                            System.out.println("|——————————————————————————————————————————————|");
                            System.out.println("Yönetici İşlemlerine Hoşgeldiniz. Yapmak istediğiniz işlemi seçiniz :");
                            System.out.println("1-) Maliye işlemleri");
                            System.out.println("2-) Hasta işlemleri");
                            System.out.println("3-) Analizler ");
                            System.out.println("4-) Birimlerin Doluluk oranı ");
                            System.out.println("5-) Reçete Görüntüle ");
                            System.out.println("6-) Doktorları Görüntüle ");
                            System.out.println("7-) Çıkış ");
                            System.out.println("|——————————————————————————————————————————————|");

                            String yapilmakIstenenIslem = userInput.next();
                            switch (yapilmakIstenenIslem){
                                case "1":
                                    YoneticiPaneli.muhasebeIslemleri();
                                    continue;
                                case "2":
                                    YoneticiPaneli.hastaFonksiyonlariYonetimi();
                                    break;
                                case "3"://Değerlendirme katagorilerinin aldıkları değerlerin toplamı
                                    DegerlendirmeFormu.katagoriOrtalamaDegerlendirmeleri();
                                    break;
                                case "4"://Birimlerin doluluk oranlarını hesaplar
                                    YoneticiPaneli.birimHastaDolulukOrani();
                                    break;
                                case "5":
                                    admin.receteGoruntule();
                                    break;
                                case "6":
                                    admin.doktorGoruntule();
                                    break;
                                case "7":
                                    System.out.println("\nYönetim panelinden çıkış yapılıyor...\n");
                                    yoneticiFlag = false;
                                    break;
                                default:
                                    System.out.println("\nHatalı seçim yaptınız. Lütfen tekrar deneyiniz.\n");
                                    break;
                            }

                        }

                    }
                    else {
                        System.out.println("\nHatalı şifre girdiniz. Ana menüye yönlendiriliyorsunuz.\n");
                    }

                    break;
                case "4":
                    System.out.println("\nGeçmiş Olsun Efenim, İyi Günler Dileriz :)\n");
                    flag1 = false;
                    break;
                default:
                    System.out.println("\nHatalı giriş yaptınız. Lütfen tekrar deneyiniz.\n");
                    break;
            }

        }

    }
}
