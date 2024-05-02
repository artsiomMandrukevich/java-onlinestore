package by.artem.store.middleware;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class UnknownMiddleware extends Middleware{

    List<String> commandvalues = Collections.singletonList(Arrays.toString(CommandValues.values()));

    public boolean check(String consoleCommand) {

        if (!commandvalues.contains(consoleCommand.toUpperCase())) {
            System.out.println("Oooops, somthenig went wrong. Try again.");
            return false;
        }
        return checkNext(consoleCommand);
    }
}
