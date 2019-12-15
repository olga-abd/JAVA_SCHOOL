import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Log {
    //protected Date dt = new Date();
    protected String dt_str;
    protected String user;
    protected String operation;
    private final String FILENAME = ".\\log.txt";
    private Path path;

    public Log ()  {
        path = Paths.get(FILENAME);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        dt_str = sdf.format(new Date());
        //
    }

    public void addLog (String user, String operation) throws IOException {
        this.user = user.toUpperCase();
        this.operation = operation;
        if(!Files.exists(path)) Files.createFile(path);
        Files.write(path, (dt_str + "\t" + user + "\t" + operation + "\r\n").getBytes(), StandardOpenOption.APPEND);
    }

    public void getUserLog (String usr) throws IOException{
        List<String> list = new ArrayList<>();

        list = Files.readAllLines(path);

        for (String line : list) {
            if (line.split("\t")[1].equals(usr)) {
                System.out.println(line);
            }
        }

    }

    public void getDateLog (String dt) throws IOException{
        List<String> list = new ArrayList<>();

        list = Files.readAllLines(path);

        for (String line : list) {
            if (line.split("\t")[0].substring(0,10).equals(dt)){
                System.out.println(line);
            }
        }
    }

    public void getAllLog () throws  IOException{
        List<String> list = new ArrayList<>();

        list = Files.readAllLines(path);

        for (String line : list) {
            System.out.println(line);
        }
    }
}
