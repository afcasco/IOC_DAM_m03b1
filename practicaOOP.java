import java.util.Scanner;

class Dispensador {
    int stockMaxim;
    int stock;
    int stockMinim;

    Dispensador() {

        System.out.println("\n--------------------------");
        System.out.println("Bevinguts a XicletLandia!");
        System.out.println("--------------------------");
        this.stockMaxim = 10;
        this.stock = 10;
        this.stockMinim = 5;
    }

    public int getStock() {
        return stock;
    }

    public void ventaStock(int venda) {
        stock -= venda;
    }

    public void setStock(int newStock) {
        stock += newStock;
    }
}

class Reposador {
    boolean actiu;
    int stockMagatzem;
    int viatges;
    int cantitatReposar;

    Reposador() {
        this.actiu = true;
        this.stockMagatzem = 20;
        this.viatges = 2;
        this.cantitatReposar = 5;
    }

    public boolean isActive() {
        return actiu;
    }

    public int reposar() {

        stockMagatzem -= 5;
        viatges -= 1;
        if (viatges == 0) {
            actiu = false;
            System.out.println("Ultima reposada del dia");
        }
        return cantitatReposar;
    }
}

public class VentaXiclets {
    public static void main(String[] args) {

        Reposador reposador = new Reposador();
        Dispensador dispensador = new Dispensador();

        int vullXiclets = 0;
        boolean quedenXiclets = true;

        while (quedenXiclets) {

            vullXiclets = getInput();
            int stock = dispensador.getStock();
            if (stock - vullXiclets > 0) {
                dispensador.ventaStock(vullXiclets);
                System.out.println("Has comprat " + vullXiclets + " xiclets");
            } else {
                System.out.println("nomes et podem donar " + dispensador.getStock() + "xiclets, no hi ha mes stock");
                dispensador.ventaStock(dispensador.getStock());
                if (reposador.isActive()) {
                    System.out.println("S'ha avisat al magatzem, han reposat 5 xiclets mes");
                    dispensador.setStock(reposador.reposar());
                } else {
                    quedenXiclets = false;
                }
            }
        }
    }

    static int getInput() {
        Scanner input = new Scanner(System.in);
        int value = 0;
        boolean inRange = false;
        while (!inRange) {
            System.out.println("Quants xiclets vols?");
            inRange = input.hasNextInt();
            if (inRange) {
                value = input.nextInt();
                if (value != 1 && value != 2 && value != 5) {
                    inRange = false;
                    System.out.println("Nomes tenim packs de 1, 2 o 5 xiclets");
                }
            }
            input.nextLine();
        }
        return value;
    }
}
