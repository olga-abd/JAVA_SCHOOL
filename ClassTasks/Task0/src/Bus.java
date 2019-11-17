public class Bus extends Car {
    protected int passagersCount;   // кол-во перевезенных пассажиров
    public Bus (String carStr){
        super(carStr);
        carDistance = Double.valueOf(carStr.substring(carStr.indexOf("-")+1,carStr.indexOf("-",carStr.indexOf("-")+1)));
        passagersCount = Integer.valueOf(carStr.substring(carStr.indexOf("-",carStr.indexOf("-")+1) + 1));
        carFuelType = 47.5;
        carFuelConsumption = 0.115;
    }

    public void printCar () {
        super.printCar();
        System.out.println("Кол-во перевезенных пассажиров: " + passagersCount);
    }
}
