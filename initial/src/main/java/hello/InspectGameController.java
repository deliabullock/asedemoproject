//package com.therealzads.telestrations.controller;
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
public class InspectGameController {
 
	@Autowired
	private UserRepository repository;
	@Autowired
	private GameRepository gameRepo;
	@Autowired
	private PhraseRepository phraseRepo;
	@Autowired
	private ImageRepository imageRepo;
	
	@RequestMapping("/viewgame")
	public String userViewingGame(
			@RequestParam(value = "username", required = true) String username,
			@RequestParam(value = "gameid", required = true) String gameid, 
			@RequestParam(value = "turn", required = false) String turn, 
			Model model) {
		Game game = gameRepo.findById(gameid);
		int viewTurn = 0;
		if (turn != "" && turn != null)
			viewTurn = Integer.parseInt(turn);
		
		if (viewTurn >= game.getLength()/2)
			viewTurn = game.getLength()/2 - 1;
		
		if (viewTurn < 0)
			viewTurn = 0;
		
		if (game == null) {
			model.addAttribute("username", username);
			model.addAttribute("header", "Uh oh!");
			model.addAttribute("msg", "There seems to be an issue with this game! Sorry about That!");
			return "messagePage";
		}
		model.addAttribute("username", username);
		model.addAttribute("game", gameRepo.findById(gameid));
		model.addAttribute("error", "");
		
		model.addAttribute("phrase", phraseRepo.findById(gameRepo.findById(gameid).getTurnPhrase(viewTurn)).getPhrase());
		
		if((viewTurn + 1) <= (game.getLength()/2) && game.getLength()%2 == 1) {
			model.addAttribute("phrase2", phraseRepo.findById(gameRepo.findById(gameid).getTurnPhrase(viewTurn + 1)).getPhrase());
		} else {
			if((viewTurn + 1) < (game.getLength()/2))
				model.addAttribute("phrase2", phraseRepo.findById(gameRepo.findById(gameid).getTurnPhrase(viewTurn + 1)).getPhrase());
		}
		
		model.addAttribute("imgData0", imageRepo.findById(gameRepo.findById(gameid).getTurnImage(viewTurn)).getImage());
		model.addAttribute("turn", viewTurn);
		model.addAttribute("displayturn", viewTurn + 1);
		
		return "viewgame";
	}
	
	
	@RequestMapping(value = "/game", method = RequestMethod.GET)
	public String showGame(
			@RequestParam(value = "username", required = true) String username, 
			@RequestParam(value = "gameid", required = true) String gameId, 
			@RequestParam(value = "imgData", required = false) String imgData,
			Model model) {
		//System.out.println(username);
		//System.out.println(imgData);
		model.addAttribute("game", gameRepo.findById(gameId));
		model.addAttribute("imgData", imgData);
		model.addAttribute("username", username);
		return "game";
	}
	
	@RequestMapping(value = "/game", method = RequestMethod.POST)
	public String submitImg(
			@RequestParam(value = "username", required = true) String username, 
			@RequestParam(value = "gameid", required = true) String gameId, 
			@RequestParam(value = "imgData", required = false) String imgData,
			Model model) {
		//System.out.println(username);
		//System.out.println(imgData);
		model.addAttribute("game", gameRepo.findById(gameId));
		model.addAttribute("imgData0", imgData);
		model.addAttribute("username", username);
		return "game";
	}
	
}



