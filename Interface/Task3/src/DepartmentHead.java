import java.util.ArrayList;

public class DepartmentHead extends SberEmployee {
    protected String depart;
    protected ArrayList<Request> requests = new ArrayList<>();

    public DepartmentHead(String fio, String tabNum, String depart) {
        super(fio, tabNum);
        this.depart = depart;
    }


    // создать заявку на подбор, передать в hr
    public void createRequest(double salary, String skills){

    }
}
