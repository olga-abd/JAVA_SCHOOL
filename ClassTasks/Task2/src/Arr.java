public class Arr {
    protected int[] arr;

    public Arr (int[] arr){
        this.arr = arr;
    }

    public Arr (int length, int val){
        arr = new int [length];
        for(int i = 0; i < arr.length; i++){
            arr[i] = val;
        }
    }

    public void print () {
        //System.out.println("***");
        for (int i : arr) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    public void addElement (int val) {
        int[] ms = arr;
        arr = new int [ms.length + 1];
        for(int i = 0; i < ms.length; i++) {
            arr[i] = ms[i];
        }
        arr[arr.length - 1] = val;
    }

    public void addElement (int val, int ind) {
        if (ind >= arr.length) {
            addElement(val);
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
        }
    }

    public void delElement(int index) {
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

    public void changeElement(int index, int val){
        arr[index] = val;
    }

    public int getLength(){
        return arr.length;
    }

    public Arr sort(int param){
        /* param = 1 - ASC
            param = 2 - DESC
         */

        int[] ms = new int[arr.length];
        for (int i = 0; i < ms.length; i++) ms[i] = arr[i];

        int tmp;

        for (int i = 0; i < ms.length; i++){
            for (int j = i + 1; j < ms.length; j++){
                if (ms[i] > ms[j] && param == 1 ||
                    ms[i] < ms[j] && param == 2){
                    tmp = ms[i];
                    ms[i] = ms[j];
                    ms[j] = tmp;
                }
            }
        }

        return  new Arr(ms);

    }

    public int minElement(){
        int min = arr[0];
        for (int i = 1; i < arr.length; i++){
            if (min > arr[i]){
                min = arr[i];
            }
        }
        return min;
    }

    public int maxElement(){
        int max = arr[0];
        for (int i = 1; i < arr.length; i++){
            if (max < arr[i]){
                max = arr[i];
            }
        }
        return max;
    }

}
