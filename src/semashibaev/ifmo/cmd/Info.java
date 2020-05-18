package semashibaev.ifmo.cmd;

import java.time.LocalDateTime;

public class Info extends Command {

        public Info(Cmd cmd) {
        super(cmd);
        this.helpInfo = "Prints all information about Movie collection";
        }

@Override

public void run() {
        int length = cmd.struct.size();
        LocalDateTime DateInitialization = cmd.struct.getLast().getCreationDate();
        this.cmd.sink.println(" Linked List is type, "+ length + " elements, " + DateInitialization  );
        }

@Override
protected void checkArgs() throws Exception {
        if (this.args.size() != 0)
        throw new Exception("Too many arguments");
        }
        }
