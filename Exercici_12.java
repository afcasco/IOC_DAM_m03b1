import java.util.Scanner;

public class Arrays {
	public static void main(String[] args) {
		
		//variables
		int people;
		Scanner input = new Scanner(System.in);

		//ask for array size and declare array
		System.out.println("Quantes persones vols entrar: ");
		people = input.nextInt();
		int[] userCode = new int[people];

		//Collect data into array
		for (int i=0;i<people;i++) {
			System.out.println("Entra el codi de l'usuari: ");
			userCode[i]= input.nextInt();	
		}

		//Show all array values	
		System.out.println("\nLlistat de codis entrats: ");
		for (int i=0;i<people;i++) {
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
        for (int i=0;i<people;i++) {
		    System.out.println(userCode[i]);
		}
	}
}
