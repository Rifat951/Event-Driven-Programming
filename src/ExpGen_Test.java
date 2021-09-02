import org.junit.Test;

import static org.junit.Assert.*;

public class ExpGen_Test {

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
    public void isCharUpper() {
        assertEquals("test for char ",ExpGen.isChar('A'),ExpGen.isChar('Z'));
    }

    @Test
    public void isCharUpperorLower() {
        assertEquals("test for isCharUpperorLower ",ExpGen.isChar('A'),ExpGen.isChar('e'));
    }

    @Test
    public void isCharLower() {
        assertEquals("test for isCharLower ",ExpGen.isChar('d'),ExpGen.isChar('o'));
    }

    @Test
    public void isCharLoweroeUpper() {
        assertEquals("test for isCharLoweroeUpper ",ExpGen.isChar('x'),ExpGen.isChar('H'));
    }

    @Test
    public void isCharDigit() {
        assertEquals("test for isCharDigit ",ExpGen.isChar('1'),ExpGen.isChar('0'));
    }

    //this one i did for fail testing
    @Test
    public void isCharSpeicalChar() {
        assertEquals("test for isCharSpeicalChar ",ExpGen.isChar('&'),ExpGen.isChar('1'));
    }

    @Test
    public void concatInator() {
        assertEquals(ExpGen.ConcatInator("abc"),ExpGen.ConcatInator("abc"));
    }


    @Test
    public void dfaConverter() {
       // assertEquals("dfa test", ExpGen.DfaConverter(ExpGen.NfaConveter("a")),ExpGen.DfaConverter(ExpGen.NfaConveter("a")));
        assertEquals("dfa test..",ExpGen.DfaConverter(ExpGen.NfaConveter("d*")),ExpGen.DfaConverter(ExpGen.NfaConveter("dd")));
    }


}