import org.junit.Test;

import static org.junit.Assert.*;

public class ExpGenTest {

//    @Test
//    public void inserttoStack() {
//
//      //  assertEquals("test for char ",ExpGen.inserttoStack('a'),ExpGen.inserttoStack('b'));
//    }

    @Test
    public void nfaConveter() {
        assertEquals("test for nfa string input",ExpGen.NfaConveter("a"),ExpGen.NfaConveter("a"));
    }

    @Test
    public void isChar() {
        assertEquals("test for char ",ExpGen.isChar('a'),ExpGen.isChar('9'));
    }

    @Test
    public void concatInator() {
        assertEquals(ExpGen.ConcatInator("abc"),ExpGen.ConcatInator("bca"));
    }

    @Test
    public void merge() {
    }

    @Test
    public void repeatation() {
    }

    @Test
    public void dfaConverter() {
    }
}