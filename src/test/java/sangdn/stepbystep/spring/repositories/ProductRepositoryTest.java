package sangdn.stepbystep.spring.repositories;

import sangdn.stepbystep.spring.configuration.RepositoryConfiguration;
import sangdn.stepbystep.spring.domain.Product;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.math.BigDecimal;

/**
 * Created by sangdn on 9/22/15.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = {RepositoryConfiguration.class})
public class ProductRepositoryTest {
    @Autowired
    public void setProductRepository(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    private ProductRepository productRepository;

    @Test
    public void testSaveProduct(){
        Product product = new Product();
        product.setDescription("Spring Framework Guru Shirt");
        product.setPrice(new BigDecimal(10));
        product.setProductId("1234");

        Assert.assertNull(product.getId());
        productRepository.save(product);
        Assert.assertNotNull(product.getId());
        //fetch from db
        Product fetchProduct = productRepository.findOne(product.getId());
        Assert.assertNotNull(fetchProduct);

        //expect equal
        Assert.assertEquals(fetchProduct.getId(), product.getId());
        Assert.assertEquals(fetchProduct.getDescription(), product.getDescription());
        assert  fetchProduct.getPrice().compareTo(product.getPrice()) == 0;

        //update db
        fetchProduct.setDescription("new description");
        fetchProduct.setPrice(new BigDecimal(11));
        productRepository.save(fetchProduct);

        //get from db  & check for update
        Product fetchUpdatedProduct = productRepository.findOne(fetchProduct.getId());
        Assert.assertEquals(fetchProduct.getDescription(), fetchUpdatedProduct.getDescription());


        //verify count in DB
        long totalProduct = productRepository.count();
        Assert.assertEquals(totalProduct, 1);

        Iterable<Product> products = productRepository.findAll();
        int count = 0;
        for (Product p : products){
            ++count;
        }
        Assert.assertEquals(count,1);

    }

}
