package hello;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.test.web.servlet.MockMvc;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class UserTest {

    User user;
    //List<String> players;

    @Autowired
    private GameController controller;
    private MockMvc mockMvc;

    @Before
    public void setUp() {
    	user = new User("zion", "123");

    }

    @Test
    public void contexLoads() throws Exception {
        //make sure that controller is being created
        assertThat(controller).isNotNull();
        assertEquals("Check that we can get the id", null, user.getId()); // autoassigned by spring
        assertEquals("Check that we can get the username", "zion", user.getUsername()); // autoassigned by spring
        assertEquals("Check that we get the correct token: ","123", user.getHash());
    }

    /*@Test
    public void shouldReturnDefaultMessage() throws Exception {
        this.mockMvc.perform(get("/creategame")).andDo(print()).andExpect(status().isOk());
    }*/
}

