package by.artem.store.middleware;

import by.artem.store.helper.SQLHelper;

public class QuitMiddleware extends Middleware{

    SQLHelper sqlHelper = new SQLHelper();

    public boolean check(String consoleCommand) {
        if(consoleCommand.toUpperCase().equals(CommandValues.QUIT.toString())){
            sqlHelper.closeSQLConnection();
            System.out.println("!!!! EXIT !!!");
            return true;
        }
        return checkNext(consoleCommand);
    }

}
