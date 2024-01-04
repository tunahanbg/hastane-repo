public class Paneller {

    public static void girisPaneli(){
        System.out.println("1-) Kullanıcı Girişi");
        System.out.println("2-) Doktor Girişi");
        System.out.println("3-) Yönetici Girişi");
    }
    public static void kullaniciPaneli(){
        System.out.println("|——————————————————————————————————————————————|");
        System.out.println("1-) Poliklinikleri Görüntüle");
        System.out.println("2-) Doktorları Görüntüle");
        System.out.println("3-) Randevu Alma Talebi Oluştur");
        System.out.println("4-) Hemşire'ye Not Bırak");
        System.out.println("5-) Geri Dönüş Bildir");
        System.out.println("|——————————————————————————————————————————————|");
    }

    public static void kullaniciGeriDonusPaneli(){
        System.out.println("|——————————————————————————————————————————————|");
        System.out.println("Geri Dönüş Yapmak İstediğiniz Birimi Seçiniz:");
        System.out.println("1-) Hastane Hakkında");
        System.out.println("2-) Doktor Hakkında");
        System.out.println("3-) Hemşire Hakkında");
        System.out.println("|——————————————————————————————————————————————|");
    }
    public static void doktorPaneli(){
        System.out.println("|——————————————————————————————————————————————|");
        System.out.println("Yapmak İstediğiniz İşlemi Seçiniz:");
        System.out.println("1-) Randevu Takvimini Görüntüle");
        System.out.println("2-) Hasta ");
        System.out.println("|——————————————————————————————————————————————|");
    }
    public static void adminPaneli(){
        System.out.println("|——————————————————————————————————————————————|");
        System.out.println("Yapmak İstediğiniz İşlemi Seçiniz:");
        System.out.println("1-) Doktorları Görüntüle");
        System.out.println("2-) Hemşireleri Görüntüle");
        System.out.println("3-) Hastaları Görüntüle");
        System.out.println("4-) Personelleri Görüntüle");
        System.out.println("|——————————————————————————————————————————————|");
    }

    public static void adminDoktorPaneli(){
        System.out.println("|——————————————————————————————————————————————|");
        System.out.println("1-) Doktorları Görüntüle");
        System.out.println("2-) Doktor Ekle");
        System.out.println("3-) Doktor Çıkar");
        System.out.println("|——————————————————————————————————————————————|");
    }

    public static void adminHemsirePaneli(){
        System.out.println("|——————————————————————————————————————————————|");
        System.out.println("1-) Hemşireleri Görüntüle");
        System.out.println("1-) Hemşireleri Görüntüle");
        System.out.println("1-) Hemşireleri Görüntüle");
        System.out.println("|——————————————————————————————————————————————|");
    }
}
