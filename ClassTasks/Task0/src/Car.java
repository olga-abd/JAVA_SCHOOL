public class Car {
    protected String carStr = new String();     // исходная строка
    protected int carCode;                      // Код авто
    protected String carNumber = new String();  // гос номер
    protected double carDistance;               // пробег
    protected double carFuelType;               // тип топлива
    protected double carFuelConsumption;        // расход топлива

    public Car (String carStr) {
        this.carStr = carStr;
        carCode = Integer.valueOf(carStr.substring(1,carStr.indexOf("_")));
        carNumber = carStr.substring(carStr.indexOf("_")+1,carStr.indexOf("-"));

    }

    public void printCar () {
        String carType = new String();
        switch (carCode) {
            case 100:
            {
                carType = "Легковые авто";
                break;
            }
            case 200:
            {
                carType = "Грузовые авто";
                break;
            }
            case 300:
            {
                carType = "Пассажирский транспорт";
                break;
            }
            case 400:
            {
                carType = "Тяжелая техника";
                break;
            }
        }
        System.out.println("*****");
        System.out.println("Тип авто: " + carType);
        System.out.println("Номер: " + carNumber);
        System.out.println("Пробег: " + carDistance);
    }

}
