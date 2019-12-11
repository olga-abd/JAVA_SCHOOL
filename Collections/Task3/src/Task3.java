import java.util.*;

public class Task3 {
    public static void main (String[] args){
        ArrayList<Integer> arrayList = new ArrayList<>();

        // заполняем случайными числами от 0 до 3
        for (int i = 0; i < 10; i++){
            arrayList.add(generateInt3());
        }

        System.out.print("Исходный массив: ");
        for (int i : arrayList){
            System.out.print(i + " ");
        }
        System.out.println();

        System.out.print("Без дубликатов: ");
        for (int i : removeDuplicates(arrayList)){
            System.out.print(i + " ");
        }
    }


    public static <T>Collection<T> removeDuplicates(Collection<T> collection){
        //Set <T> set =
        return new HashSet<>(collection);
    }

    public static Integer generateInt3() {
        return (int) (Math.random() * 3);
    }

}
