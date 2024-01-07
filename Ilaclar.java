import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Ilaclar {
    public static ArrayList <String> aKatagorisiIlaclariList = new ArrayList<>();
    public static ArrayList <String> bKatagorisiIlaclariList = new ArrayList<>();
    public static ArrayList <String> cKatagorisiIlaclariList = new ArrayList<>();
    public static ArrayList <String> dKatagorisiIlaclariList = new ArrayList<>();

    // Bu diziyi dosyadan ilaç verilerini çekerken kullanıyorum. (Tunahan)
    public static ArrayList[] tumKatagorilerIlaclariList = {aKatagorisiIlaclariList, bKatagorisiIlaclariList, cKatagorisiIlaclariList, dKatagorisiIlaclariList};

    public  static void ilaclariGoruntule(){
        Scanner userInput = new Scanner(System.in);

        int userChoice;

        while(true){
            System.out.println("|——————————————————————————————————————————————|");
            System.out.println("Hangi Katagorideki İlaçları Görüntülemek İstersiniz?");
            System.out.println("1-) A Katagorisi\n2-) B Katagorisi\n3-) C Katagorisi\n4-) D Katagorisi");
            System.out.println("|——————————————————————————————————————————————|");

            try {
                userChoice = userInput.nextInt();

            }catch (InputMismatchException e){
                System.out.println("Hatalı giriş yaptınız. Lütfen tekrar deneyiniz.");
                userInput.nextLine();
                continue;
            }
            break;
        }

        boolean flag = true;

        while (flag){

            switch (userChoice){
                case 1:
                    System.out.println("|=============================================|");
                    for (String a : aKatagorisiIlaclariList) {
                        System.out.println("- " + a);
                    }
                    System.out.println("|=============================================|");

                    flag = false;
                    break;

                case 2:
                    System.out.println("|=============================================|");
                    for (String b : bKatagorisiIlaclariList) {
                        System.out.println("- " + b);
                    }
                    System.out.println("|=============================================|");

                    flag = false;
                    break;

                case 3:
                    System.out.println("|=============================================|");
                    for (String c : cKatagorisiIlaclariList) {
                        System.out.println("- " + c);
                    }
                    System.out.println("|=============================================|");

                    flag = false;
                    break;

                case 4:
                    System.out.println("|=============================================|");
                    for (String d : dKatagorisiIlaclariList) {
                        System.out.println("- " + d);
                    }
                    System.out.println("|=============================================|");

                    flag = false;
                    break;

                default:
                    System.out.println("Hatalı giriş yaptınız.");
                    break;
            }
        }
    }
}
