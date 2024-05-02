package by.artem.store.middleware;

import by.artem.store.Store;

public class PrintPurchasesMiddleware extends Middleware {

    Store store;

    public PrintPurchasesMiddleware(Store store) {
        this.store = store;
    }

    public boolean check(String consoleCommand) {
        if (consoleCommand.toUpperCase().equals(CommandValues.PRINT_PURCHASES.toString())) {
            store.printPurchaseCollection();
            return false;
        }
        return checkNext(consoleCommand);
    }
}
