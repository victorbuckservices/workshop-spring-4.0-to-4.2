package demo._40.ordered

import java.util.concurrent.ThreadLocalRandom

beans {
    for (int i = 0; i < 100; i++) {
        "orderedListener#${i}"(OrderedListener) {
            order = ThreadLocalRandom.current().nextInt()
        }
    }
}