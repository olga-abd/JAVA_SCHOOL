public interface Lists {
    public void insert (int val);
    public void insert (int val, int position);
    public void print ();
    public void getSize();
    public void deleteAt(int position);
    public void changeValueAt(int val, int position);
    public void sort();
    public void sort(boolean desc);
    public int getMin (int start, int end);
    public int getMax (int start, int end);
    public int getMin();
    public int getMax();
}
