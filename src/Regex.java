
import java.util.Arrays;
import java.util.Scanner;

public class Regex {

    public static void main(String[] args) {

        // need to input three line of strings
        Scanner input = new Scanner(System.in);
        System.out.println("Number of lines we want to display (int) : ");
        // splite line
        String[] str = new String [input.nextInt()];
        // input string
        input.nextLine();
        for (int index = 0; index < str.length; index++)
        {
            str[index] = input.nextLine();
        }
//        System.out.println(Arrays.toString(str));

        System.out.println("\nResults: ");
        //for-each loop to print the string
        for(String strIndex: str)
        {
            System.out.println(strIndex);
        }


        // 1. transform the expression to tree(usage of dfs maybe) ?
        // 2. tree to transition table(multi array) ?
        // 3 display the transition table
        //
    }

}
