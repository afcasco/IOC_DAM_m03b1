public class E14_FernandezC {

	public static final int MALE = 0;
 	public static final int WOMAN = 1;

	public static void main(String[] args) {

		int winnerM=0;
		int winnerW=0;
		int firstM=0;
		int firstW=0;
		boolean maleFound= false;
		boolean womanFound= false;

		int[][] dades =  {{3457,1,51,52},	   
					  	{3467,1,32,41},	   
						{3568,0,14,57},	   
						{3570,0,12,63},	   
						{3571,1,45,63},	   
						{3572,0,17,46},	   
						{3573,0,12,44},	   
						{3574,0,30,42},	   
						{3575,1,24,77},	   
						{3576,0,57,48}};

		for(int i=0;i<dades.length;i++) {
			for (int j=0;j<dades[i].length;j++){
				System.out.print(dades[i][j]+ " ");
			}
			System.out.println();
		}

		//find first male in array
		int i=0;
		do {
			if(dades[i][1]==MALE) {
				firstM=i;
				maleFound = true;	
			} else i++;
		} while(!maleFound);

		//find first woman in array
		int j=0;
		do {
			if(dades[j][1]==WOMAN) {
				firstM=j;
				womanFound = true;	
			} else j++;
		} while(!womanFound);

		//get winners row position
		int maxMale = dades[firstM][3];
		int maxWoman = dades[firstW][3];
		for(int x=0;x<dades.length;x++) {
			if(dades[x][3]<maxMale && dades[x][1]==MALE) {
				maxMale= dades[x][3];
				winnerM=x;
			}
			if(dades[x][3]<maxWoman && dades[x][1]==WOMAN) {
				maxWoman= dades[x][3];
				winnerW=x;
			}
		}

		System.out.println("el guanyadora femenina es troba a la pos: "+winnerW);
		System.out.println("el guanyador masculi es troba al a pos: "+winnerM);

		System.out.println("camps "+dades[0].length);

	}
}
