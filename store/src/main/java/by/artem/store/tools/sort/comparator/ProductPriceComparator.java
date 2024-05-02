package by.artem.store.tools.sort.comparator;


import by.artem.domain.Product;
import java.util.Comparator;

public class ProductPriceComparator  implements Comparator<Product> {

    public int compare(Product a, Product b){

        return a.getPrice().compareTo(b.getPrice());
    }

}