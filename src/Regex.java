import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Regex {

    public static void main(String[] args) throws Exception {


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

        Scanner s = new Scanner(myObj);


//        // Read the regular expression
        String regular = s.next();


        //          System.out.println(regular);
//
//        // Read all the expressions to apply the regular expression
        ArrayList<String> arr = new ArrayList<String>();
        while (s.hasNext()) {
            arr.add(s.next());
        }
        System.out.println(arr);
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

}
