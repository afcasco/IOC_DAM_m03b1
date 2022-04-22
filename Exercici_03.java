import java.util.Scanner;

public class E3_FernandezC {

    //La llargada es predefinida com a constant
    public static final float LLARG = 300.3f;

    public static void main(String[] args) {

        System.out.println("VERSIO 2, AMB VALORS INTRODUITS PER TECLAT I CONVERSIO DE TIPUS");
        //L'usuari introdueix els valors d'ample i profunditat com a nmbres reals
        Scanner lector = new Scanner(System.in);
        System.out.println("Introdueix l'ample de la piscina 1");
        float ample1 = lector.nextFloat();
        System.out.println("Introdueix l'ample de la piscina 2");
        float ample2 = lector.nextFloat();
        System.out.println("Introdueix la profunditat de la piscina 1");
        float deep1 = lector.nextFloat();
        System.out.println("Introdueix la profunditat de la piscina 2");
        float deep2 = lector.nextFloat();

        float aux;
        int area1 = (int)(LLARG*ample1);
        int area2 = (int)(LLARG*ample2);
        int vol1 = (int)(LLARG*ample1*deep1);
        int vol2 = (int)(LLARG*ample2*deep2);

        float nAmple = ample1 + ample2;
        int nArea = (int)(LLARG*2*nAmple);
        int totalVol = vol1 + vol2;

        //Mostrem informacio demanada
        System.out.println("Area de la piscina 1: " + area1+" m^2");
        System.out.println("Area de la piscina 2: " + area2+" m^2");
        System.out.println("\nVolum de la piscina 1: " + vol1+" m^3");
        System.out.println("Volum de la piscina 2: " + vol2+" m^3");

        System.out.println("\nSi posesim les dues piscines de costat la piscina resultant faria "+LLARG*2+"m de llarg y "+nAmple+ "m d'ample");
        System.out.println("L'àrea d'aquesta nova piscina seria de "+nArea+"m^2") ;
        System.out.println("El volum total de les dues piscines es de: "+totalVol+"m^3");

        //intercanviem valor profunditats amb variable auxiliar
        aux = deep1;
        deep1 = deep2;
        deep2 = aux;

        //Mostrem les noves mesures de la piscina1 i de la piscina 2 i el seu no volum
        System.out.println("\nSi intercanviem els valors de profunditat de les dos piscines...");
        System.out.println("La piscina 1 fa ara: " + LLARG+"m de llarg "+ample1+"m d'ample i "+deep1+"m^3 de profunditat, i te una capacitat de "+area1*deep1+ "m^3");
        System.out.println("La piscina 2 fa ara: " + LLARG+"m de llarg "+ample2+"m d'ample i "+deep2+"m^3 de profunditat, i te una capacitat de "+area2*deep2+"m^3");

    }
}


