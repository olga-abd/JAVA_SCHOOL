import java.io.IOException;
import java.security.cert.CertificateRevokedException;
import java.util.List;

public interface ICarWR  {
    public void writeCar (Object obj) throws IOException;
    public List<String> readCar() throws IOException, CarException;
}
