package hello;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class NewAccountTest {

    private User user;
    @Autowired
    private NewAccountController controller;

    @Autowired
    private UserRepository repository;

    @Before
    public void setUp() {
        repository.deleteAll();
        user = new User("tiffany", "pwd");
        repository.save(user);
    }

    @Test
    public void contexLoads() throws Exception {
    	//assertTrue("Checks that username is unique: ", user.getId() == repository.findByUsername("tiffany").getId());
    	//assertTrue("Checks that usernames are not allowed to be null: ", repository.findByUsername("") == null);

    }
}