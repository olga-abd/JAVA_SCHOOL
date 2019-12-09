import java.util.ArrayList;
import java.util.HashMap;

public class GSM {
    public static void main (String[] args) {
        String[] cars = {"eee","C100_1-100", "C200_1-120-1200", "C300_1-120-30", "C400_1-80-20", "C100_2-50", "C200_2-40-1000", "C300_2-200-45", "C400_2-10-20",
                "C100_3-10", "C200_3-170-1100", "C300_3-150-29", "C400_3-100-28", "C100_1-300", "C200_1-100-750", "C300_1-32-15",};


        // преданализ массива

        int carCode;
        StringBuffer carNumber = new StringBuffer(); // для проверки номера автомобиля. Будет хранится часть строки С100_1  тип_номер
        int passCarCnt = 0; // для подсчета легковых авто
        int truckCarCnt = 0;   // для подсчета грузовых авто
        int busCnt = 0; // для подсчета пассажирского транспорта
        int craneCnt = 0; // для подсчета кранов

        double[] gsm = new double[5]; // для каждого типа авто значение в своем индексе + общая сумма

        ArrayList<Car> passangersCars = new ArrayList<>();
        ArrayList<Car> truckCars = new ArrayList<>();
        ArrayList<Car> buses = new ArrayList<>();
        ArrayList<Car> cranes = new ArrayList<>();


         // посчитали кол-во транспорта разного типа, создаем массивы
        //PassangersCar[] passCars = new PassangersCar[passCarCnt];
        //TruckCar[] truckCars = new TruckCar[truckCarCnt];
        //Bus[] buses = new Bus[busCnt];
        //Crane[] cranes = new Crane[craneCnt];
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
                System.out.println("Ошибка на строке: " + car);
                return;
            }
            switch (carCode) {
                case 100:
                {
                    tempCar = new PassangersCar(tempObject);
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

                    tempCar = new TruckCar(tempObject);
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

                    tempCar = new Bus(tempObject);
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

                    tempCar = new Crane(tempObject);
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

        System.out.println("Общая стоимость расходов ГСМ: " + gsm[gsm.length - 1]);
        System.out.println("Расход ГСМ по легковым авто: " + gsm[0]);
        System.out.println("Расход ГСМ по грузовым авто: " + gsm[1]);
        System.out.println("Расход ГСМ по пассажирскому транспорту: " + gsm[2]);
        System.out.println("Расход ГСМ по тяжелой технике: " + gsm[3]);

        System.out.println("Наименьшую стоимость ГСМ имеет тип авто: " + CarUtil.minCost(gsm));
        System.out.println("Наибольшую стоимость ГСМ имеет тип авто: " + CarUtil.maxCost(gsm));

        // выводим детальную инфу с сортировкой
        try {
            CarUtil.sortDopParam(passangersCars);
        } catch (CarException e) {
            System.out.println(e.getMessage());
        }
        try {
            CarUtil.sortDopParam(truckCars);
        } catch (CarException e) {
            System.out.println(e.getMessage());
        }
        try {
            CarUtil.sortDopParam(buses);
        } catch (CarException e) {
            System.out.println(e.getMessage());
        }

         CarUtil.sortDistance(cranes);


    }
}
