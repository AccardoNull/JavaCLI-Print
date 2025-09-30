// File: SaaSquatchCli.java
import picocli.CommandLine;
import picocli.CommandLine.Command;
import picocli.CommandLine.Option;

import java.util.concurrent.Callable;

@Command(
    name = "saasquatch",
    mixinStandardHelpOptions = true,
    version = "saasquatch 1.0",
    description = "Prints the name 'SaaSquatch'."
)
public class SaaSquatchCli implements Callable<Integer> {

    @Option(
        names = {"-t", "--times"},
        description = "How many times to print.",
        defaultValue = "1"
    )
    int times;

    @Option(
        names = {"-u", "--upper"},
        description = "Print in UPPERCASE."
    )
    boolean upper;

    @Override
    public Integer call() {
        String name = upper ? "SAASQUATCH" : "SaaSquatch";
        for (int i = 0; i < times; i++) {
            System.out.println(name);
        }
        return 0;
    }

    public static void main(String[] args) {
        int exitCode = new CommandLine(new SaaSquatchCli()).execute(args);
        System.exit(exitCode);
    }
}
