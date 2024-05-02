package by.artem.store.middleware;


import by.artem.store.Store;
import by.artem.store.http.HTTPHelper;

public class ClearPurchasesMiddleware extends Middleware{

    Store store;
    HTTPHelper httpHelper = new HTTPHelper();

    public ClearPurchasesMiddleware(Store store) {
        this.store = store;
    }

    public boolean check(String consoleCommand) {
        if(consoleCommand.toUpperCase().equals(CommandValues.CLEAR_PURCHASES.toString())){
            httpHelper.httpClientHitEndpoint("/clear-purchases");
            return false;
        }
        return checkNext(consoleCommand);
    }
}
