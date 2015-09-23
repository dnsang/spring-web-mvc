package sangdn.stepbystep.spring.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import sangdn.stepbystep.spring.domain.Product;
import sangdn.stepbystep.spring.repositories.ProductRepository;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;

/**
 * Created by sangdn on 9/22/15.
 */
//@Service(value = "productService")
@Service
public class ProductServiceImpl implements ProductService {


    ProductRepository productRepository;


    public ProductRepository getProductRepository() {
        return productRepository;
    }

    @Autowired
    public void setProductRepository(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public Iterable<Product> getAll() {
        return productRepository.findAll();
    }

    @Override
    public Product get(Integer productId) {
        return productRepository.findOne(productId);
    }

    @Override
    public void delete(Integer productId) {
        productRepository.delete(productId);
    }

    @Override
    public void save(Product product) {
        productRepository.save(product);
    }

    @Override
    public void update(Product product) {
        productRepository.save(product);
    }
}
