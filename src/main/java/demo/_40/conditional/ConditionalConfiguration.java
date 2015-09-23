package demo._40.conditional;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by nlabrot on 01/09/15.
 */
@Configuration
public class ConditionalConfiguration {

    public ConditionalConfiguration() {
        System.out.println("ok");
    }

    @Bean
    @Os(windows = true)
    public MyOsDependantInterface windows(){
        return new MyOsDependantInterface.Windows();
    }

    @Bean
    @Os(windows = false)
    public MyOsDependantInterface linux(){
        return new MyOsDependantInterface.Linux();
    }

}
