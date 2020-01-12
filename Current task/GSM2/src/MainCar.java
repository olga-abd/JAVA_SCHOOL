import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MainCar {
    protected List<Car> carList = new ArrayList<>();
    protected List<CarParams> carParamsList = new ArrayList<>();
    protected CarWR carWR = new CarWR();
    protected CarParamR carParamR = new CarParamR();

    private void initCarParams() throws IOException, CarException {
        List<String> list = carParamR.readCarParams();
        //System.out.println(list);

        StringBuffer carType;
        double fuelType;
        double fuelCons;
        for (String s : list) {
            carType = new StringBuffer(s.split("\t")[0]);

            try {
                Double.parseDouble(s.split("\t")[1]);
                Double.parseDouble(s.split("\t")[2]);
            }
            catch (NumberFormatException e){
                throw new CarException("ERR1");
            }
            catch (ArrayIndexOutOfBoundsException e){
                throw new CarException("ERR2");
            }
            catch (Exception e) {
                throw new CarException("ERR0");
            }


            fuelType = Double.valueOf(s.split("\t")[1]);
            fuelCons = Double.valueOf(s.split("\t")[2]);

            carParamsList.add(new CarParams(new String(carType), fuelType, fuelCons));
        }

        if (carParamsList.size() == 0) System.out.println ("нет информации о бензине");
    }

    private void initCars() throws IOException, CarException{
        List<String> stringList = carWR.readCar();
        String carType;
        String carNumber;
        double carDistance;
        double dopParam;
        double fuelType = 0;
        double fuelCons = 0;
        Car car;

        for (String s : stringList) {
            car = CarUtils.createCar(s,carParamsList);
            carList = CarUtils.equalCar(carList, car);
        }
    }

    public boolean init() {
        try {
            initCarParams();
        } catch (CarException e) {
            System.out.println(e.getMessage());
            return false;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }

        try {
            initCars();
        } catch (CarException e) {
            System.out.println(e.getMessage());
            //return false;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            //return false;
        }
        //System.out.println(carList);
        return true;
    }

    public void add (String s) {
        SimpleDateFormat sdp = new SimpleDateFormat("yyyy-MM-dd");
        try {
            String dt = sdp.format(new Date());
            Car car = CarUtils.createCar(dt + "\t" + s,carParamsList);
            carList = CarUtils.equalCar(carList,car);
            carWR.writeCar(carList);
        } catch (CarException | IOException e) {
            System.out.println(e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Непредвиденная ошибка");
        }
    }

    public void type (String tp) {
        try {
            CarUtils.gsm(carList, tp);
            CarUtils.sortCars(carList, tp);
        } catch (CarException e) {
            System.out.println(e.getMessage());
        }
    }

    public void calc () {
        type ("ALL");
    }
}
