import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import static org.junit.Assert.*;
import org.junit.Test;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

/**
 * Created by FATEN on 13/10/2017.
 */
public class StringHelperTest {
  
  
   private StringHelper stringHelper = new StringHelper(); 
   @Rule
    public final ExpectedException exception=ExpectedException.none();
        
   @Test
    public void test_join() throws Exception {

       StringHelper s=new StringHelper();
       String V[]=new String[]{"table","chair","door","window"};
       String expected="table;chair;door;window";

       assertEquals(expected,s.Join(V,4));

    }
        
    @Test
    public void test_eliminate() throws Exception {

        StringHelper s=new StringHelper();
        String str="et je vais à la poste non ";
        String expected=" je vais la poste ";

        assertEquals(expected,s.Eliminate(str));

    }
        
    @Test
    public void test_occurrence() throws Exception {
        StringHelper s=new StringHelper();
        String str="mot rien motIGL peu importemot mot phrase";

        assertEquals(4,s.Occurrence("mot",str));

    }


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

