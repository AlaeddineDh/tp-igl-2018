import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by FATEN on 13/10/2017.
 */
public class StringHelper {

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
}