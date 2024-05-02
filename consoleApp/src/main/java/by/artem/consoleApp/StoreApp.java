package by.artem.consoleApp;

import by.artem.store.Helper.StoreHelper;
import by.artem.store.Store;
import by.artem.store.tools.sort.StoreComparator;

public class StoreApp {

    public static void main(String[] args) {

        Store store = new Store();
        StoreHelper sh = new StoreHelper(store);
        StoreComparator storeComparator = new StoreComparator();

        sh.fillOutProductList();
        store.printProductFromCategory();

        store.printProduct(storeComparator.sortProduct(store.getAllProducts()));
        store.printProduct(storeComparator.top5ProductPrice(store.getAllProducts()));

    }

}