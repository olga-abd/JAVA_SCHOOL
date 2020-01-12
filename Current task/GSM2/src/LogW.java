import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class LogW implements ILogW {
    private final String FILENAME = ".\\log.txt";

    @Override
    public void write(Logger logger) throws IOException {
        Path path = Paths.get(FILENAME);

        if (Files.notExists(path)) Files.createFile(path);

        Files.write(path, logger.getLog().getBytes(), StandardOpenOption.APPEND);
    }
}
