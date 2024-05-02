package by.artem.store.Helper;

import by.artem.store.Store;
import by.artem.store.tools.sort.StoreComparator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class StoreInteraction {

    Store store;
    StoreComparator storeComparator = new StoreComparator();

    public StoreInteraction(Store store) {
        this.store = store;
    }

    public String InputString() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        return reader.readLine();
    }

    public void SortProducts() throws IOException {
        boolean isQuit = false;
        while (!isQuit) {
            System.out.println("Enter command (sort, top, quit)");
            switch (InputString()) {
                case "sort": store.printProduct(storeComparator.sortProduct(store.getAllProducts()));
                    break;
                case "top": store.printProduct(storeComparator.top5ProductPrice(store.getAllProducts()));
                    break;
                case "quit": isQuit = true;
                    break;
                default: System.out.println("Oooops, something wrong !");
                    break;
            }
        }
    }

}
