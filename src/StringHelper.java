import java.util.ArrayList;

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
}