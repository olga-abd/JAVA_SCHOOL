import java.text.SimpleDateFormat;
import java.util.Date;

public class Logger {
    protected Date date;
    protected String command;
    protected String user;

    public Logger (Date date, String command, String user) {
        this.date = date;
        this.command = command;
        this.user = user;
    }

    public String getLog () {
        SimpleDateFormat sdp = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        return sdp.format(date) + "\t" + user + "\t" + command + "\r\n";
    }
}
