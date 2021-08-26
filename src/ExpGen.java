import java.util.Stack;

public class ExpGen {


    private static Stack<Character> speicalChars = new Stack<Character>();
    private static Stack<NFA> StackedValofNfa = new Stack<NFA>();
    private static  int IdStates = 0;

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
    
    

    private static boolean OperandPrior(char firstchar, Character secondChar){
        if( firstchar == secondChar || secondChar == '*' ||secondChar == '+' || secondChar == '|'){
            return true;
        }
        else if(firstchar == '*' || firstchar == '+' || firstchar == '|'){
            return false;
        }
        else {
            return true;
        }
    }    
    
    
    
    // RegExpression string value will be parsed here

    public static NFA NfaConveter(String RegExpression){

            // RegExpression need to have a function which can concat between symbols eg. ()() like this
            RegExpression = ConcatInator(RegExpression);

    }



    public static boolean isChar(char inputchar){
        if(inputchar == 'a' || inputchar == 'b' || inputchar == 'c' || inputchar == 'e' ) {
            return true;
        }
        else {
            return false;
        }
    }

    public static String ConcatInator(String RegExpression){

        String str = new String("");

        for(int indexofString = 0 ; indexofString < RegExpression.length()-1 ; indexofString++){
            //need a boolean beacause we might need to input some chars at the same time
            char firsttempval = RegExpression.charAt(indexofString);
            char secondtempval = RegExpression.charAt(indexofString+1);
                if( (isChar(firsttempval) && isChar(secondtempval)) || (isChar(firsttempval) && secondtempval == '(') ||
                        (firsttempval == ')' && isChar(secondtempval)) || (firsttempval == '*' && isChar(secondtempval)) ||
                        (firsttempval == '*' && secondtempval == '(') || (firsttempval == ')' && secondtempval == '(')){

                    str = str + firsttempval + ".";

                }
                else {
                    str = str + firsttempval;
                }
        }

        str =  str + RegExpression.charAt(RegExpression.length() -1 );
        return str;
    }



    public static void merge(){
        NFA firstCharofNfa = StackedValofNfa.pop();
        NFA secondCharofNfa = StackedValofNfa.pop();


        TransState startstate = new TransState (IdStates++);
        TransState endstate = new TransState (IdStates++);

        // Set transition table begin and end of each SubNfa
        startstate.Transition(endstate, 'e');
        // well we nee to get NFA, otherwise cannot progress.

    }

    public  static void repeatation(){

    }


}
