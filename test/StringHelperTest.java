import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

/**
 * Created by FATEN on 13/10/2017.
 */
public class StringHelperTest {

    private StringHelper stringHelper = new StringHelper();

    @Test
    public void testSplit() {
        String[] expected = new String[]{"str1", "str2", "str3"};
        String[] actuals = stringHelper.split("str1,str2,str3", ',');
        assertArrayEquals(expected, actuals);
    }

    @Test
    public void testCapitalize() {
        String expected = "    Et je vais à la poste .Non no non non on .     I'm gonna";
        String actual = stringHelper.capitalize("    et je vais à la poste .non no non non on .     i'm gonna");
        assertEquals(expected, actual);
    }

    @Test
    public void testApplyFormula() {
        String expected = "bcdeaCBA";
        String actuals = stringHelper.applyFormula("abcdzBAZ", new FormulaApplier() {
            @Override
            public char applyFormula(char c) {
                return Character.isAlphabetic( c + 1) ? (char) (c + 1) : (char) (c - 25);
            }
        });
        assertEquals(expected, actuals);
    }
}

