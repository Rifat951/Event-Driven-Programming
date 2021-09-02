import java.util.LinkedList;

public class NFA {


    //constructor for NFA
    private LinkedList<TransState> nfa;

    public NFA() {
        this.setNfa(new LinkedList<TransState>());
        //System.out.println("test1"+nfa);
        this.getNfa().clear();
    }


    public LinkedList<TransState> getNfa() {
        //System.out.println("teste2"+nfa);
        return nfa;

    }

    public void setNfa(LinkedList<TransState> nfa) {
        this.nfa = nfa;
    }
}
