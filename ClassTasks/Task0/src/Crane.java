public class Crane extends Car {
    protected double cargoWeight;   // вес поднятых грузов

    public Crane (String carStr){
        super(carStr);
        carDistance = Double.valueOf(carStr.substring(carStr.indexOf("-")+1,carStr.indexOf("-",carStr.indexOf("-")+1)));
        cargoWeight = Double.valueOf(carStr.substring(carStr.indexOf("-",carStr.indexOf("-")+1) + 1));
        carFuelType = 48.9;
        carFuelConsumption = 20;
    }

    public void printCar () {
        super.printCar();
        System.out.println("Вес поднятых грузов: " + cargoWeight);
    }
}
