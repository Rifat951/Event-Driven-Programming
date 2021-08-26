import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;
import java.util.Stack;

public class ExpGen {


    private static Stack<Character> speicialChars = new Stack<Character>();
    private static Stack<NFA> StackedValofNfa = new Stack<NFA>();
    private static  int IdStates = 0;

    private static void SpeicalCharOperation(){

        char tempchar;
        if(ExpGen.speicialChars.size() > 0){

            tempchar = speicialChars.pop();
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

    // */|/+ needs to be prioritized

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


    // method for inserting into the stack
    public static void inserttoStack(char RegExpressionChar){
        TransState firstState = new TransState(IdStates++);
        TransState secondState = new TransState(IdStates++);

        firstState.Transition(secondState, RegExpressionChar);

        // for adding temp state of NFA we will take a temp object
        NFA tempNfa = new NFA();
        tempNfa.getNfa().addLast(firstState);
        tempNfa.getNfa().addLast(secondState);

        // it will insert all the data
        StackedValofNfa.push(tempNfa);

    }


    // RegExpression string value will be parsed here

    public static NFA NfaConveter(String RegExpression){

            // RegExpression need to have a function which can concat between symbols eg. ()() like this
            RegExpression = ConcatInator(RegExpression);

            //(ab)*|c+
            speicialChars.add('a');
            speicialChars.add('b');
            speicialChars.add('c');


            // remove all the elements from stacks
            StackedValofNfa.clear();
            speicialChars.clear();


            // we need a method to insert into the stacks of our NFA

            for (int startingIndex = 0 ; startingIndex < RegExpression.length(); startingIndex++){
                char tempchar = RegExpression.charAt(startingIndex);
                if(isChar(tempchar)){
                    inserttoStack(tempchar);
                }
                else if(speicialChars.isEmpty() || tempchar == '('){
                    speicialChars.push(tempchar);
                }
                else if(tempchar == ')'){
                    while (speicialChars.get(speicialChars.size()-1) != '('){
                        SpeicalCharOperation();
                    }
                }

            }

            while (!StackedValofNfa.isEmpty()){
                SpeicalCharOperation();
            }

            NFA FullNfa = StackedValofNfa.pop();
            FullNfa.getNfa().get(FullNfa.getNfa().size()-1).setAccpetState(true);

            return FullNfa;

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
        startstate.Transition(firstCharofNfa.getNfa().getFirst(),'e');
        startstate.Transition(secondCharofNfa.getNfa().getFirst(),'e' );
        //endstate
        firstCharofNfa.getNfa().getLast().Transition(endstate,'e');
        secondCharofNfa.getNfa().getLast().Transition(endstate,'e');


        //insert all the start states to end states and  the states from second to first and in order
        firstCharofNfa.getNfa().addLast(startstate);
        secondCharofNfa.getNfa().addLast(endstate);

        for( TransState states : secondCharofNfa.getNfa()){
            firstCharofNfa.getNfa().addLast(states);
        }

        // put them back
        StackedValofNfa.push(firstCharofNfa);


    }

    public  static void repeatation(){

    }


}
