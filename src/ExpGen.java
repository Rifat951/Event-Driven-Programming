import java.net.IDN;
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

        // states for merge method
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

        NFA tempNfa = StackedValofNfa.pop();
        TransState StartStateRep = new TransState(IdStates++);
        TransState EndStateRep = new TransState(IdStates++);

        // same as merge method
        StartStateRep.Transition(EndStateRep, 'e');
        StartStateRep.Transition(tempNfa.getNfa().getFirst(),'e');

        tempNfa.getNfa().getLast().Transition(EndStateRep,'e');
        tempNfa.getNfa().getLast().Transition(tempNfa.getNfa().getFirst(),'e');

        tempNfa.getNfa().addFirst(StartStateRep);
        tempNfa.getNfa().addLast(EndStateRep);

        StackedValofNfa.push(tempNfa);

    }

    // implementing DFA

    //first we need to convert nfa to dfa means removing the e-closures and need to find a way for changed states


    private static Set<TransState> FirstSet = new HashSet<TransState>();
    private static Set<TransState> SecondSet = new HashSet<TransState>();

    private static void EliminateETrans(){
        Stack<TransState> eliminateval = new Stack<TransState>();
        SecondSet = FirstSet;
        for(TransState trns : FirstSet){
            eliminateval.push(trns);
        }
        while(!eliminateval.isEmpty()){
            TransState trns_new = eliminateval.pop();
            ArrayList<TransState> eclosure = trns_new.displayTransitionStates('e');

            for( TransState trns_second : eclosure){
                if(!SecondSet.contains(trns_second)){
                    SecondSet.add(trns_second);
                    eliminateval.push(trns_second);
                }
            }
        }
    }

    private static void changeStates(Character inputchar, Set<TransState> transStates, Set<TransState> stateSet){
        ArrayList<TransState> temparr =  new ArrayList<TransState>();

        for(TransState trns_first : transStates){
            temparr.add(trns_first);
        }
        for (TransState trns_outerloop : temparr){
            ArrayList<TransState> dispStates = trns_outerloop.displayTransitionStates(inputchar);
            for(TransState trns_innerloop : dispStates){
                stateSet.add(trns_innerloop);
            }
        }
    }



    //pulll the nfa data to dfa ...

    public  static DFA DfaConverter(NFA ParsedNfa){

        DFA tempDfa = new DFA();
        IdStates = 0;
        LinkedList<TransState> interStates = new LinkedList<TransState>();

        //these sets will be used for storing the intermediate states of DFA
        Set<TransState> dfafirstset = new HashSet<TransState>();
        Set<TransState> dfesecondset = new HashSet<TransState>();

        // val of nfa will be redirected over here in the dfafirstset
        dfafirstset.add(ParsedNfa.getNfa().getFirst());




        return DFA;
    }



}
