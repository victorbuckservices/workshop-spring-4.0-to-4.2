package demo._42.aliasfor;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by nlabrot on 17/09/15.
 */
@Target({ElementType.TYPE, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
//@Cacheable
@ResponseBody
@RequestMapping
public @interface CacheableRequRestMapping {
    String[] cacheNames() default {};
    String key() default "";
    String[] path() default {};
    RequestMethod[] method() default {};
}
