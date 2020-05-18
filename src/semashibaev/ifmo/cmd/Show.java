package semashibaev.ifmo.cmd;


public class Show extends Command {
    public Show(Cmd cmd) {
        super(cmd);
        this.helpInfo = "Prints all Movie elements in collection";
    }

    @Override
    public void run() {
        this.cmd.struct.forEach(this.cmd.sink::println);
    }

    @Override
    protected void checkArgs() throws Exception {
        if (this.args.size() != 0)
            throw new Exception("Too many arguments");
    }
}
