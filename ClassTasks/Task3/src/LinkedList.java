public class LinkedList {
    protected int size; // размер
    Element head; // первый элемент, чтобы было от чего отталкиваться

    // вставка нового элемента
    public void insert (int val) {
        Element new_element = new Element(val);

        if (head == null){ // если это первый элемент
            head = new_element;
        }
        else { // ищем последний элемент
            Element last = head;
            while (last.nextMember != null) {
                last = last.nextMember;
            }
            // добавляем друг другу ссылки
            last.nextMember = new_element;
            new_element.prevMember = last;
        }

        size++; // увеличиваем размер
    }

    public void printList () {
        System.out.print("Связанный список: ");
        Element curElement = head;
        while (curElement.nextMember != null) {
            System.out.print(curElement.value + " ");
            curElement = curElement.nextMember;
        }
        System.out.println(curElement.value + " "); // последний элемент
    }

    public class Element {
        protected int value;
        protected Element prevMember;
        protected Element nextMember;

        public Element(int value) {
            this.value = value;
        }
    }

}
