public class ExtendedCar extends Car {
    protected double dopParam;

    public ExtendedCar(TempObject tempObject){
        super(tempObject);
        dopParam = tempObject.dopParam;
    }

    public void printCar () {
        String carType = new String();
        switch (carCode) {
            /*case 100:
            {
                carType = "Легковые авто";
                break;
            }*/
            case 200:
            {
                carType = "Грузовые авто";
                break;
            }
            case 300:
            {
                carType = "Пассажирский транспорт";
                break;
            }
            case 400:
            {
                carType = "Тяжелая техника";
                break;
            }
        }
        System.out.println("*****");
        System.out.println("Тип авто: " + carType);
        System.out.println("Номер: " + carNumber);
        System.out.println("Пробег: " + carDistance);
    }

    public void addDopParam(double newValue){
        dopParam += newValue;
    }
}
