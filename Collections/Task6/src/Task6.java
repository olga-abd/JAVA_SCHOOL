import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Task6 {
    public static void main(String[] args){
        String[] list = {"Ivan 5", "Petr 3", "Alex 10", "Petr 8", "Ivan 6", "Alex 5", "Ivan 1", "Petr 5", "Alex 1"};

        Map<String, Integer> map = new HashMap<>();

        // добавляем все в мап
        for (String s : list) {
            String[] arr = s.split(" ");
            if (map.containsKey(arr[0])) {
                map.put(arr[0],map.get(arr[0]) + Integer.valueOf(arr[1]));
            } else {
                map.put(arr[0], Integer.valueOf(arr[1]));
            }
        }
        // определяем максимум
        int max = getMax(map);


        // делаем новый мап, при добавлении проверяяем, кто достиг максимума
        Map<String, Integer> map2 = new HashMap<>();
        for (String s : list) {
            String[] arr = s.split(" ");
            if (map2.containsKey(arr[0])) {
                map2.put(arr[0],map2.get(arr[0]) + Integer.valueOf(arr[1]));
            } else {
                map2.put(arr[0], Integer.valueOf(arr[1]));
            }
            if(map2.get(arr[0]) == max){
                System.out.println ("Победитель: " + arr[0]);
                break;
            }
        }

    }

    public static int getMax(Map<String, Integer> map){
        int max = Integer.MIN_VALUE;
        for (int i : map.values()) {
            if(i > max) max = i;
        }
        return max;

    }
}
