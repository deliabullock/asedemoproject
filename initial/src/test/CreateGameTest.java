package hello;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CreateGameTest {

    @Autowired
    private CreateGameController controller;

    @Test
    public void contexLoads() throws Exception {
        //make sure that controller is being created - not a blackbox test
        //assertThat(controller).isNotNull();
        Game game = new Game("Game1", "Tree", "steph", 5);

        assertTrue("Check that game exists: ", game.getId() > 0);
        assertEquals("Check that game is associated with correct creator : ", "steph", game.getCreator());
        assertNotNull("Check that there's input for the game name": game.getName());
        assertNotNull("Check that there's a length specified": game.Length());

    }
}