import java.util.Scanner;

public class Exercici10 {

    private static final int NUM_MIN =  20;
    private static final int NUM_MAX = 100;
    private static final int EXIT = -1;
    private static final int MAX_LOOPS = 2;
    
    public static void main(String[] args) {

        Scanner istream = new Scanner(System.in);
        boolean inRange = true;
        int limit=0;
        int cumulative=0;
        int repeat = 0;

        do{
            System.out.println("\n----------------------------------"); 
            System.out.println("Here we go! LOOP: "+(repeat+1)+"/"+MAX_LOOPS);
            System.out.println("----------------------------------\n"); 

            do {

                if(!inRange) System.out.println("Enter a number in the specified range please...");

                System.out.println("Enter integer between 20 and 100: ");
                inRange = istream.hasNextInt();
                if (inRange) {

                    limit = istream.nextInt();
                    if (limit < NUM_MIN || limit > NUM_MAX) {
                        inRange = false;

                    }
                }
                istream.nextLine();
            } while (!inRange && limit != EXIT);

            if (inRange) {
                for(int i=0; i <= limit; i++) {
                    if(i%2!=0) {
                        System.out.println("odd number: "+i);
                        cumulative += i;
                    }
                }
                System.out.println("All added odds in range: "+cumulative);
            } else {

                System.out.println("EXIT TRIGGERED BY USER");
            }

            repeat++;    

        } while(repeat<MAX_LOOPS); 
    }
}