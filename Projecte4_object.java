import java.util.Scanner;
import java.util.ArrayList;

class Family {

    public static final int MIN = 0;
    public static final int MAX = 1;
    private static final int MAX_ATTEMPTS = 3;
    private static final int[] ID_RANGE = {10,999};
    private static final int[] TEL_NUM_RANGE = {111_111_111,999_999_999};
    private static final int[] ROOM_RANGE = {0,3};
    private static final int[] PPL_RANGE = {1,99};

    int id;
    int telNumber;
    String accomodationType;
    int pplToAccomodate;
    String speaksRu;
    static boolean answerOk;
    static int attempts;

    Family() {
        this.id = getIntInput("Enter ID number: ", ID_RANGE[MIN], ID_RANGE[MAX]);
        if (answerOk) {
            this.telNumber = getIntInput("Enter telephone number: ", TEL_NUM_RANGE[MIN], TEL_NUM_RANGE[MAX]);
            if (answerOk) {
                this.accomodationType = getRoomType(getIntInput("Enter room type: ", ROOM_RANGE[MIN], ROOM_RANGE[MAX]));
                if (answerOk) {
                    this.pplToAccomodate = getIntInput("Enter how many people: ", PPL_RANGE[MIN], PPL_RANGE[MAX]);
                    if (answerOk) {
                        this.speaksRu = getSpeaksLang(getIntInput("Enter 0 or 1 (no/yes)", MIN, MAX));
                    }
                }
            }
        }
    }


   @Override
   public String toString() {
        return (this.id+" "+this.telNumber +" "+this.accomodationType +" "+ this.speaksRu+"\n");
   }

    static int getIntInput(String inputText, int min, int max) {
        attempts = 0;
        int getValue = 0;
        Family.answerOk = false;
        while (attempts < 3 && !answerOk) {
            System.out.println(inputText);
            Scanner input = new Scanner(System.in);
            answerOk = input.hasNextInt();
            if (answerOk) {
                getValue = input.nextInt();
                if (getValue < min || getValue > max) {
                    answerOk = false;
                }
            }
            if (!answerOk) {
                System.out.println("Value has to be between " + min + " and " + max);
                System.out.println(MAX_ATTEMPTS - 1 - attempts + " attempts remaining...");
                attempts++;
            }
            input.nextLine();
        }
        return getValue;
    }

    String getSpeaksLang(int m) {
        return (m == 1) ? "Yes" : "No";
    }
    String getRoomType(int m) {
        String room;
        switch (m) {
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
        int anotherFamily;
        ArrayList < Family > familiesList = new ArrayList < Family > ();
       
        while (keepAsking) {
            Family temp = new Family();
            if(Family.answerOk) {
            	familiesList.add(temp);
            } else {
            	System.out.println("Error in data entry, family won't be added.");
            }
            
            Scanner tempInput = new Scanner(System.in);
            anotherFamily = Family.getIntInput("Register another family?",Family.MIN,Family.MAX);

            if (anotherFamily == 0) keepAsking = false;


            
        }
        System.out.println("Total families registered: " + familiesList.size());

        System.out.println(familiesList); 



    }
}

