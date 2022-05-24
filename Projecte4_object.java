import java.util.Scanner;
import java.util.ArrayList;

class Family {

	int id;
	int telNumber;
	String accomodationType;
	int pplToAccomodate;
	boolean speaksRu;

	Family(){
		this.id = getIntInput();
		this.telNumber = getIntInput();
		this.accomodationType = getRoomType(getIntInput());
		this.pplToAccomodate = getIntInput();
		this.speaksRu = getBooleanInput();
	}
	
	int getIntInput() {
		System.out.println("entradada: ");
	    Scanner input = new Scanner(System.in);
	    return input.nextInt();
	}
	boolean getBooleanInput(){
	    Scanner input = new Scanner(System.in);
	    return (input.nextInt()==1) ? true : false;
	}
	String getRoomType(int m){
		Scanner input = new Scanner(System.in);
		m = input.nextInt();
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

	public enum Type = { 
		SHARED("shared"),
		SINGLE("single"),
		FULL("full"),
		COMUNAL("comunal");
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

