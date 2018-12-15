package be.mil.logchain.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LogChainController {

	@GetMapping("/")
	public String homepage() {
		return "index";
	}
}
