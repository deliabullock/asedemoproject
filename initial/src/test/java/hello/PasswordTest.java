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
public class PasswordTest {

    Password password;
    //List<String> players;

    @Autowired
    private GameController controller;
    private MockMvc mockMvc;

    @Before
    public void setUp() {
    	password = new Password("012", "123");

    }

    @Test
    public void contexLoads() throws Exception {
        //make sure that controller is being created
        assertThat(controller).isNotNull();
        assertEquals("Check that we can get the id", null, password.getId()); // autoassigned by spring
        assertEquals("Check that we get the correct token: ","123", password.getToken());
    }

    /*@Test
    public void shouldReturnDefaultMessage() throws Exception {
        this.mockMvc.perform(get("/creategame")).andDo(print()).andExpect(status().isOk());
    }*/
}
