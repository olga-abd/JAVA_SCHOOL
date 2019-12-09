public class CarException extends Exception {
    public CarException(){
        super();
    }
    public CarException(String code){
        super(ErrorsEnum.valueOf(code).getDescription());
    }
    public CarException(String code, String msg){
        super(ErrorsEnum.valueOf(code).getDescription() + "; " + msg);
    }

    public CarException(String code, Throwable e){
        super(ErrorsEnum.valueOf(code).getDescription(),e);
    }
}
