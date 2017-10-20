import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import java.util.Arrays;
import java.util.Collection;
import static org.junit.Assert.assertEquals;

/**
 * Created by faten on 20/10/2017.
 */

@RunWith(Parameterized.class)
public class EliminerMotsVidesTestParameterized {

    private StringHelper stringHelper = new StringHelper();
    private String expected;
    private String argument;

    @Parameterized.Parameters
    public static Collection params() {
        return Arrays.asList(
                new String[]{"je vais à la maison","je vais la maison"},
                new String[]{"le test deux ou un", "le test deux un"},
                new String[]{"ce n'est ou pas comme ça et ceci est faux", "ce n'est pas comme ça ceci est faux"}
        );
    }

    public EliminerMotsVidesTestParameterized(String expected, String argument) {
        this.expected = expected;
        this.argument = argument;
    }

    @Test
    public void testEliminate() {
        assertEquals(expected, stringHelper.Eliminate(argument));
    }


}
