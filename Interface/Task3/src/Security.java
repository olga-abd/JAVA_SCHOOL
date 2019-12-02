public class Security extends SberEmployee {
    public Security(String fio, String tabNum) {
        super(fio, tabNum);
    }

    // служба безопасности проверяет кандидата и дает заключение
    public boolean checkCandidate(Candidate candidate){
        return true;
    }
}
