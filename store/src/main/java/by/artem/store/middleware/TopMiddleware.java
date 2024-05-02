package by.artem.store.middleware;


import by.artem.store.Store;

public class TopMiddleware extends Middleware{

    Store store;

    public TopMiddleware(Store store) {
        this.store = store;
    }

    public boolean check(String consoleCommand) {
        if(consoleCommand.toUpperCase().equals(CommandValues.TOP.toString())){
            store.printTopProducts();
            return false;
        }
        return checkNext(consoleCommand);
    }

}
