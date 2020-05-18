package semashibaev.ifmo.cmd;

/**
 * Simply removes all elements from the collection
 */
public class Clear extends Command {
    public Clear(Cmd cmd) {
        super(cmd);
        this.helpInfo = "Removes all Movie elements from collection";
    }

    @Override
    public void run() {
        this.cmd.struct.clear();
    }

    @Override
    protected void checkArgs() throws Exception {
        if (!this.args.isEmpty()) {
            throw new Exception("Too many arguments");
        }
    }
}