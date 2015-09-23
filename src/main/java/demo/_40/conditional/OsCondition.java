package demo._40.conditional;

import org.apache.commons.lang3.SystemUtils;
import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;

/**
 * Created by nlabrot on 01/09/15.
 */
public class OsCondition implements Condition {

    @Override
    public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
        boolean requireWindows = (Boolean) metadata.getAnnotationAttributes(Os.class.getName()).get("windows");

        return requireWindows && SystemUtils.IS_OS_WINDOWS ||
                !requireWindows && !SystemUtils.IS_OS_WINDOWS;
    }
}
