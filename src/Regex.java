
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

        String str_tree = str[0];
        System.out.println(str_tree);

        // implement graph to regular expression
        // use enum class in order to record the transition states

    }

}
