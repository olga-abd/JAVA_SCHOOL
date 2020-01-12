import java.lang.reflect.Array;
import java.text.SimpleDateFormat;
import java.util.*;

public class CarUtils {

    public static Car createCar (String s, List<CarParams> carParamsList) throws CarException {
        String dt = new String();
        String carType = new String();
        String carNumber = new String();

        try {
            //System.out.println(s);
            dt = s.substring(0, s.indexOf("\t")); //System.out.println(dt);
            carType = s.substring(s.indexOf("\t") + 1, s.indexOf("_")); //System.out.println(carType);
            carNumber = s.substring(s.indexOf("_") + 1, s.indexOf("-", s.indexOf("\t"))); //System.out.println(carNumber);
        } catch (Exception e) {
            throw new CarException("ERR5", s.substring(s.indexOf("\t")));
        }
        double fuelCons = 0;
        double fuelType = 0;
        int carDistance;
        int dopParam;
        Car car;

        // ищем параметры
        for (CarParams cp : carParamsList) {
            if (cp.carType.equals(carType)) {
                fuelCons = cp.fuelConsumption;
                fuelType = cp.fuelType;
                break;
            }
        }
        // если не найдены параметры, выводим ошибку
        if (fuelCons * fuelType == 0) {
            throw new CarException("ERR3");
        }

        if (carType.equals("C100")) {
            carDistance = Integer.valueOf(s.substring(s.indexOf("-",s.indexOf("\t")) + 1));
            car = new Car(dt,carType,carNumber,carDistance,fuelType,fuelCons);
        } else {
            carDistance = Integer.valueOf(s.substring(s.indexOf("-",s.indexOf("\t")) + 1, s.indexOf("-", s.indexOf("-",s.indexOf("\t")) + 1)));
            dopParam = Integer.valueOf(s.substring(s.indexOf("-", s.indexOf("-",s.indexOf("\t")) + 1) + 1));
            car = new Car(dt,carType,carNumber,carDistance,dopParam,fuelType,fuelCons);
        }

        return car;
    }

    public static List<Car> equalCar (List<Car> carList, Car car){
        if (carList.indexOf(car) == -1) { // если такой машины нет, то добавляем новую
            carList.add(car);
        } else {
            carList.get(carList.indexOf(car)).updateCar(car); // если есть, то суммируем
        }
        return carList;
    }

    public static void gsm (List<Car> carList, String type) throws CarException{
        if (!type.matches("C[1|2|3|4]00") && !type.equals("ALL")) throw new CarException("ERR5", type);

        double[] gsm_arr = new double[5];
        int i = 0;

        for(Car car : carList){
            switch (car.carType) {
                case "C100":
                {
                    i = 0;
                    break;
                }
                case "C200":
                {
                    i = 1;
                    break;
                }
                case "C300":
                {
                    i = 2;
                    break;
                }
                case "C400":
                {
                    i = 3;
                    break;
                }
            }
            gsm_arr[i] += car.distance * car.fuelType * car.fuelConsumption;
            //gsm_arr[4] += gsm_arr[i];
        }
        for (int x = 0; x < 4; x++) {
            gsm_arr[4] += gsm_arr[x];
        }

        if (type.equals("C100") || type.equals("ALL")) System.out.println ("ГСМ по легковым авто: " + gsm_arr[0]);
        if (type.equals("C200") || type.equals("ALL")) System.out.println ("ГСМ по грузовым авто: " + gsm_arr[1]);
        if (type.equals("C300") || type.equals("ALL")) System.out.println ("ГСМ по пассажирскому транспору: " + gsm_arr[2]);
        if (type.equals("C400") || type.equals("ALL")) System.out.println ("ГСМ по спецтранспорту: " + gsm_arr[3]);
        if (type.equals("ALL")) {
            System.out.println ("ГСМ всего: " + gsm_arr[4]);
            System.out.println ("Наименьшую стоимость ГСМ имеет " + get_category("C" + (min_gsm(gsm_arr) + 1) + "00"));
            System.out.println ("Наибольшую стоимость ГСМ имеет " + get_category("C" + (max_gsm(gsm_arr) + 1) + "00"));
        }


    }

    private static int min_gsm(double[] gsm){
        double min = Double.MAX_VALUE;
        int min_index = Integer.MAX_VALUE;

        for (int i = 0; i < gsm.length - 1; i++) {
            if (min > gsm[i]) {
                min = gsm[i];
                min_index = i;
            }
        }

        return min_index;
    }

    private static int max_gsm(double[] gsm){
        double max = Double.MIN_VALUE;
        int max_index = Integer.MAX_VALUE;

        for (int i = 0; i < gsm.length - 1; i++) {
            if (max < gsm[i]) {
                max = gsm[i];
                max_index = i;
            }
        }

        return max_index;
    }

    public static String get_category (String carType) {
        String s = new String();
        switch(carType) {
            case "C100":
            {
                s = "легковые авто";
                break;
            }
            case "C200" :
            {
                s  = "грузовые авто";
                break;
            }
            case "C300":
            {
                s = "пассажирский транспорт";
                break;
            }
            case "C400":
            {
                s = "спецтранспорт";
                break;
            }
        }
        return s;
    }

    public static void sortCars(List<Car> carList, String type){
        // выводим сортировку
        if (type.equals("C100") || type.equals("ALL")) sort(carList, "C100");
        if (type.equals("C200") || type.equals("ALL")) sort(carList, "C200");
        if (type.equals("C300") || type.equals("ALL")) sort(carList, "C300");
        if (type.equals("C400") || type.equals("ALL")) sort(carList, "C400");
    }

    private static void sort (List<Car> carList, String carType) {
        Map<Car, Integer> map = new TreeMap<>(new Comparator<Car>() {
            @Override
            public int compare(Car o1, Car o2) {
                return o1.compareTo(o2);
            }
        }) ;

        for (Car car : carList){
            if (carType.equals(car.carType)) map.put(car,0);
        }

        for (Car car : map.keySet()){
            car.printCar();
        }
    }
}
