public class Crane extends ExtendedCar {
    protected double cargoWeight;   // вес поднятых грузов

    public Crane (TempObject tempObject){
        super(tempObject);
        cargoWeight = dopParam; // Double.valueOf(carStr.substring(carStr.indexOf("-",carStr.indexOf("-")+1) + 1));
        carFuelType = 48.9;
        carFuelConsumption = 0.20;
    }

    public void printCar () {
        super.printCar();
        System.out.println("Вес поднятых грузов: " + cargoWeight);
    }

    public void addDopParam (double newValue){
        super.addDopParam(newValue);
        cargoWeight = dopParam;
    }
}
