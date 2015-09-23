package demo._42.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Description;

/**
 * Created by nlabrot on 02/09/15.
 */
@Configuration
@Description("Hello!")
public class FinalConfiguration implements FeatureAConfiguration, FeatureBConfiguration {

}
