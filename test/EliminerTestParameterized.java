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
public class EliminerMotsVidesTestParameterized {

    private StringHelper stringHelper = new StringHelper();
    private String expected;
    private String argument;

    @Parameterized.Parameters
    public static Collection params() {
        return Arrays.asList(
                new String[]{"je vais à la poste ou la maison","je vais la poste la maison"},
                new String[]{"salem et bonjour non coucou", "salem bonjour coucou"}
        );
    }

    public EliminerMotsVidesTestParameterized(String expected, String argument) {
        this.expected = expected;
        this.argument = argument;
    }

    @Test
    public void testEliminer() {
        assertEquals(expected, stringHelper.Eliminate(argument));
    }

}
