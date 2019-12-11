public class ArrayIterator<T> {
    protected T[] array;
    private int currentIndex = 0;

    public ArrayIterator(T[] arr){
        this.array = arr;
    }

    public boolean hasNext() {
        return currentIndex < array.length;
    }

    public T next() throws IteratorException{
        if(hasNext()) {
            return array[currentIndex++];

        }
        else {
            throw new IteratorException("Достигнут конец массива");
        }
    }

    public T prev() throws IteratorException{
        if (currentIndex == 0) throw new IteratorException("Достигнуто начало массива");
        return array[--currentIndex];
    }
}
