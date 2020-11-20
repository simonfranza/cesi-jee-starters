package com.jee.helloworld.controller;

import com.jee.helloworld.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.UUID;

@Controller
@RequestMapping("/user")
public class UserController {
	ArrayList<User> validAccounts = new ArrayList<User>() {{
		add(new User("admin", "admin"));
	}};
	static HashMap<String, String> userTokens = new HashMap<>();

	@GetMapping("/login")
	public String login(Model model) {
		model.addAttribute("user", new User());
		return "login";
	}

	@PostMapping(path = "/login")
	public String login(HttpSession session, @ModelAttribute User user) {
		User authenticatedUser = validAccounts.stream()
				.filter(pUser -> pUser.getUsername().equals(user.getPassword()) && pUser.getPassword().equals(user.getPassword()))
				.findFirst()
				.orElse(null);

		if (authenticatedUser != null) {
			UUID token = UUID.randomUUID();
			userTokens.put(token.toString(), user.getUsername());
			session.setAttribute("authToken", token.toString());
			return "redirect:/earthquake";
		}

		return "redirect:/login";
	}

	public static boolean isTokenValid(String token) {
		return userTokens.containsKey(token);
	}
}
