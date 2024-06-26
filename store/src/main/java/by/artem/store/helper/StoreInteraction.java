package by.artem.store.helper;

import by.artem.store.middleware.*;
import by.artem.store.Store;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.concurrent.TimeUnit;

import lombok.SneakyThrows;

public class StoreInteraction {

    static Store store;
    private static MiddlewareServer middlewareServer;

    public StoreInteraction(Store store) {
        StoreInteraction.store = store;
    }

    public String InputString() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        return reader.readLine();
    }

    private static void initMiddleware() {
        middlewareServer = new MiddlewareServer();

        Middleware middleware = new SortMiddleware(store);
        middleware.linkWith(new TopMiddleware(store))
                .linkWith(new CreateOrderMiddleware(store))
                .linkWith(new PrintPurchasesMiddleware(store))
                .linkWith(new CategoryMiddleware(store))
                .linkWith(new ClearPurchasesMiddleware(store))
                .linkWith(new QuitMiddleware())
                .linkWith(new UnknownMiddleware());

        middlewareServer.setMiddleware(middleware);
    }

    @SneakyThrows
    public void ConsoleInteraction() {
        initMiddleware();
        boolean isQuit = false;

        while(!isQuit){
            TimeUnit.MILLISECONDS.sleep(300);
            System.out.print("Enter command (category, sort, top, create_random_purchase, print_purchases, clear_purchases, quit): ");
            isQuit = middlewareServer.processingMiddleware(InputString());
        }
    }

}