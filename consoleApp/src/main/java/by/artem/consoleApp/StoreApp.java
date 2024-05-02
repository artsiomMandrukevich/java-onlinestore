package by.artem.consoleApp;

import by.artem.store.helper.StoreHelper;
import by.artem.store.helper.StoreInteraction;
import by.artem.store.Store;

import by.artem.store.multithreading.CleanUpThread;
import lombok.SneakyThrows;

public class StoreApp {

    @SneakyThrows
    public static void main(String[] args) {

        Store store = Store.getInstance();

        StoreHelper sh = new StoreHelper(store);
        StoreInteraction storeInteraction = new StoreInteraction(store);

        sh.fillOutProductList();

        final CleanUpThread cleanUpThread = new CleanUpThread(store);
        new Thread(cleanUpThread).start();

        storeInteraction.ConsoleInteraction();
        cleanUpThread.finish();

    }

}