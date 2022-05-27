import java.util.Scanner;

public class Repas {

	private static final int VALOR = 21;

	// Imprimeix per pantalla si el nombre de la constant VALOR es parell o senar
	static void parellSenar(){
		if(VALOR%2==0) {
			System.out.println("Es parell");
		} else {
			System.out.println("Es senar");
		}
		
	}

	// imprimeix per pantalla si el nombre de la constant VARLOR es mutliple de 7
	static void multipleDe7(){
		if(VALOR%7==0) {
			System.out.println("Es multiple de 7");
		} else {
			System.out.println("No es multiple de 7");
		}
		System.out.println();
		// versio alternativa amb operador ternari
		System.out.println((VALOR%7==0) ? "Es multiple de 7" : "No es multiple de 7");

	}

	static void showCharsC(){
		int max = 100;
		for(int i=0;i<max;i++){
		    System.out.println((char)i +" "+i);
		}
		
	}

	// introduir nombres sencers fins introduir nombre = FI
	private static final int FI = 0;
	static void llegeixIntFinsFI(){
		Scanner input = new Scanner(System.in);
		int numero=Integer.MIN_VALUE;
		while(numero!=0){
			System.out.println("Intodueix un numero sencer: ");
			numero = input.nextInt();
			if(numero == FI) {
				System.out.println("\nHas introduit el numero pero sortir ("+FI+")");
			} else {
				System.out.println("\nHas introduit el numero: "+numero);
			}
		}
	}

	private static void ComptaParells(){
		Scanner input = new Scanner(System.in);
		int numero=Integer.MIN_VALUE;
		int parells=0;
		while(numero!=0){
			System.out.println("Intodueix un numero sencer: ");
			numero = input.nextInt();
			if(numero%2==0) {
				parells++;
			}	
		}
		System.out.println("Has introduit un total de "+parells);

	}

    // mostra calendari amb dies i dia d'inici entrats per usuari
	private static void diesDelMes(){
		Scanner input = new Scanner(System.in);
		int dies; int inici;
		
		System.out.println("Quants dies te el mes? ");
		dies = input.nextInt();
		System.out.println("Quin dia de la setmana comenca el mes? ");
		inici = input.nextInt();

		int[] mes = new int[dies+inici];

		for(int i=0;i<dies;i++){
			if(i<inici){
				mes[i]=0;
			} else {
				mes[i]=i-inici+1;
			}
		}
	
		for(int i=0;i<dies;i++){
			if(mes[i]==0) {
				System.out.print(" ");
			} else {
				System.out.print(mes[i]+" ");
			}
			if((i+1)%7==0) System.out.println("\n");
		}
	}


	public static void main(String[] args) {
		//parellSenar();
		//multipleDe7();
		//showCharsC();
		//llegeixIntFinsFI();
		//diesDelMes();
	}
	
}
