package by.artem.store.middleware;

import by.artem.store.Store;
import by.artem.store.http.HTTPHelper;

public class SortMiddleware extends Middleware{

    Store store;
    HTTPHelper httpHelper = new HTTPHelper();

    public SortMiddleware(Store store) {
        this.store = store;
    }

    public boolean check(String consoleCommand) {
        if(consoleCommand.toUpperCase().equals(CommandValues.SORT.toString())){
            httpHelper.httpClientHitEndpoint("/get-sort-products");
            return false;
        }
        return checkNext(consoleCommand);
    }
}
