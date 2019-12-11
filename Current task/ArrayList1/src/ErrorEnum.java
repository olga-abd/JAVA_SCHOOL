public enum ErrorEnum {

    ERR100 ("Превышен размер массива"),
    ERR200 ("Элемента не существует");

    private String description;
    ErrorEnum (String description){
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
