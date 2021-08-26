
import java.util.LinkedList;


public class DFA {

    private LinkedList<TransState> dfa;

    //we weill set getters and setters for dfa and nfa


    //constructor for DFA
    public DFA(){
        this.setDfa(new LinkedList<TransState>());
        this.getDfa().clear();
    }

    public LinkedList<TransState> getDfa() {
        return dfa;
    }

    public void setDfa(LinkedList<TransState> nfa) {
        this.dfa = nfa;
    }

}
