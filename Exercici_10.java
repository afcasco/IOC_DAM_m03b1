package Unitat1;

import java.util.Scanner;

public class E10_FernandezC {

    //Constants declaration
    private static final int NUM_MIN = 20;
    private static final int NUM_MAX = 100;
    private static final int EXIT = -1;
    private static final int N_LOOPS = 2;

    public static void main(String[] args) {

        //variables declaration
        Scanner istream = new Scanner(System.in);
        boolean inRange;
        int limit = 0;
        int repeat = 0;
        int cumulative;

        //run until repeat reaches N_LOOPS
        do {
            //assign inside the loop to avoid carry-over between runs
            inRange = true;
            cumulative = 0;
            System.out.println("\n----------------------------------");
            System.out.println("Here we go! LOOP: " + (repeat + 1) + "/" + N_LOOPS);
            System.out.println("----------------------------------\n");

            //run while conditions are not met (exit with a valid number or -1)
            do {
                //Will only show the error message after the first run
                if (!inRange) System.out.println("Enter a number in the specified range please...");
                System.out.println("Enter integer between 20 and 100 (-1 to exit): ");
                inRange = istream.hasNextInt();
                if (inRange) {
                    limit = istream.nextInt();
                    if (limit < NUM_MIN || limit > NUM_MAX) {
                        inRange = false;
                    }
                }
                istream.nextLine();
            } while (!inRange && limit != EXIT);

            //If loop was ended with valid number (not -1)
            if (inRange) {
                System.out.println("Odds in given range:");
                for (int i = 0; i <= limit; i++) {
                    if (i % 2 != 0) {
                        System.out.print(i);
                        //Avoid trailing comma
                        if (i < limit - 1) System.out.print(", ");
                        cumulative += i;
                    }
                }
                System.out.println("\nAll added odds in range: " + cumulative);

                //If we exit the loop with -1 print error message
            } else {
                System.out.println("EXIT TRIGGERED BY USER");
            }

            repeat++;
        } while (repeat < N_LOOPS);
    }
}
