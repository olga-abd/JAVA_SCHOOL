import org.omg.Messaging.SYNC_WITH_TRANSPORT;

import java.security.spec.PSSParameterSpec;

public class Task0 {
    public static void main (String[] args) {
        String[] cars = {"C100_1-100", "C200_1-120-1200", "C300_1-120-30", "C400_1-80-20", "C100_2-50", "C200_2-40-1000", "C300_2-200-45", "C400_2-10-20",
                "C100_3-10", "C200_3-170-1100", "C300_3-150-29", "C400_3-100-28", "C100_1-300", "C200_1-100-750", "C300_1-32-15",};


        // преданализ массива

        int carCode;
        StringBuffer carNumber = new StringBuffer(); // для проверки номера автомобиля. Будет хранится часть строки С100_1  тип_номер
        int passCarCnt = 0; // для подсчета легковых авто
        int truckCarCnt = 0;   // для подсчета грузовых авто
        int busCnt = 0; // для подсчета пассажирского транспорта
        int craneCnt = 0; // для подсчета кранов

        double[] gsm = new double[5]; // для каждого типа авто значение в своем индексе + общая сумма

        for (String car : cars) {
            carCode = Integer.valueOf(car.substring(1,car.indexOf("_"))); // тип авто

            // в carNumber через ; сохраняем посчитанные авто, чтобы исключить дубли
            if(carNumber.indexOf(car.substring(0,car.indexOf("-")) + ";") == -1) { // если не было такого тип_номер, то считаем
                carNumber.append(car.substring(0, car.indexOf("-")) + ";");
                switch (carCode) {
                    case 100: {
                        passCarCnt++;
                        break;
                    }
                    case 200: {
                        truckCarCnt++;
                        break;
                    }
                    case 300: {
                        busCnt++;
                        break;
                    }
                    case 400: {
                        craneCnt++;
                        break;
                    }
                }
            }
        }

        // посчитали кол-во транспорта разного типа, создаем массивы
        PassangersCar[] passCars = new PassangersCar[passCarCnt];
        TruckCar[] truckCars = new TruckCar[truckCarCnt];
        Bus[] buses = new Bus[busCnt];
        Crane[] cranes = new Crane[craneCnt];
        TempObject tempObject;
        int ind; // переменная, куда сохранится индекс массива при поиске

        // заполняем массивы
        for (String car : cars) {
            carCode = Integer.valueOf(car.substring(1,car.indexOf("_")));
            tempObject = new TempObject(car);
            switch (carCode) {
                case 100:
                {
                    // ищем индекс в массиве
                    ind = CarUtil.searchCar(passCars, tempObject);
                    if (ind == -1) { // если в массиве нет такой машины, то добавляем
                        passCars[--passCarCnt] = new PassangersCar(tempObject);
                    }
                    else {
                        // если в массиве есть машина, то суммируем дистанцию. для остальных машин еще доп параметры
                        passCars[ind].addDistance(tempObject.carDistance);
                    }
                    break;
                }
                case 200:
                {
                    ind = CarUtil.searchCar(truckCars, tempObject);
                    if (ind == -1) {
                        truckCars[--truckCarCnt] = new TruckCar(tempObject);
                    }
                    else {
                        truckCars[ind].addDistance(tempObject.carDistance);
                        truckCars[ind].addDopParam(tempObject.dopParam);
                    }
                    break;
                }
                case 300:
                {
                    ind = CarUtil.searchCar(buses, tempObject);
                    if (ind == -1) {
                        buses[--busCnt] = new Bus(tempObject);
                    }
                    else {
                        buses[ind].addDistance(tempObject.carDistance);
                        buses[ind].addDopParam(tempObject.dopParam);
                    }
                    break;
                }
                case 400:
                {
                    ind = CarUtil.searchCar(cranes, tempObject);
                    if(ind == -1) {
                        cranes[--craneCnt] = new Crane(tempObject);
                    }
                    else {
                        cranes[ind].addDistance(tempObject.carDistance);
                        cranes[ind].addDopParam(tempObject.dopParam);
                    }
                    break;
                }
            }
        }

        // считаем ГСМ
        gsm[0] = CarUtil.calcGsm2(passCars);
        gsm[1] = CarUtil.calcGsm2(truckCars);
        gsm[2] = CarUtil.calcGsm2(buses);
        gsm[3] = CarUtil.calcGsm2(cranes);
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
        CarUtil.sortDistance(passCars);
        CarUtil.sortDopParam(truckCars);
        CarUtil.sortDopParam(buses);
        CarUtil.sortDistance(cranes);


    }
}
