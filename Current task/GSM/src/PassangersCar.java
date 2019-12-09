public class PassangersCar extends Car {
    public PassangersCar (TempObject tempObject){
        super(tempObject);
        carFuelType = 46.1;
        carFuelConsumption = 0.125;
    }

    @Override
    public void printCar() {

        System.out.println("*****");
        System.out.println("Тип авто: Легковые авто");
        System.out.println("Номер: " + carNumber);
        System.out.println("Пробег: " + carDistance);
    }
}
