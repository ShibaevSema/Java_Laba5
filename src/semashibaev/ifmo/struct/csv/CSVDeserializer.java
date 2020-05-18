package semashibaev.ifmo.struct.csv;

import semashibaev.ifmo.struct.Movie;
import semashibaev.ifmo.struct.Struct;

import java.util.Arrays;
import java.util.List;


public class CSVDeserializer {
    public static Struct deserialize(String rawData) throws Exception {
        Struct struct = new Struct();
        List<String> objects = Arrays.asList(rawData.split("\n"));

        if (objects.size() == 0)
            return struct;

        String header = objects.get(0);

        if (!CSVSerializer.header.equals(header)) {
            throw new Exception("Invalid CSV format");
        }

        for (String line : objects) {
            if (line.equals("") || header.equals(line))
                continue;

            List<String> params = Arrays.asList(line.split(";", -1));
            if (params.size() != CSVSerializer.header.split(";").length)
                throw new Exception("Invalid CSV format");

            String name = params.get(0);
            String coordX = params.get(1);
            String coordY = params.get(2);
            String creationDate = params.get(3);
            String oscarsCount = params.get(4);
            String goldenPalmCount = params.get(5);
            String totalBoxOffice = params.get(6);
            String mpaaRating = params.get(7);
            String screenwriter = params.get(8);

            Movie m = new Movie( name,  oscarsCount, goldenPalmCount, totalBoxOffice, coordX, coordY );
            m.setCreationDate(creationDate);
            m.setMpaaRating(mpaaRating);
            m.setPerson(screenwriter);
            struct.addFirst(m);

        }
        return struct;
    }
}
