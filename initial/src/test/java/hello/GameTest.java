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
public class GameTest {

    private Game game;
    //private List<String> players = new ArrayList()<>;

    @Autowired
    private CreateGameController controller;
    private MockMvc mockMvc;

    @Before
    public void setUp() {
        //this.mockMvc = webAppContextSetup(webApplicationContext).build();
        game = new Game("Game1", "Tree", "steph", 5, 1);
        game.setCreator("bob");
        game.setCreator("steph");
        game.addPlayer("John");
        game.addPlayer("Fred");
        game.addImage("123");
        game.addPhrase("123");
        game.setCurrLength(2);
        game.setLength(20);
        game.setName("Game0");

    }

    @Test
    public void contexLoads() throws Exception {
        //make sure that controller is being created
        assertThat(controller).isNotNull();
        assertTrue("Check that game exists: ", game.getId() != "");
        assertEquals("Check that game is associated with correct creator : ", "steph", game.getCreator());
        assertNotNull("Check that there's input for the game name:", game.getName());
        assertEquals("Check that game name is saved correctly: ", "Game0", game.getName());
        assertNotNull("Check that there's a length specified:", game.getLength());
        assertTrue("Check that players are being saved: ", !(game.getPlayers().isEmpty()));
        assertTrue("Check that creator is added to players list: ", game.getPlayers().contains("steph"));
        assertNotNull("Check that current length is set: ", game.getCurrLength());
        assertNotNull("Check that last phrase was added: ", game.getLastPhrase());
        assertNotNull("Check that last image was added: ", game.getLastImage());
        assertNotNull("Check that last turn 1 image was added: ", game.getTurnImage(0));
        assertNotNull("Check that last turn 1 phrase was added: ", game.getTurnPhrase(0));
    }

    /*@Test
    public void shouldReturnDefaultMessage() throws Exception {
        this.mockMvc.perform(get("/creategame")).andDo(print()).andExpect(status().isOk());
    }*/
}
