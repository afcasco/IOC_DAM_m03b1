package Unitat1;

import java.util.Scanner;

public class E12_FernandezC {

    private static final int NUM_MIN = 0;
    private static final int NUM_MAX = 1000;
    private static final String INPUT_ERROR = "Dada fora de rang! Torna a provar...";

    public static void main(String[] args) {

        //variables
        int people = 0;
        boolean inRange;
        boolean validSize = false;
        Scanner input = new Scanner(System.in);

        //ask for array size, needs an integer > 0 to set validSize to true
        System.out.println("Quantes persones vols entrar: ");
        inRange = input.hasNextInt();
        if (inRange) {
            people = input.nextInt();
            if (people > 0) {
                validSize = true;
            }
        }

        //If array size is valid
        if (validSize) {
            //decalre array with size = people
            int[] userCode = new int[people];
            input.nextLine();

            //Collect data into array until usercode[people] is full
            for (int i = 0; i < people; i++) {
                inRange = false;
                //repeat same for iteration if value is not valid (unlimited attempts given)
                while (!inRange) {
                    System.out.print("Entra el codi de l'usuari: ");
                    inRange = input.hasNextInt();
                    if (inRange) {
                        userCode[i] = input.nextInt();
                        if (userCode[i] < NUM_MIN || userCode[i] > NUM_MAX) {
                            inRange = false;
                        }
                    }
                    if (!inRange) System.out.println(INPUT_ERROR);
                    input.nextLine();
                }
            }

            //Show all array values
            System.out.println("\nLlistat de codis entrats: ");
            for (int i = 0; i < people; i++) {
                System.out.println(userCode[i]);
            }

            //bubble sort array values
            for (int i = 0; i < people - 1; i++) {
                for (int j = 0; j < people - i - 1; j++) {
                    if (userCode[j] > userCode[j + 1]) {
                        int aux = userCode[j];
                        userCode[j] = userCode[j + 1];
                        userCode[j + 1] = aux;
                    }
                }
            }

            //Show all rearanged array values
            System.out.println("\nLlistat ordenat de tots els codis entrats: ");
            for (int i = 0; i < people; i++) {
                System.out.println(userCode[i]);
            }
            //If array size is not valid
        } else {
            System.out.println("Error, l'array ha de tenir com a minim un element");
        }
    }
}

