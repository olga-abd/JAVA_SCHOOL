public class CarUtil {

    // Расчет ГСМ
    public static double calcGsm2 (Car[] cars){
        double gsm = 0;
        for (Car car : cars){
            gsm += car.carDistance * car.carFuelType * car.carFuelConsumption;
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

    public static void sortDistance (Car[] cars) {
        System.out.println("Сортировка по дистанции:");
        Car tmp;

        for(int i = 0; i < cars.length; i++) {
            for (int j = i + 1; j < cars.length; j++) {
                if (cars[i].carDistance > cars[j].carDistance) {
                    tmp = cars[i];
                    cars[i] = cars[j];
                    cars[j] = tmp;
                }
            }
        }

        for (Car car : cars) {
            car.printCar();
        }

        System.out.println("*****");
    }

    public static void sortDopParam (ExtendedCar[] cars){
        System.out.println("Сортировка по доп параметру:");
        if (cars[0].carCode == 100) {
            for(Car car : cars) {
                car.printCar();
            }
        }
        else {
            ExtendedCar tmp;

            for (int i = 0; i < cars.length; i++) {
                for (int j = i + 1; j < cars.length; j++) {
                    if (cars[i].dopParam > cars[j].dopParam) {
                        tmp = cars[i];
                        cars[i] = cars[j];
                        cars[j] = tmp;
                    }
                }
            }

            for (ExtendedCar car : cars) {
                car.printCar();
            }
        }

        System.out.println("*****");
    }

    // ищем машину в массиве. возвращаем индекс в массиве или -1
    public static int searchCar(Car[] cars, TempObject tempObject){
        for (int i = cars.length - 1; i >= 0; i--){

            if (cars[i] == null) break;
            if (cars[i] != null && cars[i].carCode == (tempObject.carCode) && String.valueOf(cars[i].carNumber).equals(tempObject.carNumber)){
                return i;
            }
        }
        return -1;
    }
}
