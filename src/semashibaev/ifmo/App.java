package semashibaev.ifmo;

import semashibaev.ifmo.cmd.Cmd;
import semashibaev.ifmo.struct.Struct;

import java.nio.file.Path;
import java.nio.file.Paths;

final class App {
    private Cmd cmd;
    private Struct struct;
    private Path dbPath;

    App(String[] args) {
        if (args.length > 0)
            dbPath = Paths.get(args[0]);
        else {
            System.err.println("Set the path to db file");
            System.exit(1);
        }
    }

    int exec() {
        try {
            struct = Struct.fromDatabase(dbPath);
        } catch (Exception e) {
            System.err.println("Cannot read db file\n" + e.getMessage());
            return 1;
        }

        cmd = new Cmd(System.in, System.out, this.struct, 0);

        try {
            cmd.start();
        } catch (Exception e) {
            System.err.println(e.getMessage());
            return 1;
        }

        return 0;
    }
}
