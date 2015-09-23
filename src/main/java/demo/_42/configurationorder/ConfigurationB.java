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
@Order(1)
public class ConfigurationB {

    private static final Logger LOG = LoggerFactory.getLogger(ConfigurationB.class);

    public ConfigurationB() {
    }

    @Bean
    public OrderedBean orderedBean(){
        LOG.info(">>>>>>>>>>>>>>>>>ConfigurationB");
        return new OrderedBean();
    }
}
