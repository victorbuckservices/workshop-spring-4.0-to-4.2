package demo._42.rule;

import org.junit.Assert;
import org.junit.ClassRule;
import org.junit.Rule;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.junit4.rules.SpringClassRule;
import org.springframework.test.context.junit4.rules.SpringMethodRule;
import org.springframework.test.context.web.WebAppConfiguration;

import demo.WorkshopApplication;

/**
 * Created by nlabrot on 16/09/15.
 */
@SpringApplicationConfiguration(classes = WorkshopApplication.class)
@WebAppConfiguration
public class JunitRuleTest {

    @ClassRule
    public static final SpringClassRule SPRING_CLASS_RULE = new SpringClassRule();

    @Rule
    public final SpringMethodRule springMethodRule = new SpringMethodRule();


    @Autowired
    private ApplicationContext applicationContext;

    @Test
    public void testName() throws Exception {
        Assert.assertNotNull(applicationContext);
    }
}
