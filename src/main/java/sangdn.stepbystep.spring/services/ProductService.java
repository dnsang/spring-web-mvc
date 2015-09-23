package sangdn.stepbystep.spring.services;

import sangdn.stepbystep.spring.domain.Product;

import java.util.List;

/**
 * Created by sangdn on 9/22/15.
 */
public interface ProductService {
    public Iterable<Product> getAll();
    public Product get(Integer productId);
    public void delete(Integer productId);
    public void save(Product product);
    public void update(Product product);
}
