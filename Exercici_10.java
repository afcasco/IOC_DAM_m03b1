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
        Scanner input = new Scanner(System.in);
        int limit = 0, repeat = 0, cumulative, totalOdds;
        boolean inRange;

        //run until repeat reaches N_LOOPS
        do {

            //assign inside the loop to avoid carry-over between runs
            inRange = true;
            cumulative = 0;
            totalOdds = 0;
            System.out.println("\n---------------------------------------");
            System.out.println("| Here we go! LOOP: " + (repeat + 1) + "/" + N_LOOPS + "               |");
            System.out.println("---------------------------------------\n");

            //run while conditions are not met (exit with a valid number or -1)
            do {

                //Will only show the error message after the first run
                if (!inRange) System.out.println("Invalid input, stick to the rules please!");
                System.out.println("Enter an integer between 20 and 100 (-1 to exit): ");
                inRange = input.hasNextInt();
                if (inRange) {
                    limit = input.nextInt();
                    if (limit < NUM_MIN || limit > NUM_MAX) inRange = false;
                }
                input.nextLine();
            } while (!inRange && limit != EXIT);

            //If loop was ended with valid number (not -1)
            if (inRange) {
                System.out.println("Odd numbers in the given range:");
                for (int i = 0; i <= limit; i++) {

                    //Only print odd numbers and increment totalOdds
                    if (i % 2 != 0) {
                        System.out.print(i);
                        totalOdds++;

                        //Avoid trailing comma and print how many odds were found
                        if (i < limit - 1) System.out.print(", ");
                        else System.out.print("  (" + totalOdds + " found!)");
                        cumulative += i;
                    }
                }
                System.out.println("\nThe sum of all the odd numbers in the series is: " + cumulative);

                //If we exit the loop with -1 print error message
            } else System.out.println("\nEXIT TRIGGERED BY USER");
            repeat++;
        } while (repeat < N_LOOPS);
    }
}
