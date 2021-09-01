import java.util.LinkedList;

public class NFA {


    //constructor for NFA
    private LinkedList<TransState> nfa;

    public NFA() {
        this.setNfa(new LinkedList<TransState>());
        this.getNfa().clear();
    }

    public LinkedList<TransState> getNfa() {
        return nfa;
    }

    public void setNfa(LinkedList<TransState> nfa) {
        this.nfa = nfa;
    }
}
