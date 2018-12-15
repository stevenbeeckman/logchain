package be.mil.logchain;

import java.util.ArrayList;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.google.gson.GsonBuilder;

@SpringBootApplication
public class LogChainApplication {
	
	public static ArrayList<LogBlock> blockchain = new ArrayList<LogBlock>();

	public static void main(String[] args) {
		SpringApplication.run(LogChainApplication.class, args);
		
		blockchain.add(new LogBlock("General Ortega", "There's a certain calmth in the air.", "1"));
		blockchain.add(new LogBlock("Colonel Sanders", "I feel a storm coming.", blockchain.get(blockchain.size()-1).hash));
		blockchain.add(new LogBlock("Captain Zork", "Aye matey's, hold on to your ankles! This storm is huge!", blockchain.get(blockchain.size()-1).hash));

		String blockchainJson = new GsonBuilder().setPrettyPrinting().create().toJson(blockchain);
		System.out.println(blockchainJson);
		System.out.println(isChainValid() ? "The chain is valid." : "The chain is not valid.");
	}

	public static Boolean isChainValid() {
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
	
	public static ArrayList<LogBlock> getBlockchain(){
		return blockchain;
	}
}

