public class TruckCar extends ExtendedCar {
    protected double cargoVolume;   // объем перевезенного груза

    public TruckCar (TempObject tempObject) {
        super(tempObject);
        cargoVolume = dopParam; // Double.valueOf(carStr.substring(carStr.indexOf("-",carStr.indexOf("-")+1) + 1));
        carFuelType = 48.9;
        carFuelConsumption = 0.12;
    }

    public void printCar () {
        super.printCar();
        System.out.println("Объем перевезенного груза: " + cargoVolume);
    }

    public void addData (TruckCar newCar){
        super.addData(newCar);
        cargoVolume = dopParam;
    }
}
