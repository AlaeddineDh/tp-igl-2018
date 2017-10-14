import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

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

}

