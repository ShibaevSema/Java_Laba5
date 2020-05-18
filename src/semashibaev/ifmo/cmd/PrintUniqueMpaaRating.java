package semashibaev.ifmo.cmd;

public class PrintUniqueMpaaRating extends Command {
    public PrintUniqueMpaaRating(Cmd cmd) {
        super(cmd);
        this.helpInfo = "Prints mpaa rating of all Movie elements in collection";
    }

    @Override
    public void run() {
        cmd.struct.forEach(movie -> movie.getmpaaRating());

    }

    @Override
    protected void checkArgs() throws Exception {
        if (this.args.size() != 0)
            throw new Exception("Too many arguments");
    }
}
