package sangdn.stepbystep.spring.bootstrap;

import sangdn.stepbystep.spring.domain.Product;
import sangdn.stepbystep.spring.repositories.ProductRepository;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

/**
 * Created by sangdn on 9/22/15.
 */
@Component
public class ProductLoader implements ApplicationListener<ContextRefreshedEvent> {
    private ProductRepository productRepository;
    private Logger logger = Logger.getLogger(ProductLoader.class);
    @Autowired
    public void setProductRepository(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        Product shirt = new Product();
        shirt.setDescription("A t-shirt");
        shirt.setPrice(new BigDecimal(10));
        shirt.setProductId("1");
        shirt.setImageUrl("http://test.com/img.png");
        productRepository.save(shirt);
        logger.info("save shirt -id:" + shirt.getId());

        Product mug = new Product();
        mug.setDescription("A mug");
        mug.setPrice(new BigDecimal(10));
        mug.setProductId("2");
        mug.setImageUrl("http://test.com/img.png");
        productRepository.save(mug);

        logger.info("save mug id: " + mug.getId());
    }
}
