public class ArrayIterator<T> {
    protected T[] array;
    private int currentIndex = 0;

    public ArrayIterator(T[] arr){
        this.array = arr;
    }

    public boolean hasNext() {
        return currentIndex < array.length;
    }

    public T next() {
        return array[currentIndex++];
    }
}
