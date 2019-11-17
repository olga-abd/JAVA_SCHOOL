public class PassangersCar extends Car {
    public PassangersCar (String carStr){
        super(carStr);
        carDistance = Double.valueOf(carStr.substring(carStr.indexOf("-")+1));
        carFuelType = 46.1;
        carFuelConsumption = 0.125;
    }
}
