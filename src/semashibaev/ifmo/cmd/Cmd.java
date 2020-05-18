package semashibaev.ifmo.cmd;

import semashibaev.ifmo.cmd.*;
import semashibaev.ifmo.struct.Struct;

import java.io.InputStream;
import java.io.PrintStream;
import java.util.*;

public class Cmd {
    public final LinkedHashMap<String, Command> commands = new LinkedHashMap<>();
    public final Struct struct;
    public final Scanner scanner;
    public final PrintStream sink;
    private boolean stop = false;
    public int depth;

    public Cmd(InputStream source, PrintStream sink, Struct struct, int depth) {
        this.struct = struct;
        this.scanner = new Scanner(source);
        this.sink = sink;
        this.depth = depth;

        commands.put("exit", new Exit(this));
        commands.put("help", new Help(this));
        commands.put("add", new Add(this));
        commands.put("clear", new Clear(this));
        commands.put("execute_script", new ExecuteScript(this));
        commands.put("info", new Info(this));
        commands.put("filter_starts_with_name", new FilterStartsWithName(this));
        commands.put("print_unique_mpaa_rating", new PrintUniqueMpaaRating(this));
        commands.put("remove_lower", new RemoveLower(this));
        commands.put("remove_all_by_golden_palm_count", new RemoveAllByGoldenPalmCount(this));
        commands.put("remove_first", new RemoveFirst(this));
        commands.put("remove_greater", new RemoveGreater(this));
        commands.put("save", new Save(this));
        commands.put("show", new Show(this));
        commands.put("update", new UpdateID(this));
        commands.put("remove_by_id", new RemoveById(this));

    }


    public void start() throws Exception {
        if (this.depth > 2)
            throw new Exception("Recursion limit");

        while (!stop) {
            sink.print(">> ");
            if (!scanner.hasNextLine())
                break;

            StringTokenizer tokenizer = new StringTokenizer(scanner.nextLine(), " ");

            if (!tokenizer.hasMoreTokens())
                continue;

            String command = tokenizer.nextToken();

            LinkedList<String> args = new LinkedList<>();

            while (tokenizer.hasMoreTokens())
                args.add(tokenizer.nextToken());

            if (commands.containsKey(command)) {
                Command c = commands.get(command);
                try {
                    c.setArgs(args);
                    c.execute();
                } catch (Exception e) {
                    sink.println(e.getMessage());
                    sink.println(c.getHelpInfo());
                }
            } else {
                sink.println("Unknown command, use help");
            }


        }


    }
            public void stop() {
            this.stop = true;
    }
}
