public class ListException extends Exception {
    public ListException(String code){
        super(ErrorEnum.valueOf(code).getDescription());
    }
}
