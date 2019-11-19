public class Task3 {
    public static void main (String[] agrs){
        LinkedList linkedList = new LinkedList();

        linkedList.insert(5);
        linkedList.insert(10);
        linkedList.insert(4);

        System.out.println("Первый элемент: " + linkedList.head.value);

        linkedList.printList();

        System.out.println("Размер списка: " + linkedList.size);

    }
}
