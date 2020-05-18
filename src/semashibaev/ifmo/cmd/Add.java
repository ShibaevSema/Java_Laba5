package semashibaev.ifmo.cmd;

import semashibaev.ifmo.struct.Movie;
import semashibaev.ifmo.struct.csv.*;

/**
 * Command used for simply adding element {@link semashibaev.ifmo.struct.Movie} to collection {@link semashibaev.ifmo.struct.Struct}
 */
public class Add extends Command {
    public Add(Cmd cmd) {
        super(cmd);
        this.helpInfo = "Add new Movie colection\n" +
                "\tfirst pass <name>;<oscars_count>;<golden_palm_count>;<total_box_office>\n" +
                "\tthen pass coordinates like <x>;<y>\n" +
                "\tthen pass <screenwriter>\n"+
                "\tmpaaRating could be empty";
    }

    @Override
    public void run() throws Exception {
        Movie movie = MovieReader.read(this.cmd.scanner, this.cmd.sink);
        this.cmd.struct.addFirst(movie);
    }

    @Override
    protected void checkArgs() throws Exception {
        if (this.args.size() != 0)
            throw new Exception("Too many arguments");
    }
}