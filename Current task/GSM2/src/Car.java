import java.util.Comparator;
import java.util.Date;

public class Car implements Comparable {
    protected String carType;
    protected String carNumber;
    protected int distance;
    protected int dopParam;
    protected double fuelType;
    protected double fuelConsumption;
    protected String dt;

    public Car (String dt, String carType, String carNumber, int distance, double fuelType, double fuelConsumption){
        this.carNumber = carNumber;
        this.carType = carType;
        this.distance = distance;
        this.fuelType = fuelType;
        this.fuelConsumption = fuelConsumption;
        this.dt = dt;
    }

    public Car (String dt, String carType, String carNumber, int distance, int dopParam, double fuelType, double fuelConsumption){
        this.carNumber = carNumber;
        this.carType = carType;
        this.distance = distance;
        this.dopParam = dopParam;
        this.fuelType = fuelType;
        this.fuelConsumption = fuelConsumption;
        this.dt = dt;
    }

    public void updateCar (Car car) {
        this.distance += car.distance;
        if (!carType.equals("C100")) this.dopParam += car.dopParam;
        this.dt = car.dt;
    }

    public void printCar () {
        System.out.println(CarUtils.get_category(carType));
        System.out.println("Номер: " + carNumber);
        System.out.println("Дистанция: " + distance);
        switch (carType) {
            case "C200" :
            {
                System.out.println ("Объем груза: " + dopParam);
                break;
            }
            case "C300":
            {
                System.out.println("Кол-во пассажиров: " + dopParam);
                break;
            }
            case "C400":
            {
                System.out.println("Доп характеристика: " + dopParam);
                break;
            }
        }
        System.out.println("*****");

    }

    @Override
    public boolean equals (Object car){
        return ((Car)car).carNumber.equals(carNumber) && ((Car)car).carType.equals(carType);
    }

    @Override
    public int compareTo (Object object){
        return (int) (this.distance - ((Car) object).distance);
    }
}
