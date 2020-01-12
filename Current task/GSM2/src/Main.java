import java.io.IOException;
import java.text.ParseException;
import java.util.Date;
import java.util.Scanner;

public class Main {
    public static void main (String[] args){
        LogW logW = new LogW();
        MainCar mainCar = new MainCar();
        if(!mainCar.init()) {
            System.out.println("что-то пошло не так");
            return;
        }
        Scanner scanner = new Scanner(System.in);
        System.out.println("!!! После каждой команды вводите Enter!!!");
        System.out.print("Имя пользователя: ");
        String user = scanner.next().toUpperCase();
        System.out.print ("Введите команду (ADD/TYPE/CALC/LOG): ");
        String command = scanner.next().toUpperCase();
        switch (command) {
            case "ADD":
            {
                System.out.print("Введите строку с авто в формате C100_1-100 / C200_2-200-3: ");
                String auto = scanner.next().toUpperCase();
                try {
                    logW.write(new Logger(new Date(), command + " " + auto, user));
                } catch (Exception e) {
                    e.printStackTrace();
                }
                mainCar.add(auto);
                break;
            }
            case "TYPE":
            {
                System.out.print("Введите тип авто (C100/C200/C300/C400): ");
                String type = scanner.next().toUpperCase();
                try {
                    logW.write(new Logger(new Date(), command + " " + type, user));
                } catch (Exception e) {
                    e.printStackTrace();
                }
                mainCar.type(type);
                break;
            }
            case "CALC":
            {
                try {
                    logW.write(new Logger (new Date(), command, user));
                } catch (Exception e) {
                    e.printStackTrace();
                }
                mainCar.calc();
                break;
            }
            case "LOG":
            {
                try {
                    logW.write(new Logger(new Date(),"LOG", user));
                } catch (Exception e) {
                    e.printStackTrace();
                }
                System.out.print("За какую дату вывести лог (формат YYYY-MM-DD или ALL): ");
                String dt = scanner.next().toUpperCase();
                if (!dt.equals("ALL") && !dt.matches("\\d{4}-\\d{2}-\\d{2}")){
                    System.out.println("Неверный формат даты");
                    return;
                }
                System.out.print("По какому пользователю вывести лог (username или ALL): ");
                try {
                    LoggerUtils.outputLogs(dt, scanner.next().toUpperCase());
                } catch (ParseException e) {
                    System.out.println("Ошибка преобразования даты");
                    return;
                } catch (IOException e) {
                    e.printStackTrace();
                    return;
                } catch (Exception e) {
                    System.out.println("Непредвиденная ошибка");
                    return;
                }
                break;
            }
            default:
            {
                System.out.println("Введена неверная команда");
                break;
            }
        }
    }
}
