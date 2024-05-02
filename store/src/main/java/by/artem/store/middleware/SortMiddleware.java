package by.artem.store.middleware;

import by.artem.store.Store;
import by.artem.store.helper.SQLHelper;

public class SortMiddleware extends Middleware{

    Store store;
    SQLHelper sqlHelper = new SQLHelper();

    public SortMiddleware(Store store) {
        this.store = store;
    }

    public boolean check(String consoleCommand) {
        if(consoleCommand.toUpperCase().equals(CommandValues.SORT.toString())){
            sqlHelper.selectSortFromProductTable();
            return false;
        }
        return checkNext(consoleCommand);
    }
}
