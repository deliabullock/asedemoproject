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
			@RequestParam(value = "name", required = false, defaultValue = "user") String name, Model model) {
		String user = "Emily";
		model.addAttribute("username", user);
		return "creategame";
	}

	@RequestMapping(value = "/creategame", method = RequestMethod.POST)
	public String submit(@RequestParam("gameName") String name, @RequestParam("username") String username, @RequestParam("length") int length, @RequestParam("phrase") String phrase, Model model) {
		System.out.println(name);
		System.out.println(length);
		System.out.println(phrase);
		gameRepo.save(new Game(name, phrase, username, length, 0));	
		return "creategame";
	}
}
