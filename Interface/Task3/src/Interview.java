public class Interview {
    protected DepartmentHead departmentHead;
    protected HR hr;
    protected Candidate candidate;

    // собеседование
    public Interview(DepartmentHead departmentHead, HR hr, Candidate candidate){
        this.departmentHead = departmentHead;
        this.hr = hr;
        this.candidate = candidate;
    }
}
