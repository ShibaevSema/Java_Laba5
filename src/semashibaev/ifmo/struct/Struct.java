package semashibaev.ifmo.struct;
        import semashibaev.ifmo.struct.csv.CSVDeserializer;

        import java.nio.file.Files;
        import java.nio.file.Path;
        import java.util.LinkedList;

public class Struct extends LinkedList<Movie> {
    public static Path dbFileName;
    public int lenght;

    public static Struct fromDatabase(Path db) throws Exception {
        dbFileName = db;
        String rawData = new String(Files.readAllBytes(dbFileName));
        return CSVDeserializer.deserialize(rawData);
    }

    @Override
    public String toString() {
        return "Struct{}";
    }
}