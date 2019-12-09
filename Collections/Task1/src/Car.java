public abstract class Car { // Класс Car сделала абстрактым
    protected String carStr = new String();     // исходная строка
    protected int carCode;                      // Код авто
    protected String carNumber = new String();  // гос номер
    protected double carDistance;               // пробег
    protected double carFuelType;               // тип топлива
    protected double carFuelConsumption;        // расход топлива


    public Car (TempObject tempObject) {
        carCode = tempObject.carCode;
        carNumber = tempObject.carNumber;
        carDistance = tempObject.carDistance;
    }

    public abstract void printCar() ; // абстрактный метод. В ExtendedCar и PassangersCar метод переопределен

    public void addData (Car newCar) { carDistance += newCar.carDistance;}

    @Override
    public boolean equals(Object obj){
        if (((Car) obj).carNumber.equals(carNumber) && ((Car) obj).carCode == carCode){
            return true;
        } else {
            return false;
        }
    }
}
