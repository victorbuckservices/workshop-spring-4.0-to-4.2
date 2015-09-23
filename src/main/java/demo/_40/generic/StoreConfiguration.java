package demo._40.generic;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by nlabrot on 14/09/15.
 */
@Configuration
public class StoreConfiguration {

    @Bean
    public Store<Integer> integerStore() {
        return new Store<>(Integer.class);
    }


    @Bean
    public Store<String> stringStore() {
        return new Store<>(String.class);
    }
}
