import java.util.Scanner;

public class Projecte1 {

    //Declarem constants
    private static final int ID_MIN = 10;
    private static final int ID_MAX = 999;
    private static final int PLACES_MIN = 1;
    private static final int PLACES_MAX = 99;
    private static final int IDIOMA_SI = 1;
    private static final int IDIOMA_NO = 0;
    private static final int ROOM_MIN = 0;
    private static final int ROOM_MAX = 3;
    private static final int TELF_MIN = 111111111;
    private static final int TELF_MAX = 999999999;
    private static final String SHARED = "Habitació compartida             ";
    private static final String SINGLE = "Habitació                        ";
    private static final String HOME = "Habitatge sencer                 ";
    private static final String DORM = "Sala comunitària, local habilitat";
    private static final String PARLA_SI = "si";
    private static final String PARLA_NO = "no";
    private static final String ERROR_MSG = "Error, entrada de dades no vàlida";

    public static void main(String[] args) {

        //iniciem objecte scanner per llegir dades del teclat
        Scanner entrada = new Scanner(System.in);

        //declaració de variables
        int id = 0;
        int places = 0;
        int respostaIdioma = 0;
        int room = 0;
        int telf = 0;
        String parlaIdioma = PARLA_NO;
        String allotjament;
        boolean inRange;

        System.out.println("\n********************************************************************");
        System.out.println("* Mode d'introducció de dades, el sistema no acceptara cap dada    *");
        System.out.println("* fora dels rangs demanats!                                        *");
        System.out.println("********************************************************************\n");

        //Comencem a demanar dades, reutilitzem el boolea inRange tot el programa posant-lo a false
        //quan un numero no sigui sencer, o no estigui en rang, per tant si un dels blocs if no es correcte
        //no demanara cap mes dada
        System.out.println("Introdueix id familia (10-999):");
        inRange = entrada.hasNextInt();
        if (inRange) {
            id = entrada.nextInt();
            if (id < ID_MIN || id > ID_MAX) {
                inRange = false;
            }
        }

        if (inRange) {
            System.out.println("Introdueix número de places disponible (1-99):");
            inRange = entrada.hasNextInt();
            if (inRange) {
                places = entrada.nextInt();
                if (places < PLACES_MIN || places > PLACES_MAX) {
                    inRange = false;
                }
            }
        }

        if (inRange) {
            System.out.println("Parla rus o ucraines? (0=no, 1=si):");
            inRange = entrada.hasNextInt();
            if (inRange) {
                respostaIdioma = entrada.nextInt();
                if (respostaIdioma > IDIOMA_SI || respostaIdioma < IDIOMA_NO) {
                    inRange = false;
                }
            }
        }

        if (inRange) {
            System.out.println("De quin tipus d'allotjament es tracta?:");
            System.out.println("      (0) habitació compartida:");
            System.out.println("      (1) habitació:");
            System.out.println("      (2) habitatge sencer:");
            System.out.println("      (3) sala comunitària, local habilitat:");
            inRange = entrada.hasNextInt();
            if (inRange) {
                room = entrada.nextInt();
                if (room < ROOM_MIN || room > ROOM_MAX) {
                    inRange = false;
                }
            }
        }

        if (inRange) {
            System.out.println("Introdueix un telefon de contacte:");
            inRange = entrada.hasNextInt();
            if (inRange) {
                telf = entrada.nextInt();
                if (telf < TELF_MIN || telf > TELF_MAX) {
                    inRange = false;
                }
            }
        }

        //si arriva al final, fara els últims calculs sobre idioma i habitació i presentara les dades
        //per pantalla (ho podiem haver inclos al mateix if on es demanen aquestes dades, pero per claredat
        //m'ha semblat que quedava millor així
        if (inRange) {
            if (respostaIdioma == IDIOMA_SI) {
                parlaIdioma = PARLA_SI;
            }
            switch (room) {
                case 0:
                    allotjament = SHARED;
                    break;
                case 1:
                    allotjament = SINGLE;
                    break;
                case 2:
                    allotjament = HOME;
                    break;
                default:
                    allotjament = DORM;
                    break;
            }

            System.out.println("Id\tplaces\trus/ucraïnès\ttipus\t\t\t\t\ttelèfon");
            System.out.println(id + "\t" + places + "\t" + parlaIdioma + "\t\t" + allotjament + "\t" + telf);

        //si al final inRange es false, presentara un missatge d'error
        } else {
            System.out.println(ERROR_MSG);
        }
    }
}
