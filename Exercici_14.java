public class E14_FernandezC {

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
			System.out.println("Dorsal: "+dades[i][0]);
		}

		//find first male in array
		int i=0;
		do {
			if(dades[i][1]==0) {
				firstM=i;
				maleFound = true;	
			} else i++;
		} while(!maleFound);
		System.out.println("posicio primer home "+firstM);

		//find first woman in array
		int j=0;
		do {
			if(dades[j][1]==0) {
				firstM=j;
				womanFound = true;	
			} else j++;
		} while(!womanFound);
		System.out.println("posicio primera dona "+firstW);

		//get winners row position
		int maxMale = dades[firstM][3];
		int maxWoman = dades[firstW][3];
		for(int x=0;x<dades.length;x++) {
			if(dades[x][3]<maxMale && dades[x][1]==0) {
				maxMale= dades[x][3];
				winnerM=x;
			}
			if(dades[x][3]<maxWoman && dades[x][1]==1) {
				maxWoman= dades[x][3];
				winnerW=x;
			}
		}

		System.out.println("el guanyadora femenina es troba a la pos: "+winnerW);
		System.out.println("el guanyador masculi es troba al a pos: "+winnerM);

	}
}
