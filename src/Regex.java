
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;


public class Regex {

    public static void main(String[] args) {

        // need to input three line of strings
        Scanner input = new Scanner(System.in);
        System.out.println("Number of lines we want to display (int) : ");
        // splite line
        String[] str = new String [input.nextInt()];
        // input string
        input.nextLine();

        // transform this into array where we will put the first element through diagram, table, rest of the array elements will be used for displaying output only
        for (int index = 0; index < str.length; index++)
        {
            str[index] = input.nextLine();
        }

        String str_tree = str[0];
        System.out.println(str_tree);


        // regular expression to graph
        // otherwise we cannot calculate the edges or e-nfa





//        System.out.println(Arrays.toString(str));

//        System.out.println("\nResults: ");
//        //for-each loop to print the string
//        for(String strIndex: str)
//        {
//            System.out.println(str[strIndex]);
//        }

    }

}
