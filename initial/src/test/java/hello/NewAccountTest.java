package hello;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class NewAccountTest {

    @Autowired
    private NewAccountController controller;
    private UserRepository repository;

    @Test
    public void contexLoads() throws Exception {
    	User user = new User("tiffany", "pwd");
    	//repository.save(user);
    	//assertTrue("Checks that username is unique: ", user.getId() == repository.findByUsername("tiffany").getId());
    	//assertTrue("Checks that usernames are not allowed to be null: ", repository.findByUsername("") == null);

    }
}