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
public class CreateGameController {
	
	@Autowired
	private GameRepository gameRepo;
 
	@RequestMapping("/creategame")
	public String showCreateGame(
			@RequestParam(value = "username", required = true) String username, Model model) {
		return loadCreateGame(username, "", model);
	}

	@RequestMapping(value = "/creategame", method = RequestMethod.POST)
	public String submit(@RequestParam("gameName") String name, @RequestParam(value = "username", required = true) String username, @RequestParam("length") String length, @RequestParam("phrase") String phrase, Model model) {	
		int gameLength;
		try{
        		gameLength = Integer.parseInt(length);
    		}catch(NumberFormatException e){
			return loadCreateGame(username, "Must enter game length greater than 0.", model);
    		}
		if (phrase == null || phrase == "" || name == null || phrase == "" || gameLength <= 0) {
			return loadCreateGame(username, "Phrase and name fields must be nonempty. Length must be great than or equal to 1.", model);
		}
		gameRepo.save(new Game(name, phrase, username, gameLength, 0));	
		return loadCreateGame(username, name + " game successfully created!", model);
	}

	private String loadCreateGame(String username, String error, Model model) {
		model.addAttribute("username", username);
		model.addAttribute("error", error);
		return "creategame";
	}

}
