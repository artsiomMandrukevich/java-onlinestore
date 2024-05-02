package by.artem.consoleApp;

import by.artem.store.Helper.StoreHelper;
import by.artem.store.Helper.StoreInteraction;
import by.artem.store.Store;

import java.io.IOException;

public class StoreApp {

    public static void main(String[] args) throws IOException {

        Store store = Store.getInstance();
        StoreHelper sh = new StoreHelper(store);
        StoreInteraction storeInteraction = new StoreInteraction(store);

        sh.fillOutProductList();
        storeInteraction.ConsoleInteraction();

    }

}