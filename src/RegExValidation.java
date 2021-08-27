public class RegExValidation {

    public static boolean evaluate(DFA dfa, String str){

        TransState evalState = dfa.getDfa().getFirst();
        System.out.println(evalState);

        System.out.println(str);
        // acceptation for empty string
        if(str.compareTo("e")==0){
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
            }
        }
    }


}
