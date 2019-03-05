import java.io.*;
import java.util.*;

public class DFA {

    public boolean readFile(){
        String line;
        SortedSet<String> States = new TreeSet<>();
        SortedSet<String> Alphabet = new TreeSet<>();
        String StartState;
        SortedSet<String> FinalStates = new TreeSet<>();
        Map<String,Map<String,String>> transFunc=new HashMap<>();


        ArrayDeque<String> information = new ArrayDeque<String>();
       try{
           File file = new File("k.txt");
           BufferedReader br = new BufferedReader( new FileReader(file));
            while ((line = br.readLine())!=null){
                information.addLast(line);
            }
       } catch (IOException e) {
           e.printStackTrace();
           return false;
       }

       String [] tmpArray = information.pollFirst().split(" ");
       Collections.addAll(Alphabet,tmpArray);

       String [] tmpArr = information.pollFirst().split(" ");
       Collections.addAll(States,tmpArr);

       StartState = information.pollFirst();

       String [] tmp = information.pollFirst().split(" ");
       Collections.addAll(FinalStates,tmp);

       while ((information.pollFirst())!=null){
           String [] tmpAr = information.pollFirst().split(" ");
          transFunc.put(tmpAr[0],new HashMap<>());
          Map<String,String> pair = transFunc.get(tmpAr[0]);
          pair.put(tmpAr[1],tmpAr[2]);
        }
       return true;
    }

    public static void main(String[] args) throws Exception {

        }
    }

