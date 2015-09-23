package demo._42.configurationorder;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.core.annotation.Order;

/**
 * Created by nlabrot on 17/09/15.
 */
@Configuration

@Profile("configuration-order")
@Order(0)
public class ConfigurationA {

    private static final Logger LOG = LoggerFactory.getLogger(ConfigurationA.class);

    public ConfigurationA() {

    }

    @Bean
    public OrderedBean orderedBean(){
        LOG.info(">>>>>>>>>>>>>>>>>ConfigurationA");
        return new OrderedBean();
    }
}
