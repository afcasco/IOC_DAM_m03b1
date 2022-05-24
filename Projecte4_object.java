import java.util.Scanner;
import java.util.ArrayList;

class Family {



	int id;
	int telNumber;
	String accomodationType;
	int pplToAccomodate;
	boolean speaksRu;

	static int attempts = 0;

	Family(){

		this.id = getIntInput("Enter ID number: ");
		this.telNumber = getIntInput("Enter telephone number: ");
		this.accomodationType = getRoomType(getIntInput("Enter room type"));
		this.pplToAccomodate = getIntInput("Enter how many people: ");
		this.speaksRu = getBooleanInput("Enter 0 or 1 (no/yes");
	}
	
	int getIntInput(String inputText) {
		System.out.println(inputText);
	    Scanner input = new Scanner(System.in);
	    return input.nextInt();
	}
	boolean getBooleanInput(String inputText){
		System.out.println(inputText);
	    Scanner input = new Scanner(System.in);
	    return (input.nextInt()==1) ? true : false;
	}
	String getRoomType(int m){
		String room;
	    switch(m) {
	    	case 0:
	    		room = "shared";
	    		break;
	    	case 1:
	    		room = "single";
	    		break;
	    	case 2:
	    		room = "full";
	    		break;
	    	default:
	    		room = "comunal";
	    }
	    return room;
	}

}

class Acollida {
	public static void main(String[] args) {
	    
	    boolean keepAsking = true;
	    int continu;
	    
	    ArrayList<Family> familiesList = new ArrayList<Family>();
	    while(keepAsking) {
	        Family temp = new Family();
	        familiesList.add(temp);
	        Scanner tempInput = new Scanner(System.in);
	        System.out.println("continue entering families?");
	        continu = tempInput.nextInt();
	        
	        if(continu==0) keepAsking = false;
	    }

	    System.out.println("arraylist size "+familiesList.size());
		

	}	
}

