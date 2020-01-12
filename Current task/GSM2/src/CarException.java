public class CarException extends Exception {
    public CarException(String code){
        super(ErrorsEnum.valueOf(code).getDescr());
    }
    public CarException(String code, String msg){
        super(ErrorsEnum.valueOf(code).getDescr() + ": " + msg);
    }
}
