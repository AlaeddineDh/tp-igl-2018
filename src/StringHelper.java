import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by FATEN on 13/10/2017.
 */
public class StringHelper {
  
  
    /**
     * @param V le tableau qui contient les chaines de caractes
     * @param length la taille de tableau
     * @return une chaine qi contient les elements du tabeau entre eux un séparateur
     * Exemple d'utilisation: [str1,str2,str3]====>"str1;str2;str3"
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
     * Exemple d'utilisation: "je vais à la poste ou à la mairie" ==> "je vais la poste la mairie"
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
     *Exemple d'utilisaion: "je mange une pomme pomme" avec word=pomme ==> occurence=2
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
  

    /**
     * fractioner une chaine de caracteres en utilisant un caractere de separation
     *
     * @param str chaine a fractioner
     * @param sep caractere de separation
     * @return un tableau de sous-chaines separees
     */
    public String[] split(String str, char sep) {
        String subStr = "";
        ArrayList<String> subStrings = new ArrayList<>();
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (c != sep) {
                subStr += Character.toString(c);
            } else {
                subStrings.add(subStr);
                subStr = "";
            }
        }
        subStrings.add(subStr);
        return subStrings.toArray(new String[0]);
    }

    /**
     * Mettre en majiscule la premiere lettre de chaque phrase de str
     *
     * @param str chaine a transformer
     * @return la chaine str avec premiere lettre de chaque phranse en majiscule
     */
    public String capitalize(String str) {
        final String seperators = ".:(";
        if (str == null || str.length() <= 0) return null;
        StringBuilder sb = new StringBuilder(str);
        int p = positionOfFirstLetter(str, 0);
        sb.setCharAt(p, Character.toUpperCase(str.charAt(p)));
        for (int i = p + 1; i < str.length(); i++) {
            if (seperators.contains(Character.toString(str.charAt(i)))) {
                i = positionOfFirstLetter(str, i);
                sb.setCharAt(i, Character.toUpperCase(str.charAt(i)));
            } else {
                sb.setCharAt(i, Character.toLowerCase(str.charAt(i)));
            }
        }
        return sb.toString();
    }

    /**
     * Retourne la position du premier caractere alphabetique dans str qui vient apres la position pos
     *
     * @param str chaine de caracteres
     * @param pos position apres laquele on cherche le premier caractere
     * @return position du prmeier caractere alphabetique
     */
    private int positionOfFirstLetter(String str, int pos) {
        Pattern p = Pattern.compile("\\p{L}");
        Matcher m = p.matcher(str.substring(pos));
        if (m.find()) {
            return m.start() + pos;
        } else {
            return -1;
        }
    }

    /**
     * applique une formula precise par applier sur touts les caracteres de str
     * @param str chaine sur laquelle on applique la formule
     * @param applier classe qui implemente l'interface FormulaApplier
     * @return chaine apres application de la formule
     */
    public String applyFormula(String str, FormulaApplier applier){
        StringBuilder builder = new StringBuilder(str);
        for (int i =0; i< str.length();i++){
            builder.setCharAt(i,applier.applyFormula(str.charAt(i)));
        }
        return builder.toString();
    }
}
