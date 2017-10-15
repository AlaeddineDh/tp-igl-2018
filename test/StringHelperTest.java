import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import static org.junit.Assert.*;

/**
 * Created by FATEN on 13/10/2017.
 */
public class StringHelperTest {
        
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

}

