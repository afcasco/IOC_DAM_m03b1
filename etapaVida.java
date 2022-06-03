import java.util.Scanner;

class etapaVida{
	static final int EDAT_MIN = 0;
	static final int EDAT_MAX = 150;
	static final String[] etapas = {"nado","nen","pre-adolescent","adolescent","jove","adult","ancia"};
	public static void main(String[] args) {
		int edat;
		String etapa;
		edat = getUserInput("Introdueix una edat",EDAT_MIN,EDAT_MAX);
		etapa = edatAetapa(edat);
		System.out.printf("L'edat introduida es correspon a la etapa de vida: %s.",etapa);
	}

	static String edatAetapa(int edat) {
		String etapa = null;
		if(numeroEnRang(edat,0,12)) {
			etapa = etapas[0];
		} else if (numeroEnRang(edat,2,10)){
			etapa = etapas[1];
		} else if (numeroEnRang(edat,10,12)){
			etapa = etapas[2];
		} else if (numeroEnRang(edat,12,18)){
			etapa = etapas[3];
		} else if (numeroEnRang(edat,18,30)){
			etapa = etapas[4];
		} else if (numeroEnRang(edat,30,70)){
			etapa = etapas[5];
		} else {
			etapa = etapas[6];
		}
		return etapa;
	}

	static boolean numeroEnRang(int numero, int min, int max){
		return (numero >= min && numero<max) ? true : false;
	}

	static int getUserInput(String text,int min,int max){
		Scanner input = new Scanner(System.in);
		System.out.printf("%s: %n",text);
		boolean inRange = false;
		int value=0;
		while(!inRange) {
			inRange = input.hasNextInt();
			if(inRange){
				value = input.nextInt();
				if(value<EDAT_MIN||value>EDAT_MAX){
					inRange=false;
				} else continue;
			}
		System.out.printf("%s valida (%d-%d):%n",text,EDAT_MIN,EDAT_MAX);
		input.nextLine();
		}
		return value;
	}
}
