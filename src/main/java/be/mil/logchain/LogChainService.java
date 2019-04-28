package be.mil.logchain;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import be.mil.logchain.entities.LogBlock;

@Service
public class LogChainService {

	@Autowired
	LogChainRepository repository;
	
	public LogChainService() {
		
	}
	
	public ArrayList<LogBlock> getLogChain(){
		return (ArrayList<LogBlock>) repository.findAll(Sort.by(Sort.Direction.DESC, "createdDate"));
	}
	
	public LogBlock add(LogBlock logBlock) {
		return repository.save(logBlock);
	}
	
	public Boolean isChainValid() {
		ArrayList<LogBlock> blockchain = repository.findAll();
		LogBlock currentBlock;
		LogBlock previousBlock;
		
		for(int i = 1; i < blockchain.size(); i++) {
			currentBlock = blockchain.get(i);
			previousBlock = blockchain.get(i-1);
			if(!currentBlock.hash.equals(currentBlock.hash())){
				System.out.println("Current hash is not correct.");
				return false;
			}
			if(!previousBlock.hash.equals(currentBlock.previousHash)) {
				System.out.println("Previous hash is not correct.");
				return false;
			}
		}
		return true;
	}
	
}
