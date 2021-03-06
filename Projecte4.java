import java.util.Scanner;

public class Projecte4 {

    public static final int[] ID_RANGE = new int[]{10, 999};
    public static final int[] PLACES_RANGE = new int[]{1, 99};
    public static final int[] ROOM_RANGE = new int[]{0, 3};
    public static final int[] TELF_RANGE = new int[]{111_111_111, 999_999_999}; //underscore separation for readability
    private static final int MIN = 0;
    private static final int MAX = 1;
    private static final int MAX_ATTEMPTS = 3;
    private static final String SHARED = "Habitacio compartida             ";
    private static final String SINGLE = "Habitacio                        ";
    private static final String HOME = "Habitatge sencer                 ";
    private static final String DORM = "Sala comunitaria, local habilitat";
    private static final String PARLA_SI = "si";
    private static final String PARLA_NO = "no";
    private static final String PRINT_RESULTS_HEADER = "Id\tplaces\trus/ucraines\ttipus\t\t\t\t\ttelefon";
    private static final String INVALID_INPUT_ERROR_MSG = "Error, input de dades no valida";
    private static final int END_CURRENT = -1;
    private static final int MAX_FAMILIES = 10;
    private static final int ID = 0;
    private static final int PLACES = 1;
    private static final int LANGUAGE = 2;
    private static final int ROOM = 3;
    private static final int TELF = 4;
    private static final String MENU = """
            ****************************************************************************
                                ENTRADA DE FAMILIES D'ACOLLIDA.
            ****************************************************************************
                                                    
            El sistema no acceptara cap dada fora dels rangs demanats
            Introduir la mateixa dada erroniament 3 vegades cancelara l'entrada actual
            Si t'equivoques introdueix -1 per cancelar la entrada manualment
                                            
            ****************************************************************************
            """;

    //declare arrays to store data (max 10 families)
    static int[][] familyData = new int[MAX_FAMILIES][5];
    static int attempts;

    public static void main(String[] args) {

        //Show how-to input data text
        System.out.println(MENU);
        Scanner input = new Scanner(System.in);
        int keepAskingInt;
        int nFam = 0;
        int queryPlaces = 0;
        int placesDisplay = 0;
        int showStats = 0;
        int totalPlaces = 0;
        int totalIdioma = 0;
        int orderByType;
        int type;
        String parlaIdioma;
        String allotjament;
        boolean inRange;
        boolean keepAsking;
        boolean exit;

        do {
            exit = false;
            keepAsking = true;
            keepAskingInt = 0;
            attempts = 0;
            inRange = false;

            //family id input
            while (!inRange && attempts < MAX_ATTEMPTS && !exit) {
                System.out.println("Introdueix id familia (10-999):");
                inRange = input.hasNextInt();
                if (inRange) {
                    familyData[nFam][ID] = input.nextInt();
                    if ((familyData[nFam][ID]) < ID_RANGE[MIN] || (familyData[nFam][ID]) > ID_RANGE[MAX]) {
                        inRange = false;
                        if (familyData[nFam][ID] == END_CURRENT) {
                            exit = true;
                        }
                    }
                }
                if (!inRange && !exit) increaseAttemptsAndPrintErrorIfBadValue();
                input.nextLine();
            }

            //how many spots input
            if (attempts < MAX_ATTEMPTS && !exit) {
                inRange = false;
                attempts = 0;
            }
            while (!inRange && attempts < MAX_ATTEMPTS && !exit) {
                System.out.println("Introdueix numero de places disponible (1-99):");
                inRange = input.hasNextInt();
                if (inRange) {
                    familyData[nFam][PLACES] = input.nextInt();
                    if (familyData[nFam][PLACES] < PLACES_RANGE[MIN] || familyData[nFam][PLACES] > PLACES_RANGE[MAX]) {
                        inRange = false;
                        if (familyData[nFam][PLACES] == END_CURRENT) {
                            exit = true;
                        }
                    }
                }
                if (!inRange && !exit) increaseAttemptsAndPrintErrorIfBadValue();
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
                    familyData[nFam][LANGUAGE] = input.nextInt();
                    if (familyData[nFam][LANGUAGE] < MIN || familyData[nFam][LANGUAGE] > MAX) {
                        inRange = false;
                        if (familyData[nFam][LANGUAGE] == END_CURRENT) {
                            exit = true;
                        }
                    }
                }
                if (!inRange && !exit) increaseAttemptsAndPrintErrorIfBadValue();
                input.nextLine();
            }

            //room type input and question decoration
            if (attempts < MAX_ATTEMPTS && !exit) {
                inRange = false;
                attempts = 0;
                printTipusAllotjament();
            }
            while (!inRange && attempts < MAX_ATTEMPTS && !exit) {
                System.out.println("Introdueix una de les opcions:");
                inRange = input.hasNextInt();
                if (inRange) {
                    familyData[nFam][ROOM] = input.nextInt();
                    if (familyData[nFam][ROOM] < ROOM_RANGE[MIN] || familyData[nFam][ROOM] > ROOM_RANGE[MAX]) {
                        inRange = false;
                        if (familyData[nFam][ROOM] == END_CURRENT) {
                            exit = true;
                        }
                    }
                }
                if (!inRange && !exit) increaseAttemptsAndPrintErrorIfBadValue();
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
                    familyData[nFam][TELF] = input.nextInt();
                    if (familyData[nFam][TELF] < TELF_RANGE[MIN] || familyData[nFam][TELF] > TELF_RANGE[MAX]) {
                        inRange = false;
                        if (familyData[nFam][TELF] == END_CURRENT) {
                            exit = true;
                        }
                    }
                }
                if (!inRange && !exit) increaseAttemptsAndPrintErrorIfBadValue();
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
                    if (keepAskingInt < MIN || keepAskingInt > MAX) {
                        inRange = false;
                    }
                }
                if (!inRange) increaseAttemptsAndPrintErrorIfBadValue();
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
            System.out.println(PRINT_RESULTS_HEADER);
            for (int i = 0; i < nFam; i++) {
                parlaIdioma = switchIdioma(familyData[i][LANGUAGE]);
                allotjament = switchRoomType(familyData[i][ROOM]);
                System.out.println(familyData[i][ID] + "\t" + familyData[i][PLACES] + "\t" + parlaIdioma + "\t\t" + allotjament + "\t" + familyData[i][TELF]);
            }

