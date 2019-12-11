
public class MyLinkedList<T> implements Lists<T>{
    private int size; // размер
    Element head; // первый элемент, чтобы было от чего отталкиваться

    public MyLinkedList(){

    }

    public MyLinkedList(T val, int size){
        for (int i = 0; i < size; i++ ) {
            insert(val);
        }
    }

    // вставка нового элемента
    @Override
    public void insert (T val) {
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
    @Override
    public void insert (T val, int position) throws ListException{
        if (size <= position) {
            //insert(val);
            //return;
            throw new ListException("ERR100");
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

    @Override
    public void print () {
        System.out.print("Связанный список: ");
        Element curElement = head;
        while (curElement.nextMember != null) {
            System.out.print(curElement.value + " ");
            curElement = curElement.nextMember;
        }
        System.out.println(curElement.value + " "); // последний элемент
    }

    @Override
    public void getSize(){
        System.out.println("Размер списка: " + size);
    }

    @Override
    public void deleteAt (int position) throws ListException{
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
        else if (position >= size) {
            throw new ListException("ERR200");
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

    public Element getElement (int position) throws ListException{

        if (position == 0 ) return head;

        if (position >= size) throw new ListException("ERR100");

        Element elt = head;

        int i = 0;
        while (elt.nextMember != null && i++ < position){
            elt = elt.nextMember;
        }
        return elt;
    }

    @Override
    public void changeValueAt (T val, int position) throws ListException{
        if(position == 0){
            head.value = val;
        }
        else if (position >= size) {
            throw new ListException("ERR200");
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

    @Override
    public void sort() {
        sort(false);
    }

    @Override
    public void sort(boolean desc){
        T[] arr = (T[])new Object[size];
        try { // если Т - число, то сортируем
            // связанный список переносим в массив
            for (int i = 0; i < size; i++) {
                arr[i] = getElement(i).value;
            }
            T x = arr[0];
            // сортируем
            for (int i = 0; i < size; i++) {
                for (int j = i + 1; j < size; j++) {
                    if (Integer.valueOf(arr[i].toString()) > Integer.valueOf(arr[j].toString()) && desc == false ||
                            Integer.valueOf(arr[i].toString()) < Integer.valueOf(arr[j].toString()) && desc == true) {
                        x = arr[i];
                        arr[i] = arr[j];
                        arr[j] = x;
                    }
                }
            }
        } catch (Exception e){}

        System.out.println("Сортировка по " + (desc ? "убыванию" : "возрастанию") + ":");
        for (int i = 0; i < size; i++){
            System.out.print(arr[i] + " ");
        }
        System.out.println();

    }

    @Override
    public T getMin (int start, int end) throws ListException{
        Element s = getElement(start); // start
        T min = s.value;
        Element e = getElement(end); // end
        //int i = 0;

        try { // если Т - число, то возвращаем значение. иначе первый элемент

            while (s.nextMember != null && s.nextMember != e.nextMember) {
                if (Integer.valueOf(s.value.toString()) < Integer.valueOf(min.toString())) min = s.value;
                //System.out.println(s.value + "; min = " + min);
                s = s.nextMember;
            }
            if (Integer.valueOf(e.value.toString()) < Integer.valueOf(min.toString())) min = e.value;
        } catch (Exception ex){}

        return min;
    }

    @Override
    public T getMax (int start, int end) throws ListException{
        Element s = getElement(start); // start
        T max = s.value;
        Element e = getElement(end); // end
        //int i = 0;

        try { // если числа

            while (s.nextMember != null && s.nextMember != e.nextMember) {
                if (Integer.valueOf(s.value.toString()) > Integer.valueOf(max.toString())) max = s.value;
                //System.out.println(s.value + "; max = " + max);
                s = s.nextMember;
            }
            if (Integer.valueOf(e.value.toString()) > Integer.valueOf(max.toString())) max = e.value;
            //System.out.println(e.value + "; max = " + max);
        } catch (Exception ex){ex.printStackTrace();}

        return max;
    }

    @Override
    public T getMin() throws ListException{

            return getMin(0, size);

    }

    @Override
    public T getMax() throws ListException{
        return getMax(0,size);
    }

    public class Element {
        protected T value;
        protected Element prevMember;
        protected Element nextMember;

        public Element(T value) {
            this.value = value;
        }
    }
}
