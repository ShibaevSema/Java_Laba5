package semashibaev.ifmo.cmd;

import semashibaev.ifmo.struct.Movie;
import semashibaev.ifmo.struct.csv.MovieReader;

public class UpdateID extends Command {
    public UpdateID(Cmd cmd) {
        super(cmd);
        this.helpInfo = "Rewrites a Movie element by <id>";
    }

    @Override
    public void run() throws Exception {
        int id = Integer.parseInt(this.args.get(0));
        Movie movie = this.cmd.struct.stream().filter(mb -> mb.getId() == id).findFirst().orElse(null);

        if (movie == null)
            throw new Exception(String.format("Can not find object with id: %d", id));

        Movie newM = MovieReader.read(this.cmd.scanner, this.cmd.sink);

        this.cmd.struct.remove(movie);
        this.cmd.struct.addFirst(newM);
    }

    @Override
    protected void checkArgs() throws Exception {
        if (this.args.size() != 1)
            throw new Exception("Invalid arguments");
        try {
            Integer.parseInt(args.get(0));
        } catch (Exception e) {
            throw new Exception("Invalid id format\n" + e.getMessage());
        }
    }
}
