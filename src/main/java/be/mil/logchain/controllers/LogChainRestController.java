package be.mil.logchain.controllers;

import java.util.ArrayList;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import be.mil.logchain.LogChainApplication;
import be.mil.logchain.LogBlock;

@RestController
@RequestMapping("/api")
public class LogChainRestController {
	
	@GetMapping("/blockchain")
	public ArrayList<LogBlock> getBlockChain(){
		return LogChainApplication.getBlockchain();
	}

}
