import java.util.Scanner;
import  java.util.Stack;

public class Regex {

    public static void main(String[] args){
        //Input the string from user's end
        Scanner input_str = new Scanner(System.in);
        System.out.println("Enter String which needs to contain '(', ')', '*', '|', '+'");
        String user_str = input_str.nextLine();


        //contain all the methods in a stack the pop the least essential ones
        Stack<Character> stack_str = new Stack<>();

        for(int i =0 ; i < user_str.length(); i ++){
            for(int j = i ; j <= i; j ++){
               stack_str.push(user_str.charAt(j));
//                System.out.println(user_str.charAt(j));
            }
        }

        System.out.println(stack_str);


    }

}
