import com.sun.tools.javac.Main;
import org.junit.Test;

import java.io.*;
import java.util.Scanner;

import static org.junit.Assert.*;

public class RegexEngine_Test {

    @Test
    public void fileOpener() {

        assertTrue(RegexEngine.fileOpener());
    }
    @Test
    public void fileOpenerNotNull() {
        assertNotNull("File not epmty",RegexEngine.fileOpener());
    }

//    @Test
//    public void SetPath(){
//        String data = "D:/test";
//        InputStream stdin = System.in;
//        try {
//            System.setIn(new ByteArrayInputStream(data.getBytes()));
//            Scanner scanner = new Scanner(System.in);
//            System.out.println(scanner.nextLine());
//        } finally {
//            System.setIn(stdin);
//        }
//    }
//
//    @Test
//    public void intputTest() throws FileNotFoundException {
//        String data = "(ab)*c";
//        InputStream stdin = System.in;
//        try {
//            System.setIn(new ByteArrayInputStream(data.getBytes()));
//            Scanner scanner = new Scanner(System.in);
//            System.out.println(scanner.nextLine());
//        } finally {
//            System.setIn(stdin);
//        }
//    }

}