package semashibaev.ifmo.struct.csv;

import semashibaev.ifmo.struct.Movie;
import semashibaev.ifmo.struct.substruct.MpaaRating;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
public class  MovieReader {
    public static Movie read(Scanner scanner, PrintStream sink) throws Exception {

        Movie movieI = new Movie("I", "1",
                "1", "1","0","0" );

        while (true) {
            sink.println("Enter <name>;<oscars_count>;<golden_palm_count>;<total_box_office>:");
            List<String> firstParams = Arrays.asList(scanner.nextLine().split(";", -1));
            if (firstParams.size() != 4) {
                sink.println("Illegal number of arguments (try again)");
                continue;
            }
            try {
                movieI.setName(firstParams.get(0));
                movieI.setOscarsCount(firstParams.get(1));
                movieI.setGoldenPalmCount(firstParams.get(2));
                movieI.setTotalBoxOffice(firstParams.get(3));
            } catch (Exception e) {
                sink.println("Illegal arguments (try again)\n" + e.getMessage());
                continue;
            }
            break;
        }
        while (true) {
            sink.println("Enter coordinates like <x>;<y> :");
            List<String> coordinates = Arrays.asList(scanner.nextLine().split(";", -1));
            if (coordinates.size() != 2) {
                sink.println("Illegal number of arguments (try again)");
                continue;
            }
            try {
                movieI.setCoordinates(coordinates.get(0), coordinates.get(1));
            } catch (Exception e) {
                sink.println("Illegal arguments (try again)\n" + e.getMessage());
                continue;
            }
            break;
        }
        while (true) {
            sink.println("Enter person like <person_name> :");
            List<String> screenwriter = Arrays.asList(scanner.nextLine().split(";", -1));
            if (screenwriter.size() != 1) {
                sink.println("Illegal number of arguments (try again)");
                continue;
            }
            try {
                movieI.setPerson(screenwriter.get(0));
            } catch (Exception e) {
                sink.println("Illegal arguments (try again)\n" + e.getMessage());
                continue;
            }
            break;
        }

        while (true) {
            sink.println("Enter mpaa rating like <mpas_rating> :");
            sink.println("Mpaa Rating :");
            Arrays.asList(MpaaRating.values()).forEach(sink::println);

            List<String> mpaaRating = Arrays.asList(scanner.nextLine().split(";", -1));

            if (mpaaRating.size() != 1) {
                sink.println("Illegal number of arguments (try again)");
                continue;
            }
            try {
                movieI.setMpaaRating(mpaaRating.get(0));
            } catch (Exception e) {
                sink.println("Illegal arguments (try again)\n" + e.getMessage());
                continue;
            }
            break;
        }
        return movieI;
    }
}
