package semashibaev.ifmo.cmd;

public class RemoveFirst extends Command {
    public RemoveFirst(Cmd cmd) {
        super(cmd);
        this.helpInfo = "Removes the first Movie elements from the collection";
    }

    @Override
    public void run() {

                this.cmd.struct.removeFirst();

    }
    @Override
    protected void checkArgs() throws Exception {
        if (this.args.size() != 0)
            throw new Exception("Too many arguments");
    }
}