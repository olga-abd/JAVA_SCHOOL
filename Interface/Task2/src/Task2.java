public class Task2 {
    public static void main (String[] agrs){

        System.out.println("LinkedList:");
        LinkedList linkedList = new LinkedList();

        linkedList.insert(5);
        linkedList.insert(10);
        linkedList.insert(4);

        System.out.println("Первый элемент: " + linkedList.head.value);

        linkedList.print();

        linkedList.getSize();

        System.out.println("Добавляем элемент 24 на позицию 2:");
        linkedList.insert(24,2);
        linkedList.print();


        System.out.println("Добавляем элемент 33 на позицию 0:");
        linkedList.insert(33,0);
        linkedList.print();

        System.out.println("Добавляем элемент 44 на позицию 1:");
        linkedList.insert(44,1);
        linkedList.print();

        System.out.println("Добавляем элемент 55 на позицию 55 (в конец списка):");
        linkedList.insert(55,55);
        linkedList.print();

        linkedList.getSize();

        System.out.println("Удалим элемент на позиции 0:");
        linkedList.deleteAt(0);
        linkedList.print();
        System.out.println("Удалим элемент на позиции 5:");
        linkedList.deleteAt(5);
        linkedList.print();
        System.out.println("Удалим элемент на позиции 3:");
        linkedList.deleteAt(3);
        linkedList.print();
        linkedList.getSize();

        System.out.println("Изменим значение на позиции 2 на 78:");
        linkedList.changeValueAt(78,2);
        linkedList.print();

        System.out.println("Минимальное значение в списке: " + linkedList.getMin());
        System.out.println("Минимальное значение между 0 и 2 элементами: " + linkedList.getMin(0,2));
        System.out.println("Максимальное значение меджу 1 и 3 элементами: " + linkedList.getMax(1,3));
        System.out.println("Максимальное значение меджу 0 и 1 элементами: " + linkedList.getMax(0,1));

        linkedList.sort();
        linkedList.sort(true);
        System.out.print("Изначальный список:");
        linkedList.print();

        System.out.println("Создаем список из 7 элементов со значением 5");
        LinkedList linkedList1 = new LinkedList(5,7);
        linkedList1.print();
        System.out.println();


        System.out.println("ArrayList:");
        int[] c = {5, 10};
        Arr arr = new Arr(c);
        arr.insert(4);
        arr.print();
        arr.getSize();

        System.out.println("Добавляем элемент 24 на позицию 2:");
        arr.insert(24, 2);
        arr.print();

        System.out.println("Добавляем элемент 33 на позицию 0:");
        arr.insert(33, 0);
        arr.print();

        System.out.println("Добавляем элемент 44 на позицию 1:");
        arr.insert(44,1);
        arr.print();

        System.out.println("Добавляем элемент 55 на позицию 55 (в конец списка):");
        arr.insert(55,55);
        arr.print();

        arr.getSize();


        System.out.println("Удалим элемент на позиции 0:");
        arr.deleteAt(0);
        arr.print();
        System.out.println("Удалим элемент на позиции 5:");
        arr.deleteAt(5);
        arr.print();
        System.out.println("Удалим элемент на позиции 3:");
        arr.deleteAt(3);
        arr.print();
        arr.getSize();


        System.out.println("Изменим значение на позиции 2 на 78:");
        arr.changeValueAt(78,2);
        arr.print();

        System.out.println("Минимальное значение в списке: " + arr.getMin());
        System.out.println("Минимальное значение между 0 и 2 элементами: " + arr.getMin(0,2));
        System.out.println("Максимальное значение меджу 1 и 3 элементами: " + arr.getMax(1,3));
        System.out.println("Максимальное значение меджу 0 и 1 элементами: " + arr.getMax(0,1));

        arr.sort();
        arr.sort(true);
        System.out.print("Изначальный список:");
        arr.print();

        System.out.println("Создаем список из 7 элементов со значением 5");
        Arr arr1 = new Arr(7,5);
        arr1.print();
        System.out.println();

    }


}
