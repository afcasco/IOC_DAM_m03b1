import java.util.Scanner;

public class FamiliesAcollida {

    //declare constants
    private static final int MIN = 0;
    private static final int MAX = 1;
    private static final int[] ID_RANGE = {10,999};
    private static final int[] PLACES_RANGE = {1,99};
    private static final int[] ROOM_RANGE = {0,3};
    private static final int[] TEL_NUMBER_RANGE = {111111111,999999999};
    private static final int MAX_ATTEMPTS = 3;
    private static final String SHARED = "Habitaci compartida             ";
    private static final String SINGLE = "Habitaci                     ";
    private static final String HOME = "Habitatge sencer                 ";
    private static final String DORM = "Sala comunitria, local habilitat";
    private static final String PARLA_SI = "si";
    private static final String PARLA_NO = "no";
    private static final String BAD_VALUE_INPUT = "Error, input de dades no valida";
    private static final int END_CURRENT = -1;
    private static final int MAX_FAMILIES = 10;
    private static final boolean LISTEN_FOR_EXIT = true;
    private static final boolean DONT_LISTEN_FOR_EXIT = false;

    //declare arrays to store data (max 10 families)
    int[] id = new int[MAX_FAMILIES];
    int[] places = new int[MAX_FAMILIES];
    int[] respostaIdioma = new int[MAX_FAMILIES];
    int[] room = new int[MAX_FAMILIES];
    int[] telf = new int[MAX_FAMILIES];
    String allotjament;
    int nFam = 0;
    int attempts;
    boolean inRange;
    boolean exit = false;
    String parlaIdioma;
    int i = 0;
    int keepAskingInt;

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
            attempts = 0;
            inRange = false;

            //id input
            id[nFam] = getInput("Introdueix id familia (10-999)", ID_RANGE[MIN], ID_RANGE[MAX], LISTEN_FOR_EXIT);

            //spots input
            if (attempts != MAX_ATTEMPTS && !exit) {
                places[nFam] = getInput("Introdueix numero de places disponible (1-99", PLACES_RANGE[MIN], PLACES_RANGE[MAX], LISTEN_FOR_EXIT);
            }

            //speaks ru/ukr input
            if (attempts != MAX_ATTEMPTS && !exit) {
                respostaIdioma[nFam] = getInput("Parla rus o ucraines (si: 1/ no:0)", MIN, MAX, LISTEN_FOR_EXIT);
            }

            //room type input
            if (attempts != MAX_ATTEMPTS && !exit) {
                room[nFam] = getInput("Introdueix una de les opcions:", ROOM_RANGE[MIN], ROOM_RANGE[MAX], LISTEN_FOR_EXIT);
            }

            //mobile # input
            if (attempts != MAX_ATTEMPTS && !exit) {
                telf[nFam] = getInput("Introdueix un telefon de contacte:", TEL_NUMBER_RANGE[MIN], TEL_NUMBER_RANGE[MAX], LISTEN_FOR_EXIT);
            }

            //Print why current input was cancelled, or add 1 to nFam if it wasn't
            errorMessageHandling();

            //ask to continue input
            keepAskingInt = getInput("\nContinuar introduint dades? (si: 1/ no:0)", MIN, MAX, DONT_LISTEN_FOR_EXIT);

        } while (keepAskingInt != 0);

        //print total number of families
        System.out.println("\nS'han introduit les dades de: " + nFam + " families");

        //if families greater than 0
        if (nFam > 0) {
            printFamilyData();
        }
    }

    public int getInput(String inputText, int min, int max, boolean listenForExit) {
        exit = false;
        int curInput = 0;
        attempts = 0;
        inRange = false;
        Scanner input = new Scanner(System.in);
        System.out.println(inputText);
        while (!inRange && attempts < MAX_ATTEMPTS && !exit) {
            inRange = input.hasNextInt();
            if (inRange) {
                curInput = input.nextInt();
                if (curInput < min || curInput > max) {
                    inRange = false;
                    if (curInput == -1) exit = true;
                }
            }
            if (!inRange&&!exit) {
                attempts++;
                System.out.println(BAD_VALUE_INPUT);
            }
            input.nextLine();
        }
        return curInput;
    }

    public void errorMessageHandling(){
        if(attempts==MAX_ATTEMPTS&&!exit){
            System.out.println("reached max attemts, canceling current family input...");

        } else if (exit) {
            System.out.println("Current family input cancelled by operator with -1");
        } else {
            nFam++;
        }
    }

    public void printFamilyData(){
        System.out.println("\nId\t\tplaces\t\trus/ucraines\t\ttipus\t\t\t\t\t\t\t\t\ttelefon");
        for(int i=0;i<nFam;i++){
            System.out.println(id[i] + "\t\t" + places[i] + "\t\t\t" + respostaIdioma[i] + "\t\t\t\t\t" + room[i] + "\t\t" + telf[i]);
        }

    }

}