package demo._41.sql;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.transaction.TestTransaction;
import org.springframework.transaction.annotation.Transactional;

import demo.AbstractTest;
import demo.repository.UserRepository;

/**
 * Created by nlabrot on 17/09/15.
 */
//@SqlConfig(transactionMode = SqlConfig.TransactionMode.INFERRED)
public class SqlTest extends AbstractTest{

    @Autowired
    private UserRepository userRepository;

    @Test
    @Transactional
    @Sql("/sql/create-user.sql")
    public void userTest() {
        Assert.assertNotNull(userRepository.findOne(1234l));
        TestTransaction.end();

        Assert.assertNull(userRepository.findOne(1234l));
    }

    @Test
    @Transactional
    @Sql(statements = "INSERT INTO USER (ID, FIRSTNAME,LASTNAME,ADDRESS) VALUES (1234,'Bilbo' , 'Baggins', 'Fondcombe')")
    public void userStatementTest() {
        Assert.assertNotNull(userRepository.findOne(1234l));
        TestTransaction.end();
        Assert.assertNull(userRepository.findOne(1234l));
    }
}
