package demo._40.groovybean

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.groovy.GroovyBeanDefinitionReader
import org.springframework.context.ApplicationContext
import org.springframework.stereotype.Service

import java.time.LocalDate

/**
 * Created by nlabrot on 01/09/15.
 */
@Service
class GroovyBeanDefinitionService {

    @Autowired
    ApplicationContext applicationContext;

    void groovyBean(boolean instanciate, String name = null, int numberOf = 1) {
        def reader = new GroovyBeanDefinitionReader(applicationContext)
        reader.beans {
            beanA(GroovyBeanA)
            //Bean can be conditionnaly instanciated

            if (instanciate) {
                for (int i = 0; i < numberOf; i++) {
                    "${name}#${i}"(GroovyBeanB) {
                        beanA = beanA
                        localDate = LocalDate.now()
                    }
                }
            }
        }
    }
}
