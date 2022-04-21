import java.util.Scanner;
public class E05_FernandezC {

    private static final int TEGERMA = 40;
    private static final int VIUZONA = 30;
    private static final int FEINAZONA = 20;
    private static final int TEDISC = 10;
    private static final int FAMNOMB = 15;
    private static final int EXALUMN = 5;

    public static void main(String[] args) {
        int numReg, teGerma, viuZona, feinaZona, teDisc, famNomb, exAlumn, puntsTot;
        boolean esEnter;
        puntsTot = 0;
        Scanner scan = new Scanner(System.in);
        //Demanem dades i s'assigna 0 o 1 en funcio de si la resposta es si o no
        System.out.println("Introdueix el nummero de registre (1-499)");
        esEnter = scan.hasNextInt();
        if (esEnter) {
            numReg = scan.nextInt();
            //Si el numero de registre es valid continuem si no el programa s'atura
            if ((numReg >= 1) && (numReg <= 499)) {
                System.out.println("Te algun germa al centre? (0=no, 1=si");
                esEnter = scan.hasNextInt();
                if (!esEnter) {
                    System.out.println("Valor incorrecte");
                } else {
                    teGerma = scan.nextInt();
                    if (teGerma <= 1 && teGerma >= 0) {
                        System.out.println("Viu a la zona de l'escola? (0=no, 1=si");
                        esEnter = scan.hasNextInt();
                        if (!esEnter) {
                            System.out.println("Valor incorrecte");
                        } else {
                            viuZona = scan.nextInt();
                            if (viuZona <= 1 && viuZona >= 0) {
                                System.out.println("Algun dels pares treballa a la zona de l'escola? (0=no, 1=si");
                                esEnter = scan.hasNextInt();
                                if (!esEnter) {
                                    System.out.println("Valor incorrecte");
                                } else {
                                    feinaZona = scan.nextInt();
                                    if (feinaZona <= 1 && feinaZona >= 0) {
                                        System.out.println("Te alguna discapacitat o malaltia cronica? (0=no, 1=si");
                                        esEnter = scan.hasNextInt();
                                        if (!esEnter) {
                                            System.out.println("Valor incorrecte");
                                        } else {
                                            teDisc = scan.nextInt();
                                            if (teDisc <= 1 && teDisc >= 0) {
                                                System.out.println("Forma part de familia nombrosa o monoparental? (0=no, 1=si");
                                                esEnter = scan.hasNextInt();
                                                if (!esEnter) {
                                                    System.out.println("Valor incorrecte");
                                                } else {
                                                    famNomb = scan.nextInt();
                                                    if (famNomb <= 1 && famNomb >= 0) {
                                                        System.out.println("El pare la mare o algun germa son exalumnes? (0=no, 1=si");
                                                        esEnter = scan.hasNextInt();
                                                        if (!esEnter) {
                                                            System.out.println("Valor incorrecte");
                                                        } else {
                                                            exAlumn = scan.nextInt();
                                                            if (exAlumn <= 1 && exAlumn >= 0) {
                                                                if (teGerma == 1) puntsTot += TEGERMA;
                                                                //Si viu a la zona sumem punts viuzona, i sino comprobem si podem
                                                                //sumar els punts feinazona, si tots dos son 0 no sumem cap punt
                                                                if (viuZona == 1) {
                                                                    puntsTot += VIUZONA;
                                                                } else {
                                                                    if (feinaZona == 1) puntsTot += FEINAZONA;
                                                                }
                                                                //si te alguna discapacitat sumem punts TEDISC
                                                                if (teDisc == 1) puntsTot += TEDISC;
                                                                //Si es familia nombrosa sumem punts FAMNOMB
                                                                if (famNomb == 1) puntsTot += FAMNOMB;
                                                                //Si familiar es exalumne sumem punts de la constant EXALUMN
                                                                if (exAlumn == 1) puntsTot += EXALUMN;
                                                                System.out.println("El nen assignat al numero de registre " + numReg + " ha obtingut un total de " + puntsTot + " punts");
                                                            } else {
                                                                System.out.println("Valor incorrecte");
                                                            }
                                                        }
                                                    } else {
                                                        System.out.println("Valor incorrecte");
                                                    }
                                                }
                                            } else {
                                                System.out.println("Valor incorrecte");
                                            }
                                        }
                                    } else {
                                        System.out.print("Valor incorrecte");
                                    }
                                }
                            } else {
                                System.out.println("Valor Incorrecte");
                            }
                        }
                    } else {
                        System.out.println("Valor Incorrecte");
                    }
                }
            } else System.out.println("El numero de registre introduit no es valid");
        } else {
            System.out.println("El numero introduit es erroni");
        }
    }
}
