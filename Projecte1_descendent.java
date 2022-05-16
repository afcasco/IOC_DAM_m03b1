import java.util.Scanner;

public class FamiliesAcollida {

    //declare constants
    private static final int MIN = 0;
    private static final int MAX = 0;
    private static final int[] ID_RANGE = {10,999};
    private static final int[] PLACES_RANGE = {1,99};
    private static final int ROOM_MIN = 0;
    private static final int ROOM_MAX = 3;
    private static final int TELF_MIN = 111111111;
    private static final int TELF_MAX = 999999999;
    private static final int SI = 1;
    private static final int NO = 0;
    private static final int MAX_ATTEMPTS = 3;
    private static final String SHARED = "Habitaci compartida             ";
    private static final String SINGLE = "Habitaci                     ";
    private static final String HOME = "Habitatge sencer                 ";
    private static final String DORM = "Sala comunitria, local habilitat";
    private static final String PARLA_SI = "si";
    private static final String PARLA_NO = "no";
    private static final String ERROR_MSG = "Error, input de dades no valida";
    private static final int END_CURRENT = -1;
    private static final int MAX_FAMILIES = 10;
    private static final boolean LISTEN_FOR_EXIT = true;
    private static final boolean DONT_LISTEN_FOR_EXIT = false;

    //declare arrays to store data (max 10 families)
    Scanner input = new Scanner(System.in);
    int[] id = new int[MAX_FAMILIES];
    int[] places = new int[MAX_FAMILIES];
    int[] respostaIdioma = new int[MAX_FAMILIES];
    int[] room = new int[MAX_FAMILIES];
    int[] telf = new int[MAX_FAMILIES];
    String allotjament;
    int nFam = 0;
    int attempts;
    boolean inRange;
    boolean exit;
    String parlaIdioma;
    int i = 0;
    int keepAskingInt;
    boolean keepAsking;

    public static void main(String[] args) {

        FamiliesAcollida programa = new FamiliesAcollida();
        programa.inici();
    }

    public void inici() {

        //Mostrem a l'usuari com s'han d'introduir les dades
        System.out.println("\n***************************************************************************");
        System.out.println("* El sistema no acceptara cap dada fora dels rangs demanats               *");
        System.out.println("* Introduir la mteixa dada malament 3 vegades cancelara la entrada actual *");
        System.out.println("* Si t'equivoques introdueix -1 per cancelar la entrada manualment        *");
        System.out.println("***************************************************************************\n");

        int queryPlaces = 0;
        int placesDisplay = 0;
        int showStats = 0;
        int totalPlaces = 0;
        int totalIdioma = 0;

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

            id[nFam] = getInput("Introdueix id familia (10-999)", ID_RANGE[MIN], ID_RANGE[MAX], LISTEN_FOR_EXIT);
            if (attempts < MAX_ATTEMPTS && !exit) {
                resetForNextQuestion();
            }

            //spots input
            places[nFam] = getInput("Introdueix numero de places disponible (1-99", PLACES_RANGE[MIN], PLACES_RANGE[MAX], LISTEN_FOR_EXIT);
            if (attempts < MAX_ATTEMPTS && !exit) {
                resetForNextQuestion();
            }

            //speaks ru/ukr input
            respostaIdioma[nFam] = getInput("Parla rus o ucraines (si: 1/ no:0)", NO, SI, LISTEN_FOR_EXIT);
            //reset for next question includes next question room type decoration
            if (attempts < MAX_ATTEMPTS && !exit) {
                resetForNextQuestion();
                printRoomType();
            }

            //room type input
            room[nFam] = getInput("Introdueix una de les opcions:", ROOM_MIN, ROOM_MAX, LISTEN_FOR_EXIT);
            if (attempts < MAX_ATTEMPTS && !exit) {
                resetForNextQuestion();
            }

            //mobile # input
            telf[nFam] = getInput("Introdueix un telefon de contacte:", TELF_MIN, TELF_MAX, LISTEN_FOR_EXIT);

            //3 failed input attempts error msg
            errorMessageHandling();

            //ask to continue input
            resetForNextQuestion();
            keepAskingInt = getInput("\nContinuar introduint dades? (si: 1/ no:0)", NO, SI, DONT_LISTEN_FOR_EXIT);
            //convert keepaskingINt to boolean value
            switchKeepAskingToBoolean();

        } while (keepAsking);

