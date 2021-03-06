import java.util.Scanner;

public class FamiliesAcollida {

    private static final int MIN = 0;
    private static final int MAX = 1;
    private static final int[] ID_RANGE = {10,999};
    private static final int[] PLACES_RANGE = {1,99};
    private static final int[] ROOM_RANGE = {0,3};
    private static final int[] TEL_NUMBER_RANGE = {111111111,999999999};
    private static final int MAX_ATTEMPTS = 3;
    private static final String PARLA_SI = "si";
    private static final String PARLA_NO = "no";
    private static final String BAD_VALUE_INPUT = "Error, input de dades no valida";
    private static final int END_CURRENT = -1;
    private static final int MAX_FAMILIES = 10;
    private static final boolean LISTEN_FOR_EXIT = true;
    private static final boolean DONT_LISTEN_FOR_EXIT = false;
    private static final int ID = 0;
    private static final int PLACES = 1;
    private static final int LANGUAGE = 2;
    private static final int ROOM = 3;
    private static final int TELF = 4;

    private enum Accomodation {
        SHARED {public String toString() {return "HHabitaci compartida             ";}},
        SINGLE {public String toString() {return "Habitacio                     ";}},
        HOME {public String toString() {return "Habitatge sencer                 ";}},
        DORM {public String toString() {return "Sala comunitria, local habilitat";}},
    }

    //declare arrays to store data (max 10 families)
    int[][] familyData = new int[MAX_FAMILIES][5];
    String allotjament;
    int numberOfFamilies = 0;
    int attempts;
    boolean inRange;
    boolean exit = false;
    String speaksRuOrUkr;
    int i = 0;
    int continueAskingForFamilies;

    public static void main(String[] args) {

        FamiliesAcollida programa = new FamiliesAcollida();
        programa.start();
    }

    public void start() {

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
            attempts = 0;
            inRange = false;

            //id input
            familyData[numberOfFamilies][ID] = getInput("Introdueix id familia (10-999)", ID_RANGE[MIN], ID_RANGE[MAX], LISTEN_FOR_EXIT);
            //spots input
            if (attempts != MAX_ATTEMPTS && !exit) {
                familyData[numberOfFamilies][PLACES] = getInput("Introdueix numero de places disponible (1-99", PLACES_RANGE[MIN], PLACES_RANGE[MAX], LISTEN_FOR_EXIT);
            }
            //speaks ru/ukr input
            if (attempts != MAX_ATTEMPTS && !exit) {
                familyData[numberOfFamilies][LANGUAGE] = getInput("Parla rus o ucraines (si: 1/ no:0)", MIN, MAX, LISTEN_FOR_EXIT);
            }
            //room type input
            if (attempts != MAX_ATTEMPTS && !exit) {
                printRoomType();
                familyData[numberOfFamilies][ROOM] = getInput("", ROOM_RANGE[MIN], ROOM_RANGE[MAX], LISTEN_FOR_EXIT);
            }
            //mobile # input
            if (attempts != MAX_ATTEMPTS && !exit) {
                familyData[numberOfFamilies][TELF] = getInput("Introdueix un telefon de contacte:", TEL_NUMBER_RANGE[MIN], TEL_NUMBER_RANGE[MAX], LISTEN_FOR_EXIT);
            }

            //Print why current input was cancelled, or add 1 to numberOfFamilies if it wasn't
            errorMessageHandler();
            //ask to continue input
            continueAskingForFamilies = getInput("\nContinuar introduint dades? (si: 1/ no:0)", MIN, MAX, DONT_LISTEN_FOR_EXIT);

        } while (continueAskingForFamilies != 0);

        //print total number of families
        System.out.println("\nS'han introduit les dades de: " + numberOfFamilies + " families");

