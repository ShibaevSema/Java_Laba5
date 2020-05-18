package semashibaev.ifmo.struct;

import semashibaev.ifmo.struct.substruct.Coordinates;
import semashibaev.ifmo.struct.substruct.MpaaRating;
import semashibaev.ifmo.struct.substruct.Person;

import java.io.PrintStream;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

import static java.lang.Double.compare;
import static java.lang.Double.longBitsToDouble;

public class Movie implements Comparable<Movie> {
    private static int incrementId = 1;
    private Long id; //Поле не может быть null, Значение поля должно быть больше 0, Значение этого поля должно быть уникальным, Значение этого поля должно генерироваться автоматически
    private String name; //Поле не может быть null, Строка не может быть пустой
    private Coordinates coordinates; //Поле не может быть null
    private LocalDateTime creationDate; //Поле не может быть null, Значение этого поля должно генерироваться автоматически
    private Integer oscarsCount; //Значение поля должно быть больше 0, Поле может быть null
    private Integer goldenPalmCount; //Значение поля должно быть больше 0, Поле может быть null
    private double totalBoxOffice; //Значение поля должно быть больше 0, Поле не может быть null
    private MpaaRating mpaaRating; //Поле может быть null
    private Person screenwriter; //Поле может быть null

    public Movie(String name, String oscarsCount, String goldenPalmCount,String totalBoxOffice, String coordX, String coordY) throws Exception {
        setName(name);
        setGoldenPalmCount(goldenPalmCount);
        setOscarsCount(oscarsCount);
        setTotalBoxOffice(totalBoxOffice);
        setCoordinates(coordX, coordY);

        this.creationDate = LocalDateTime.now();
        this.id = Long.valueOf(incrementId++);
    }




    @Override
    public int compareTo(Movie movie) {

        int result = -this.name.compareTo(movie.name);

        if (result == 0)
            result = -this.oscarsCount.compareTo(movie.oscarsCount);

        if (result == 0)
            result = -this.goldenPalmCount.compareTo(movie.goldenPalmCount);

        if (result == 0)
            result = -Double.compare(this.totalBoxOffice, movie.totalBoxOffice);
        return result;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) throws Exception {
        if (name == null || name.isEmpty())
            throw new Exception("Invalid name");
        this.name = name;
    }

    public Coordinates getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(String coordinatesX, String coordinatesY) throws Exception {
        if (coordinatesX.equals("") || coordinatesY.equals(""))
            this.coordinates = null;
        try {
            long coordX = Long.parseLong(coordinatesX);
            long coordY = Long.parseLong(coordinatesY);
            this.coordinates = new Coordinates(coordX, coordY);
        } catch (Exception e) {
            throw new Exception("Invalid coordinates format\n" + e.getMessage());
        }
    }

    public LocalDateTime getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(String creationDate) throws Exception {
        try {
            this.creationDate = LocalDateTime.parse(creationDate);
        } catch (Exception e) {
            throw new Exception("Invalid datetime format\n" + e.getMessage());
        }
    }

    public Integer getOscarssCount() {
        return oscarsCount;
    }
    public Integer getGoldenPalmCount() {
        return goldenPalmCount;
    }
    public Double getTotalBoxOffice() {
        return totalBoxOffice;
    }
    public void setOscarsCount(String oscarsCount) throws Exception {
        try {
            Integer num = Integer.parseInt(oscarsCount);
            if (num <= 0)
                throw new Exception("Invalid oscarsCount (must be > 0)");

            this.oscarsCount = num;

        } catch (Exception e) {
            throw new Exception("Invalid oscarsCount format\n" + e.getMessage());
        }

    }
    public void setGoldenPalmCount(String goldenPalmCount) throws Exception {
        try {
            Integer num = Integer.parseInt(goldenPalmCount);
            if (num <= 0)
                throw new Exception("Invalid goldenPalmCount (must be > 0)");

            this.goldenPalmCount = num;

        } catch (Exception e) {
            throw new Exception("Invalid goldenPalmCount format\n" + e.getMessage());
        }


    }


    public void setTotalBoxOffice(String totalBoxOffice) throws Exception {
        try {
            if (totalBoxOffice.length() > 15) throw new Exception("Invalid totalBoxOffice(too many too many numbers) ");
        Double num = Double.parseDouble(totalBoxOffice);
        if (num <= 0)
        throw new Exception("Invalid totalBoxOffice (must be > 0)");

        this.totalBoxOffice = num;

        } catch (Exception e) {
        throw new Exception("Invalid totalBoxOffice format\n" + e.getMessage());
        }


}
    public MpaaRating getmpaaRating(){
        return mpaaRating;
        }

    public void setMpaaRating(String mpaaRating) throws Exception {
        if (mpaaRating.equals(""))
            this.mpaaRating = null;
        else {
            this.mpaaRating = MpaaRating.fromString(mpaaRating);
        }
    }

    public Person getPerson(){
        return screenwriter;
        }

    public void setPerson(String screenwriter) {
        if (screenwriter.equals(""))
            this.screenwriter = null;
        else
            this.screenwriter = new Person(screenwriter);
    }

    @Override
    public String toString(){
        return"Movie{"+
        "id="+id+
        ", name='"+name+'\''+
        ", coordinates="+coordinates+
        ", creationDate="+creationDate.format(DateTimeFormatter.ofPattern("dd/MMM/yyyy"))+
        ", oscarsCount="+oscarsCount+
        ", goldenPalmCount="+goldenPalmCount+
                ",totalBoxOffice ="+totalBoxOffice+
                ", mpaaRating="+mpaaRating+
                ", screenwriter="+screenwriter+
        '}';
        }
}


