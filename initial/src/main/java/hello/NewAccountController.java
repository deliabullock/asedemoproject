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
        private CustomerRepository repository;
 
	@RequestMapping("/newaccpage")
	public String showMessage(Model model,
			@RequestParam(value = "name", required = false, defaultValue = "*user*") String name) {
		model.addAttribute("msg", "Please create account");
		model.addAttribute("error", "");
		return "newaccpage";
	}

         @RequestMapping(value = "/newaccpage", method = RequestMethod.POST)
         public String submit(@RequestParam("username") String username, @RequestParam("password") String password, Model model) {
                 System.out.println(username);
                 System.out.println(password);
		 
	//	 String encoded = encoder.encode(password);
		 if (repository.findByUsername(username) != null || password == "" || username == ""){
		    model.addAttribute("msg", "Please create account");
                    model.addAttribute("error", "Incorrect");
                    return "newaccpage";
		 }
                 repository.save(new Customer(username, password));
		 model.addAttribute("msg", "Welcome ");
                 model.addAttribute("username", username);
                 return "mainpage";
         }
}
