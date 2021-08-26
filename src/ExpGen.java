import java.util.Stack;

public class ExpGen {


    private static Stack<Character> speicalChars = new Stack<Character>();

    private  static void SpeicalCharOperation{

        char tempchar;
        if(ExpGen.speicalChars.size() > 0){

            tempchar = speicalChars.pop();
            //usage of a switchcase
            switch (tempchar){
                case('|'):
                    merge();
                    break;
                case ('*'):
                    repeatation();
                    break;
                default:
                    System.out.println("Unknown Symbols");
                    System.exit(1);
                    break;
            }
        }
    }

    public static void merge(){
    }

    public  static void repeatation(){

    }


}
