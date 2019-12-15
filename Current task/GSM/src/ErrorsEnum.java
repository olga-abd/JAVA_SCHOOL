public enum ErrorsEnum {
    ERR100 ("Неверный формат автомобиля"),
    ERR200 ("Невозможно отсортировать"),
    ERR300 ("В файле нет необходимых данных"),
    ERR400 ("Файла не существует");

    private String description;
    ErrorsEnum(String descr){
        this.description = descr;
    }

    public String getDescription(){
        return description;
    }
}
