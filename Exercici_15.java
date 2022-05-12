import java.util.Scanner;
import java.util.Random;

public class strings {

	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);
		int limit = 10;
		System.out.println("Enter name and surname: ");
		String fullName = input.nextLine();
		String password = "";
		String[] splitName = fullName.split(" ");
		Random rand = new Random();
		int randomNum;
		
     //concatenate 2 first leters of name and surname
		for(int i=0;i<2;i++) {
			password = password + splitName[0].charAt(i) + splitName[1].charAt(i);
		}
        
    //add 4 random digits
		for(int i=0;i<4;i++) {
			randomNum= rand.nextInt(limit);
			password += randomNum;
		}
		//print password
		System.out.println("The new password is "+password);
	}
}
