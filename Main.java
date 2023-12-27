public class Main {
    public static void main(String[] args) {
        Hasta h1=new Hasta("aaaaa","aaaaa","123","10.10.1974",1,123,"Ankara");
        Hasta h2=new Hasta("bbbbb","bbbbb","456","10.10.1974",2,456,"İstanbul");

        Doktor d1=new Doktor("aaaaa","aaaaa","123","10.10.1974",1,123,"Ankara",EnumDoktorBrans.PEDIATRI);

        //d1.receteYaz();
        //d1.receteYaz();

        System.out.println(d1.getBrans());
        d1.hastaGoruntule();

    }
}
