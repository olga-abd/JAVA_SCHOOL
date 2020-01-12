import java.io.IOException;
import java.util.List;

public interface ICarParamR {
    public List<String> readCarParams() throws IOException, CarException;
}
