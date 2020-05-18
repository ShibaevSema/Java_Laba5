package semashibaev.ifmo.cmd;

public class Exit extends Command {
    public Exit(Cmd cmd) {
        super(cmd);
        helpInfo = "Stops program";
    }

    @Override
    public void run() {
        cmd.stop();
    }

    @Override
    protected void checkArgs() throws Exception {
        if (!this.args.isEmpty()) {
            throw new Exception("Too many arguments");
        }
    }
}
