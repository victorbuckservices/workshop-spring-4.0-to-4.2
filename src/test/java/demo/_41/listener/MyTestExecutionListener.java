package demo._41.listener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.TestContext;
import org.springframework.test.context.TestExecutionListener;

/**
 * Created by nlabrot on 02/09/15.
 */
public class MyTestExecutionListener implements TestExecutionListener {

    private static final Logger LOG = LoggerFactory.getLogger(MyTestExecutionListener.class);

    @Override
    public void beforeTestClass(TestContext testContext) throws Exception {

    }

    @Override
    public void prepareTestInstance(TestContext testContext) throws Exception {

    }

    @Override
    public void beforeTestMethod(TestContext testContext) throws Exception {
        LOG.info("********************************START {}********************************" , testContext.getTestMethod().getName());
    }

    @Override
    public void afterTestMethod(TestContext testContext) throws Exception {
        LOG.info("********************************END {}********************************" , testContext.getTestMethod().getName());
    }

    @Override
    public void afterTestClass(TestContext testContext) throws Exception {

    }
}
