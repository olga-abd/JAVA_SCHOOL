import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.text.SimpleDateFormat;
import java.util.*;

public class GSM {
    public static void main (String[] args) {
        /*String[] cars; = {"C100_1-100", "C200_1-120-1200", "C300_1-120-30", "C400_1-80-20", "C100_2-50", "C200_2-40-1000", "C300_2-200-45", "C400_2-10-20",
                "C100_3-10", "C200_3-170-1100", "C300_3-150-29", "C400_3-100-28", "C100_1-300", "C200_1-100-750", "C300_1-32-15",};
*/
        final String  CARFILEPATH = ".\\cars_file.txt";



        Scanner sc = new Scanner(System.in);
        System.out.println ("!!! Информацию вводите через enter !!!");

        System.out.print("User: ");
        String user = sc.next().toUpperCase();

        System.out.print("Command (ADD / CALC / TYPE / LOG): ");
        String command = sc.next().toUpperCase();

        String param = new String();// = sc.next();
        String param2 = new String(); //для параметров лога
        Log log = new Log();


        // проверяем, какая комманда введена
        if (!command.equals("ADD") && !command.equals("CALC") && !command.equals("TYPE") && !command.equals("LOG")) {
            try {
                log.addLog(user, command);
            } catch (IOException e) {
                e.printStackTrace();
            }
            System.out.println("Неизвестная команда");
            return;
        }
        // если команда не Calc, то ждем вторую вводную
        if (!command.equals("CALC")) {
            System.out.print("Parametr");
            switch (command) {
                case "TYPE":
                {
                    System.out.print(" (C100 / C200 / C300 / C400)");
                    break;
                }
                case "LOG":
                {
                    System.out.print(" (USER <name> / DATE <yyyy-mm-dd> / ALL)");
                    break;
                }
                case "ADD":
                {
                    System.out.print(" (format: C100_1-100 / C200_1-100-1000)");
                    break;
                }
            }
            System.out.print(": ");
            param = sc.next().toUpperCase();

            // проверяем формат введенной строки
            if (command.equals("TYPE") && !param.matches("C[1|2|3|4]00")){
                System.out.println ("Неверный формат ввода");
                return;
            }
            if (command.equals("TYPE")) { //
                System.out.print("За какую дату вывести результат? Если фильтровать по дате не надо, то пишите ALL: ");
                param2 = sc.next().toUpperCase();
                if(!param2.equals("ALL") && !param2.matches("\\d{4}(-\\d{2}){2}")) {
                    System.out.println("Неверный формат ввода");
                    return;
                }
            }
            if (command.equals("LOG") && !param.equals("USER") && !param.equals("DATE") && !param.equals("ALL")){
                System.out.println ("Неверный формат ввода");
                return;
            }
        } else { // CALC
            System.out.print("За какую дату вывести результат? Если фильтровать по дате не надо, то пишите ALL: ");
            param2 = sc.next().toUpperCase();
            if (!param2.equals("ALL") && !param2.matches("\\d{4}(-\\d{2}){2}")) {
                System.out.println("Неверный формат ввода");
                return;
            }
        }

        if (!command.equals("LOG")) {
            try {
                log.addLog(user, command + " " + param + " " + param2);
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            if (param.equals("USER")) {
                try {
                    log.getUserLog(sc.next().toUpperCase());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            else if (param.equals("DATE")){
                param2 = sc.next();
                if(param2.matches("\\d{4}(-\\d{2}){2}")) {
                    try {
                        log.getDateLog(param2);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                } else {
                    System.out.println ("Дата введена неверно (yyyy-mm-dd)");
                    return;
                }
            }
            else if (param.equals("ALL")){
                try {
                    log.getAllLog();
                } catch (IOException e){
                    e.printStackTrace();
                }
            }
            return;
        }

        // файл с машинами
        Path path = Paths.get(CARFILEPATH);

        List<String> cars2 = new ArrayList<>();

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        // если ADD, то добавляем вконец
        if (command.equals("ADD")) {

            try {
                if (checkCarFormat(param)) { // проверяем формат строки с авто
                    if (!Files.exists(path)) Files.createFile(path);
                    Files.write(path, (sdf.format(new Date()) + " " + param + "\r\n").getBytes(), StandardOpenOption.APPEND);
                    System.out.println("Автомобиль " + param + " добавлен");
                }
            } catch (IOException e){
                System.out.println("Ошибка записи в файл");
                e.printStackTrace();

            } catch (CarException e){
                System.out.println(e.getMessage()); // неверный формат автомобиля
            } catch (Exception e){
                System.out.println("Непредвиденная ошибка");
                e.printStackTrace();
            }
            return; // выход из программы
        }
        else {
            // если файл существует
            if(Files.exists(path)) {
                try {
                    cars2 = Files.readAllLines(path);
                } catch (IOException e) {
                    System.out.println("Ошибка чтения");
                    e.printStackTrace();
                    return;
                }
            } else {
                System.out.println("Не добавлено ни одного автомобиля");

            }
        }

        //System.out.println(cars2.toString());

        // Если не ADD, то идем дальше


        // если нужен определенный вид авто, то остальные удаляем из листа
        if (command.equals("TYPE") ) {
            for(int i = cars2.size()-1; i >= 0; i--){
                if(!cars2.get(i).split(" ")[1].substring(0,4).equals(param)) cars2.remove(i);
            }
        }

        for (int i = cars2.size() - 1; i >= 0; i--){
            if(param2.equals("ALL") || param2.equals(cars2.get(i).split(" ")[0])){
                cars2.set(i,cars2.get(i).substring(cars2.get(i).indexOf(" ")+1));
            } else {
                cars2.remove(i);
            }
        }


        if(cars2.size() == 0) {
            System.out.println("Нет автомобилей по заданным параметрам");
            return;
        }

        String[] cars = new String[cars2.size()];
        cars2.toArray(cars);

        int carCode;


        double[] gsm = new double[5]; // для каждого типа авто значение в своем индексе + общая сумма

        ArrayList<Car> passangersCars = new ArrayList<>();
        ArrayList<Car> truckCars = new ArrayList<>();
        ArrayList<Car> buses = new ArrayList<>();
        ArrayList<Car> cranes = new ArrayList<>();


        TempObject tempObject;
        int ind; // переменная, куда сохранится индекс массива при поиске
        Car tempCar;
        Car currentCar;
        // заполняем массивы
        for (String car : cars) {
            try {

                tempObject = new TempObject(car);
                carCode = Integer.valueOf(car.substring(1,car.indexOf("_")));

                //if (car.equals("C100_1-100"))throw new Exception();
            } catch (CarException e){
                System.out.println(e.getMessage());
                continue;
            } catch (Exception e){
                System.out.println("Непредвиденная ошибка на строке: " + car);
                return;
            }
            switch (carCode) {
                case 100:
                {
                    try {
                        tempCar = new PassangersCar(tempObject);
                    } catch (CarException e) {
                        System.out.println(e.getMessage());
                        break;
                    }
                    if (passangersCars.contains(tempCar)){ // если есть такая машина
                        ind = passangersCars.indexOf(tempCar);
                        currentCar = passangersCars.get(ind);
                        currentCar.addData(tempCar);
                        passangersCars.set(ind, (PassangersCar) currentCar);
                    } else { // если нет машины
                        passangersCars.add((PassangersCar) tempCar);
                    }

                    break;
                }
                case 200:
                {
                    try {
                        tempCar = new TruckCar(tempObject);
                    } catch (CarException e) {
                        System.out.println(e.getMessage());
                        break;
                    }
                    if (truckCars.contains(tempCar)){
                        ind = truckCars.indexOf(tempCar);
                        currentCar = truckCars.get(ind);
                        ((TruckCar)currentCar).addData((TruckCar)tempCar);
                        truckCars.set(ind, (TruckCar) currentCar);
                    } else {
                        truckCars.add((TruckCar) tempCar);
                    }
                    break;
                }
                case 300:
                {
                    try {
                        tempCar = new Bus(tempObject);
                    } catch (CarException e) {
                        System.out.println(e.getMessage());
                        break;
                    }
                    if (buses.contains(tempCar)){
                        ind = buses.indexOf(tempCar);
                        currentCar = buses.get(ind);
                        ((Bus)currentCar).addData((Bus) tempCar);
                        buses.set(ind, (Bus) currentCar);
                    } else {
                        buses.add((Bus) tempCar);
                    }

                    break;
                }
                case 400:
                {
                    try {
                        tempCar = new Crane(tempObject);
                    } catch (CarException e) {
                        System.out.println(e.getMessage());
                        break;
                    }
                    if (cranes.contains(tempCar)){
                        ind = cranes.indexOf(tempCar);
                        currentCar = cranes.get(ind);
                        ((Crane)currentCar).addData(tempCar);
                        cranes.set(ind, (Crane) currentCar);
                    } else {
                        cranes.add((Crane) tempCar);
                    }
                    break;
                }
            }
        }

        // считаем ГСМ

        gsm[0] = CarUtil.calcGsm3(passangersCars);
        gsm[1] = CarUtil.calcGsm3(truckCars);
        gsm[2] = CarUtil.calcGsm3(buses);
        gsm[3] = CarUtil.calcGsm3(cranes);

        // сумма ГСМ (по последнем элементе - ИТОГО)
        for (int i = 0; i < gsm.length - 1; i++){
            gsm[gsm.length - 1] += gsm[i];
        }


        if(command.equals("CALC")) System.out.println("Общая стоимость расходов ГСМ: " + gsm[gsm.length - 1]);
        if(command.equals("CALC") || (command.equals("TYPE") && param.equals("C100"))) System.out.println("Расход ГСМ по легковым авто: " + gsm[0]);
        if(command.equals("CALC") || (command.equals("TYPE") && param.equals("C200"))) System.out.println("Расход ГСМ по грузовым авто: " + gsm[1]);
        if(command.equals("CALC") || (command.equals("TYPE") && param.equals("C300"))) System.out.println("Расход ГСМ по пассажирскому транспорту: " + gsm[2]);
        if(command.equals("CALC") || (command.equals("TYPE") && param.equals("C400"))) System.out.println("Расход ГСМ по тяжелой технике: " + gsm[3]);

        if(command.equals("CALC")) System.out.println("Наименьшую стоимость ГСМ имеет тип авто: " + CarUtil.minCost(gsm));
        if(command.equals("CALC")) System.out.println("Наибольшую стоимость ГСМ имеет тип авто: " + CarUtil.maxCost(gsm));

        // выводим детальную инфу с сортировкой
        if(command.equals("CALC") || (command.equals("TYPE") && param.equals("C100"))) {
            CarUtil.sortDistance(passangersCars);
        }

        if(command.equals("CALC") || (command.equals("TYPE") && param.equals("C200"))) {
            try {
                CarUtil.sortDopParam(truckCars);
            } catch (CarException e) {
                System.out.println(e.getMessage());
            } catch (Exception e){
                e.printStackTrace();
            }
        }

        if(command.equals("CALC") || (command.equals("TYPE") && param.equals("C300"))) {
            try {
                CarUtil.sortDopParam(buses);
            } catch (CarException e) {
                System.out.println(e.getMessage());
            }
        }

        if(command.equals("CALC") || (command.equals("TYPE") && param.equals("C400"))) {
            CarUtil.sortDistance(cranes);
        }


    }

    public static boolean checkCarFormat(String car) throws CarException{
        if(car.matches("C[1|2|3|4]00_\\d*-\\d*(-\\d*){0,1}")) {
            return true;
        } else {
            throw new CarException("ERR100");
        }
    }
}
