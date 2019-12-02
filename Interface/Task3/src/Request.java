public class Request extends Questionnaire {
    protected DepartmentHead departmentHead;

    public Request(DepartmentHead departmentHead, double salary, String skills) {
        super(salary, skills);
        this.departmentHead = departmentHead;
    }
}
