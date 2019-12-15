import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

public class CarUtil {

    // Расчет ГСМ

    public static double calcGsm3 (ArrayList<Car> cars){
        double gsm = 0;
        for (int i = 0; i < cars.size(); i++){
            gsm += cars.get(i).carDistance * cars.get(i).carFuelType * cars.get(i).carFuelConsumption;
        }
        return gsm;
    }

    public static String minCost (double[] arr){

        double a = arr[0];  // первый элемент берем за основу
        int ind = 0;        // переменная для сохранения индекса, т.к по индексу определяется тип авто
        String str = new String();
        for (int i = 1; i < arr.length - 1; i++) {
            if (a > arr[i]) {
                a = arr[i];
                ind = i;
            }
        }

        switch (ind) {
            case 0:
            {
                str = "Легковые авто";
                break;
            }
            case 1:
            {
                str = "Грузовые авто";
                break;
            }
            case 2:
            {
                str = "Пассажирский транспорт";
                break;
            }
            case 3:
            {
                str = "Тяжелая техника";
                break;
            }
        }

        return str;
    }

    public static String maxCost (double[] arr){

        double a = arr[0];  // первый элемент берем за основу
        int ind = 0;        // переменная для сохранения индекса, т.к по индексу определяется тип авто
        String str = new String();
        for (int i = 1; i < arr.length - 1; i++) {
            if (a < arr[i]) {
                a = arr[i];
                ind = i;
            }
        }

        switch (ind) {
            case 0:
            {
                str = "Легковые авто";
                break;
            }
            case 1:
            {
                str = "Грузовые авто";
                break;
            }
            case 2:
            {
                str = "Пассажирский транспорт";
                break;
            }
            case 3:
            {
                str = "Тяжелая техника";
                break;
            }
        }

        return str;
    }

    public static void sortDistance (ArrayList<Car> cars){
        cars.sort(new Comparator<Car>() {
            @Override
            public int compare(Car o1, Car o2) {
                return (int) (o1.carDistance - o2.carDistance);
            }
        });

        for (Car car : cars) {
            car.printCar();
        }
    }

    public static void sortDopParam (ArrayList<Car> cars) throws CarException {
        if (cars.get(0).carCode == 100) throw new CarException("ERR200");
        cars.sort(new Comparator<Car>() {
            @Override
            public int compare(Car o1, Car o2) {
                return (int) (((ExtendedCar)o1).dopParam - ((ExtendedCar)o2).dopParam);
            }
        });
        for (Car car : cars){
            car.printCar();
        }
    }

    public static double getFuelType (String carType) throws CarException{
        return getFuelInfo(".\\carFuelTypeFile.txt",carType);
    }

    public static double getFuelComsuption (String carType) throws CarException{
        return getFuelInfo(".\\carFuelConsumptionFile.txt", carType);
    }

    private static double getFuelInfo (String filePath, String carType) throws CarException {

        Path path = Paths.get(filePath);
        List<String> list = new ArrayList<>();

        if(!Files.exists(path))  throw new CarException("ERR400");

        try {
            list = Files.readAllLines(path);
        } catch (IOException e) {
            e.printStackTrace();
            throw new CarException("ERR400");
        }

        for (int i = 0; i < list.size(); i++) {
            if(list.get(i).split(" ")[0].equals(carType)){
                return Double.valueOf(list.get(i).split(" ")[1]);
            }
        }
        throw new CarException("ERR300");
    }
}
