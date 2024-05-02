package by.artem.store.middleware;

import by.artem.store.Store;
import by.artem.store.http.HTTPHelper;

public class TopMiddleware extends Middleware{

    Store store;
    HTTPHelper httpHelper = new HTTPHelper();

    public TopMiddleware(Store store) {
        this.store = store;
    }

    public boolean check(String consoleCommand) {
        if(consoleCommand.toUpperCase().equals(CommandValues.TOP.toString())){
            httpHelper.httpClientHitEndpoint("/get-top-products");
            return false;
        }
        return checkNext(consoleCommand);
    }

}
