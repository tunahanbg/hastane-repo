import java.util.ArrayList;
import java.util.Scanner;

public class Ilaclar {
    public static ArrayList <String> aKatagorisiIlaclariList = new ArrayList<>();
    public static ArrayList <String> bKatagorisiIlaclariList = new ArrayList<>();
    public static ArrayList <String> cKatagorisiIlaclariList = new ArrayList<>();
    public static ArrayList <String> dKatagorisiIlaclariList = new ArrayList<>();


    public  static void ilaclariGoruntule(){
        Scanner userInput = new Scanner(System.in);

        System.out.println("Hangi Katagorideki İlaçları Görüntülemek İstersiniz?");
        System.out.println("1-) A Katagorisi\n2-) B Katagorisi\n3-) C Katagorisi\n4-) D Katagorisi");

        int userChoice = userInput.nextInt();

        boolean flag = true;

        while (flag){

            switch (userChoice){
                case 1:
                    for (String a : aKatagorisiIlaclariList) {
                        System.out.println(a);
                        flag = false;
                    }
                    break;

                case 2:
                    for (String b : bKatagorisiIlaclariList) {
                        System.out.println(b);
                        flag = false;
                    }
                    break;

                case 3:
                    for (String c : cKatagorisiIlaclariList) {
                        System.out.println(c);
                        flag = false;
                    }
                    break;

                case 4:
                    for (String d : dKatagorisiIlaclariList) {
                        System.out.println(d);
                        flag = false;
                    }
                    break;

                default:
                    System.out.println("Hatalı giriş yaptınız.");
                    break;
            }
        }
    }


    public static void ilaclariOlustur(){
        for (int i = 0; i < 10 ; i++){
            aKatagorisiIlaclariList.add("aIlaci" + (i+1));
            cKatagorisiIlaclariList.add("cIlaci" + (i+1));
        }

        for (int i = 0; i < 15 ; i++){
            bKatagorisiIlaclariList.add("bIlaci" + (i+1));
        }

        for (int i = 0; i < 5 ; i++){
            dKatagorisiIlaclariList.add("dIlaci" + (i+1));
        }
    }


    public static void aIlaciSil(String userChoice){

        for (int i = 0; i < aKatagorisiIlaclariList.size(); i++) {
            if (aKatagorisiIlaclariList.get(i).equals(userChoice)) {
                aKatagorisiIlaclariList.remove(i);
            }
        }
    }

    public static void bIlaciSil(String userChoice){

        for (int i = 0; i < bKatagorisiIlaclariList.size(); i++){
            if(bKatagorisiIlaclariList.get(i).equals(userChoice)){
                bKatagorisiIlaclariList.remove(i);
            }

        }
    }

    public static void cIlaciSil(String userChoice){

        for (int i = 0; i < cKatagorisiIlaclariList.size(); i++){
            if(cKatagorisiIlaclariList.get(i).equals(userChoice)){
                cKatagorisiIlaclariList.remove(i);
            }
        }
    }

    public static void dIlaciSil(String userChoice){

        for (int i = 0; i < dKatagorisiIlaclariList.size(); i++){
            if(dKatagorisiIlaclariList.get(i).equals(userChoice)){
                dKatagorisiIlaclariList.remove(i);
            }
        }
    }


    public static void katagoriSec(){
        Scanner userInput = new Scanner(System.in);

        System.out.println("Hangi Katagorideki İlaçdan Seçim Yapmak istersiniz?");
        System.out.println("1-) A Katagorisi\n2-) B Katagorisi\n3-) C Katagorisi\n4-) D Katagorisi");

        int userChoice = userInput.nextInt();

        boolean flag = true;

        while (flag){
            switch (userChoice){

                case 1:
                    System.out.println("İlaç ismini giriniz: ");
                    String ilacSecimi = userInput.next();

                    if (Ilaclar.aKatagorisiIlaclariList.contains(ilacSecimi)){
                        Ilaclar.aIlaciSil(ilacSecimi);
                        flag = false;
                        break;
                    }

                    else {
                        System.out.println("Hatalı ilaç ismi girdiniz. Lütfen tekrar deneyiniz.");
                        continue;
                    }


                case 2:
                    System.out.println("İlaç ismini giriniz: ");
                    String ilacSecimi1 = userInput.next();

                    if (Ilaclar.bKatagorisiIlaclariList.contains(ilacSecimi1)){
                        Ilaclar.bIlaciSil(ilacSecimi1);
                        flag = false;
                        break;
                    }

                    else {
                        System.out.println("Hatalı ilaç ismi girdiniz. Lütfen tekrar deneyiniz.");
                        continue;
                    }


                case 3:
                    System.out.println("İlaç ismini giriniz: ");
                    String ilacSecimi2 = userInput.next();

                    if (Ilaclar.cKatagorisiIlaclariList.contains(ilacSecimi2)){
                        Ilaclar.cIlaciSil(ilacSecimi2);
                        flag = false;
                        break;
                    }

                    else {
                        System.out.println("Hatalı ilaç ismi girdiniz. Lütfen tekrar deneyiniz.");
                        continue;
                    }


                case 4:
                    System.out.println("İlaç ismini giriniz: ");
                    String ilacSecimi3 = userInput.next();

                    if (Ilaclar.dKatagorisiIlaclariList.contains(ilacSecimi3)){
                        Ilaclar.dIlaciSil(ilacSecimi3);
                        flag = false;
                        break;
                    }

                    else {
                        System.out.println("Hatalı ilaç ismi girdiniz. Lütfen tekrar deneyiniz.");
                        continue;
                    }

                default:
                    System.out.println("Hatalı giriş yaptınız. Lütfen tekrar deneyin.");
                    break;
            }
        }
    }
}
