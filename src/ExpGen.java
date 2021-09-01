import javax.swing.plaf.nimbus.State;
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

        if(ExpGen.speicialChars.size() > 0){
            char tempchar = speicialChars.pop();
            //usage of a switchcase
            switch (tempchar){
                case('|'):
                    merge();
                    break;
                case ('+'):
                    repeatation();
                    break;
                case ('.'):
                    concat();
                    break;
                case ('*'):
                    repeatation();
                    break;
                default:
                    System.out.println("Unknown Symbols... error");
                    System.exit(1);
                    break;
            }
        }
    }

    // */|/+ needs to be prioritized

    private static boolean OperandPrior(char firstchar, Character secondChar){
       if(firstchar == secondChar){
           return true;
       }
       else if (firstchar == '*'){
           return  false;
       }
       else if(secondChar == '*'){
           return true;
       }
       else if (firstchar == '+'){
           return  false;
       }
       else if(secondChar == '+'){
           return true;
       }
       else if(firstchar == '.'){
           return false;
       }
       else if(secondChar == '.'){
           return true;
       }
       else if(firstchar == '|'){
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
    
    
    private static Set<Character> input_val = new HashSet<Character>();

   // private static Set<Character> input_val = new HashSet<Character>();

    public static NFA NfaConveter(String RegExpression){

        // RegExpression need to have a function which can concat between symbols eg. ()() like this
        RegExpression = ConcatInator (RegExpression);

        //(ab)*|c+
        input_val.add('a');
        input_val.add('b');
        input_val.add('c');
        input_val.add('d');
        input_val.add('e');
        input_val.add('f');
        input_val.add('g');
        input_val.add('h');
        input_val.add('i');
        input_val.add('j');
        input_val.add('k');
        input_val.add('l');
        input_val.add('m');
        input_val.add('n');
        input_val.add('o');
        input_val.add('p');
        input_val.add('q');
        input_val.add('r');
        input_val.add('s');
        input_val.add('t');
        input_val.add('u');
        input_val.add('v');
        input_val.add('w');
        input_val.add('x');
        input_val.add('y');
        input_val.add('z');

        // remove all the elements from stacks
        StackedValofNfa.clear();
        speicialChars.clear();


        // we need a method to insert into the stacks of our NFA

        for (int i = 0 ; i < RegExpression.length(); i++) {

            if (isChar (RegExpression.charAt(i))) {
                inserttoStack(RegExpression.charAt(i));

            } else if (speicialChars.isEmpty()) {
                speicialChars.push(RegExpression.charAt(i));

            } else if (RegExpression.charAt(i) == '(') {
                speicialChars.push(RegExpression.charAt(i));

            } else if (RegExpression.charAt(i) == ')') {
                while (speicialChars.get(speicialChars.size()-1) != '(') {
                    SpeicalCharOperation();
                }

                // '(' left parenthesis pops out
                speicialChars.pop();

            } else {
                while (!speicialChars.isEmpty() &&
                        OperandPrior (RegExpression.charAt(i), speicialChars.get(speicialChars.size() - 1)) ){
                    SpeicalCharOperation ();
                }
                speicialChars.push(RegExpression.charAt(i));
            }
        }


        while (!speicialChars.isEmpty()) {	SpeicalCharOperation(); }
        NFA completeNfa = StackedValofNfa.pop();
        completeNfa.getNfa().get(completeNfa.getNfa().size() - 1).setAccpetState(true);

        return completeNfa;

    }



    public static boolean isChar(char inputchar){
        if(inputchar == 'a' || inputchar == 'b' || inputchar == 'c' ||  inputchar == 'd' || inputchar == 'e'||
                inputchar == 'f' || inputchar == 'g' || inputchar == 'h' ||  inputchar == 'i' || inputchar == 'j'||
                inputchar == 'k' || inputchar == 'l' || inputchar == 'm' ||  inputchar == 'n' || inputchar == 'o'||
                inputchar == 'p' || inputchar == 'q' || inputchar == 'r' ||  inputchar == 's' || inputchar == 't' ||
                inputchar == 'u' || inputchar == 'v' || inputchar == 'w' ||  inputchar == 'x' || inputchar == 'y' || inputchar == 'z' ){
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
                        (firsttempval == '*' && secondtempval == '(') || (firsttempval == ')' && isChar(secondtempval)) ||
                        (firsttempval == '+' && isChar(secondtempval)) || (firsttempval == '+' && secondtempval == '(') ||
                        (firsttempval == ')' && isChar(secondtempval))) {

                    str += firsttempval + ".";

                }
                else {
                    str += firsttempval;
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
        startstate.Transition(firstCharofNfa.getNfa().getFirst(),'!');
        startstate.Transition(secondCharofNfa.getNfa().getFirst(),'!' );
        //endstate
        firstCharofNfa.getNfa().getLast().Transition(endstate,'!');
        secondCharofNfa.getNfa().getLast().Transition(endstate,'!');


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

        NFA tempnfa = StackedValofNfa.pop();

        // Create states for star operation
        TransState start = new TransState (IdStates++);
        TransState end	= new TransState (IdStates++);

        // Add transition to start and end state
        start.Transition(end, '!');
        start.Transition(tempnfa.getNfa().getFirst(), '!');

        tempnfa.getNfa().getLast().Transition(end, '!');
        tempnfa.getNfa().getLast().Transition(tempnfa.getNfa().getFirst(), '!');

        tempnfa.getNfa().addFirst(start);
        tempnfa.getNfa().addLast(end);

        // Put nfa back in the stackNfa
        StackedValofNfa.push(tempnfa);

    }

    private static void concat(){

        NFA nfastate2 = StackedValofNfa.pop();
        NFA nfastate1 = StackedValofNfa.pop();

        nfastate1.getNfa().getLast().Transition(nfastate2.getNfa().getFirst(),'!');

        for(TransState s : nfastate2.getNfa()){
            nfastate1.getNfa().addLast(s);
        }
        StackedValofNfa.push(nfastate1);
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

            ArrayList<TransState> eclosure = trns_new.displayTransitionStates('!');

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

    public  static DFA DfaConverter(NFA ParsedNfa) {

        DFA dfa = new DFA ();

        // Clearing all the states ID for the DFA
        IdStates = 0;

        // Create an arrayList of unprocessed States
        LinkedList <TransState> unprocessed = new LinkedList<TransState> ();

        // Create sets
        FirstSet = new HashSet <TransState> ();
        SecondSet = new HashSet <TransState> ();

        // Add first state to the set1
        FirstSet.add(ParsedNfa.getNfa().getFirst());

        // Run the first remove Epsilon the get states that
        // run with epsilon
        EliminateETrans ();

        // Create the start state of DFA and add to the stack
        TransState dfaStart = new TransState (SecondSet, IdStates++);

        dfa.getDfa().addLast(dfaStart);
        unprocessed.addLast(dfaStart);

        // While there is elements in the stack
        while (!unprocessed.isEmpty()) {
            // Process and remove last state in stack
            TransState state = unprocessed.removeLast();

            // Check if input symbol
            for (Character symbol : input_val) {
                FirstSet = new HashSet<TransState> ();
                SecondSet = new HashSet<TransState> ();

                changeStates (symbol, state.getStates(), FirstSet);
                EliminateETrans ();

                boolean isavailable = false;
                TransState st = null;

                for (int i = 0 ; i < dfa.getDfa().size(); i++) {
                    st = dfa.getDfa().get(i);

                    if (st.getStates().containsAll(SecondSet)) {
                        isavailable = true;
                        break;
                    }
                }

                // Not in the DFA set, add it
                if (!isavailable) {
                    TransState p = new TransState (SecondSet, IdStates++);
                    unprocessed.addLast(p);
                    dfa.getDfa().addLast(p);
                    state.Transition(p, symbol);

                    // Already in the DFA set
                } else {
                    state.Transition(st, symbol);
                }
            }
        }
        // Return the complete DFA
        return dfa;
    }
}
