import java.util.Scanner;

class Dispensador {
	int stockMaxim;
	int stock;
	int stockMinim;
	int[] packs = {1,2,5};

	Dispensador(){

		System.out.println("\n--------------------------");
		System.out.println("Bevinguts a XicletLandia!");
		System.out.println("--------------------------");
		this.stockMaxim = 10;
		this.stock = 10;
		this.stockMinim = 5;
	}

	public int getStock(){
		return this.stock;
	}

	public void ventaStock(int venda){
		this.stock -= venda;
	}
	
	public void setStock(int newStock){
		this.stock += newStock;
	}
}


class Reposador {
	boolean actiu;
	int stockMagatzem;
	int maxViatges;

	Reposador(){
		this.actiu = true;
		this.stockMagatzem = 20;
		this.maxViatges = 2;
	}

	public boolean isActive(){
		return this.actiu;
	}

	public int reposar(){
		this.stockMagatzem -= 5;
		this.maxViatges -= 1;
		if(this.maxViatges==0) {
			this.actiu = false;
			System.out.println("Ultima reposada, el reposador plega per avui");
		}
		return 5;
	}
}

public class VentaXiclets {
	public static void main(String[] args) {	

		Reposador reposador = new Reposador();
		Dispensador dispensador = new Dispensador();

		int vullXiclets=0;
		boolean quedenXiclets = true;

		while(quedenXiclets){
			
			vullXiclets = getInput();
			int stock = dispensador.getStock();
			if(stock-vullXiclets>0){
				dispensador.ventaStock(vullXiclets);
				System.out.println("Has comprat "+vullXiclets+" xiclets");
			} else {
				System.out.println("nomes et podem donar "+dispensador.getStock()+ "xiclets, no hi ha mes stock");
				dispensador.ventaStock(dispensador.getStock());
				if(reposador.isActive()){
					System.out.println("Avisem el noi, hi ha reposat 5 xiclets");
					dispensador.setStock(reposador.reposar());
				} else {
					quedenXiclets = false;
				}
			}
		}
	}

	static int getInput(){
		Scanner input = new Scanner(System.in);
		int value=0;
		boolean inRange=false;
		while(!inRange) {
			System.out.println("Quants xiclets vols?");
			inRange = input.hasNextInt();
			if(inRange){
				value = input.nextInt();
				if(value!=1&&value!=2&&value!=5){
					inRange=false;
					System.out.println("Nomes tenim packs de 1, 2 o 5 xiclets");
				}
			}
			input.nextLine();
		}
		return value;
	}
}
