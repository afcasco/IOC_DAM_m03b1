/*
Find and print all the multiples between the defined constants NUM_MIN and NUM_MAX up until SHOW_MAX
*/

import java.util.Scanner;
public class E8_FernandezC {

    private static final int NUM_MIN = 1;
    private static final int NUM_MAX = 20;
    private static final int SHOW_MAX = 100;

    public static void main(String[] args) {

        Scanner istream = new Scanner(System.in);
        int num = 0; int i = 0; int multiple = 0;
        boolean inRange = false;

        while (!inRange) {
            System.out.println("Introdueix un numero sencer de 1 a 20: ");
            inRange = istream.hasNextInt();
            if (inRange) {
                num = istream.nextInt();
                if (num < NUM_MIN || num > NUM_MAX) {
                    inRange = false;
                }
            }
            istream.nextLine();
        }

        while (multiple <= (SHOW_MAX - num)) {
            multiple = num * i;
            System.out.println(multiple);
            i++;
        }
    }
}
