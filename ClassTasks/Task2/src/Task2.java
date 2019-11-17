public class Task2 {
    public static void main (String[] args) {
        int[] c = {3,5,1,2,4};

        Arr arr = new Arr(c);
        arr.print();
        System.out.println("Длина массива: " + arr.getLength());

        arr.addElement(10);
        System.out.print("Добавили цифру 10 в конец массива: ");
        arr.print();

        arr.addElement(33,3);
        System.out.print("Добавили цифру 33 на место индекса 3: ");
        arr.print();

        arr.delElement(4);
        System.out.print("Удалили элемент по индексу 4: ");
        arr.print();

        arr.changeElement(2,8);
        System.out.print("Изменили элемент по индексу 2 на значение 8: ");
        arr.print();

        System.out.print("Отсортировали массив: ");
        arr.sort(2).print();
        System.out.print("Изначальный массив остался неизменным: ");
        arr.print();

        System.out.println("Минимальный элемент: " + arr.minElement());
        System.out.println("Максимальный элемент: " + arr.maxElement());

        System.out.println("Массив 6 элементов, заполненный четверками");
        Arr arr2 = new Arr(6,4);
        System.out.println("Длина массива: " + arr2.getLength());
        arr2.print();

    }
}
