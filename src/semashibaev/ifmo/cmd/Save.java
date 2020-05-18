package semashibaev.ifmo.cmd;

import semashibaev.ifmo.struct.Struct;
import semashibaev.ifmo.struct.csv.CSVSerializer;

import java.nio.file.Files;

public class Save extends Command {
    public Save(Cmd cmd) {
        super(cmd);
        this.helpInfo = "Saves a collection into database";
    }

    @Override
    public void run() throws Exception {
        Files.write(Struct.dbFileName, CSVSerializer.serialize(this.cmd.struct));
        boolean iswrite = Files.isWritable(Struct.dbFileName);
        if (!iswrite)
            System.err.println("FIle not is Writable");
    }

    @Override
    protected void checkArgs() throws Exception {
        if (this.args.size() != 0)
            throw new Exception("Too many arguments");
    }
}