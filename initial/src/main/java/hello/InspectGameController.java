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
public class InspectGameController {
 
	@Autowired
	private GameRepository gameRepo;

	@RequestMapping("/game")
	public String showMainPage(
			@RequestParam(value = "username", required = true) String username, 
			@RequestParam(value = "gameId", required = true) String gameId, Model model) {
		model.addAttribute("game", gameRepo.findById(gameId));
		model.addAttribute("username", username);
		return "game";
	}
}
