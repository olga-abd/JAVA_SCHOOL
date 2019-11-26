public class Arr implements Lists{
    protected int[] arr;
    //protected int size;

    public Arr (int[] arr){
        this.arr = arr;
    }

    public Arr (int length, int val){
        arr = new int [length];
        for(int i = 0; i < arr.length; i++){
            arr[i] = val;
        }
    }


    @Override
    public void print () {
        //System.out.println("***");
        for (int i : arr) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    @Override
    public void getSize() {
        System.out.println("Размер массива: " + arr.length);
    }

    @Override
    public void insert (int val) {
        int[] ms = arr;
        arr = new int [ms.length + 1];
        for(int i = 0; i < ms.length; i++) {
            arr[i] = ms[i];
        }
        arr[arr.length - 1] = val;
        //size++;
    }

    @Override
    public void insert (int val, int ind) {
        if (ind >= arr.length) {
            insert(val);
        }
        else {
            int[] ms = new int[arr.length + 1];
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
    public void deleteAt(int index) {
        int[] ms = new int[arr.length - 1];
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
    public void changeValueAt(int val, int index ){
        arr[index] = val;
    }

    @Override
    public void sort(boolean desc){
        /* param = 1 - ASC
            param = 2 - DESC
         */

        int[] ms = new int[arr.length];
        for (int i = 0; i < ms.length; i++) ms[i] = arr[i];

        int tmp;

        for (int i = 0; i < ms.length; i++){
            for (int j = i + 1; j < ms.length; j++){
                if (ms[i] > ms[j] && !desc ||
                        ms[i] < ms[j] && desc){
                    tmp = ms[i];
                    ms[i] = ms[j];
                    ms[j] = tmp;
                }
            }
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
    public int getMin(){
        /*int min = arr[0];
        for (int i = 1; i < arr.length; i++){
            if (min > arr[i]){
                min = arr[i];
            }
        }
        return min;*/
        return getMin(0,arr.length);
    }

    @Override
    public int getMax(){
        /*int max = arr[0];
        for (int i = 1; i < arr.length; i++){
            if (max < arr[i]){
                max = arr[i];
            }
        }
        return max;*/
        return getMax(0,arr.length);
    }

    @Override
    public int getMin(int start, int end) {
        int min = arr[start];
        for (int i = start + 1; i < end; i++){
            if (min > arr[i]){
                min = arr[i];
            }
        }
        return min;
    }

    @Override
    public int getMax(int start, int end) {
        int max = arr[start];
        for (int i = start + 1; i < end; i++){
            if (max < arr[i]){
                max = arr[i];
            }
        }
        return max;
    }

}
