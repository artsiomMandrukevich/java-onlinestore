package by.artem.store.middleware;

import by.artem.store.Store;
import by.artem.store.helper.SQLHelper;

public class PrintPurchasesMiddleware extends Middleware {

    Store store;
    SQLHelper sqlHelper = new SQLHelper();

    public PrintPurchasesMiddleware(Store store) {
        this.store = store;
    }

    public boolean check(String consoleCommand) {
        if (consoleCommand.toUpperCase().equals(CommandValues.PRINT_PURCHASES.toString())) {
            sqlHelper.selectFromPuchaseTable();
            return false;
        }
        return checkNext(consoleCommand);
    }
}
