import javax.swing.text.Caret;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CarWR implements ICarWR {
    private final String FILENAME = ".\\carFile.txt";

    @Override
    public void writeCar(Object obj) throws IOException {
        Path path = Paths.get(FILENAME);
        StringBuffer putString = new StringBuffer();

        SimpleDateFormat sdp = new SimpleDateFormat("yyyy-MM-dd"); // для удобной записи даты

        /*String putString = sdp.format(new Date()) + "\t"; // в первой колонке будет дата
        // дальше авто по привычной строке
        putString += ((Car)obj).carType + "_" + ((Car)obj).carNumber + "-" + ((Car)obj).distance;
        if (!((Car)obj).carType.equals("C100")) putString += "-" + ((Car)obj).dopParam;
        putString += "\r\n"; // перенос строки*/

        for (Car car : (List<Car>) obj) {
            putString.append(car.dt + "\t" + car.carType + "_" + car.carNumber + "-" + car.distance);
            if(!car.carType.equals("C100")) putString.append("-" + car.dopParam);
            putString.append("\r\n");
        }


        Files.deleteIfExists(path); // пересоздаем файл
        Files.createFile(path);
        Files.write(path, new String(putString).getBytes()); // записываем
    }

    @Override
    public List<String> readCar() throws IOException, CarException {
        Path path = Paths.get(FILENAME);

        List<String> list = new ArrayList<>();

        if (Files.notExists(path)) throw new CarException("ERR4", FILENAME);
        list = Files.readAllLines(path);

        return list;
    }
}
