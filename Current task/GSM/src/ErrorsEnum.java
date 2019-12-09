public enum ErrorsEnum {
    ERR100 ("Неверный формат автомобиля"),
    ERR200 ("Невозможно отсортировать");

    private String description;
    ErrorsEnum(String descr){
        this.description = descr;
    }

    public String getDescription(){
        return description;
    }
}
