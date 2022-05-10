package FamiliesAcollida;

import java.util.Scanner;

public class AmpliacioP1ArrayUni {

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
    private static final int END_CURRENT = -1;
    private static final int MAX_FAMILIES = 10;

    public static void main(String[] args) {

        //Mostrem a l'usuari com s'han d'introduir les dades
        System.out.println("\n***************************************************************************");
        System.out.println("* El sistema no acceptara cap dada fora dels rangs demanats               *");
        System.out.println("* Introduir la mteixa dada malament 3 vegades cancelara la entrada actual *");
        System.out.println("* Si t'equivoques introdueix -1 per cancelar la entrada manualment        *");
        System.out.println("***************************************************************************\n");

        Scanner input = new Scanner(System.in);
        int attempts;
        int keepAskingInt;
        int nFam = 0;
        int queryPlaces = 0;
        int placesDisplay = 0;
        int showStats = 0;
        int totalPlaces = 0;
        int totalIdioma = 0;
        String parlaIdioma;
        String allotjament;
        boolean inRange;
        boolean keepAsking;
        boolean exit;

        //declare arrays to store data (max 10 families)
        int[] id = new int[MAX_FAMILIES];
        int[] places = new int[MAX_FAMILIES];
        int[] respostaIdioma = new int[MAX_FAMILIES];
        int[] room = new int[MAX_FAMILIES];
        int[] telf = new int[MAX_FAMILIES];

        do {
            exit = false;
            keepAsking = true;
            keepAskingInt = 0;
            id[nFam] = 0;
            places[nFam] = 0;
            respostaIdioma[nFam] = 0;
            room[nFam] = 0;
            telf[nFam] = 0;
            attempts = 0;
            inRange = false;

            //family id input
            while (!inRange && attempts < MAX_ATTEMPTS && !exit) {
                System.out.println("Introdueix id familia (10-999):");
                inRange = input.hasNextInt();
                if (inRange) {
                    id[nFam] = input.nextInt();
                    if (id[nFam] < ID_MIN || id[nFam] > ID_MAX) {
                        inRange = false;
                        if (id[nFam] == END_CURRENT) {
                            exit = true;
                        }
                    }
                }
                if (!inRange && !exit) {
                    System.out.println(ERROR_MSG);
                    attempts++;
                }
                input.nextLine();
            }

            //how many spots input
            if (attempts < MAX_ATTEMPTS && !exit) {
                inRange = false;
                attempts = 0;
            }
            while (!inRange && attempts < MAX_ATTEMPTS && !exit) {
                System.out.println("Introdueix número de places disponible (1-99):");
                inRange = input.hasNextInt();
                if (inRange) {
                    places[nFam] = input.nextInt();
                    if (places[nFam] < PLACES_MIN || places[nFam] > PLACES_MAX) {
                        inRange = false;
                        if (places[nFam] == END_CURRENT) {
                            exit = true;
                        }
                    }
                }
                if (!inRange && !exit) {
                    System.out.println(ERROR_MSG);
                    attempts++;
                }
                input.nextLine();
            }

            //speaks ru/ukr input
            if (attempts < MAX_ATTEMPTS && !exit) {
                inRange = false;
                attempts = 0;
            }
            while (!inRange && attempts < MAX_ATTEMPTS && !exit) {
                System.out.println("Parla rus o ucraines? (si: 1/ no:0):");
                inRange = input.hasNextInt();
                if (inRange) {
                    respostaIdioma[nFam] = input.nextInt();
                    if (respostaIdioma[nFam] < NO || respostaIdioma[nFam] > SI) {
                        inRange = false;
                        if (respostaIdioma[nFam] == END_CURRENT) {
                            exit = true;
                        }
                    }
                }
                if (!inRange && !exit) {
                    System.out.println(ERROR_MSG);
                    attempts++;
                }
                input.nextLine();
            }

            //room type input and question decoration
            if (attempts < MAX_ATTEMPTS && !exit) {
                inRange = false;
                attempts = 0;
                System.out.println("De quin tipus d'allotjament es tracta?:");
                System.out.println("      (0) " + SHARED);
                System.out.println("      (1) " + SINGLE);
                System.out.println("      (2) " + HOME);
                System.out.println("      (3) " + DORM);
            }
            while (!inRange && attempts < MAX_ATTEMPTS && !exit) {
                System.out.println("Introdueix una de les opcions:");
                inRange = input.hasNextInt();
                if (inRange) {
                    room[nFam] = input.nextInt();
                    if (room[nFam] < ROOM_MIN || room[nFam] > ROOM_MAX) {
                        inRange = false;
                        if (room[nFam] == END_CURRENT) {
                            exit = true;
                        }
                    }
                }
                if (!inRange && !exit) {
                    System.out.println(ERROR_MSG);
                    attempts++;
                }
                input.nextLine();
            }

            //mobile # input
            if (attempts < MAX_ATTEMPTS && !exit) {
                inRange = false;
                attempts = 0;
            }
            while (!inRange && attempts < MAX_ATTEMPTS && !exit) {
                System.out.println("Introdueix un telefon de contacte:");
                inRange = input.hasNextInt();
                if (inRange) {
                    telf[nFam] = input.nextInt();
                    if (telf[nFam] < TELF_MIN || telf[nFam] > TELF_MAX) {
                        inRange = false;
                        if (telf[nFam] == END_CURRENT) {
                            exit = true;
                        }
                    }
                }
                if (!inRange && !exit) {
                    System.out.println(ERROR_MSG);
                    attempts++;
                }
                input.nextLine();
            }

            //3 failed input attempts error msg
            if (attempts == MAX_ATTEMPTS) {
                System.out.println("------------------------------------------------------");
                System.out.println("Has introduit alguna dada malament mes de 3 vegades...");
                //Current input canceled by user with -1 message
            } else if (exit) {
                System.out.println("------------------------------------------------------");
                System.out.println("\nEntrada actual cancelada per operador");
            } else {
                nFam++;
            }

            //ask to continue input
            inRange = false;
            attempts = 0;
            while (!inRange && attempts < MAX_ATTEMPTS) {
                System.out.println("\nContinuar introduint dades? (si: 1/ no:0)");
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
            if (attempts == MAX_ATTEMPTS || keepAskingInt == 0) {
                keepAsking = false;
            }

        } while (keepAsking);

        //print total number of families
        System.out.println("\nS'han introduit les dades de: " + nFam + " families");

        //if families greater than 0
        if (nFam != 0) {
            //Print all families data
            System.out.println("Id\t\tplaces\t\trus/ucraïnès\t\ttipus\t\t\t\t\t\t\t\t\ttelèfon");
            for (int i = 0; i < nFam; i++) {
                if (respostaIdioma[i] == 1) {
                    parlaIdioma = PARLA_SI;
                } else parlaIdioma = PARLA_NO;
                allotjament = switch (room[i]) {
                    case 0 -> SHARED;
                    case 1 -> SINGLE;
                    case 2 -> HOME;
                    default -> DORM;
                };
                System.out.println(id[i] + "\t\t" + places[i] + "\t\t\t" + parlaIdioma + "\t\t\t\t\t" + allotjament + "\t\t" + telf[i]);
            }

            //chose view stats input
            inRange = false;
            attempts = 0;
            while (!inRange && attempts < MAX_ATTEMPTS) {
                System.out.println("\nVols consultar per número de places?(si: 1/ no:0)");
                inRange = input.hasNextInt();
                if (inRange) {
                    queryPlaces = input.nextInt();
                    if (queryPlaces < NO || queryPlaces > SI) {
                        inRange = false;
                    }
                }
                if (!inRange) {
                    System.out.println(ERROR_MSG);
                    attempts++;
                }
                input.nextLine();
            }

            //Show stats if showStats input was 1
            if (queryPlaces == 1) {
                //Bubble sort around places[i]
                for (int i = 0; i < nFam; i++) {
                    for (int j = 0; j < nFam - i - 1; j++) {
                        int aux;
                        if (places[j] > places[j + 1]) {
                            //exchange all arrays around places[]
                            aux = id[j];
                            id[j] = id[j + 1];
                            id[j + 1] = aux;
                            aux = places[j];
                            places[j] = places[j + 1];
                            places[j + 1] = aux;
                            aux = respostaIdioma[j];
                            respostaIdioma[j] = respostaIdioma[j + 1];
                            respostaIdioma[j + 1] = aux;
                            aux = room[j];
                            room[j] = room[j + 1];
                            room[j + 1] = aux;
                            aux = telf[j];
                            telf[j] = telf[j + 1];
                            telf[j + 1] = aux;
                        }
                    }
                }

                //ask how many spots needed
                inRange = false;
                attempts = 0;
                while (!inRange && attempts < MAX_ATTEMPTS) {
                    System.out.println("\nQuantes places necessiteu?");
                    inRange = input.hasNextInt();
                    if (inRange) {
                        placesDisplay = input.nextInt();
                        if (placesDisplay < PLACES_MIN || placesDisplay > PLACES_MAX) {
                            inRange = false;
                        }
                    }
                    if (!inRange) {
                        System.out.println(ERROR_MSG);
                        attempts++;
                    }
                    input.nextLine();
                }

                System.out.println("\nId\t\tplaces\t\trus/ucraïnès\t\ttipus\t\t\t\t\t\t\t\t\ttelèfon");
                for (int i = 0; i < nFam; i++) {
                    if (places[i] >= placesDisplay) {
                        if (respostaIdioma[i] == 1) {
                            parlaIdioma = PARLA_SI;
                        } else parlaIdioma = PARLA_NO;
                        allotjament = switch (room[i]) {
                            case 0 -> SHARED;
                            case 1 -> SINGLE;
                            case 2 -> HOME;
                            default -> DORM;
                        };
                        System.out.println(id[i] + "\t\t" + places[i] + "\t\t\t" + parlaIdioma + "\t\t\t\t\t" + allotjament + "\t\t" + telf[i]);
                    }
                }
            }

            //ask if user wants to show family stats
            inRange = false;
            attempts = 0;
            while (!inRange && attempts < MAX_ATTEMPTS) {
                System.out.println("\nVols veure un resum estadístic de les dades? (si: 1/ no:0)");
                inRange = input.hasNextInt();
                if (inRange) {
                    showStats = input.nextInt();
                    if (showStats < NO || showStats > SI) {
                        inRange = false;
                    }
                }
                if (!inRange) {
                    System.out.println(ERROR_MSG);
                    attempts++;
                }
                input.nextLine();
            }

            //show stats if showStats input == 1
            if (showStats == 1) {
                for (int i = 0; i < nFam; i++) {
                    totalPlaces += places[i];
                    totalIdioma += respostaIdioma[i];
                }
                System.out.println("\nNúmero de famílies que acullen: " + nFam);
                System.out.println("Número de places totals: " + totalPlaces);
                System.out.println("Número de famílies que parlen rus/ucraïnès: " + totalIdioma);

            }
        }
    }
}
