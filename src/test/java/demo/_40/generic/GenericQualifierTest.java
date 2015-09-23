package demo._40.generic;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import demo.AbstractTest;

/**
 * Created by nlabrot on 14/09/15.
 */
public class GenericQualifierTest extends AbstractTest {

    @Autowired
    private Store<Integer> integerStore;

    @Autowired
    private Store<String> stringStore;

    @Autowired
    private List<Store<Integer>> integers;

    @Test
    public void testQualifier() throws Exception {
        Assert.assertEquals(Integer.class , integerStore.getType());
        Assert.assertEquals(String.class , stringStore.getType());


        Assert.assertEquals(1, integers.size());
        Assert.assertEquals(integerStore ,integers.get(0));
    }
}
