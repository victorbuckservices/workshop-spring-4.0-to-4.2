package demo._40.ordered;

import java.util.List;
import java.util.stream.Collectors;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import demo.AbstractTest;

import static java.lang.Integer.compare;

/**
 * Created by nlabrot on 14/09/15.
 */
public class OrderedTest extends AbstractTest {

    @Autowired
    private List<OrderedListener> orderedBeans;

    @Test
    public void testOrder() throws Exception {

        List<OrderedListener> expected = orderedBeans.stream()
                .sorted((l, r) -> compare(l.getOrder(), r.getOrder()))
                .collect(Collectors.toList());

        Assert.assertEquals(expected, orderedBeans);

    }
}
