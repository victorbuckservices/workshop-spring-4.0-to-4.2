package demo._42.configuration;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import demo.AbstractTest;

/**
 * Created by nlabrot on 02/09/15.
 */
public class ImportedServiceTest extends AbstractTest {

    @Autowired
    private FeatureAConfiguration.FeatureA featureA;

    @Autowired
    private FeatureBConfiguration.FeatureB featureB;


    @Test
    public void testConfiguration() throws Exception {


    }
}
