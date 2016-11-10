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
public class CreateGameController {
	
	@Autowired
	private GameRepository gameRepo;
 
	@RequestMapping("/creategame")
	public String showCreateGame(
			@RequestParam(value = "username", required = true) String username, Model model) {
		model.addAttribute("username", username);
		return "creategame";
	}

	@RequestMapping(value = "/creategame", method = RequestMethod.POST)
	public String submit(@RequestParam("gameName") String name, @RequestParam(value = "username", required = true) String username, @RequestParam("length") int length, @RequestParam("phrase") String phrase, Model model) {
		System.out.println(name);
		System.out.println(length);
		System.out.println(phrase);
		System.out.println(username);
		gameRepo.save(new Game(name, phrase, username, length, 0));	
		model.addAttribute("username", username);
		return "creategame";
	}
}
