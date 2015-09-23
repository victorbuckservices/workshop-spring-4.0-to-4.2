package demo

import demo._40.groovybean.GroovyBeanDefinitionService
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.IntegrationTest
import org.springframework.boot.test.SpringApplicationConfiguration
import org.springframework.context.ApplicationContext
import org.springframework.test.annotation.DirtiesContext
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner
import org.springframework.test.context.web.WebAppConfiguration

@RunWith(SpringJUnit4ClassRunner)
@SpringApplicationConfiguration(classes = WorkshopApplication)
@WebAppConfiguration
@IntegrationTest
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_CLASS)
abstract class AbstractTest {

    @Autowired
    protected GroovyBeanDefinitionService fooService;

    @Autowired
    protected ApplicationContext applicationContext;
}
