import com.sun.istack.internal.Nullable;

import javax.lang.model.type.NullType;
import java.io.*;
import java.util.*;

public class FA {
    static private Map<Integer,Map<Character, TreeSet<Integer>>> Transition = new TreeMap<>();

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Write a sequence of letters :");
        String sequence = in.nextLine();
        System.out.printf("Word: %s \n", sequence);
        TreeSet<Character> test = Alphabet(sequence);
        show_Alphabet(test);
        show_Edges(sequence, test);

        String word = "cabbacc";
        TreeSet <Integer> S0 = new TreeSet<>();
        S0.add(0);
        for (int i=0;i<word.length();i++){
            TreeSet <Integer> S = new TreeSet<>();
            Character ch  = word.charAt(i);
            for (Integer elem :S0){
                TreeSet <Integer> tmp = Transition.get(elem).get(ch);
                if(tmp==null){
                    continue;
                }
                for (Integer tmpelem : tmp){
                    S.add(tmpelem);
                }
            }


            System.out.printf("Word: %s \n", word.charAt(i));
            System.out.print("States:");
            for (Integer elem:S){
                System.out.printf(" %d", elem);
            }
            System.out.print("\n");
            S0=S;
        }
        for (Integer elem:S0){
            System.out.printf(" %d", elem);
        }

    }

    static void show_Alphabet(TreeSet<Character> letters) {
        for (Character t : letters) {
            System.out.printf("%c ", t);
        }
        System.out.print("\n");
    }

    static TreeSet<Character> Alphabet(String str) {
        TreeSet<Character> Letters = new TreeSet<>();
        for (int i = 0; i < str.length(); i++) {
            Letters.add(str.charAt(i));
        }
        return Letters;
    }

    static void add_Edge(int from,int to,char ch){
        if (!Transition.containsKey(from)){
        Transition.put(from,new TreeMap<>());}
        Map<Character,TreeSet<Integer>> edge_of_state = Transition.get(from);
        if (!edge_of_state.containsKey(ch)){
        edge_of_state.put(ch,new TreeSet<Integer>());}
        edge_of_state.get(ch).add(to);
    }

    static void show_Edges(String str, TreeSet<Character> Alphabet) {
        for (Character t : Alphabet) {
            add_Edge(0,0,t);
            System.out.printf("(0 ,%c)-> 0 \n", t);
        }
        for (int j = 0; j < str.length(); j++) {
            add_Edge(j,j+1,str.charAt(j));
            System.out.printf("(%d,%c)-> %d \n", j, str.charAt(j), j + 1);
        }
        for (Character t : Alphabet) {
            add_Edge(str.length(),str.length(),t);
            System.out.printf("(%d ,%c)-> %d \n", str.length(), t, str.length());
        }
    }

    }
