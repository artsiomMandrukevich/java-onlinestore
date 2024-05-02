package by.artem.store.middleware;


import by.artem.store.http.HTTPHelper;
import by.artem.store.Store;

public class CreateOrderMiddleware extends Middleware{

    Store store;
    HTTPHelper httpHelper = new HTTPHelper();

    public CreateOrderMiddleware(Store store) {
        this.store = store;
    }

    public boolean check(String consoleCommand) {
        if(consoleCommand.toUpperCase().equals(CommandValues.CREATE_RANDOM_PURCHASE.toString())){
            httpHelper.httpClientHitEndpoint("/create-random-purchase");
            return false;
        }
        return checkNext(consoleCommand);
    }

}
