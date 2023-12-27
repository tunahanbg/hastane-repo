public class HastaneYonetimi {
    public void doktorEkle(){}
    public void doktorCikar(){}
    public void hastaEkle(){}
    public void hastaCikar(){}
    public void hemsireEkle(){}

    public static void hemsireCikar(Hemsire cikarilanHemsire){
        for (int i = 0; i < Hemsire.hemsireArrayList.size(); i++){
            if(cikarilanHemsire.id == Hemsire.hemsireArrayList.get(i).id){
                Hemsire.hemsireArrayList.remove(i);
            }
        }
    }
    public void maasBelirle(){}
    public void hastaListele(){}
    public void doktorListele(){}
    public void personelListele(){}
    public static void hemsireListele(){
        for (Hemsire hemsire: Hemsire.hemsireArrayList){
            System.out.println(hemsire.isim);
        }
    }
}
