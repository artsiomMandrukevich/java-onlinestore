package by.artem.store.middleware;

import by.artem.store.Store;
import by.artem.store.helper.SQLHelper;

public class TopMiddleware extends Middleware{

    Store store;
    SQLHelper sqlHelper = new SQLHelper();

    public TopMiddleware(Store store) {
        this.store = store;
    }

    public boolean check(String consoleCommand) {
        if(consoleCommand.toUpperCase().equals(CommandValues.TOP.toString())){
            sqlHelper.selectTop5FromProductTable();
            return false;
        }
        return checkNext(consoleCommand);
    }

}
