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
	}

}

