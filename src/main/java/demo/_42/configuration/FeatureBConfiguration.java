package demo._42.configuration;

import org.springframework.context.annotation.Bean;

/**
 * Created by nlabrot on 02/09/15.
 */
public interface FeatureBConfiguration {


    @Bean
    default FeatureB featureB(){
        return new FeatureB();
    }


    class FeatureB {

    }
}
