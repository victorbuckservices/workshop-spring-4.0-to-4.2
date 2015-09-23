package demo._41.transactional;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.transaction.TestTransaction;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import demo.AbstractTest;
import demo.domain.User;
import demo.repository.UserRepository;

import static demo.domain.User.newUser;

/**
 * Created by nlabrot on 02/09/15.
 */
@TransactionConfiguration(defaultRollback=true)
@Transactional
public class TransactionalTest extends AbstractTest {

    @Autowired
    private UserRepository userRepository;

    @Test
    public void testTransactional() throws Exception {
        User user = newUser().address("address").firstName("firstname").lastName("lastname").build();
        user = userRepository.save(user);

        TestTransaction.end();
        Assert.assertEquals(0 , userRepository.findAll().size());


        TestTransaction.start();
        TestTransaction.flagForCommit();
        user = newUser().address("address").firstName("firstname").lastName("lastname").build();
        user = userRepository.save(user);
        TestTransaction.end();

        Assert.assertEquals(user, userRepository.findAll().get(0));
    }
}
