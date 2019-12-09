import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class Task2 {
    public static void main (String[] args){
        String s = "The journey began at Folly Bridge, Oxford and ended five miles away in the village of Godstow. During the trip Charles Dodgson told the girls a story that featured a bored little girl named Alice who goes looking for an adventure. The girls loved it, and Alice Liddell asked Dodgson to write it down for her. He began writing the manuscript of the story the next day, although that earliest version no longer exists. The girls and Dodgson took another boat trip a month later when he elaborated the plot to the story of Alice, and in November he began working on the manuscript in earnest.To add the finishing touches he researched natural history for the animals presented in the book, and then had the book examined by other children—particularly the children of George MacDonald. He added his own illustrations but approached John Tenniel to illustrate the book for publication, telling him that the story had been well liked by children.";

        Map<Character,Integer> dict = new TreeMap<>();

        for (char c : s.toLowerCase().toCharArray()){
            if (String.valueOf(c).matches("[a-z]")) {
                if (dict.containsKey(c)) {
                    dict.replace(c, dict.get(c) + 1);
                } else {
                    dict.put(c, 1);
                }
            }
        }

        for (char c : dict.keySet()){
            System.out.println(c + ": " + dict.get(c));
        }
    }
}
