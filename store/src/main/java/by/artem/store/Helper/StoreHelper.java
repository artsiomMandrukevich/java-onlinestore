package by.artem.store.Helper;

import by.artem.domain.Category;
import by.artem.domain.Product;
import by.artem.store.Store;

import org.reflections.Reflections;
import org.reflections.scanners.SubTypesScanner;

import java.lang.reflect.InvocationTargetException;
import java.util.*;

public class StoreHelper {

    Store store;

    public StoreHelper(Store store) {
        this.store = store;
    }

    RandomStorePopulator randomStorePopulator = new RandomStorePopulator();

    private Map<Category, Integer> createMapOfCatefory(){
        Map<Category, Integer> mapOfCategory = new HashMap<>();

        Reflections reflections = new Reflections("by.artem.domain.categories", new SubTypesScanner());
        Set<Class<? extends Category>> subTypes = reflections.getSubTypesOf(Category.class);

        for(Class<? extends Category> type : subTypes){
            try{
                mapOfCategory.put(type.getConstructor().newInstance(), randomStorePopulator.setRandomInt());
            } catch (NoSuchMethodException | InvocationTargetException | IllegalAccessException | InstantiationException e){
                e.printStackTrace();
            }
        }
        return mapOfCategory;
    }

    public void fillOutProductList() {
        Map<Category, Integer> categiryProductList = createMapOfCatefory();

        for(Map.Entry<Category, Integer> fillEntry : categiryProductList.entrySet()) {
            for (int i = 0; i< fillEntry.getValue(); i++){
                Product product = new Product(
                        randomStorePopulator.setName(fillEntry.getKey().getName()),
                        randomStorePopulator.setRate(),
                        randomStorePopulator.setPrice()
                );
                fillEntry.getKey().setProductList(product);
            }
            this.store.setProductCategoryList(fillEntry.getKey());
        }
    }
}