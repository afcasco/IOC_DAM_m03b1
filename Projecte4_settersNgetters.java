package FamiliesAcollida;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.stream.Collectors;

class Family {

    public static final int MIN = 0;
    public static final int MAX = 1;
    private static final int MAX_ATTEMPTS = 3;
    private static final int[] ID_RANGE = {10, 999};
    private static final int[] TEL_NUM_RANGE = {111_111_111, 999_999_999};
    private static final int[] ROOM_RANGE = {0, 3};
    private static final int[] PPL_RANGE = {1, 99};
    static boolean answerOk;
    static int attempts;
    private int id;
    private int telNumber;
    private String accomodationType;
    private int pplToAccomodate;
    private String speaksRu;

    Family() {
        setId(getIntInput("Enter ID number", ID_RANGE[MIN], ID_RANGE[MAX]));
        if (isAnswerOk()) {
            setTelNumber(telNumber = getIntInput("Enter telephone number", TEL_NUM_RANGE[MIN], TEL_NUM_RANGE[MAX]));
            if (isAnswerOk()) {
                setAccomodationType(accomodationType = getRoomType(getIntInput("Enter room type\n0: Shared\n1: Single\n2: Home\n3: Dorm\n", ROOM_RANGE[MIN], ROOM_RANGE[MAX])));
                if (isAnswerOk()) {
                    setPplToAccomodate(pplToAccomodate = getIntInput("Enter how many people", PPL_RANGE[MIN], PPL_RANGE[MAX]));
                    if (isAnswerOk()) {
                        setSpeaksRu(speaksRu = getSpeaksLang(getIntInput("Speaks ru or ukr", MIN, MAX)));
                    }
                }
            }
        }
    }

    public static boolean isAnswerOk() {
        return answerOk;
    }

    public static void setAnswerOk(boolean answerOk) {
        Family.answerOk = answerOk;
    }

    public static int getAttempts() {
        return attempts;
    }

    public static void setAttempts(int attempts) {
        Family.attempts = attempts;
    }

    public static int getIntInput(String inputText, int min, int max) {
        attempts = 0;
        int getValue = 0;
        setAnswerOk(false);
        while (attempts < MAX_ATTEMPTS && !isAnswerOk()) {
            System.out.printf("%s (%d-%d):%n",inputText,min,max);
            Scanner input = new Scanner(System.in);
            setAnswerOk(input.hasNextInt());
            if (isAnswerOk()) {
                getValue = input.nextInt();
                if (getValue < min || getValue > max) {
                    setAnswerOk(false);
                }
            }
            if (!isAnswerOk()) {
                System.out.println("Value has to be between " + min + " and " + max);
                System.out.println(MAX_ATTEMPTS - 1 - attempts + " attempts remaining...");
                setAttempts(getAttempts() + 1);
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
        return switch (m) {
            case 0 -> "shared";
            case 1 -> "single";
            case 2 -> "full";
            default -> "comunal";
        };
    }
}

class Acollida {
    public static void main(String[] args) {

        boolean keepAsking = true;
        int anotherFamily;
        ArrayList<Family> familiesList = new ArrayList<>();

        while (keepAsking) {
            Family temp = new Family();
            if (Family.answerOk) {
                familiesList.add(temp);
            } else {
                System.out.println("Error in data entry, family won't be added.");
            }
            anotherFamily = Family.getIntInput("Register another family?", Family.MIN, Family.MAX);
            if (anotherFamily == 0) keepAsking = false;
        }

        System.out.println("Total families registered: " + familiesList.size());
        if (familiesList.size() > 0) {
            System.out.println("\nId\t\tplaces\t\trus/ucraines\t\ttipus\t\t\t\t\t\t\t\t\ttelefon");
            System.out.println(familiesList.stream().map(Object::toString).collect(Collectors.joining("")));
        }

    }
}


