package hello;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import java.util.ArrayList;
import java.util.List;
 
@Controller
public class NewAccountController {
	String message = "Please enter a username and password";
//	StandardPasswordEncoder encoder = new StandardPasswordEncoder("secret");
         
	@Autowired
        private UserRepository repository;
	@Autowired
        private GameRepository gameRepo;
 
	@RequestMapping("/newaccpage")
	public String showMessage(Model model) {
		model.addAttribute("msg", "Please create account");
		model.addAttribute("error", "");
		return "newaccpage";
	}

         @RequestMapping(value = "/newaccpage", method = RequestMethod.POST)
         public String submit(@RequestParam(value = "username", required = true) String username, @RequestParam("password") String password, Model model) {
                 System.out.println(username);
                 System.out.println(password);
		 
	//	 String encoded = encoder.encode(password);
		 if (repository.findByUsername(username) != null || password == "" || username == ""){
		    model.addAttribute("msg", "Please create account");
                    model.addAttribute("error", "Incorrect");
                    return "newaccpage";
		 }
                 repository.save(new User(username, password));
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