        //print total number of families
        System.out.println("\nS'han introduit les dades de: " + nFam + " families");

        //if families greater than 0
        if (nFam != 0) {
            //Print all families data
            printDataHeader();
            for (int i = 0; i < nFam; i++) {
                switchIntAnswerToString();
                printFamilyData();
            }

            //chose view stats input
            resetForNextQuestion();
            queryPlaces = getInput("Vols consultar per numero de places (si: 1/ no:0)?", NO, SI, DONT_LISTEN_FOR_EXIT);

            //Show stats if showStats input was 1
            if (queryPlaces == 1) {
                sortPlaces();
                //ask how many spots needed
                resetForNextQuestion();
                placesDisplay = getInput("Quantes places necessiteu?", PLACES_RANGE[MIN], PLACES_RANGE[MAX], DONT_LISTEN_FOR_EXIT);

                printDataHeader();
                for (int i = 0; i < nFam; i++) {
                    if (places[i] >= placesDisplay) {
                        switchIntAnswerToString();
                        printFamilyData();
                    }
                }
            }

            //ask if user wants to show family stats
            resetForNextQuestion();
            showStats = getInput("\nVols veure un resum estadistic de les dades? (si: 1/ no:0)", NO, SI, DONT_LISTEN_FOR_EXIT);

            //show stats if showStats input == 1
            if (showStats == 1) {
                for (int i = 0; i < nFam; i++) {
                    totalPlaces += places[i];
                    totalIdioma += respostaIdioma[i];
                }
                System.out.println("\nNumero de families que acullen: " + nFam);
                System.out.println("Numero de places totals: " + totalPlaces);
                System.out.println("Nimero de families que parlen rus/ucraines: " + totalIdioma);
            }
        }
    }

    public void resetForNextQuestion() {
        inRange = false;
        attempts = 0;
    }

    public void printErrorOnBadValue() {
        if (!inRange) {
            System.out.println(ERROR_MSG);
            attempts++;
        }
    }

    public void printRoomType() {
        System.out.println("De quin tipus d'allotjament es tracta?:");
        System.out.println("      (0) " + SHARED);
        System.out.println("      (1) " + SINGLE);
        System.out.println("      (2) " + HOME);
        System.out.println("      (3) " + DORM);
    }

    public int getInput(String inputText, int min, int max, boolean listenForExit) {
        int curInput = 0;
        while (!inRange && attempts < MAX_ATTEMPTS && !exit) {
            System.out.println(inputText);
            inRange = input.hasNextInt();
            if (inRange) {
                curInput = input.nextInt();
                if (curInput < min || curInput > max) {
                    inRange = false;
                    if (listenForExit) {
                        if (curInput == END_CURRENT) {
                            exit = true;
                        }
                    }
                }
            }
            printErrorOnBadValue();
            input.nextLine();
        }
        return curInput;
    }

    public void switchIntAnswerToString() {
        if (respostaIdioma[i] == 1) {
            parlaIdioma = PARLA_SI;
        } else parlaIdioma = PARLA_NO;
        switch (room[i]) {
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
        };
    }

    public void printDataHeader() {
        System.out.println("\nId\t\tplaces\t\trus/ucraines\t\ttipus\t\t\t\t\t\t\t\t\ttelefon");
    }

    public void printFamilyData() {
        System.out.println(id[i] + "\t\t" + places[i] + "\t\t\t" + parlaIdioma + "\t\t\t\t\t" + allotjament + "\t\t" + telf[i]);
    }

    public void sortPlaces() {
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
    }

    public void errorMessageHandling() {
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
    }

    public void switchKeepAskingToBoolean() {
        if (attempts == MAX_ATTEMPTS || keepAskingInt == 0) {
            keepAsking = false;
        }
    }
}
