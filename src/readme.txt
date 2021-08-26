

Instead of implementing a whole class in one go


task -1
insert the scanned details to file --- ok

// read from file path and store it to arrylist

Scanner s = new Scanner(new File("filepath"));
ArrayList<String> list = new ArrayList<String>();
while (s.hasNext()){
    list.add(s.next());
}
s.close();



task -2 ----- ok
read those data from the file

task -3 ---- ok
create the fsa ( which will include dfa/nfa)  and states

task -4
create the regular expressions

task -5
validation was also in regex.. so we need a find a way to user it... otherwise true/false will not come
