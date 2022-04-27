import java.util.Scanner;

public class Arrays {
	public static void main(String[] args) {
		
		//variables
		int people;
		Scanner input = new Scanner(System.in);

		//ask for array size
		System.out.println("Quantes persones s'han d'entrar: ");
		people = input.nextInt();
		System.out.println("Llegirem el codi de "+people+" persones.\r");

		//declare array when we have 'people' value
		int[] userCode = new int[people];

		//Collect data into array
		for (int i=0;i<people;i++) {
			System.out.println("Introdueix el codi: ");
			userCode[i]= input.nextInt();	
		}

		//Show all array values	
		System.out.println("Els codis introduits son: ");
		for (int i=0;i<people;i++) {
		    System.out.println("Codi: "+userCode[i]+" a la posicio "+(i)+"\r");
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
        System.out.println("Els valors dels codis ordenats son: ");
        for (int i=0;i<people;i++) {
		    System.out.println("codi: "+userCode[i]+" a la posicio "+(i)+"\r");
		}
	}
}
