package hello;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import java.util.ArrayList;
import java.util.List;

@Controller
public class GameController {
	
	@Autowired
	private UserRepository repository;
	@Autowired
	private PasswordRepository pwRepo;
        @Autowired
        private GameRepository gameRepo;
        @Autowired
        private PhraseRepository phraseRepo;
	
	@RequestMapping("/userjoining")
	public String userJoiningGame(
			@RequestParam(value = "username", required = true) String username,
			@RequestParam(value = "gameid", required = true) String gameid, Model model) {
		Game game = gameRepo.findById(gameid);
		if (game == null) {
			model.addAttribute("username", username);
			model.addAttribute("header", "Uh oh!");
			model.addAttribute("msg", "There seems to be an issue with this game! Sorry about That!");
			return "messagePage";
		}		
		model.addAttribute("username", username);
		model.addAttribute("game", gameRepo.findById(gameid));
		model.addAttribute("error", "");
		if(game.getCurrLength() % 2 == 0){
			return "guessimage";
		} else {
			return "guessphrase";
		}
	}
 
	@RequestMapping("/phraseguess")
	public String showPhraseGuess(
			@RequestParam(value = "username", required = true) String username,
			@RequestParam(value = "gameid", required = true) String gameid, Model model) {
		model.addAttribute("username", username);
		model.addAttribute("game", gameRepo.findById(gameid));
		model.addAttribute("error", "");
		return "guessphrase";
	}

	@RequestMapping(value = "/phraseguess", method = RequestMethod.POST)
	public String submitPhrase(
			@RequestParam(value = "username", required = true) String username,
			@RequestParam(value = "gameid", required = true) String gameid, 
			@RequestParam(value = "currlen", required = true) int currLength, 
			@RequestParam(value = "phrase") String phrase, Model model) {
		Game game = gameRepo.findById(gameid);
		if (game == null || game.getCurrLength() != currLength){
			model.addAttribute("username", username);
			model.addAttribute("header", "Oh no there has been a conflict!");
			model.addAttribute("msg", "It seems another player submitted a guess for this step while you were making your guess. Your guess could not be submitted. Sorry!");
			return "messagePage";
		}
		if (phrase == null || phrase == ""){
			model.addAttribute("username", username);
			model.addAttribute("game", gameRepo.findById(gameid));
			model.addAttribute("error", "Guess is empty!");
			return "guessphrase";
		}

		// Create phrase and add it to game
		Phrase phraseObj = new Phrase(username, phrase);
		phraseRepo.save(phraseObj);
		game.addPhrase(phraseObj.getId());
	
		// Add game to users in progress games!
		game.addPlayer(username);
		gameRepo.save(game);

		model.addAttribute("username", username);
		model.addAttribute("header", "Submitted!");
		model.addAttribute("msg", "Thanks for guessing! Now it's up to other players to finish the game. Once the game is completed, it will be moved into your finished games and you can see how close your guess is!");
		return "messagePage";
	}
	
	@RequestMapping("/imageguess")
	public String showImageGuess(
			@RequestParam(value = "username", required = true) String username,
			@RequestParam(value = "gameid", required = true) String gameid, Model model) {
		model.addAttribute("username", username);
		model.addAttribute("game", gameRepo.findById(gameid));
		model.addAttribute("phrase", phraseRepo.findById(gameRepo.findById(gameid).getLastPhrase()).getPhrase());
		model.addAttribute("error", "");
		return "guessimage";
	}

	@RequestMapping(value = "/imageguess", method = RequestMethod.POST)
	public String submitImage(
			@RequestParam(value = "username", required = true) String username,
			@RequestParam(value = "gameid", required = true) String gameid, 
			@RequestParam(value = "currlen", required = true) int currLength, 
			@RequestParam(value = "image") String image, Model model) {
		Game game = gameRepo.findById(gameid);
		if (game == null || game.getCurrLength() != currLength){
			model.addAttribute("username", username);
			model.addAttribute("header", "Oh no there has been a conflict!");
			model.addAttribute("msg", "It seems another player submitted a guess for this step while you were making your guess. Your guess could not be submitted. Sorry!");
			return "messagePage";
		}
		if (image == null || image == ""){
			model.addAttribute("username", username);
			model.addAttribute("game", gameRepo.findById(gameid));
			model.addAttribute("phrase", phraseRepo.findById(gameRepo.findById(gameid).getLastPhrase()).getPhrase());
			model.addAttribute("error", "Guess is empty!");
			return "guessimage";
		}

		// Create phrase and add it to game
		//Phrase phraseObj = new Phrase(username, phrase);
		//phraseRepo.save(phraseObj);
		// TODO: add this when image works
		game.addImage(image);
	
		// Add game to users in progress games!
		game.addPlayer(username);
		gameRepo.save(game);

		model.addAttribute("username", username);
		model.addAttribute("header", "Submitted!");
		model.addAttribute("msg", "Thanks for guessing! Now it's up to other players to finish the game. Once the game is completed, it will be moved into your finished games and you can see how close your guess is!");
		return "messagePage";
	}
	
}
