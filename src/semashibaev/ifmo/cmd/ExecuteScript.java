package semashibaev.ifmo.cmd;

import java.io.FileInputStream;


public class ExecuteScript extends Command {
    public ExecuteScript(Cmd cmd) {
        super(cmd);
        this.helpInfo = "Interprets the script file passed as a parameter <file_path>";
    }

    @Override
    public void run() throws Exception {
        Cmd virtualCmd = new Cmd(new FileInputStream(this.args.get(0)), System.out, this.cmd.struct, this.cmd.depth + 1);
        virtualCmd.start();
    }

    @Override
    protected void checkArgs() throws Exception {
        if (this.args.size() != 1) {
            throw new Exception("Invalid arguments");
        }
    }
}