import java.util.ArrayList;
import java.util.LinkedList;


public class FSA {

    private LinkedList<TransState> dfa;
    private LinkedList<TransState> nfa;

    //we weill set getters and setters for dfa and nfa


    //constructor for DFA
    public FSA(){
        this.setDfa(new LinkedList<TransState>());
        this.getDfa().clear();
    }

    public LinkedList<TransState> getDfa() {
        return dfa;
    }

    public void setDfa(LinkedList<TransState> nfa) {
        this.dfa = nfa;
    }

    //constructor for NFA

    public FSA(LinkedList Transtate){
        this.setNfa(new LinkedList<TransState> ());
        this.getNfa().clear();
    }

    public LinkedList<TransState> getNfa() {
        return nfa;
    }

    public void setNfa(LinkedList<TransState> nfa) {
        this.nfa = nfa;
    }

}
