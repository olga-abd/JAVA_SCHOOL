public class TruckCar extends Car {
    protected double cargoVolume;   // объем перевезенного груза

    public TruckCar (String carStr) {
        super(carStr);
        carDistance = Double.valueOf(carStr.substring(carStr.indexOf("-")+1,carStr.indexOf("-",carStr.indexOf("-")+1)));
        cargoVolume = Double.valueOf(carStr.substring(carStr.indexOf("-",carStr.indexOf("-")+1) + 1));
        carFuelType = 48.9;
        carFuelConsumption = 0.12;
    }

    public void printCar () {
        super.printCar();
        System.out.println("Объем перевезенного груза: " + cargoVolume);
    }
}
