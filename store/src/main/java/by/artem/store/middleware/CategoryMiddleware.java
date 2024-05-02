package by.artem.store.middleware;

import by.artem.store.Store;
import by.artem.store.http.HTTPHelper;

public class CategoryMiddleware extends Middleware{

    Store store;
    HTTPHelper httpHelper = new HTTPHelper();

    public CategoryMiddleware(Store store) {
        this.store = store;
    }

    public boolean check(String consoleCommand) {
        if(consoleCommand.toUpperCase().equals(CommandValues.CATEGORY.toString())){
            httpHelper.httpClientHitEndpoint("/get-category");
            return false;
        }
        return checkNext(consoleCommand);
    }
}