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
public class NewAccountController {
	String message = "Please enter a username and password";
         
	@Autowired
        private UserRepository repository;
	@Autowired
        private PasswordRepository pwRepo;
	@Autowired
        private GameRepository gameRepo;
	
	public static PasswordAuth pwauthentication = new PasswordAuth(16);
 
	@RequestMapping("/newaccpage")
	public String showMessage(Model model) {
		model.addAttribute("msg", "Please create account");
		model.addAttribute("error", "");
		return "newaccpage";
	}

         @RequestMapping(value = "/newaccpage", method = RequestMethod.POST)
         public String submit(@RequestParam(value = "username", required = true) String username, @RequestParam("password") String password, Model model) {
		
		if (repository.findByUsername(username) != null || password == "" || username == ""){
		   model.addAttribute("msg", "Please create account");
                   model.addAttribute("error", "Incorrect");
                   return "newaccpage";
		}

		String[] tokenHash = pwauthentication.hash(password.toCharArray());

                repository.save(new User(username, tokenHash[1]));
                pwRepo.save(new Password(tokenHash[1], tokenHash[0]));
		List<Game> ongoingGames = new ArrayList<Game>();
		List<Game> userOngoingGames = new ArrayList<Game>();
		List<Game> userCompletedGames = new ArrayList<Game>();
		List<Game> completedGames = new ArrayList<Game>();
        
		for (Game game : gameRepo.findAll()) {
			if (!game.getPlayers().contains(username)){
				if(game.getLength() > game.getCurrLength()){
					ongoingGames.add(game);
				} else {
					completedGames.add(game);
				}					
			} else {
				if(game.getLength() > game.getCurrLength()){
					userOngoingGames.add(game);
				} else {
					userCompletedGames.add(game);
				}
			}		
		}
        
		model.addAttribute("ongoinglist", ongoingGames);
		model.addAttribute("completedlist", completedGames);
		model.addAttribute("userongoinglist", userOngoingGames);
		model.addAttribute("usercompletedlist", userCompletedGames);
		model.addAttribute("username", username);
		model.addAttribute("msg", "Welcome back to Telestrations");
		return "mainpage";
         }
}
