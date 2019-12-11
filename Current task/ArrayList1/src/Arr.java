public class Arr<T> implements Lists<T>{
    protected T[] arr;
    //protected int size;

    public Arr (T[] arr){
        this.arr = arr;
    }

    public Arr(){}

    public Arr (int length, T val){
        arr = (T[])new Object[length];
        for(int i = 0; i < arr.length; i++){
            arr[i] = val;
        }
    }


    @Override
    public void print () {
        //System.out.println("***");
        for (T i : arr) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    @Override
    public void getSize() {
        System.out.println("Размер массива: " + arr.length);
    }

    @Override
    public void insert (T val) {
        T[] ms = arr;
        arr = (T[])new Object[ms.length + 1];
        for(int i = 0; i < ms.length; i++) {
            arr[i] = ms[i];
        }
        arr[arr.length - 1] = val;
        //size++;
    }

    @Override
    public void insert (T val, int ind) throws ListException{
        if (ind >= arr.length) {
            //insert(val);
            throw new ListException("ERR100");
        }
        else {
            T[] ms = (T[])new Object[arr.length + 1];
            for (int i = 0 ; i < ms.length; i++){
                if (i < ind){
                    ms[i] = arr[i];
                }
                else if(i == ind) {
                    ms[i] = val;
                }
                else {
                    ms[i] = arr[i - 1];
                }
            }
            arr = ms;
            //size++;
        }
    }

    @Override
    public void deleteAt(int index) throws ListException{
        if (index >= arr.length) throw new ListException("ERR200");
        T[] ms = (T[])new Object[arr.length - 1];
        for(int i = 0; i < ms.length; i++) {
            if (i >= index){
                ms[i] = arr[i+1];
            }
            else{
                ms[i] = arr[i];
            }
        }
        arr = ms;
    }

    @Override
    public void changeValueAt(T val, int index ) throws ListException{
        if(index >= arr.length) throw new ListException("ERR200");
        arr[index] = val;
    }

    @Override
    public void sort(boolean desc){


        T[] ms = (T[])new Object[arr.length];

        // если массив числовой, то сортируем. иначе - нет
        try {
            for (int i = 0; i < ms.length; i++) ms[i] = arr[i];

            T tmp;
            for (int i = 0; i < ms.length; i++){
                for (int j = i + 1; j < ms.length; j++){
                    if (Integer.valueOf(ms[i].toString()) > Integer.valueOf(ms[j].toString()) && !desc ||
                            Integer.valueOf(ms[i].toString()) < Integer.valueOf(ms[j].toString()) && desc){
                        tmp = ms[i];
                        ms[i] = ms[j];
                        ms[j] = tmp;
                    }
                }
            }
        } catch (Exception e) {
            // если это не число, то не сортируем
            ms = arr;
        }



        System.out.println("Сортировка по " + (desc ? "убыванию" : "возрастанию") + ":");
        for (int i = 0; i < ms.length; i++){
            System.out.print(ms[i] + " ");
        }
        System.out.println();


    }

    @Override
    public void sort(){
        sort(false);
    }

    @Override
    public T getMin() throws ListException{

        return getMin(0,arr.length);
    }

    @Override
    public T getMax() throws ListException{

        return getMax(0,arr.length);
    }

    @Override
    public T getMin(int start, int end) throws ListException{
        if (start >= arr.length || end >= arr.length) throw new ListException("ERR200");
        T min = arr[start];
        try { //если числовой массив, то вычисляем значение. Иначе - возращаем первый элемент
            for (int i = start + 1; i < end; i++) {
                if (Integer.valueOf(min.toString()) > Integer.valueOf(arr[i].toString())) {
                    min = arr[i];
                }
            }
        } catch (Exception e){

        }
        return min;
    }

    @Override
    public T getMax(int start, int end) throws ListException{
        if (start >= arr.length || end >= arr.length) throw new ListException("ERR200");
        T max = arr[start];
        try { // если массив числовой - возвращаем значение. иначе - первый элемент

            for (int i = start + 1; i < end; i++) {
                if (Integer.valueOf(max.toString()) < Integer.valueOf(arr[i].toString())) {
                    max = arr[i];
                }
            }
        } catch (Exception e){

        }
        return max;
    }

}
