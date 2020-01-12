import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class CarParamR implements ICarParamR {
    private final String FILEFUELTYPE = ".\\fuelTypes.txt";
    private final String FILEFUELCONSUMPTION = ".\\fuelConsumption.txt";

    @Override
    public List<String> readCarParams() throws IOException, CarException {
        Path pathFtype = Paths.get(FILEFUELTYPE); // получаем цену топлива
        if (Files.notExists(pathFtype)) throw new CarException("ERR4", FILEFUELTYPE);
        List<String> listFtype = Files.readAllLines(pathFtype);
        //System.out.println(listFtype);

        Path pathFcons = Paths.get(FILEFUELCONSUMPTION); // получаем расход
        if (Files.notExists(pathFcons)) throw new CarException("ERR4", FILEFUELCONSUMPTION);
        List<String> listFcons = Files.readAllLines(pathFcons);
        //ystem.out.println(listFcons);

        // Объединенный лист
        List<String> finalList = new ArrayList<>();

        String carType = new String();
        // пробегаем по первому листу
        for (String s : listFtype) {
            carType = s.split("\t")[0]; // определяем тип авто
            for (String f : listFcons){ // пробегаем по второму листу
                if(f.split("\t")[0].equals(carType)){ // если тип авто такой же
                    finalList.add(s + "\t" + f.split("\t")[1]); // то добавляем суммарную строчку в итоговый лист
                    break;
                }
            }
        }
        // формат строки: С100  48.9    0.12

        return finalList;
    }
}
