public enum ErrorsEnum {
    ERR0 ("Неизвестная ошибка"),
    ERR1 ("Неверный формат числа"),
    ERR2 ("В файле неверное количество столбцов"),
    ERR3 ("Не найдены значения для типа авто"),
    ERR4 ("Файл не найден"),
    ERR5 ("Неверный формат строки для авто");

    private String descr;

    ErrorsEnum(String d){
        descr = d;
    }

    public String getDescr(){
        return descr;
    }
}
