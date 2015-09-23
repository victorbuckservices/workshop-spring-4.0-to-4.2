package demo._41.property;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.test.context.TestPropertySource;

import demo.AbstractTest;

/**
 * Created by nlabrot on 15/09/15.
 */
@TestPropertySource("/test-properties.properties")
public class PropertyTest extends AbstractTest{

    @Value("${test.properties}")
    private String value;

    @Test
    public void testProperty() throws Exception {
        Assert.assertEquals("bar" , value);

    }
}
