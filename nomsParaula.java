import java.util.Scanner;
class nomsParaula {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Introdueix una frase: ");
        String sentence = scan.nextLine();
        if (sentence != null && !sentence.trim().isEmpty()) {
            String[] words = sentence.split(" ");
            String paraula = "";
            for (String word: words) {
                paraula += word.charAt(0);
            }
            System.out.println("La paraula es: " + paraula);
        } else {
            System.out.println("La frase esta buida");
        }
    }
}
