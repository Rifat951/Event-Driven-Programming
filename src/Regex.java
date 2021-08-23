import java.util.Scanner;

public class Regex {

    public static void main(String[] args){
        //Input the string from user's end
        Scanner input_str = new Scanner(System.in);
        System.out.println("Enter String which needs to contain '(', ')', '*', '|', '+'");

        String user_str = input_str.nextLine();

        System.out.println(user_str);

    }

}
