package FamiliesAcollida;

import java.util.Scanner;

public class AmpliacioP1 {
    //Definim les constants que farem servir
    private static final int ID_MIN = 10;
    private static final int ID_MAX = 999;
    private static final int PLACES_MIN = 1;
    private static final int PLACES_MAX = 99;
    private static final int ROOM_MIN = 0;
    private static final int ROOM_MAX = 3;
    private static final int TELF_MIN = 111111111;
    private static final int TELF_MAX = 999999999;
    private static final int SI = 1;
    private static final int NO = 0;
    private static final int MAX_ATTEMPTS = 3;
    private static final String SHARED = "Habitació compartida             ";
    private static final String SINGLE = "Habitació                        ";
    private static final String HOME = "Habitatge sencer                 ";
    private static final String DORM = "Sala comunitària, local habilitat";
    private static final String PARLA_SI = "si";
    private static final String PARLA_NO = "no";
    private static final String ERROR_MSG = "Error, input de dades no vàlida";

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        //Declarem variables
        int id, places, respostaIdioma, room, telf, attempts, nFamilies = 0;
        String parlaIdioma, allotjament;
        boolean inRange;
        boolean keepAsking;
        int keepAskingInt;

        do {
            keepAsking = true;
            keepAskingInt = 0;
            id = 0;
            places = 0;
            respostaIdioma = 0;
            room = 0;
            telf = 0;
            attempts = 0;
            parlaIdioma = PARLA_NO;
            inRange = false;
            //Mostrem a l'usuari com s'han d'introduir les dades
            System.out.println("\n********************************************************************");
            System.out.println("* Mode d'introducció de dades, el sistema no acceptara cap dada    *");
            System.out.println("* fora dels rangs demanats, si es comet un error tornara a demanar *");
            System.out.println("* la mateixa dada fins que compleixi el format demanat. Gracies.   *");
            System.out.println("********************************************************************\n");

            //Demanem que s'introdueixi una dada fins que el valor introduit esta dins el rang acceptat
            while (!inRange && attempts < MAX_ATTEMPTS) {
                System.out.println("Introdueix id familia (10-999):");
                inRange = input.hasNextInt();
                if (inRange) {
                    id = input.nextInt();
                    if (id < ID_MIN || id > ID_MAX) {
                        inRange = false;
                    }
                }
                if (!inRange) {
                    System.out.println(ERROR_MSG);
                    attempts++;
                }
                input.nextLine();
            }

            if (attempts < MAX_ATTEMPTS) {
                inRange = false;
                attempts = 0;
            }
            //Demanem que s'introdueixi una dada fins que el valor introduit esta dins el rang acceptat
            while (!inRange && attempts < MAX_ATTEMPTS) {
                System.out.println("Introdueix número de places disponible (1-99):");
                inRange = input.hasNextInt();
                if (inRange) {
                    places = input.nextInt();
                    if (places < PLACES_MIN || places > PLACES_MAX) {
                        inRange = false;
                    }
                }
                if (!inRange) {
                    System.out.println(ERROR_MSG);
                    attempts++;
                }
                input.nextLine();
            }

            if (attempts < MAX_ATTEMPTS) {
                inRange = false;
                attempts = 0;
            }

            //Demanem que s'introdueixi una dada fins que el valor introduit esta dins el rang acceptat
            while (!inRange && attempts < MAX_ATTEMPTS) {
                System.out.println("Parla rus o ucraines? (0=no, 1=si):");
                inRange = input.hasNextInt();
                if (inRange) {
                    respostaIdioma = input.nextInt();
                    if (respostaIdioma < NO || respostaIdioma > SI) {
                        inRange = false;
                    }
                }
                if (!inRange) {
                    System.out.println(ERROR_MSG);
                    attempts++;
                }
                input.nextLine();
            }

            if (attempts < MAX_ATTEMPTS) {
                inRange = false;
                attempts = 0;
                //Mostra informacio relativa al tipus d'allotjament a l'usuari
                System.out.println("De quin tipus d'allotjament es tracta?:");
                System.out.println("      (0) habitació compartida:");
                System.out.println("      (1) habitació:");
                System.out.println("      (2) habitatge sencer:");
                System.out.println("      (3) sala comunitària, local habilitat:");
            }

            //Demanem que s'introdueixi una dada fins que el valor introduit esta dins el rang acceptat
            while (!inRange && attempts < MAX_ATTEMPTS) {
                System.out.println("Introdueix una de les opcions:");
                inRange = input.hasNextInt();
                if (inRange) {
                    room = input.nextInt();
                    if (room < ROOM_MIN || room > ROOM_MAX) {
                        inRange = false;

                    }
                }
                if (!inRange) {
                    System.out.println(ERROR_MSG);
                    attempts++;
                }
                input.nextLine();
            }

            if (attempts < MAX_ATTEMPTS) {
                inRange = false;
                attempts = 0;
            }

            //Demanem que s'introdueixi una dada fins que el valor introduit esta dins el rang acceptat
            while (!inRange && attempts < MAX_ATTEMPTS) {
                System.out.println("Introdueix un telefon de contacte:");
                inRange = input.hasNextInt();
                if (inRange) {
                    telf = input.nextInt();
                    if (telf < TELF_MIN || telf > TELF_MAX) {
                        inRange = false;
                    }
                }
                if (!inRange) {
                    System.out.println(ERROR_MSG);
                    attempts++;
                }
                input.nextLine();
            }

            if (attempts < MAX_ATTEMPTS) {

                if (respostaIdioma == SI) parlaIdioma = PARLA_SI;

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

                //Presentem les dades per pantalla tabulades correctament
                System.out.println("Id\t\tplaces\t\trus/ucraïnès\t\ttipus\t\t\t\t\t\t\t\t\ttelèfon");
                System.out.println(id + "\t\t" + places + "\t\t\t" + parlaIdioma + "\t\t\t\t\t" + allotjament + "\t\t" + telf);
                nFamilies++;
            } else {
                System.out.println("------------------------------------------------------");
                System.out.println("Has introduit alguna dada malament mes de 3 vegades...");
            }

            inRange = false;
            attempts = 0;
            while (!inRange && attempts < MAX_ATTEMPTS) {
                System.out.println("\nContinuar introduint dades? 0=no, 1=si");
                inRange = input.hasNextInt();
                if (inRange) {
                    keepAskingInt = input.nextInt();
                    if (keepAskingInt < NO || keepAskingInt > SI) {
                        inRange = false;
                    }
                }
                if (!inRange) {
                    System.out.println(ERROR_MSG);
                    attempts++;
                }
                input.nextLine();
            }

            if (keepAskingInt == 0 || attempts == MAX_ATTEMPTS) {
                keepAsking = false;
            }
        } while (keepAsking);
        System.out.println("\nS'han introduit les dades de: " + nFamilies + " families");
    }
}
