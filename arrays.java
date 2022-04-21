import java.util.Scanner;

public class Arrays {
	public static void main(String[] args) {
		
		int persones;
		Scanner entrada = new Scanner(System.in);
		System.out.println("Quantes persones s'han d'entrar: ");
		persones = entrada.nextInt();
		System.out.println("Llegirem el codi de "+persones+" persones.\r");

		int[] codiUsuari = new int[persones];
		for (int i=0;i<persones;i++) {
			System.out.println("Introdueix el codi: ");
			codiUsuari[i]= entrada.nextInt();	
		}

		System.out.println("Els codis introduits son: ");
		for (int i=0;i<persones;i++) {
		    System.out.println("Codi: "+codiUsuari[i]+" a la posicio "+(i)+"\r");
		}

   		 for (int i = 0; i < persones - 1; i++) {
    
      		for (int j = 0; j < persones - i - 1; j++) {

       			 if (codiUsuari[j] > codiUsuari[j + 1]) {
         		 	int temp = codiUsuari[j];
        		 	codiUsuari[j] = codiUsuari[j + 1];
        		 	codiUsuari[j + 1] = temp;
        		 }
        	}
        }
        
        System.out.println("Els valors dels codis ordenats son: ");
        for (int i=0;i<persones;i++) {
		    System.out.println("codi: "+codiUsuari[i]+" a la posicio "+(i)+"\r");
		}
	}
}