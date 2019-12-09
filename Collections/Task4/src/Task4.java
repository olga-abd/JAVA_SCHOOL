import java.util.ArrayList;
import java.util.Iterator;

public class Task4 {
    public static void main (String [] args){

        Integer[] arr = new Integer[5];
        for (int i = 0; i < arr.length; i++){
            arr[i] = i;
        }

        ArrayIterator<Integer> arrayIterator = new ArrayIterator(arr);

        while (arrayIterator.hasNext()){
            System.out.println(arrayIterator.next());
        }

    }
}
