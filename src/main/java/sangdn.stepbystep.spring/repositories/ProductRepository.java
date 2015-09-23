package sangdn.stepbystep.spring.repositories;

import sangdn.stepbystep.spring.domain.Product;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by sangdn on 9/22/15.
 */
public interface ProductRepository extends CrudRepository<Product,Integer> {
}
