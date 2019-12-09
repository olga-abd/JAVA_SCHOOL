import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class Task5 {
    public static void main (String[] args){
        Map<String, Integer> map = new HashMap<>();

        map.put("asd", 4);
        map.put("ddd", 5);
        map.put("iuoi", 9);
        map.put("kkk", 5);

        System.out.println(map.toString());


        System.out.println();
        System.out.println("Переворачиваем:");

        Map<Integer, Collection<String>> map2 = rev(map);

        System.out.println(map2.toString());

    }

    public static <V, K> Map<V, Collection<K>> rev(Map<K, V> map){
        Map<V, Collection<K>> rev = new HashMap<>();


        for (K k : map.keySet()){
            if(rev.containsKey(map.get(k))){
                Collection<K> col = rev.get(map.get(k));
                col.add(k);
                rev.put(map.get(k), col);
            } else {
                Collection<K> col = new ArrayList<>();
                col.add(k);
                rev.put(map.get(k), col);
            }
        }

        return rev;
    }

}
