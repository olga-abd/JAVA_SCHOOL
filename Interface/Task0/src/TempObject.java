public class TempObject {
    protected String carStr = new String();     // исходная строка
    protected int carCode;                      // Код авто
    protected String carNumber = new String();  // гос номер
    protected double carDistance;               // пробег
    protected double dopParam;                     // дополнительный параметр

    public TempObject (String carStr) {
        this.carStr = carStr;
        carCode = Integer.valueOf(carStr.substring(1,carStr.indexOf("_")));
        carNumber = carStr.substring(carStr.indexOf("_")+1,carStr.indexOf("-"));
        if (carCode == 100) {
            carDistance = Double.valueOf(carStr.substring(carStr.indexOf("-")+1));
        }
        else {
            carDistance = Double.valueOf(carStr.substring(carStr.indexOf("-")+1,carStr.indexOf("-",carStr.indexOf("-")+1)));
            dopParam = Double.valueOf(carStr.substring(carStr.indexOf("-",carStr.indexOf("-")+1) + 1));
        }
    }

}
