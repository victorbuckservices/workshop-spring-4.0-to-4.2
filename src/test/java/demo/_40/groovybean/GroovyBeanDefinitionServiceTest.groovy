package demo._40.groovybean

import demo.AbstractTest
import org.junit.Assert
import org.junit.Test

import static java.util.Collections.emptyMap

class GroovyBeanDefinitionServiceTest extends AbstractTest {

    @Test
    void testGroovyBeanDefinition() {
        fooService.groovyBean(false);
        Assert.assertNotNull(applicationContext.getBean("beanA"))
        Assert.assertEquals(emptyMap(), applicationContext.getBeansOfType(GroovyBeanB))

        fooService.groovyBean(true, "beanB", 10);
        Assert.assertNotNull(applicationContext.getBean("beanA"))
        Assert.assertEquals(10, applicationContext.getBeansOfType(GroovyBeanB).size())
    }

}
