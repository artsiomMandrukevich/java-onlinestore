package by.artem.store.middleware;


import by.artem.store.multithreading.CreateOrderThread;
import by.artem.store.Store;

public class CreateOrderMiddleware extends Middleware{

    Store store;

    public CreateOrderMiddleware(Store store) {
        this.store = store;
    }

    public boolean check(String consoleCommand) {
        if(consoleCommand.toUpperCase().equals(CommandValues.CREATE_ORDER.toString())){
            final CreateOrderThread createOrderThread = new CreateOrderThread(store);
            new Thread(createOrderThread).start();
            return false;
        }
        return checkNext(consoleCommand);
    }

}
