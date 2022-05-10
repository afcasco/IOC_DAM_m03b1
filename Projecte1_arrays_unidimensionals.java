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

    
    int[] id = new int [10];
    int[] places = new int [10];
    int[] respostaIdioma = new int [10];
    int[] room = new int [10];
    int[] telf = new int [10];

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
      parlaIdioma = PARLA_NO;
      inRange = false;

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
      if (attempts < MAX_ATTEMPTS && !exit) {
        inRange = false;
        attempts = 0;
      }
      while (!inRange && attempts < MAX_ATTEMPTS && !exit) {
        System.out.println("Introdueix nmero de places disponible (1-99):");
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
      if (attempts < MAX_ATTEMPTS && !exit) {
        inRange = false;
        attempts = 0;
      }
      while (!inRange && attempts < MAX_ATTEMPTS && !exit) {
        System.out.println("Parla rus o ucraines? (0=no, 1=si):");
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
      if (attempts < MAX_ATTEMPTS && !exit) {
        if (respostaIdioma[nFam] == SI) {
          parlaIdioma = PARLA_SI;
        }
        switch (room[nFam]) {
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

    
        System.out.println("Id\tplaces\trus/ucrans\ttipus\t\t\t\t\ttelon");
        System.out.println(id[nFam] + "\t" + places[nFam] + "\t" + parlaIdioma + "\t\t" + allotjament + "\t" + telf[nFam]);
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


    System.out.println("Id\tplaces\trus/ucrans\ttipus\t\t\t\t\ttelon");
    for (int i = 0; i < nFam; i++) {
      if (respostaIdioma[i] == 0) {
        parlaIdioma = PARLA_SI;
      } else {
        parlaIdioma = PARLA_NO;
      }
      if (room[i] == 0) {
        allotjament = SHARED;
      } else if (room[i] == 1) {
        allotjament = SINGLE;
      } else if (room[i] == 2) {
        allotjament = HOME;
      } else {
        allotjament = DORM;
      }
      System.out.println(id[i] + "\t" + places[i] + "\t" + parlaIdioma + "\t\t" + allotjament + "\t" + telf[i]);
    }
  }
}



