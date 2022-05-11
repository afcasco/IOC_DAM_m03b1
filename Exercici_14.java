package Unitat1;

public class E14_FernandezC {

    public static final int MALE = 0;
    public static final int FEMALE = 1;

    public static void main(String[] args) {

        int winnerM = 0;
        int winnerF = 0;
        int firstM = 0;
        int firstF = 0;
        boolean maleFound = false;
        boolean femaleFound = false;

        int[][] dades =     {{3457,1,51,52},
                            {3467,1,32,41},
                            {3568,0,14,57},
                            {3570,0,12,63},
                            {3571,1,45,63},
                            {3572,0,17,46},
                            {3573,0,12,44},
                            {3574,0,30,42},
                            {3575,1,24,77},
                            {3576,0,57,48}};

      	//show data
        for (int i = 0; i < dades.length; i++) {
            for (int j = 0; j < dades[i].length; j++) {
                System.out.print(dades[i][j] + " ");
            }
            System.out.println();
        }

        //get first male and female row
        int i = 0;
        do {
            if (dades[i][1] == MALE && !maleFound) {
                firstM = i;
                maleFound = true;
            }
            if (dades[i][1] == FEMALE && !femaleFound) {
                firstF = i;
                femaleFound = true;
            }
            i++;
        } while (!maleFound || !femaleFound);

        //get winners row position
        int maxMale = dades[firstM][3];
        int maxWoman = dades[firstF][3];
        for (int x = 0; x < dades.length; x++) {
            if (dades[x][3] <= maxMale && dades[x][1] == MALE) {
                maxMale = dades[x][3];
                winnerM = x;
            }
            if (dades[x][3] <= maxWoman && dades[x][1] == FEMALE) {
                maxWoman = dades[x][3];
                winnerF = x;
            }
        }
        //print winners
        System.out.println(" male WINNER in pos: " + winnerM);
        System.out.println(" female WINNER in pos: " + winnerF);
    }
}
