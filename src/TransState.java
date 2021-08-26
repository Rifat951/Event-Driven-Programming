import java.security.PublicKey;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.ArrayList;


public class TransState {

    //we will separate the states of DFA and NFA

        //transition states for DFA
    private Set<TransState> statesdfa;
    private Map<Character,ArrayList<TransState>> nextState;
    int IdOfStates;
    boolean accpetState;

    public TransState(Set<TransState> statesdfa, int ID){
        this.setStates(statesdfa);
        this.setIdOfStates(IdOfStates);
        this.setNextState(new HashMap<Character, ArrayList<TransState>>());

        for(TransState indexofStates : statesdfa){
            if(indexofStates.isAccpetState()){
                this.setAccpetState(true);
                break;
            }
        }

    }
    
    
        // transition between states

    public void Transition( TransState traversal, char key ){

        ArrayList<TransState> valueofTranStates = this.nextState.get(key);

        if(valueofTranStates == null){
            valueofTranStates = new ArrayList<TransState>();
            this.nextState.put(key , valueofTranStates);
        }
        valueofTranStates.add(traversal);
        System.out.println(valueofTranStates);

    }
    

    public Set <TransState> getStates() {
        return statesdfa;
    }
    public void setStates(Set <TransState> statesdfa) {
        this.statesdfa = statesdfa;
    }

    public int getIdOfStates(){
        return IdOfStates;
    }

    public void setIdOfStates(int IdOfStates){
        this.IdOfStates = IdOfStates;
    }
    public void setNextState(HashMap<Character, ArrayList<TransState>> newmap){
        this.nextState = newmap;
    }

    public Map<Character, ArrayList<TransState>> getNextState(){
        return nextState;
    }

    private boolean isAccpetState() {
        return accpetState;
    }


    public void setAccpetState(boolean accpetState){
        this.accpetState = accpetState;
    }

}
