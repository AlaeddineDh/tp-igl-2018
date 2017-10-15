
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

    /**
     * @param str la chaine ou on doit enlever les mots vides
     * @return la chaine après transformation
     */
    public String Eliminate(String str){

        str=str.replaceAll(" ou "," ").replace("ou "," ").replace(" ou"," ");
        str=str.replaceAll(" et "," ").replace("et "," ").replace(" et"," ");
        str=str.replaceAll(" à "," ").replace("à "," ").replace(" à"," ");
        str=str.replaceAll(" non "," ").replace("non "," ").replace(" non"," ");

        return str;
    }
  
  /**
     * @param word le mot dont on doit calculer les occurrences
     * @param str la chaine qui contient le mot dont on veut calculer l'occurence
     * @return
     * @throws ExceptionTexteVide
     */
    public int Occurrence(String word,String str) throws ExceptionTexteVide{

        int occ=0;

        if (str.length()==0) throw new ExceptionTexteVide();
        else {
            Pattern p = Pattern.compile(word);
            Matcher m = p.matcher( str );
            while (m.find()) {
                occ++;
            }
        }

        return occ;
    }
  
  
  
}
