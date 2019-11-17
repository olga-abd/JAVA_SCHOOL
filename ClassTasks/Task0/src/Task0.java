import java.security.spec.PSSParameterSpec;

public class Task0 {
    public static void main (String[] args) {
        String[] cars = {"C100_1-100", "C200_1-120-1200", "C300_1-120-30", "C400_1-80-20", "C100_2-50", "C200_2-40-1000", "C300_2-200-45", "C400_2-10-20",
                "C100_3-10", "C200_3-170-1100", "C300_3-150-29", "C400_3-100-28", "C100_1-300", "C200_1-100-750", "C300_1-32-15",};


        // преданализ массива

        int carCode;
        int passCarCnt = 0; // для подсчета легковых авто
        int truckCarCnt = 0;   // для подсчета грузовых авто
        int busCnt = 0; // для подсчета пассажирского транспорта
        int craneCnt = 0; // для подсчета кранов

        double[] gsm = new double[5]; // для каждого типа авто значение в своем индексе + общая сумма

        for (String car : cars) {
            carCode = Integer.valueOf(car.substring(1,car.indexOf("_")));
            switch (carCode) {
                case 100:
                {
                    passCarCnt++;
                    break;
                }
                case 200:
                {
                    truckCarCnt++;
                    break;
                }
                case 300:
                {
                    busCnt++;
                    break;
                }
                case 400:
                {
                    craneCnt++;
                    break;
                }
            }
        }

        // посчитали кол-во транспорта разного типа, создаем массивы
        PassangersCar[] passCars = new PassangersCar[passCarCnt];
        TruckCar[] truckCars = new TruckCar[truckCarCnt];
        Bus[] buses = new Bus[busCnt];
        Crane[] cranes = new Crane[craneCnt];

        // считаем ГСМ
        for (String car : cars) {
            carCode = Integer.valueOf(car.substring(1,car.indexOf("_")));
            switch (carCode) {
                case 100:
                {
                    passCars[--passCarCnt] = new PassangersCar(car);
                    gsm[0] += CarUtil.calcGsv(passCars[passCarCnt]);
                    break;
                }
                case 200:
                {
                    truckCars[--truckCarCnt] = new TruckCar(car);
                    gsm[1] += CarUtil.calcGsv(truckCars[truckCarCnt]);
                    break;
                }
                case 300:
                {
                    buses[--busCnt] = new Bus(car);
                    gsm[2] += CarUtil.calcGsv(buses[busCnt]);
                    break;
                }
                case 400:
                {
                    cranes[--craneCnt] = new Crane(car);
                    gsm[3] += CarUtil.calcGsv(cranes[craneCnt]);
                    break;
                }
            }
        }
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
        for (PassangersCar car : CarUtil.sort(passCars, 1)) {
            car.printCar();
        }
        System.out.println("*****");
        for (TruckCar car : CarUtil.sort(truckCars,2)) {
            car.printCar();
        }
        System.out.println("*****");
        for (Bus car : CarUtil.sort(buses, 2)) {
            car.printCar();
        }
        System.out.println("*****");
        for (Crane car : CarUtil.sort(cranes,1)) {
            car.printCar();
        }
        System.out.println("*****");
    }
}
