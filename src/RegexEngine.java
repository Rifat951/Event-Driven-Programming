import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class RegexEngine {

    private static Scanner scan;
    private static String regularinput;

    // Reads all the expressions in this arrayList
    private static ArrayList<String> rgexpressions = new ArrayList<String>();

    // stores de NFA
    private static NFA nfa;

    // stores the DFA
    private static DFA dfa;


    // Getters and Setters
    public static NFA getNfa() {
        return nfa;
    }

    public static void setNfa(NFA nfa) {
        RegexEngine.nfa = nfa;
    }

    public static DFA getDfa() {
        return dfa;
    }

    public static void setDfa(DFA dfa) {
        RegexEngine.dfa = dfa;
    }

    static String setpathforInput() {
        Scanner read = new Scanner(System.in);

        System.out.println("Enter the Path You want to Set \n\t");
        String path;
        //  System.out.println(path);
        return read.nextLine();

    }

    static void writeintoffile(String path) throws Exception {
        Scanner read = new Scanner(System.in);
        FileOutputStream fos = new FileOutputStream(path);
        System.out.println("Enter character  ('!') to stop writing : ");
        int char_data;
        String data;
        byte b[];
        boolean flag = true;
        byte eof = (char) ('!');
        while (true) {
            data = read.nextLine();
            b = data.getBytes();
            for (int i = 0; i < b.length; i++) {
                if (b[i] == eof) {
                    flag = false;
                    break;
                }
                fos.write(b[i]);
            }
            if (flag == false)
                break;
            fos.write((byte) ('\n'));
        }
        fos.close();
    }

    public static void main(String[] args) throws Exception {
        // Create a Scanner object
        // only problem we have right now... the file needs to be created in by user first.... then the program will work
        try {
            File createfile = new File("D:/testpath/test1.txt");
            if (createfile.createNewFile()) {
                System.out.println("File created: " + createfile.getName());
            } else {
                System.out.println("File already exists.");
            }
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }


        String writefile = setpathforInput();
        writeintoffile(writefile);
        System.out.println("File Created Successfully");

        //D:\testpath\test.txt

        File myObj = new File(setpathforInput());

        scan = new Scanner(myObj);

        regularinput = scan.next();
        System.out.println(regularinput);

        while (scan.hasNext()) {
            rgexpressions.add(scan.next());
        }
       // System.out.println(rgexpressions);

        setNfa (ExpGen.NfaConveter(regularinput));
        System.out.println("Ready");
        //getNfa();

        setDfa (ExpGen.DfaConverter (getNfa()));

        for (String str : rgexpressions) {
            if (RegExValidation.evaluate(getDfa(), str)) {
                System.out.println ("True");
            }
            else
            {
                System.out.println ("False");
            }
        }
    }
}
