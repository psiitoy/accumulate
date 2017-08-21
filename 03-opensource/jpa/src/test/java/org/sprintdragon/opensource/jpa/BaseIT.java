package org.sprintdragon.opensource.jpa;

import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.test.context.transaction.TransactionConfiguration;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;


/**
 * 1.通过 defaultRollback=true 控制测试用例回滚
 */
@ContextConfiguration(locations = {
        "classpath:spring-config.xml",
})
@TransactionConfiguration(transactionManager = "transactionManager", defaultRollback = false)
public abstract class BaseIT extends AbstractTransactionalJUnit4SpringContextTests {

    @PersistenceContext
    protected EntityManager entityManager;

    protected void flush() {
        entityManager.flush();
    }

    protected void clear() {
        entityManager.flush();
        entityManager.clear();
    }

}

