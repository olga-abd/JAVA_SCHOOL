public class CarUtil {
    public static double calcGsv (Car car) {
        return car.carDistance * car.carFuelType * car.carFuelConsumption;
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

    public static PassangersCar[] sort (PassangersCar[] cars, int param) {
        /* param = 1 - сортировка по пробегу
           param = 2 - сортировка по доп параметру
         */

        if (param == 1) {
            PassangersCar tmp;
            for(int i = 0; i < cars.length; i++) {
                for (int j = i + 1; j < cars.length; j++) {
                    if (cars[i].carDistance > cars[j].carDistance) {
                        tmp = cars[i];
                        cars[i] = cars[j];
                        cars[j] = tmp;
                    }
                }
            }
        }
        return cars;
    }

    public static TruckCar[] sort (TruckCar[] cars, int param) {
        /* param = 1 - сортировка по пробегу
           param = 2 - сортировка по доп параметру
         */

        TruckCar tmp;

        if (param == 1) {
            for(int i = 0; i < cars.length; i++) {
                for (int j = i + 1; j < cars.length; j++) {
                    if (cars[i].carDistance > cars[j].carDistance) {
                        tmp = cars[i];
                        cars[i] = cars[j];
                        cars[j] = tmp;
                    }
                }
            }
        }
        else {
            for(int i = 0; i < cars.length; i++) {
                for (int j = i + 1; j < cars.length; j++) {
                    if (cars[i].cargoVolume > cars[j].cargoVolume) {
                        tmp = cars[i];
                        cars[i] = cars[j];
                        cars[j] = tmp;
                    }
                }
            }
        }
        return cars;
    }

    public static Bus[] sort (Bus[] cars, int param) {
        /* param = 1 - сортировка по пробегу
           param = 2 - сортировка по доп параметру
         */

        Bus tmp;

        if (param == 1) {
            for(int i = 0; i < cars.length; i++) {
                for (int j = i + 1; j < cars.length; j++) {
                    if (cars[i].carDistance > cars[j].carDistance) {
                        tmp = cars[i];
                        cars[i] = cars[j];
                        cars[j] = tmp;
                    }
                }
            }
        }
        else {
            for(int i = 0; i < cars.length; i++) {
                for (int j = i + 1; j < cars.length; j++) {
                    if (cars[i].passagersCount > cars[j].passagersCount) {
                        tmp = cars[i];
                        cars[i] = cars[j];
                        cars[j] = tmp;
                    }
                }
            }
        }
        return cars;
    }

    public static Crane[] sort (Crane[] cars, int param) {
        /* param = 1 - сортировка по пробегу
           param = 2 - сортировка по доп параметру
         */

        Crane tmp;

        if (param == 1) {
            for(int i = 0; i < cars.length; i++) {
                for (int j = i + 1; j < cars.length; j++) {
                    if (cars[i].carDistance > cars[j].carDistance) {
                        tmp = cars[i];
                        cars[i] = cars[j];
                        cars[j] = tmp;
                    }
                }
            }
        }
        else {
            for(int i = 0; i < cars.length; i++) {
                for (int j = i + 1; j < cars.length; j++) {
                    if (cars[i].cargoWeight > cars[j].cargoWeight) {
                        tmp = cars[i];
                        cars[i] = cars[j];
                        cars[j] = tmp;
                    }
                }
            }
        }
        return cars;
    }
}