            //choose view stats input
            inRange = false;
            attempts = 0;
            while (!inRange && attempts < MAX_ATTEMPTS) {
                System.out.println("\nVols consultar per numero de places?(si: 1/ no:0)");
                inRange = input.hasNextInt();
                if (inRange) {
                    queryPlaces = input.nextInt();
                    if (queryPlaces < MIN || queryPlaces > MAX) {
                        inRange = false;
                    }
                }
                if (!inRange) increaseAttemptsAndPrintErrorIfBadValue();
                input.nextLine();
            }
            //SORT BY PLACES
            if (queryPlaces == 1) {
                //Bubble sort around places[i]
                for (int i = 0; i < nFam; i++) {
                    for (int j = 0; j < nFam - i - 1; j++) {
                        if (familyData[j][PLACES] > familyData[j + 1][PLACES]) {
                            //exchange all arrays around places[]
                            sortArrayPositions(j);
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
                        if (placesDisplay < PLACES_RANGE[MIN] || placesDisplay > PLACES_RANGE[MAX]) {
                            inRange = false;
                        }
                    }
                    if (!inRange) increaseAttemptsAndPrintErrorIfBadValue();
                    input.nextLine();
                }

                //print data
                System.out.println(PRINT_RESULTS_HEADER);
                for (int i = 0; i < nFam; i++) {
                    if (familyData[i][PLACES] >= placesDisplay) {
                        parlaIdioma = switchIdioma(familyData[i][LANGUAGE]);
                        allotjament = switchRoomType(familyData[i][ROOM]);
                        System.out.println(familyData[i][ID] + "\t" + familyData[i][PLACES] + "\t" + parlaIdioma + "\t\t" + allotjament + "\t" + familyData[i][TELF]);
                    }
                }
            }

            //Aks if user wants to order by type of accommodation
            inRange = false;
            attempts = 0;
            while (!inRange && attempts < MAX_ATTEMPTS) {
                System.out.println("\nVols consultar per tipus d'allotjament? (si: 1/ no:0)");
                inRange = input.hasNextInt();
                if (inRange) {
                    orderByType = input.nextInt();
                    if ((orderByType < MIN) || (orderByType > MAX)) {
                        System.out.println("Has d'introduir si: 1/ no:0");
                        inRange = false;
                        attempts++;
                        input.nextLine();
                    } else if (orderByType == MAX) {
                        inRange = false;
                        attempts = 0;
                        input.nextLine();
                        while (!inRange && attempts < MAX_ATTEMPTS) {
                            printTipusAllotjament();
                            if (input.hasNextInt()) {
                                type = input.nextInt();
                                if (type < ROOM_RANGE[MIN] || (type > ROOM_RANGE[MAX])) {
                                    increaseAttemptsAndPrintErrorIfBadValue();
                                } else {
                                    for (int i = 0; i < nFam; i++) {
                                        for (int j = 0; j < nFam - i - 1; j++) {
                                            if (familyData[j][ID] < familyData[j + 1][ID]) {
                                                //sort by id in descending order
                                                sortArrayPositions(j);
                                            }
                                        }
                                    }
                                    allotjament = switchRoomType(type);
                                    System.out.println("Dades de families que ofereixen " + allotjament);
                                    System.out.println(PRINT_RESULTS_HEADER);
                                    for (int i = 0; i < nFam; i++) {
                                        if (familyData[i][ROOM] == type) {
                                            parlaIdioma = switchIdioma(familyData[i][LANGUAGE]);
                                            System.out.println(familyData[i][ID] + "\t" + familyData[i][PLACES] + "\t" + parlaIdioma + "\t\t" + allotjament + "\t" + familyData[i][TELF]);
                                        }
                                    }
                                    attempts = 0;
                                    inRange = true;
                                }
                                input.nextLine();
                            } else {
                                input.nextLine();
                                increaseAttemptsAndPrintErrorIfBadValue();
                            }
                        }
                    }
                } else {
                    input.nextLine();
                    increaseAttemptsAndPrintErrorIfBadValue();
                }
            }

            //ask if user wants to show family stats
            inRange = false;
            attempts = 0;
            while (!inRange && attempts < MAX_ATTEMPTS) {
                System.out.println("\nVols veure un resum estadistic de les dades? (si: 1/ no:0)");
                inRange = input.hasNextInt();
                if (inRange) {
                    showStats = input.nextInt();
                    if (showStats < MIN || showStats > MAX) {
                        inRange = false;
                    }
                }
                if (!inRange) increaseAttemptsAndPrintErrorIfBadValue();
                input.nextLine();
            }

            //show stats if showStats input == 1
            if (showStats == 1) {
                for (int i = 0; i < nFam; i++) {
                    totalPlaces += familyData[i][PLACES];
                    totalIdioma += familyData[i][LANGUAGE];
                }
                System.out.println("\nNumero de families que acullen: " + nFam);
                System.out.println("Numero de places totals: " + totalPlaces);
                System.out.println("Numero de families que parlen rus/ucraines: " + totalIdioma);
            }
        }
    }

    //small test function to change int value input to string
    public static String switchIdioma(int languageSelection) {
        return (languageSelection == 1) ? PARLA_SI : PARLA_NO;
    }

    //small test function to change int value input to string
    public static String switchRoomType(int roomType) {
        return switch (roomType) {
            case 0 -> SHARED;
            case 1 -> SINGLE;
            case 2 -> HOME;
            default -> DORM;
        };
    }

    //for loop for sorting array around given position
    public static void sortArrayPositions(int m) {
        for (int k = 0; k < familyData[0].length; k++) {
            int aux = familyData[m][k];
            familyData[m][k] = familyData[m + 1][k];
            familyData[m + 1][k] = aux;
        }
    }

    //print tipus allotjament decoration
    public static void printTipusAllotjament() {
        System.out.println("Tipus d'allotjament?");
        System.out.println("      (0) " + SHARED);
        System.out.println("      (1) " + SINGLE);
        System.out.println("      (2) " + HOME);
        System.out.println("      (3) " + DORM);
    }

    public static void increaseAttemptsAndPrintErrorIfBadValue(){
        System.out.println(INVALID_INPUT_ERROR_MSG);
        attempts++;
    }
}
