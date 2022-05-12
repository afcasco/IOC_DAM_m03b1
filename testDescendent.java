import java.util.Scanner;

public class OrdenarDescendent {

	//Variable global
	private int[] llistaEnters = new int[10];

    public static void main(String[] args) {
        //Instruccions del metode principal (problema general)
        //...
        OrdenarDescendent programa = new OrdenarDescendent();
        programa.inici();
    }

    public void inici(){
    	llegirLlista();
    	ordenarLlista();
    	mostrarLlista();
    }
    //Metode que resol el subproblema de llegir la llista.
    public void llegirLlista() {
    	Scanner input = new Scanner(System.in);
        for(int i=0;i<llistaEnters.length;i++){
        	System.out.println("Entra un numero: ");
        	llistaEnters[i] = input.nextInt();
        }
    }
    //Metode que resol el subproblema d’ordenar la llista.
    public void ordenarLlista() {
        for(int i=0;i<llistaEnters.length-1;i++) {
        	for(int j=0;j<llistaEnters.length-1-i;j++){
        		if(llistaEnters[j]>llistaEnters[j+1]){
        			int aux = llistaEnters[j];
        			llistaEnters[j] = llistaEnters[j+1];
        			llistaEnters[j+1] = aux;
        		}
        	}
        }
    }
    //Metode que resol el subproblema de mostrar la llista per pantalla.
    public void mostrarLlista() {
        //Instruccions del metode
        for(int i=0;i<llistaEnters.length;i++) {
        	System.out.println("Posicio "+i+" es "+llistaEnters[i]);
        }
    }
}
