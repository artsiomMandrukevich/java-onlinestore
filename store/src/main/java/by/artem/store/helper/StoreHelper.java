package by.artem.store.helper;

import by.artem.domain.Category;
import by.artem.domain.CategoryFactory;
import by.artem.domain.CategoryType;
import by.artem.store.Store;

import by.artem.store.database.SQLStatements;

import java.util.*;

import static by.artem.store.database.SQLInstructions.INSERT_INTO_PRODUCT;
import static by.artem.store.database.SQLInstructions.SELECT_FROM_CATEGORY;

public class StoreHelper {

    Store store;

    RandomStorePopulator randomStorePopulator = new RandomStorePopulator();

    SQLHelper sqlHelper = new SQLHelper();
    SQLStatements sqlStatements = new SQLStatements();

    public StoreHelper(Store store) {
        this.store = store;
    }

    private Map<Category, Integer> createMapOfCategoryFromDataBase(){

        // Connect to DB, insert rows into Category table from CategoryType enum
        sqlHelper.startWorkWithDatabase();
        sqlHelper.insertCategoryFromEnumCategoryTypeIntoCategoryTable();

        // Select list of category from DataBase
        List<String> categoryListDB = sqlHelper.getListOfCategoryFromCategoryTable(sqlStatements.executeStatementQuery(SELECT_FROM_CATEGORY));

        // Create map of category from DataBase
        Map<Category, Integer> mapOfCategoryByDataBase = new HashMap<>();
        CategoryFactory categoryFactory = new CategoryFactory();
        for(String categoryTypeFromDB : categoryListDB){
            mapOfCategoryByDataBase.put(categoryFactory.getCategory(CategoryType.valueOf(categoryTypeFromDB.toUpperCase())), randomStorePopulator.setRandomInt());
        }
        return mapOfCategoryByDataBase;
    }

    public void fillOutProductList() {
        Map<Category, Integer> categoryProductList = createMapOfCategoryFromDataBase();

        for(Map.Entry<Category, Integer> fillEntry : categoryProductList.entrySet()) {
            for (int i = 0; i< fillEntry.getValue(); i++){
                // insert  Category and Product to the STORE
                sqlStatements.executeInsertIntoProductOrPurchaseTable(INSERT_INTO_PRODUCT,
                        randomStorePopulator.setName(fillEntry.getKey().getName()),
                        randomStorePopulator.setRate(),
                        randomStorePopulator.setPrice(),
                        fillEntry.getKey().getName());
            }
        }
    }
}