
/**
 * Created by FATEN on 13/10/2017.
 */
public class StringHelper {
  
    /**
     * @param V le tableau qui contient les chaines de caractes
     * @param length la taille de tableau
     * @return une chaine qi contient les elements du tabeau entre eux un séparateur
     */
    public String Join(String V[],int length){

        String result="";

        for (int i=0;i<length-1;i++){
            result=result+V[i]+";";
        }
        result=result+V[length-1];

        return result;

    }
  
  
  
}
