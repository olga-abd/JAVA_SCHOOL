
public class LinkedList implements Lists{
    private int size; // размер
    Element head; // первый элемент, чтобы было от чего отталкиваться

    public LinkedList(){

    }

    public LinkedList(int val, int size){
        for (int i = 0; i < size; i++ ) {
            insert(val);
        }
    }

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

    // вставка в позицию
    public void insert (int val, int position){
        if (size <= position) {
            insert(val);
            return;
        }

        Element new_element = new Element(val);


        if (head == null){
            head = new_element;
        }
        else {

            if (position == 0){
                head.prevMember = new_element;
                new_element.nextMember = head;
                head = new_element;
            }
            else {


                Element nxt = head;
                int i = 0;
                while (nxt.nextMember != null && i < position) {
                    nxt = nxt.nextMember;
                    i++;
                }
                Element prev = nxt.prevMember;

                // переопределяем ссылки
                prev.nextMember = new_element;
                nxt.prevMember = new_element;

                new_element.prevMember = prev;
                new_element.nextMember = nxt;
            }
        }
        size++;
    }

    public void print () {
        System.out.print("Связанный список: ");
        Element curElement = head;
        while (curElement.nextMember != null) {
            System.out.print(curElement.value + " ");
            curElement = curElement.nextMember;
        }
        System.out.println(curElement.value + " "); // последний элемент
    }

    public void getSize(){
        System.out.println("Размер списка: " + size);
    }

    public void deleteAt (int position){
        if (position == 0){
            head = head.nextMember;
            head.prevMember = null;

        }
        else if (position == size - 1){
            Element elt = head;
            while(elt.nextMember != null){
                elt = elt.nextMember;
            }
            Element last = elt.prevMember;
            last.nextMember = null;
            elt.prevMember = null;
            elt = null;
        }
        else {

            //int i = 0;
            Element elt = getElement(position);

            //while (elt.nextMember != null && i++ < position) {
            //    elt = elt.nextMember;
            //}
            Element prev = elt.prevMember;
            Element nxt = elt.nextMember;

            prev.nextMember = nxt;
            nxt.prevMember = prev;
            elt = null;

        }
        size--;
    }

    public Element getElement (int position){

        if (position == 0 ) return head;

        Element elt = head;

        int i = 0;
        while (elt.nextMember != null && i++ < position){
            elt = elt.nextMember;
        }
        return elt;
    }

    public void changeValueAt (int val, int position){
        if(position == 0){
            head.value = val;
        }
        else {
            Element elt = head;
            int i = 0;
            while (elt.nextMember != null && i++ < position){
                elt = elt.nextMember;
            }
            elt.value = val;
        }
    }

    public void sort() {
        sort(false);
    }

    public void sort(boolean desc){
        int[] arr = new int[size];
        int x = 0;
        // связанный список переносим в массив
        for (int i = 0; i < size; i++){
            arr[i] = getElement(i).value;
        }
        // сортируем
        for (int i = 0; i < size; i++){
            for (int j = i + 1; j < size; j++){
                if (arr[i] > arr[j] && desc == false ||
                        arr[i] < arr[j] && desc == true) {
                    x = arr[i];
                    arr[i] = arr[j];
                    arr[j] = x;
                }
            }
        }

        System.out.println("Сортировка по " + (desc ? "убыванию" : "возрастанию") + ":");
        for (int i = 0; i < size; i++){
            System.out.print(arr[i] + " ");
        }
        System.out.println();

    }

    public int getMin (int start, int end){
        Element s = getElement(start); // start
        int min = s.value;
        Element e = getElement(end); // end
        int i = 0;

        while (s.nextMember != null && s.nextMember != e.nextMember) {
            if (s.value < min ) min = s.value;
            //System.out.println(s.value + "; min = " + min);
            s = s.nextMember;
        }
        if (e.value < min) min = e.value;

        return min;
    }

    public int getMax (int start, int end){
        Element s = getElement(start); // start
        int max = s.value;
        Element e = getElement(end); // end
        int i = 0;

        while (s.nextMember != null && s.nextMember != e.nextMember) {
            if (s.value > max ) max = s.value;
            //System.out.println(s.value + "; max = " + max);
            s = s.nextMember;
        }
        if (e.value > max) max = e.value;
        //System.out.println(e.value + "; max = " + max);


        return max;
    }

    public int getMin(){
        return getMin(0,size);
    }

    public int getMax(){
        return getMax(0,size);
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
