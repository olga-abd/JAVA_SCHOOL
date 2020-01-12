import javax.swing.filechooser.FileNameExtensionFilter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class LoggerUtils{
    private final static String FILENAME = ".\\log.txt";

    public static void outputLogs(String date, String user) throws IOException, ParseException {
        Path path = Paths.get(FILENAME);

        List<String> list = Files.readAllLines(path);

        for (String s : list) {

            Date dt  = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").parse(s.substring(0,s.indexOf("\t")));
            String usr = s.substring(s.indexOf("\t")+1, s.indexOf("\t",s.indexOf("\t")+1));
            String command = s.substring(s.indexOf("\t",s.indexOf("\t")+1)+1);

            SimpleDateFormat sdp = new SimpleDateFormat("yyyy-MM-dd");

            // если строка соответствует фильтру или = ALL, то выводим лог
            if ((usr.equals(user) || user.equals("ALL")) &&
                    (date.equals(sdp.format(dt)) || date.equals("ALL"))) {
                System.out.println(s);
            }
        }
    }


}
