public interface Lists<T> {
    public void insert (T val);
    public void insert (T val, int position) throws ListException;
    public void print ();
    public void getSize();
    public void deleteAt(int position) throws ListException;
    public void changeValueAt(T val, int position) throws ListException;
    public void sort();
    public void sort(boolean desc);
    public T getMin (int start, int end) throws ListException;
    public T getMax (int start, int end) throws ListException;
    public T getMin() throws ListException;
    public T getMax() throws ListException;
}
