package by.artem.consoleApp;

import by.artem.store.helper.StoreHelper;
import by.artem.store.helper.StoreInteraction;
import by.artem.store.Store;

import by.artem.store.http.HTTPServer;
import lombok.SneakyThrows;

public class StoreApp {

    @SneakyThrows
    public static void main(String[] args) {

        Store store = Store.getInstance();

        StoreHelper sh = new StoreHelper(store);
        StoreInteraction storeInteraction = new StoreInteraction(store);

        sh.fillOutProductList();

        HTTPServer httpServer = new HTTPServer();
        httpServer.startHttpServer();

        storeInteraction.ConsoleInteraction();
        httpServer.stopHTTPServer();

    }

}