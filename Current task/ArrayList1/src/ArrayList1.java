public class ArrayList1 {
    public static void main (String[] agrs){

        System.out.println("LinkedList:");
        MyLinkedList linkedList = new MyLinkedList();

        linkedList.insert(5);
        linkedList.insert(10);
        linkedList.insert(4);

        System.out.println("Первый элемент: " + linkedList.head.value);

        linkedList.print();

        linkedList.getSize();

        System.out.println("Добавляем элемент 24 на позицию 2:");
        try {
            linkedList.insert(24, 2);
        } catch (ListException e) {
            System.out.println(e.getMessage());
        }
        linkedList.print();


        System.out.println("Добавляем элемент 33 на позицию 0:");
        try {
            linkedList.insert(33, 0);
        } catch (ListException e) {
            System.out.println(e.getMessage());
        }
        linkedList.print();

        System.out.println("Добавляем элемент 44 на позицию 1:");
        try {
            linkedList.insert(44, 1);
        } catch (ListException e) {
            System.out.println(e.getMessage());
        }
        linkedList.print();

        System.out.println("Добавляем элемент 55 на позицию 55:");
        try {
            linkedList.insert(55, 55);
        } catch (ListException e) {
            System.out.println(e.getMessage());
        }
        linkedList.print();

        linkedList.getSize();

        System.out.println("Удалим элемент на позиции 0:");
        try {
            linkedList.deleteAt(0);
        } catch (ListException e){
            System.out.println(e.getMessage());
        }
        linkedList.print();
        System.out.println("Удалим элемент на позиции 5:");
        try {
            linkedList.deleteAt(5);
        } catch (ListException e){
            System.out.println(e.getMessage());
        }
        linkedList.print();
        System.out.println("Удалим элемент на позиции 3:");
        try {
            linkedList.deleteAt(3);
        } catch (ListException e) {
            System.out.println(e.getMessage());
        }
        linkedList.print();
        linkedList.getSize();

        System.out.println("Изменим значение на позиции 2 на 78:");
        try {
            linkedList.changeValueAt(78, 2);
        } catch (ListException e) {
            System.out.println(e.getMessage());
        }
        linkedList.print();

        try {
            System.out.println("Минимальное значение в списке: " + linkedList.getMin());
        }
        catch (ListException e) {
            System.out.println(e.getMessage());
        }
        try {
            System.out.println("Минимальное значение между 0 и 2 элементами: " + linkedList.getMin(0, 2));
        } catch (ListException e) {
            System.out.println(e.getMessage());
        }
        try {
            System.out.println("Максимальное значение меджу 1 и 3 элементами: " + linkedList.getMax(1, 3));
        } catch (ListException e) {
            System.out.println(e.getMessage());
        }
        try {
            System.out.println("Максимальное значение меджу 0 и 1 элементами: " + linkedList.getMax(0, 1));
        } catch (ListException e) {
            System.out.println(e.getMessage());
        }

        linkedList.sort();
        linkedList.sort(true);
        System.out.print("Изначальный список:");
        linkedList.print();

        System.out.println("Создаем список из 7 элементов со значением 5");
        MyLinkedList linkedList1 = new MyLinkedList(5,7);
        linkedList1.print();
        System.out.println();


        System.out.println("ArrayList:");
        Integer[] c = {5, 10};
        Arr<Integer> arr = new Arr<Integer>(c);
        arr.insert(4);
        arr.print();
        arr.getSize();

        System.out.println("Добавляем элемент 24 на позицию 2:");
        try {
            arr.insert(24, 2);
        } catch (ListException e) {
            System.out.println (e.getMessage());
        }
        arr.print();

        System.out.println("Добавляем элемент 33 на позицию 0:");
        try {
            arr.insert(33, 0);
        } catch (ListException e) {
            System.out.println (e.getMessage());
        }
        arr.print();

        System.out.println("Добавляем элемент 44 на позицию 1:");
        try {
            arr.insert(44, 1);
        } catch (ListException e) {
            System.out.println(e.getMessage());
        }
        arr.print();

        System.out.println("Добавляем элемент 55 на позицию 55:");
        try {
            arr.insert(55, 55);
        } catch (ListException e) {
            System.out.println(e.getMessage());
        }
        arr.print();

        arr.getSize();


        System.out.println("Удалим элемент на позиции 0:");
        try {
            arr.deleteAt(0);
        } catch (ListException e) {
            System.out.println(e.getMessage());
        }
        arr.print();
        System.out.println("Удалим элемент на позиции 5:");
        try {
            arr.deleteAt(5);
        } catch (ListException e) {
            System.out.println(e.getMessage());
        }
        arr.print();
        System.out.println("Удалим элемент на позиции 3:");
        try {
            arr.deleteAt(3);
        } catch (ListException e) {
            System.out.println(e.getMessage());
        }
        arr.print();
        arr.getSize();


        System.out.println("Изменим значение на позиции 2 на 78:");
        try {
            arr.changeValueAt(78, 2);
        } catch (ListException e) {
            System.out.println(e.getMessage());
        }
        arr.print();

        try {
            System.out.println("Минимальное значение в списке: " + arr.getMin());
            System.out.println("Минимальное значение между 0 и 2 элементами: " + arr.getMin(0, 2));
            System.out.println("Максимальное значение меджу 1 и 3 элементами: " + arr.getMax(1, 3));
            System.out.println("Максимальное значение меджу 0 и 1 элементами: " + arr.getMax(0, 1));
        } catch (ListException e) {
            System.out.println(e.getMessage());
        }

        arr.sort();
        arr.sort(true);
        System.out.print("Изначальный список:");
        arr.print();

        System.out.println("Создаем список из 7 элементов со значением 5");
        Arr arr1 = new Arr(7,5);
        arr1.print();
        System.out.println();

        System.out.println("Стринговый array");

        Arr<String> stringArr = new Arr<>(new String[]{"asdf", "eret", "ddd"});
        stringArr.print();
        stringArr.getSize();
        try {
            stringArr.changeValueAt("eee", 1);
        } catch (ListException e) {
            System.out.println(e.getMessage());
        }
        stringArr.print();
        try {
            stringArr.insert("oo", 2);
        } catch (ListException e) {
            System.out.println(e.getMessage());
        }
        stringArr.print();
    }


}
