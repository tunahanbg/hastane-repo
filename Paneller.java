public class Paneller {

    public static void girisPaneli(){
        System.out.println("|——————————————————————————————————————————————|");
        System.out.println("|——————————  ——————————|>");
        System.out.println("1-) Kullanıcı Girişi");
        System.out.println("2-) Doktor Girişi");
        System.out.println("3-) Yönetici Girişi");
        System.out.println("4-) Çıkış");
        System.out.println("|——————————————————————————————————————————————|");
    }
    public static void kullaniciPaneli(){
        System.out.println("|——————————————————————————————————————————————|");
        System.out.println("1-) Poliklinikleri Görüntüle");
        System.out.println("2-) Doktorları Görüntüle");
        System.out.println("3-) Randevu Alma Talebi Oluştur");
        System.out.println("4-) Geri Dönüş Bildir");
        System.out.println("5-) Çıkış");
        System.out.println("|——————————————————————————————————————————————|");
    }
    public static void kullaniciGirisEkrani(){
        System.out.println("|——————————————————————————————————————————————|");
        System.out.println("TC Kimlik Numaranızı giriniz: ");
        System.out.println("|——————————————————————————————————————————————|");
    }

    public static void birimleriGorntule(){
        System.out.println("|——————————————————————————————————————————————|");
        for(int i=0;i<Birim.birimListesi.size();i++){
            System.out.println(Birim.birimListesi.get(i).getIsim());
        }
        System.out.println("|——————————————————————————————————————————————|");
    }

    public static void doktorlariGoruntule(){
        System.out.println("|——————————————————————————————————————————————|");
        for (int i=0;i<Doktor.doktorListesi.size();i++){
            System.out.println(Doktor.doktorListesi.get(i).id+" "+Doktor.doktorListesi.get(i).isim+" "+Doktor.doktorListesi.get(i).soyisim);
        }
        System.out.println("|——————————————————————————————————————————————|");
    }

    public static void doktorPaneli(){
        System.out.println("|——————————————————————————————————————————————|");
        System.out.println("Yapmak İstediğiniz İşlemi Seçiniz:");
        System.out.println("1-) Randevu Takvimini Görüntüle");
        System.out.println("2-) Hasta Görüntüle");
        System.out.println("3-) Reçete İşlemleri");
        System.out.println("4-) Çıkış");
        System.out.println("|——————————————————————————————————————————————|");
    }

}
