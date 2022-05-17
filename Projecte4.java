package toni.ioc.exercicis;

public class E14_HidalgoS {

	public static final int HOME = 0; // constants per cridar els dos sexes
	public static final int DONA = 1;

	public static void main(String[] args) {

		int[][] dorsal_sexe_edat_temps = { { 3457, 1, 51, 52 }, { 3467, 1, 32, 41 }, { 3568, 0, 14, 57 },
				{ 3570, 0, 12, 63 }, { 3571, 1, 45, 63 }, { 3572, 0, 17, 46 }, { 3573, 0, 12, 44 }, { 3574, 0, 30, 42 },
				{ 3575, 1, 24, 77 }, { 3576, 0, 57, 48 } };

		int marca_min = 0;// var per buscar record	
		int guanya = 0;// per els guanyadors 
		
		

		System.out.println("======0000000000000000=======");
		System.out.println("DORSAL" + "\t" + "SEXE" + "\t" + "EDAT" + "\t" + " TEMPS");
		System.out.println("======0000000000000000=======");
		System.out.println();

		for (int i = 0; i < 10; i++) { // recorregut vertical
			for (int j = 0; j < 4; j++) // recorregut horitzontal

				System.out.print(dorsal_sexe_edat_temps[i][j] + "\t" + "|");
			System.out.println();
		}
		System.out.println();
		System.out.println("==========");
		System.out.println("|Home = 0|");
		System.out.println("|Dona = 1|");
		System.out.println("==========");
		System.out.println();
		System.out.println();
		System.out.println("Guanyador Categoria Home");
		System.out.println("======0000000000000000=======");

		for (int i = 0; i < dorsal_sexe_edat_temps.length; i++) {

			if (dorsal_sexe_edat_temps[i][1] == HOME) {
				if (marca_min == 0) {
					marca_min = dorsal_sexe_edat_temps[i][3]; // per treure a la llum la marca més petita

					marca_min = dorsal_sexe_edat_temps[i][3]; // torna la var en el que volem; minuts
					guanya = i; // torna la variable ; dorsal

				} else {
					if (dorsal_sexe_edat_temps[i][3] < marca_min) {
						marca_min = dorsal_sexe_edat_temps[i][3];
						guanya = i;
					}

				}
			}
		}

		System.out.println("El guanyador categoria masculina es el dorsal; " + dorsal_sexe_edat_temps[guanya][0]
				+ "amb una marca de " + marca_min); // imprimim dorsal

		System.out.println();
		System.out.println();

		for (int i = 0; i < dorsal_sexe_edat_temps.length; i++) {

			if (dorsal_sexe_edat_temps[i][1] == DONA) {

				if (dorsal_sexe_edat_temps[i][3] < marca_min)
					;

				marca_min = dorsal_sexe_edat_temps[i][3];
				guanya = dorsal_sexe_edat_temps[i][0];

			} else {
				if (dorsal_sexe_edat_temps[i][3] < marca_min) {
					marca_min = dorsal_sexe_edat_temps[i][3];
					guanya = i;
				}

			}
		}
		
		System.out.println("Guanyador Categoria Dona");
		System.out.println("======0000000000000000=======");
		System.out.println("El guanyador categoria femenina es la dorsal; " + dorsal_sexe_edat_temps[guanya][0] + 
				" amb una marca de " + marca_min);

	}
}
