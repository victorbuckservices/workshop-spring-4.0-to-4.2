package demo._42.configuration;

import org.springframework.context.annotation.Bean;

/**
 * Created by nlabrot on 02/09/15.
 */
public interface FeatureAConfiguration {

    @Bean
    default FeatureA featureA(){
        return new FeatureA();
    }


    class FeatureA {
    }
}
