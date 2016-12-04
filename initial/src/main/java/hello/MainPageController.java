//package com.therealzads.telestrations.controller;
package hello;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import java.util.ArrayList;
import java.util.List;

@Controller
public class MainPageController {
 
	@Autowired
	private GameRepository gameRepo;

	@RequestMapping("/mainPage")
	public String showMainPage(
			@RequestParam(value = "username", required = true) String username, Model model) {
		List<Game> ongoingGames = new ArrayList<Game>();
		List<Game> userOngoingGames = new ArrayList<Game>();
		List<Game> userCompletedGames = new ArrayList<Game>();
		List<Game> completedGames = new ArrayList<Game>();

		for (Game game : gameRepo.findAll()) {
			//System.out.println(game.getPlayers());
			//System.out.println(username);
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
