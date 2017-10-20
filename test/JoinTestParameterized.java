import java.util.Arrays;
import java.util.Collection;
import org.junit.Test;
import org.junit.Before;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
import org.junit.runner.RunWith;
import static org.junit.Assert.assertEquals;

/**
 * Created by faten on 21/10/2017.
 */

@RunWith(Parameterized.class)
public class JoinTestParameterized {

    private String Vect[];
    private String expected;
    private StringHelper stringHelper = new StringHelper();

    @Parameterized.Parameters
    public static Collection params() {

        /* les tableaux des données */
        String T1[]={"faten","mlm","etudiante"};
        String T2[]={"salem","bonjour;","hello"};

        return Arrays.asList(new Object[][] {

                {T1,"faten;mlm;etudiante"},
                {T2,"salem;bonjour;;hello"}

        });
    }

    public JoinTestParameterized(String Vect[], String expected) {
        this.Vect=Vect;
        this.expected=expected;
    }


    @Test
    public void testJoin(){
        assertEquals(expected, stringHelper.Join(Vect,Vect.length));
    }

}
