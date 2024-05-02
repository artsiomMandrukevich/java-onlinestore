package by.artem.consoleApp;

import by.artem.store.Helper.StoreHelper;
import by.artem.store.Store;

public class StoreApp {

    public static void main(String[] args) {

        Store store = new Store();
        StoreHelper sh = new StoreHelper(store);

        sh.fillOutProductList();
        store.printProductFromCategory();

    }
}