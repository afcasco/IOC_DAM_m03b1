import java.util.Scanner;

public class E7_FernandezC {

    private static final float IVASUPERREDUIT = 0.04f;
    private static final float IVAREDUIT = 0.08f;
    private static final float IVAGENERAL = 0.21f;
    private static final int MEDICAMENTS = 1;
    private static final int FARINES = 2;
    private static final int MEDICAMENTSVET = 3;
    private static final int AIGUES = 4;
    private static final int COSMETICS = 5;
    private static final int ALCOHOLIQUES = 6;
    private static final int ENVIAPOC = 3;
    private static final int ENVIAMIG = 20;
    private static final int ENVIAMES = 50;
    private static final int MIN = 100;
    private static final int MAX = 500;

    public static void main(String[] args) {

        int opcio;
        float preu;
        int unitats;
        int cat;
        float preuFinal;
        float preuFinalNoIva;
        Scanner entrada = new Scanner(System.in);

        System.out.println("-------------------------------------------------|");
        System.out.println("BENVINGUT AL TEU MAGATZEM!                       |");
        System.out.println("-------------------------------------------------|");
        System.out.println("Calcular preu final       (1)                    |");
        System.out.println("Mostrar quin IVA s'aplica (2)                    |");
        System.out.println("Cost de l'enviament       (3)                    |");
        System.out.println("-------------------------------------------------|");

        //Demanem introduir opcio fins que s'esculli una de les opcions valides
        do {
            System.out.print("Introdueix una opció (1, 2 o 3):\n");
            while (!entrada.hasNextInt()) {
                entrada.next();
                System.out.println("Introdueix una opció (1, 2 o 3:\n");
            }
            opcio = entrada.nextInt();
        } while (opcio < 1 || opcio > 3);
        
        //Codi a executar per la opció 1
        if (opcio == 1) {
            System.out.println("Introdueix el preu base del prodcute: ");
            preu = entrada.nextFloat();
            System.out.println("Introdueix el nombre d'unitats: ");
            unitats = entrada.nextInt();

            System.out.println("---------------------------------------------*");
            System.out.println("Selecciona una categoria                     *");
            System.out.println("---------------------------------------------*");
            System.out.println("MEDICAMENTS             (1)                  *");
            System.out.println("FARINES                 (2)                  *");
            System.out.println("MEDICAMENTS VETERINARIS (3)                  *");
            System.out.println("AIGUES                  (4)                  *");
            System.out.println("COSMÈTICS               (5)                  *");
            System.out.println("BEGUDES ACOHÒLIQUES     (6)                  *");
            System.out.println("---------------------------------------------*");

            //Sempre que no sigui iva reduit o super reduit, aplicarem iva normal.
            cat = entrada.nextInt();

            switch (cat) {
                case MEDICAMENTS:
                case FARINES:
                    preuFinal = (preu + (preu * IVASUPERREDUIT)) * unitats;
                    System.out.println("El preu final es:  " + preuFinal);
                    break;
                case MEDICAMENTSVET:
                case AIGUES:
                    preuFinal = (preu + (preu * IVAREDUIT)) * unitats;
                    System.out.println("El preu final es:  " + preuFinal);
                    break;
                default:
                    preuFinal = (preu + (preu * IVAGENERAL)) * unitats;
                    System.out.println("El preu final es:  " + preuFinal);
                    break;
            }
        }
        //Codi a executar per la opcio 2
        if (opcio == 2) {
            System.out.println("---------------------------------------------  *");
            System.out.println("Indica la categoria per coneixer l'iva aplicat *");
            System.out.println("---------------------------------------------  *");
            System.out.println("MEDICAMENTS             (1)                    *");
            System.out.println("FARINES                 (2)                    *");
            System.out.println("MEDICAMENTS VETERINARIS (3)                    *");
            System.out.println("AIGUES                  (4)                    *");
            System.out.println("COSMÈTICS               (5)                    *");
            System.out.println("BEGUDES ACOHÒLIQUES     (6)                    *");
            System.out.println("---------------------------------------------  *");
            cat = entrada.nextInt();

            //Amb aquesta estructura ens asegurem de que si les dades son incorrectes s'informi a l'usuari
            //abans d'acabar el programa
            if ((cat == MEDICAMENTS) || (cat == FARINES)) {
                System.out.println("S'aplica un IVA superreduit (" + (int) (IVASUPERREDUIT * 100) + "%)");
            } else if ((cat == MEDICAMENTSVET) | (cat == AIGUES)) {
                System.out.println("S'aplica un IVA reduit (" + (int) (IVAREDUIT * 100) + "%)");
            } else if ((cat == COSMETICS || cat == ALCOHOLIQUES)) {
                System.out.println("S'aplica l'IVA general (" + (int) (IVAGENERAL * 100) + "%)");
            } else {
                System.out.println("Categoria inexistent");
            }
        }
        //Codi a executar per la opcio 3
        if (opcio == 3) {
            System.out.println("Introdueix el preu base del prodcute: ");
            preu = entrada.nextFloat();
            System.out.println("Introdueix el nombre d'unitats: ");
            unitats = entrada.nextInt();
            preuFinalNoIva = preu * unitats;

            //Amb aquesta estructura ens asegurem de que si les dades son incorrectes s'informi a l'usuari
            //abans d'acabar el programa
            if ((preuFinalNoIva <= MIN) && preuFinalNoIva > 0) {
                System.out.println("El cost de l'enviament es de: " + ENVIAPOC + "€");
            } else if ((preuFinalNoIva > MIN) && preuFinalNoIva <= MAX) {
                System.out.println("El cost de l'enviament es de: " + ENVIAMIG + "€");
            } else if (preuFinalNoIva > MAX) {
                System.out.println("El cost de l'enviament es de: " + ENVIAMES + "€");
            } else {
                System.out.println("Dades incorrectes");
            }
        }
    }
}
