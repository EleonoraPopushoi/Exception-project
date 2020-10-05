package ru.netology.manager.manager;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.netology.manager.domain.Product;
import ru.netology.manager.repository.ProductRepository;

@AllArgsConstructor
@NoArgsConstructor
@Data

public class ProductManager {
    private ProductRepository repository;

    public void addProduct(Product item) {
        repository.save(item);
    }

    public Product[] searchById(String text) {
        Product[] result = new Product[0];
        for(Product product : repository.findAll()) {
            if(product.matches(text)) {
                Product[] tmp = new Product[result.length +1];
                System.arraycopy(result, 0, tmp, 0, result.length);
                tmp[tmp.length - 1] = product;
                result = tmp;
            }
        }
        return result;
    }
}
