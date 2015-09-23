//package sangdn.stepbystep.spring.services;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//import sangdn.stepbystep.spring.domain.Product;
//import sangdn.stepbystep.spring.repositories.ProductRepository;
//
//import java.util.ArrayList;
//import java.util.Iterator;
//
///**
// * Created by sangdn on 9/22/15.
// */
//@Service(value = "productService2")
//public class ProductServiceImpl2 implements ProductService {
//
//    ProductRepository productRepository;
//
//    public ProductRepository getProductRepository() {
//        return productRepository;
//    }
//    @Autowired
//    public void setProductRepository(ProductRepository productRepository) {
//        this.productRepository = productRepository;
//    }
//
//    @Override
//    public Iterable<Product> getAll() {
//        return new ArrayList<>();
//    }
//
//    @Override
//    public Product get(Integer productId) {
//        return productRepository.findOne(productId);
//    }
//
//    @Override
//    public void delete(Integer productId) {
//        productRepository.delete(productId);
//    }
//
//    @Override
//    public void update(Product product) {
//        productRepository.save(product);
//    }
//}
