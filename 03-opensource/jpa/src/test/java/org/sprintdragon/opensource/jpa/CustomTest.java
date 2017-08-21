package org.sprintdragon.opensource.jpa;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.sprintdragon.opensource.jpa.jpa.custom.User;
import org.sprintdragon.opensource.jpa.jpa.custom.UserRepository;

import javax.annotation.Resource;
import java.util.List;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

/**
 * Created by wangdi on 16-8-26.
 */
public class CustomTest extends BaseIT {

    @Resource
    UserRepository repository;

    /**
     * Tests inserting a user and asserts it can be loaded again.
     */
    @Test
    public void testInsert() {

        User user = new User();
        user.setUsername("username");

        user = repository.save(user);
        assertTrue(user.equals(repository.findOne(user.getId())));
    }

    @Test
    public void saveAndFindByLastNameAndFindByUserName() {

        User user = new User();
        user.setUsername("foobar");
        user.setLastname("lastname");

        user = repository.save(user);

        List<User> users = repository.findByLastname("lastname");

        assertNotNull(users);
        assertTrue(users.contains(user));

        User reference = repository.findByTheUsersName("foobar");
        assertTrue(user.equals(reference));
    }

    /**
     * Test invocation of custom method.
     */
    @Test
    public void testCustomMethod() {

        User user = new User();
        user.setUsername("username");

        user = repository.save(user);

        List<User> users = repository.myCustomBatchOperation();

        assertNotNull(users);
        assertTrue(users.contains(user));
    }

}
