public class PassangersCar extends Car {
    public PassangersCar (TempObject tempObject) throws CarException{
        super(tempObject);
        //carFuelType = CarUtil.getFuelType("C100");
                //46.1;
        //carFuelConsumption = CarUtil.getFuelComsuption("C100");
                //0.125;
    }

    @Override
    public void printCar() {

        System.out.println("*****");
        System.out.println("Тип авто: Легковые авто");
        System.out.println("Номер: " + carNumber);
        System.out.println("Пробег: " + carDistance);
    }
}
