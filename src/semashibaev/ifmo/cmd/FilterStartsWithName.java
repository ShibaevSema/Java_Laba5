package semashibaev.ifmo.cmd;

public class FilterStartsWithName extends Command {
    public FilterStartsWithName(Cmd cmd) {
        super(cmd);
        this.helpInfo = "Prints all Movie elements with name contains <substring>";
    }

    @Override
    public void run() {
        String subName = this.args.get(0);

        this.cmd.struct.stream()
                .filter(movie -> movie.getName().contains(subName))
                .forEach(this.cmd.sink::println);
    }

    @Override
    protected void checkArgs() throws Exception {
        if (this.args.size() != 1)
            throw new Exception("Invalid arguments");
    }
}
