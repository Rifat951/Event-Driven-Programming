public class RegExValidation {

    public static boolean evaluate(DFA dfa, String str){

        TransState evalState = dfa.getDfa().getFirst();
//        System.out.println(evalState.toString());
          System.out.println(str);

        // acceptation for empty string
        if(str.compareTo("!")==0){
            if(evalState.isAccpetState()){
                return  true;
            }
            else {
                return false;
            }
        }
        else if(dfa.getDfa().size()>0){
            for(int index = 0 ; index < str.length(); index++){
                if(evalState == null){
                    break;
                }
                // provide transition with input
                evalState = evalState.getNextState().get(str.charAt(index)).get(0);
               // System.out.println(evalState);
            }
            if(evalState != null && evalState.isAccpetState()){
                return  true;
            }
            else {
                return  false;
            }
        }
        else {
            return false;
        }
    }
}
