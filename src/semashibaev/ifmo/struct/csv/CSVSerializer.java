package semashibaev.ifmo.struct.csv;

import semashibaev.ifmo.struct.Movie;
import semashibaev.ifmo.struct.Struct;

public class CSVSerializer {


    static final String header = "name;coord_x;coord_y;creation_date;oscars_count;golden_palm_count;total_box_office;mpaa_rating;screenwriter";

    public static byte[] serialize(Struct struct) {
        StringBuilder data = new StringBuilder();
        data.append(header).append("\n");

        for (Movie m : struct) {
            data.append(m.getName()).append(';');

            data.append(m.getCoordinates().getX()).append(';');
            data.append(m.getCoordinates().getY()).append(';');

            data.append(m.getCreationDate().toString()).append(';');
            data.append(m.getOscarssCount()).append(';');
            data.append(m.getGoldenPalmCount()).append(';');
            data.append(m.getTotalBoxOffice()).append(';');

            if (m.getmpaaRating() != null)
                data.append(m.getmpaaRating().toString());
            data.append(';');

            if (m.getPerson() != null)
                data.append(m.getPerson().getName());

            data.append('\n');
        }
        return data.toString().getBytes();
    }
}
