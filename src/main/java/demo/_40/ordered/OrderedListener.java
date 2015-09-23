package demo._40.ordered;

import org.springframework.core.Ordered;

/**
 * Created by nlabrot on 14/09/15.
 */
public class OrderedListener implements Ordered {

    private int order;

    @Override
    public int getOrder() {
        return order;
    }

    public void setOrder(int order) {
        this.order = order;
    }
}
