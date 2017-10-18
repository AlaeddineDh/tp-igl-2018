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
public class ApplyFormulaTestParameterized {

    private StringHelper stringHelper = new StringHelper();
    private String expected;
    private String argument;
    private FormulaApplier applier;


    @Parameterized.Parameters
    public static Collection params() {
        return Arrays.asList(
                new Object[]{"mdwsKdssdq", new FormulaApplier() {
                    @Override
                    public char applyFormula(char c) {
                        //remplace un char par son suivant
                        return Character.isAlphabetic(c + 1) ? (char) (c + 1) : (char) (c - 25);
                    }
                }, "nextLetter"},
                new Object[]{"nextLetter", new FormulaApplier() {
                    @Override
                    public char applyFormula(char c) {
                        //remplace un char par son predecessuer
                        return Character.isAlphabetic(c - 1) ? (char) (c - 1) : (char) (c + 25);
                    }
                }, "mdwsKdssdq"},
                new Object[]{"testletterspara", new FormulaApplier() {
                    @Override
                    public char applyFormula(char c) {
                        //remplace un char par 'a'
                        return 'a';
                    }
                }, "aaaaaaaaaaaaaaa"}
        );
    }

    public ApplyFormulaTestParameterized(String argument, FormulaApplier applier, String expected) {
        this.expected = expected;
        this.argument = argument;
        this.applier = applier;
    }

    @Test
    public void testApplyFormula() {
        assertEquals(expected, stringHelper.applyFormula(argument, applier));
    }


}
