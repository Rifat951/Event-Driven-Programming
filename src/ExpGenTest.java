import org.junit.Test;

import static org.junit.Assert.*;

public class ExpGenTest {

//    @Test
//    public void inserttoStack() {
//
//       assertEquals("test for char ",ExpGen.inserttoStack('a'),ExpGen.inserttoStack('b'));
//    }

    @Test
    public void nfaConveter() {
        assertEquals("test for nfa string input",ExpGen.NfaConveter("c*"),ExpGen.NfaConveter("c*"));
    }

    @Test
    public void isChar() {
        assertEquals("test for char ",ExpGen.isChar('a'),ExpGen.isChar('9'));
        assertEquals("test for char ",ExpGen.isChar('1'),ExpGen.isChar('n'));
    }

    @Test
    public void concatInator() {
        assertEquals(ExpGen.ConcatInator("abc"),ExpGen.ConcatInator("abc"));
    }


    @Test
    public void dfaConverter() {
       // assertEquals("dfa test", ExpGen.DfaConverter(ExpGen.NfaConveter("a")),ExpGen.DfaConverter(ExpGen.NfaConveter("a")));
        assertEquals("dfa tudu..",ExpGen.DfaConverter(ExpGen.NfaConveter("d*")),ExpGen.DfaConverter(ExpGen.NfaConveter("dd")));
    }


}