public class RecorregutTotalmentOcupat{

  public static void main(String[] args){

    float[] arrayNotes = { 2f, 5.5f, 9f, 10f, 4.9f, 8f, 8.5f, 7f };
      
    //Recorrem array y mostrem notes mes grans o = que 9 i la posicio a la que es troben  
    for (int i = 0; i < arrayNotes.length; i++) {
      if(arrayNotes[i]>=9f) {
        System.out.println("Hi ha un "+arrayNotes[i]+" a la posicio "+i)
      }
    }
    
  }
}