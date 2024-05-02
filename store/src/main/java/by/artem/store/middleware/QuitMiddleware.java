package by.artem.store.middleware;

public class QuitMiddleware extends Middleware{

    public boolean check(String consoleCommand) {
        if(consoleCommand.toUpperCase().equals(CommandValues.QUIT.toString())){
            System.out.println("!!!! EXIT !!!");
            return true;
        }
        return checkNext(consoleCommand);
    }

}
