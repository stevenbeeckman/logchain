package be.mil.logchain.controllers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;

import be.mil.logchain.LogChainService;
import be.mil.logchain.entities.LogBlock;

@RestController
@RequestMapping("/api")
public class LogChainRestController {
	
	@Autowired
	LogChainService logChain;
	
	Logger logger = LoggerFactory.getLogger(LogChainRestController.class);
	
	
	@GetMapping("/blockchain")
	public ArrayList<LogBlock> getBlockChain(){
		ArrayList<LogBlock> chain = logChain.getLogChain();
//		logger.info("This is a logchain of {} LogBlocks", chain.size());
//		for(int i = 0; i < chain.size(); i++) {
//			logger.info("LogBlock {}: {} | {} | {} | {}", i, chain.get(i).getHash(), chain.get(i).getAuthor(), chain.get(i).getMessage(), chain.get(i).getPreviousHash());
//		}
		return logChain.getLogChain();
	}

	
	@GetMapping("/blockchain/valid")
	public Boolean isValid() {
		return logChain.isChainValid();
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
	public LogBlock newLogBlock(@Valid @RequestBody LogBlock logBlock) {
		ArrayList<LogBlock> logchain = logChain.getLogChain();
		String previousHash = logchain.size() > 0 ? logchain.get(0).getHash() : "";
		LogBlock newLogBlock = new LogBlock(logBlock.getAuthor(), logBlock.getMessage(), previousHash);
		logChain.add(newLogBlock);
		return newLogBlock;
	}
	
	@ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String, List<String>> handleValidationExceptions(MethodArgumentNotValidException ex) {
//        Map<String, String> errors = new HashMap<>();
//        ex.getBindingResult().getAllErrors().forEach((error) -> {
//            String fieldName = ((FieldError) error).getField();
//            String errorMessage = error.getDefaultMessage();
//            errors.put(fieldName, errorMessage);
//        });
//        return errors;
		Map<String, List<String>> errors = new HashMap<>();
		List<String> listOfErrors = new ArrayList<String>();
		ex.getBindingResult().getAllErrors().forEach((error) -> {
			String errorMessage = error.getDefaultMessage();;
			listOfErrors.add(errorMessage);
		});
		errors.put("errors", listOfErrors);
		return errors;
		
    }
}
