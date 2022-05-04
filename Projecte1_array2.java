import java.util.Scanner;

public class Projecte1 {

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
  private static final String SHARED = "Habitaci compartida             ";
  private static final String SINGLE = "Habitaci                        ";
  private static final String HOME = "Habitatge sencer                 ";
  private static final String DORM = "Sala comunitria, local habilitat";
  private static final String PARLA_SI = "si";
  private static final String PARLA_NO = "no";
  private static final String ERROR_MSG = "Error, input de dades no vlida";
  private static final int END_CURRENT = -1;
  private static final int ID_ARRAY = 0;
  private static final int PLACES_ARRAY = 1;
  private static final int IDIOMA_ARRAY = 2;
  private static final int ROOM_ARRAY = 3;
  private static final int TELF_ARRAY = 4;


  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    int attempts, nFam = 0;
    String parlaIdioma, allotjament;
    boolean inRange;
    boolean keepAsking;
    int keepAskingInt;
    boolean exit;
    int[][] families = new int[100][5];
    do {
      exit = false;
      keepAsking = true;
      keepAskingInt = 0;
      attempts = 0;
      parlaIdioma = PARLA_NO;
      inRange = false;
      System.out.println("\n(Introdueix -1 per cancelar entrada actual)");
      while (!inRange && attempts < MAX_ATTEMPTS && !exit) {
        System.out.println("Introdueix families[nFam][ID_ARRAY] familia (10-999):");
        inRange = input.hasNextInt();
        if (inRange) {
          families[nFam][ID_ARRAY] = input.nextInt();
          if (families[nFam][ID_ARRAY] < ID_MIN || families[nFam][ID_ARRAY] > ID_MAX) {
            inRange = false;
            if (families[nFam][ID_ARRAY] == END_CURRENT) {
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
      if (attempts < MAX_ATTEMPTS && !exit) {
        System.out.println("\n(Resposta anterior: families[nFam][ID_ARRAY]=" + families[nFam][ID_ARRAY] + " si no es correcte introdueix -1 per cancelar entrada actual)");
        inRange = false;
        attempts = 0;
      }
      while (!inRange && attempts < MAX_ATTEMPTS && !exit) {
        System.out.println("Introdueix nmero de families[nFam][PLACES_ARRAY] disponible (1-99):");
        inRange = input.hasNextInt();
        if (inRange) {
          families[nFam][PLACES_ARRAY] = input.nextInt();
          if (families[nFam][PLACES_ARRAY] < PLACES_MIN || families[nFam][PLACES_ARRAY] > PLACES_MAX) {
            inRange = false;
            if (families[nFam][PLACES_ARRAY] == END_CURRENT) {
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
      if (attempts < MAX_ATTEMPTS && !exit) {
        System.out.println("\n(Resposta anterior: families[nFam][PLACES_ARRAY]=" + families[nFam][PLACES_ARRAY] + " si no es correcte introdueix -1 per cancelar entrada actual)");
        inRange = false;
        attempts = 0;
      }
      while (!inRange && attempts < MAX_ATTEMPTS && !exit) {
        System.out.println("Parla rus o ucraines? (0=no, 1=si):");
        inRange = input.hasNextInt();
        if (inRange) {
          families[nFam][IDIOMA_ARRAY] = input.nextInt();
          if (families[nFam][IDIOMA_ARRAY] < NO || families[nFam][IDIOMA_ARRAY] > SI) {
            inRange = false;
            if (families[nFam][IDIOMA_ARRAY] == END_CURRENT) {
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
      if (attempts < MAX_ATTEMPTS && !exit) {
        inRange = false;
        attempts = 0;
        System.out.println("De quin tipus d'allotjament es tracta?:");
        System.out.println("      (0) " + SHARED);
        System.out.println("      (1) " + SINGLE);
        System.out.println("      (2) " + HOME);
        System.out.println("      (3) " + DORM);
        System.out.println("\n(Resposta anterior: idioma=" + families[nFam][IDIOMA_ARRAY] + " si no es correcte introdueix -1 per cancelar entrada actual)");
      }
      while (!inRange && attempts < MAX_ATTEMPTS && !exit) {
        System.out.println("Introdueix una de les opcions:");
        inRange = input.hasNextInt();
        if (inRange) {
          families[nFam][ROOM_ARRAY] = input.nextInt();
          if (families[nFam][ROOM_ARRAY] < ROOM_MIN || families[nFam][ROOM_ARRAY] > ROOM_MAX) {
            inRange = false;
            if (families[nFam][ROOM_ARRAY] == END_CURRENT) {
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
      if (attempts < MAX_ATTEMPTS && !exit) {
        System.out.println("\n(Resposta anterior: tipus d'habitatge=" + families[nFam][ROOM_ARRAY] + " si no es correcte introdueix -1 per cancelar entrada actual)");
        inRange = false;
        attempts = 0;
      }
      while (!inRange && attempts < MAX_ATTEMPTS && !exit) {
        System.out.println("Introdueix un telefon de contacte:");
        inRange = input.hasNextInt();
        if (inRange) {
          families[nFam][TELF_ARRAY] = input.nextInt();
          if (families[nFam][TELF_ARRAY] < TELF_MIN || families[nFam][TELF_ARRAY] > TELF_MAX) {
            inRange = false;
            if (families[nFam][TELF_ARRAY] == END_CURRENT) {
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
      if (attempts < MAX_ATTEMPTS && !exit) {
        if (families[nFam][IDIOMA_ARRAY] == SI) {
          parlaIdioma = PARLA_SI;
        }
        switch (families[nFam][ROOM_ARRAY]) {
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

    
        System.out.println("families[nFam][ID_ARRAY]\tplaces\trus/ucrans\ttipus\t\t\t\t\ttelon");
        System.out.println(families[nFam][ID_ARRAY] + "\t" + families[nFam][PLACES_ARRAY] + "\t" + parlaIdioma + "\t\t" + allotjament + "\t" + families[nFam][TELF_ARRAY]);
        nFam++;
        //Si s'introdueix una dada malament 3 vegades arribarem a aquest missatge
      } else if (!exit) {
        System.out.println("------------------------------------------------------");
        System.out.println("Has introduit alguna dada malament mes de 3 vegades...");
        //Si l'usuari cancela la entrada actual arribarem a aquest missatge
      } else {
        System.out.println("------------------------------------------------------");
        System.out.println("\nEntrada actual cancelada per operador");
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
      if (attempts == MAX_ATTEMPTS || keepAskingInt == 0) {
        keepAsking = false;
      }
    } while (keepAsking);
    System.out.println("\nS'han introduit les dades de: " + nFam + " families");



    for (int i = 0; i < nFam; i++) {
      if (families[i][2] == 0) {
        parlaIdioma = PARLA_SI;
      } else {
        parlaIdioma = PARLA_NO;
      }
      if (families[i][3] == 0) {
        allotjament = SHARED;
      } else if (families[i][3] == 1) {
        allotjament = SINGLE;
      } else if (families[i][3] == 2) {
        allotjament = HOME;
      } else {
        allotjament = DORM;
      }
      System.out.println("families[nFam][ID_ARRAY]\tplaces\trus/ucrans\ttipus\t\t\t\t\ttelon");
      System.out.println(families[i][ID_ARRAY] + "\t" + families[i][PLACES_ARRAY] + "\t" + parlaIdioma + "\t\t" + allotjament + "\t" + families[i][TELF_ARRAY]);
    }
  }
}
