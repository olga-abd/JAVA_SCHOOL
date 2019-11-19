public class ExtendedCar extends Car {
    protected double dopParam;

    public ExtendedCar(TempObject tempObject){
        super(tempObject);
        dopParam = tempObject.dopParam;
    }

    public void printCar () {
        super.printCar();
    }

    public void addDopParam(double newValue){
        dopParam += newValue;
    }
}
