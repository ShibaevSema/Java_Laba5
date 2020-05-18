package semashibaev.ifmo.cmd;

public class RemoveAllByGoldenPalmCount extends Command {
    public RemoveAllByGoldenPalmCount(Cmd cmd) {
        super(cmd);
        this.helpInfo = "Removes all Movie element with this <GoldenPalmCount> from collection";
    }

    @Override
    public void run() throws Exception {
        int goldenPalmCount = Integer.parseInt(args.get(0));
        this.cmd.struct.stream().filter(el -> el.getGoldenPalmCount() == goldenPalmCount).forEach(cmd.struct::remove);
    }

    @Override

    protected void checkArgs() throws Exception {
        if (this.args.size() != 1)
            throw new Exception("Invalid arguments");
        try {
            Integer.parseInt(args.get(0));
        } catch (Exception e) {
            throw new Exception("Invalid golden palm count format\n" + e.getMessage());
        }
    }
}