        //if families greater than 0
        if (numberOfFamilies > 0) {
            printFamilyData();

            placesDisplay = getInput("\nVols consultar per numero de places? (si: 1/ no:0)", MIN, MAX, DONT_LISTEN_FOR_EXIT);
            if (placesDisplay == 1) {
                
                queryPlaces = getInput("\nQuantes places necessiteu? (1-99)", PLACES_RANGE[MIN], PLACES_RANGE[MAX], DONT_LISTEN_FOR_EXIT);

                //ordenar places
                if (queryPlaces == 1) {
                    //Bubble sort around places[i]
                    sortByPlaces();
                    //display sorted by places
                    System.out.println("\nId\t\tplaces\t\trus/ucraines\t\ttipus\t\t\t\t\t\t\t\t\ttelefon");
                    for (int i = 0; i < numberOfFamilies; i++) {
                        if (familyData[i][PLACES] >= placesDisplay) {
                            speaksRuOrUkr = switchIdioma(familyData[i][LANGUAGE]);
                            allotjament = switchRoomType(familyData[i][ROOM]);
                            System.out.println(familyData[i][ID] + "\t" + familyData[i][PLACES] + "\t" + speaksRuOrUkr + "\t\t" + allotjament + "\t" + familyData[i][TELF]);
                        }
                    }
                }
            }


            //show stats
            showStats = getInput("\nVols veure un resum estadistic de les dades? (si: 1/ no:0)", MIN, MAX, DONT_LISTEN_FOR_EXIT);
            if (showStats == 1) {
                for (int i = 0; i < numberOfFamilies; i++) {
                    totalPlaces += familyData[i][PLACES];
                    totalIdioma += familyData[i][LANGUAGE];
                }
                System.out.println("\nNumero de families que acullen: " + numberOfFamilies);
                System.out.println("Numero de places totals: " + totalPlaces);
                System.out.println("Numero de families que parlen rus/ucraines: " + totalIdioma);

            }

            //filter by type of accomodation
        }
    }

    public int getInput(String inputText, int min, int max, boolean listenForExit) {
        exit = false;
        int inputValue = 0;
        attempts = 0;
        inRange = false;
        Scanner input = new Scanner(System.in);
        System.out.println(inputText);
        while (!inRange && attempts < MAX_ATTEMPTS && !exit) {
            inRange = input.hasNextInt();
            if (inRange) {
                inputValue = input.nextInt();
                if (inputValue < min || inputValue > max) {
                    inRange = false;
                    if (inputValue == -1) exit = true;
                }
            }
            if (!inRange && !exit) {
                attempts++;
                System.out.println(BAD_VALUE_INPUT);
            }
            input.nextLine();
        }
        return inputValue;
    }

    public void printRoomType() {
        System.out.println("De quin tipus d'allotjament es tracta?:");
        System.out.println("      (0) " + Accomodation.SHARED);
        System.out.println("      (1) " + Accomodation.SINGLE);
        System.out.println("      (2) " + Accomodation.HOME);
        System.out.println("      (3) " + Accomodation.DORM);
    }

    public void errorMessageHandler() {
        if (attempts == MAX_ATTEMPTS && !exit) {
            System.out.println("reached max attemts, canceling current family input...");

        } else if (exit) {
            System.out.println("Current family input cancelled by operator with -1");
        } else {
            numberOfFamilies++;
        }
    }

    public void printFamilyData() {
        System.out.println("\nId\t\tplaces\t\trus/ucraines\t\ttipus\t\t\t\t\t\t\t\t\ttelefon");
        for (int i = 0; i < numberOfFamilies; i++) {
            speaksRuOrUkr = switchIdioma(familyData[i][LANGUAGE]);
            allotjament = switchRoomType(familyData[i][ROOM]);
            System.out.println(familyData[i][ID] + "\t" + familyData[i][PLACES] + "\t" + speaksRuOrUkr + "\t\t" + allotjament + "\t" + familyData[i][TELF]);
        }
    }

    //change int value to string literal
    public static String switchIdioma(int languageSelection) {
        String languageReturn;
        if (languageSelection == 1) {
            languageReturn = PARLA_SI;
        } else {
            languageReturn = PARLA_NO;
        }
        return languageReturn;
    }

    public void sortByPlaces(){
        for (int i = 0; i < numberOfFamilies; i++) {
                        for (int j = 0; j < numberOfFamilies - i - 1; j++) {
                            int aux;
                            if (familyData[j][PLACES] > familyData[j + 1][PLACES]) {
                                //exchange all arrays around places[]
                                aux = familyData[j][ID];
                                familyData[j][ID] = familyData[j + 1][ID];
                                familyData[j + 1][ID] = aux;
                                aux = familyData[j][PLACES];
                                familyData[j][PLACES] = familyData[j + 1][PLACES];
                                familyData[j + 1][PLACES] = aux;
                                aux = familyData[j][LANGUAGE];
                                familyData[j][LANGUAGE] = familyData[j + 1][LANGUAGE];
                                familyData[j + 1][LANGUAGE] = aux;
                                aux = familyData[j][ROOM];
                                familyData[j][ROOM] = familyData[j + 1][ROOM];
                                familyData[j + 1][ROOM] = aux;
                                aux = familyData[j][TELF];
                                familyData[j][TELF] = familyData[j + 1][TELF];
                                familyData[j + 1][TELF] = aux;
                            }
                        }
                    }
    }

    //change int value to string literal
    public static String switchRoomType(int roomType) {
        String returnRoom;
        switch (roomType) {
            case 0:
                returnRoom = Accomodation.SHARED.toString();
                break;
            case 1:
                returnRoom = Accomodation.SINGLE.toString();
                break;
            case 2:
                returnRoom = Accomodation.HOME.toString();
                break;
            default:
                returnRoom = Accomodation.DORM.toString();
        };
        return returnRoom;
    }
}
