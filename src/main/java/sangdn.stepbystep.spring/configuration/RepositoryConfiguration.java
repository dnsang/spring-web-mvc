package sangdn.stepbystep.spring.configuration;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.orm.jpa.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * Created by sangdn on 9/22/15.
 */
@Configuration
@EnableAutoConfiguration
@EntityScan(basePackages = {"sangdn.stepbystep.spring.domain"})
@EnableJpaRepositories(basePackages = {"sangdn.stepbystep.spring.repositories"})
@EnableTransactionManagement
public class RepositoryConfiguration {
}
