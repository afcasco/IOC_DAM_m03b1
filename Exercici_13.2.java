public class RecorregutTotalmentOcupat{

  public static void main(String[] args){

    float[] arrayNotes = { 2f, 5.5f, 9f, 10f, 4.9f, 8f, 8.5f, 7f };
    
    float notaMesAlta= 0f;
    float notaMesBaixa= 0f;
    float notaMitjana = 0f;
    
    //ordenem array per facilitar trobar les notes mes alta i mes baixa
    for(int i=0;i<arrayNotes.length-1;i++){
        for(int j=0;j<arrayNotes.length-i-1;j++) {
            if( arrayNotes[j]>arrayNotes[j+1]){
                float temp=arrayNotes[j];
                arrayNotes[j]=arrayNotes[j+1];
                arrayNotes[j+1]=temp;
            }
        }
    }
    
    //recorrem l'array i sumem totes les notes
    for(int i=0;i<arrayNotes.length;i++){
        notaMitjana+=arrayNotes[i];
    }
    

    //dividim pel total de notes per obtenir la mitjana    
    notaMitjana = notaMitjana/arrayNotes.length;
    //despres d'ordenar la primera i ultima posicio seran les notes mes baixa i alta
    notaMesBaixa = arrayNotes[0];
    notaMesAlta = arrayNotes[arrayNotes.length-1];
    
    System.out.println("la nota mitjana es: "+notaMitjana);
    System.out.println("la nota mes baixa es: "+notaMesBaixa);
    System.out.println("la nota mes alta es: "+notaMesAlta);
    
  }
}
