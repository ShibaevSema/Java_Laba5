package semashibaev.ifmo.cmd;

import semashibaev.ifmo.struct.Movie;
import semashibaev.ifmo.struct.csv.MovieReader;

public class RemoveLower extends Command {
    public RemoveLower(Cmd cmd) {
        super(cmd);
        this.helpInfo = "Removes the lower Movie elements from the collection";
    }

    @Override
    public void run() throws Exception {
        Movie m = MovieReader.read(this.cmd.scanner, this.cmd.sink);

        this.cmd.struct.stream()
                .filter(movie -> movie.compareTo(m) < 0)
                .forEach(this.cmd.struct::remove);
    }

    @Override
    protected void checkArgs() throws Exception {
        if (this.args.size() != 0)
            throw new Exception("Too many arguments");
    }
}
