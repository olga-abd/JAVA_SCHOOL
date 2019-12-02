public abstract class SberEmployee extends Person{
    protected String tabNum;

    public SberEmployee(String fio, String tabNum){
        super(fio);
        this.tabNum = tabNum;
    }
}
