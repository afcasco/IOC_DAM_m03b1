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
    int id, places, respostaIdioma, room, telf, attempts, nFamilies = 0;
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
      id = 0;
      places = 0;
      respostaIdioma = 0;
      room = 0;
      telf = 0;
      attempts = 0;
      parlaIdioma = PARLA_NO;
      inRange = false;
      System.out.println("\n(Introdueix -1 per cancelar entrada actual)");
      while (!inRange && attempts < MAX_ATTEMPTS && !exit) {
        System.out.println("Introdueix id familia (10-999):");
        inRange = input.hasNextInt();
        if (inRange) {
          id = input.nextInt();
          if (id < ID_MIN || id > ID_MAX) {
            inRange = false;
            if (id == END_CURRENT) {
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
        System.out.println("\n(Resposta anterior: Id=" + id + " si no es correcte introdueix -1 per cancelar entrada actual)");
        inRange = false;
        attempts = 0;
      }
      while (!inRange && attempts < MAX_ATTEMPTS && !exit) {
        System.out.println("Introdueix nmero de places disponible (1-99):");
        inRange = input.hasNextInt();
        if (inRange) {
          places = input.nextInt();
          if (places < PLACES_MIN || places > PLACES_MAX) {
            inRange = false;
            if (places == END_CURRENT) {
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
        System.out.println("\n(Resposta anterior: places=" + places + " si no es correcte introdueix -1 per cancelar entrada actual)");
        inRange = false;
        attempts = 0;
      }
      while (!inRange && attempts < MAX_ATTEMPTS && !exit) {
        System.out.println("Parla rus o ucraines? (0=no, 1=si):");
        inRange = input.hasNextInt();
        if (inRange) {
          respostaIdioma = input.nextInt();
          if (respostaIdioma < NO || respostaIdioma > SI) {
            inRange = false;
            if (respostaIdioma == END_CURRENT) {
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
        System.out.println("\n(Resposta anterior: idioma=" + respostaIdioma + " si no es correcte introdueix -1 per cancelar entrada actual)");
      }
      while (!inRange && attempts < MAX_ATTEMPTS && !exit) {
        System.out.println("Introdueix una de les opcions:");
        inRange = input.hasNextInt();
        if (inRange) {
          room = input.nextInt();
          if (room < ROOM_MIN || room > ROOM_MAX) {
            inRange = false;
            if (room == END_CURRENT) {
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
        System.out.println("\n(Resposta anterior: tipus d'habitatge=" + room + " si no es correcte introdueix -1 per cancelar entrada actual)");
        inRange = false;
        attempts = 0;
      }
      while (!inRange && attempts < MAX_ATTEMPTS && !exit) {
        System.out.println("Introdueix un telefon de contacte:");
        inRange = input.hasNextInt();
        if (inRange) {
          telf = input.nextInt();
          if (telf < TELF_MIN || telf > TELF_MAX) {
            inRange = false;
            if (telf == END_CURRENT) {
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
        if (respostaIdioma == SI) {
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

        //SUBSTITUTE variables for pos in array (pending)
        families[nFamilies][ID_ARRAY] = id;
        families[nFamilies][PLACES_ARRAY] = places;
        families[nFamilies][IDIOMA_ARRAY] = respostaIdioma;
        families[nFamilies][ROOM_ARRAY] = room;
        families[nFamilies][TELF_ARRAY] = telf;
    
        System.out.println("Id\tplaces\trus/ucrans\ttipus\t\t\t\t\ttelon");
        System.out.println(id + "\t" + places + "\t" + parlaIdioma + "\t\t" + allotjament + "\t" + telf);
        nFamilies++;
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
    System.out.println("\nS'han introduit les dades de: " + nFamilies + " families");



    for (int i = 0; i < nFamilies; i++) {
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
      System.out.println("Id\tplaces\trus/ucrans\ttipus\t\t\t\t\ttelon");
      System.out.println(families[i][ID_ARRAY] + "\t" + families[i][PLACES_ARRAY] + "\t" + parlaIdioma + "\t\t" + allotjament + "\t" + families[i][TELF_ARRAY]);
    }
  }
}
