import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.*;

/**
 * Created by alaeddine on 10/18/17.
 */
@RunWith(Parameterized.class)
public class CapitalizeTestParameterized {

    private StringHelper stringHelper = new StringHelper();
    private String expected;
    private String argument;

    @Parameterized.Parameters
    public static Collection params() {
        return Arrays.asList(
                new String[]{"My name is alaeddine: I am a student. I live in algeria (It is a country)",
                        "my name is alaeddine: i am a student. i live in algeria (it is a country)"},
                new String[]{"Second test. Second", "second test. second"},
                new String[]{"Bonjour, je m'appele flan. Quel type de flan? Le type", "BONJOUR, JE M'APPELE FLAN. QUEL TYPE DE FLAN? LE TYPE"},
                new String[]{"Hello, its me: Adel . Rien rien (N'importe quoew)", "hello, its me: adel . rien rien (n'impORTE QuOEW)"},
                new String[]{"5Eme test. 55564564 45684 Name", "5eme test. 55564564 45684 name"},
                new String[]{"((((((Name)Is)Alaeddine)Corps)Dead)Walk)", "((((((name)is)ALAEDDINE)CORPS)dead)WALK)"}
                );
    }

    public CapitalizeTestParameterized(String expected, String argument) {
        this.expected = expected;
        this.argument = argument;
    }

    @Test
    public void testCapitalize() {
        assertEquals(expected, stringHelper.capitalize(argument));
    }
}
