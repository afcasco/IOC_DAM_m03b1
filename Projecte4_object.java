import java.util.stream.Collectors;  
import java.util.*;
import static java.lang.System.out;

class Family {

    private static final int MIN = 0;
    private static final int MAX = 1;
    private static final int MAX_ATTEMPTS = 3;
    private static final int[] ID_RANGE = {10, 999};
    private static final int[] TEL_NUM_RANGE = {111_111_111, 999_999_999};
    private static final int[] ROOM_RANGE = {0, 3};
    private static final int[] PPL_RANGE = {1, 99};
    private static boolean answerOk;
    private static int failedAttempts;
    private int id;
    private int telNumber;
    private String accomodationType;
    private int pplToAccomodate;
    private String speaksRu;

    public Family() {
        setId(getIntInput("Enter ID number", ID_RANGE[MIN], ID_RANGE[MAX]));
        if (isAnswerOk()) setTelNumber(getIntInput("Enter telephone number", TEL_NUM_RANGE[MIN], TEL_NUM_RANGE[MAX]));
        if (isAnswerOk()) setAccomodationType(getRoomType(getIntInput("Enter room type\n0: Shared\n1: Single\n2: Home\n3: Dorm\n", ROOM_RANGE[MIN], ROOM_RANGE[MAX])));
        if (isAnswerOk()) setPplToAccomodate(getIntInput("Enter how many people", PPL_RANGE[MIN], PPL_RANGE[MAX]));
        if (isAnswerOk()) setSpeaksRu(getSpeaksLang(getIntInput("Speaks ru or ukr", MIN, MAX)));
    }



    public static boolean isAnswerOk() {
        return answerOk;
    }

    public static void setAnswerOk(boolean answerOk) {
        Family.answerOk = answerOk;
    }

    public static int getAttempFamilyts() {
        return failedAttempts;
    }

    public static void setAttempFamilyts(int failedAttempts) {
        Family.failedAttempts = failedAttempts;
    }

    public static int getIntInput(String inputText, int min, int max) {
        setAttempFamilyts(0);
        int getValue = 0;
        setAnswerOk(false);
        while (failedAttempts < MAX_ATTEMPTS && !isAnswerOk()) {
            out.printf("%s (%d-%d):%n", inputText, min, max);
            Scanner input = new Scanner(System.in);
            setAnswerOk(input.hasNextInt());
            if (isAnswerOk()) {
                getValue = input.nextInt();
                if (getValue < min || getValue > max) {
                    setAnswerOk(false);
                }
            }
            if (!isAnswerOk()) {
                out.println("Value has to be between " + min + " and " + max);
                out.println(MAX_ATTEMPTS - 1 - failedAttempts + " failedAttempts remaining...");
                setAttempFamilyts(getAttempFamilyts() + 1);
            }
            input.nextLine();
        }
        return getValue;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getTelNumber() {
        return telNumber;
    }

    public void setTelNumber(int telNumber) {
        this.telNumber = telNumber;
    }

    public String getAccomodationType() {
        return accomodationType;
    }

    public void setAccomodationType(String accomodationType) {
        this.accomodationType = accomodationType;
    }

    public int getPplToAccomodate() {
        return pplToAccomodate;
    }

    public void setPplToAccomodate(int pplToAccomodate) {
        this.pplToAccomodate = pplToAccomodate;
    }

    public String getSpeaksRu() {
        return speaksRu;
    }

    public void setSpeaksRu(String speaksRu) {
        this.speaksRu = speaksRu;
    }

    @Override
    public String toString() {
        return (getId() + " " + getTelNumber() + " " + getPplToAccomodate() + " " + getAccomodationType() + " " + getSpeaksRu() + "\n");
    }

    private String getSpeaksLang(int m) {
        return (m == 1) ? "Yes" : "No";
    }



   
   private String getRoomType(int m) {
        String temp;
        switch (m) {
            case 0:
                temp = "shared";
                break;
            case 1:
                temp = "single";
                break;
            case 2:
                temp = "home";
                break;
            default:
                temp = "dorm";
        };
        return temp;
    }
}

class SortByID implements Comparator<Family>{
     // sorting in ascending order of id
     public int compare(Family a, Family b){
         return a.getId() - b.getId();
     }
}



class Acollida {
    public static void main(String[] args) {

        int no = 0, yes = 1;
        boolean keepAsking = true;
        int anotherFamily;
        ArrayList<Family> familiesList = new ArrayList<>();

        while (keepAsking) {
            Family tempFamily = new Family();
            if (Family.isAnswerOk()) {
                familiesList.add(tempFamily);
            } else {
                out.println("Error in data entry, family won't be added.");
            }
            anotherFamily = Family.getIntInput("Register another family?", no, yes);
            if (anotherFamily == 0) keepAsking = false;
        }

        out.println("Total families registered: " + familiesList.size());
        if (familiesList.size() > 0) {
            out.println("\nId\tplaces\trus/ucraines\ttipus\ttelefon");
            out.println(familiesList.stream().map(Object::toString).collect(Collectors.joining("")));

            out.println("----------------------------------------");

            Collections.sort(familiesList, new SortByID());
            out.println("\nId\tplaces\trus/ucraines\ttipus\ttelefon");
            out.println(familiesList.stream().map(Object::toString).collect(Collectors.joining("")));



           
            
        }

    }
}

