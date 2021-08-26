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
    
    
    // since we are focusing on the input of a,b,c
    public static boolean isChar(char inputchar){
        if(inputchar == 'a' || inputchar == 'b' || inputchar == 'c') {
            return true;
        }
        else {
            return false;
        }
    }
    
    
     // RegExpression string value will be parsed here
    public static NFA NfaConveter(String RegExpression){

            // RegExpression need to have a function which can concat between symbols eg. ()() like this

    }
    
    
    public static String ConcatInator(String RegExpression){
        String str = new String("");

        for(int indexofString = 0 ; indexofString < RegExpression.length()-1 ; indexofString++){
            //need a boolean method because we might need to input some chars at the same time
                if(booleans of chars)
        }
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
    }

    public  static void repeatation(){

    }


}
