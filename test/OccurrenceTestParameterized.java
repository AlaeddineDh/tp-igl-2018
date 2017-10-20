import java.util.Arrays;
import java.util.Collection;
import org.junit.Test;
import org.junit.Before;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
import org.junit.runner.RunWith;
import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class OccurrenceTestParameterized {

    private StringHelper stringHelper = new StringHelper();
    private String mot;
    private String chaine;
    private int expected;


    @Parameterized.Parameters
    public static Collection params() {

        return Arrays.asList(new Object[][] {
                {"mot","ceci est un mot mot dans la phrase mot",3},
                {"tp","tp done le tp à l'aide d'une autre personne tp",3}

        });
    }

    public OccurrenceTestParameterized(String mot, String chaine,int expected) {
        this.mot=mot;
        this.chaine=chaine;
        this.expected=expected;
    }


    @Test
    public void testOccurrence() throws ExceptionTexteVide {
        assertEquals(expected, stringHelper.Occurrence(mot,chaine));
    }

}