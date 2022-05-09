public class RecorregutTotalmentOcupat{

  public static void main(String[] args){

    float[] arrayNotes = { 2f, 5.5f, 9f, 10f, 4.9f, 8f, 8.5f, 7f };
    
    int failed=0;
    
    for(int i=0;i<arrayNotes.length;i++){
        if(arrayNotes[i]<5) {
            failed++;
        }
    }
    
    System.out.println("Hi ha "+failed+" suspesos");
    
  }
}