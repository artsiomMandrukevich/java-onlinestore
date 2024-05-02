package by.artem.store.middleware;

import by.artem.store.Store;

public class SortMiddleware extends Middleware{

    Store store;

    public SortMiddleware(Store store) {
        this.store = store;
    }

    public boolean check(String consoleCommand) {
        if(consoleCommand.toUpperCase().equals(CommandValues.SORT.toString())){
            store.printSortProducts();
            return false;
        }
        return checkNext(consoleCommand);
    }

}
