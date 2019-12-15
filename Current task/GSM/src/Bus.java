public class Bus extends ExtendedCar {
    protected double passagersCount;   // кол-во перевезенных пассажиров
    public Bus (TempObject tempObject) throws CarException{
        super(tempObject);
        passagersCount = dopParam; // Integer.valueOf(carStr.substring(carStr.indexOf("-",carStr.indexOf("-")+1) + 1));
        //carFuelType = 47.5;
        //carFuelConsumption = 0.115;
    }

    public void printCar () {
        super.printCar();
        System.out.println("Кол-во перевезенных пассажиров: " + passagersCount);
    }

    public void addData (Bus newCar){
        super.addData(newCar );
        passagersCount = dopParam;
    }
}
