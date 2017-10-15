
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

}

