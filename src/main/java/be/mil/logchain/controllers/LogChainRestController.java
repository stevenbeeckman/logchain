package be.mil.logchain.controllers;

import java.util.ArrayList;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import be.mil.logchain.LogChainApplication;
import be.mil.logchain.entities.LogMessage;
import be.mil.logchain.LogBlock;

@RestController
@RequestMapping("/api")
public class LogChainRestController {
	
	@GetMapping("/blockchain")
	public ArrayList<LogBlock> getBlockChain(){
		return LogChainApplication.getBlockchain();
	}

	
	@GetMapping("/blockchain/valid")
	public Boolean isValid() {
		return LogChainApplication.isChainValid();
	}
	
	
	/**
	 * LogMessage constructor needs these fields: String author, String message
	 * , long time, double latitude, double longitude.
	 * 
	 * LogBlock constructor needs these fields: String author, String message
	 * , double latitude, double longitude, Date timestamp, String previousHash
	 * 
	 * @param logMessage
	 * @return
	 */
	@PostMapping("/blockchain/logblock")
	public LogBlock newLogBlock(@RequestBody LogMessage logMessage) {
		ArrayList<LogBlock> blockchain = LogChainApplication.getBlockchain();
		String previousHash = blockchain.get(blockchain.size()-1).hash;
		LogBlock newLogBlock = new LogBlock(logMessage.getAuthor(), logMessage.getMessage(), logMessage.getLatitude(), logMessage.getLongitude(), logMessage.getCreationDate(), previousHash);
		blockchain.add(newLogBlock);
		return newLogBlock;
	}
}
