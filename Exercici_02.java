public class E2_FernandezC {
    public static void main(String[] args) {
     
     //Declarem valors i calculem areas i volums   
     int llarg1 = 300;
     int llarg2 = 300;
     int ample1 = 150;
     int ample2 = 80;
     int deep1 = 20;
     int deep2 = 35;
     
     int area1 = llarg1*ample1;
     int area2 = llarg2*ample2;
     int vol1 = llarg1*ample1*deep1;
     int vol2 = llarg2*ample2*deep2;
     
     int nLlarg = llarg1;
     int nAmple = ample1 + ample2;
     int nArea = nLlarg*nAmple;
     int totalVol = vol1 + vol2;
     
     //Mostrem informacio demanada
     System.out.println("Area de la piscina 1: " + area1+" m^2");
     System.out.println("Area de la piscina 2: " + area2+" m^2");
     System.out.println("\nVolum de la piscina 1: " + vol1+" m^3");
     System.out.println("Volum de la piscina 2: " + vol2+" m^3");
     
     System.out.println("\nSi posesim les dues piscines de costat la piscina resultant faria "+nLlarg+"m de llarg y "+nAmple+ "m d'ample");
     System.out.println("L'àrea d'aquesta nova piscina seria de "+nArea+"m^2") ;
     System.out.println("El volum total de les dues piscines es de: "+totalVol+"m^3");
     
     //Declarem una nova variable auxiliar per intercanviar fondaries
     int aux = deep1;
     deep1 = deep2;
     deep2 = aux;
     
     //Mostrem les noves mesures de la piscina1 i de la piscina 2 i el seu no volum
     System.out.println("\nSi intercanviem els valors de profunditat de les dos piscines...");
     System.out.println("La piscina 1 fa ara: " + llarg1+"m de llarg "+ample1+"m d'ample i "+deep1+"m^3 de profunditat, i te una capacitat de "+area1*deep1+ "m^3");
     System.out.println("La piscina 2 fa ara: " + llarg2+"m de llarg "+ample2+"m d'ample i "+deep2+"m^3 de profunditat, i te una capacitat de "+area2*deep2+"m^3");
     
    }
}
