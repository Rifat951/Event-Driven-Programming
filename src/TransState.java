import java.security.PublicKey;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.ArrayList;


public class TransState {

    //we will separate the states of DFA and NFA

        //transition states for DFA
    private Set<TransState> statesdfa;
    int IdOfStates;
    public TransState(Set<TransState> statesdfa, int ID){
        this.setStates(statesdfa);
        this.setIdOfStates(IdOfStates);
    }
    public Set <TransState> getStates() {
        return statesdfa;
    }
    public void setStates(Set <TransState> statesdfa) {
        this.statesdfa = statesdfa;
    }

    public void setIdOfStates(int IdOfStates){
        this.IdOfStates = IdOfStates;
    }

}
