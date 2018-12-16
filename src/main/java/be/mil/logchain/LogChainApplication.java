package be.mil.logchain;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.Date;
import java.util.TimeZone;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class LogChainApplication {
	
	public static ArrayList<LogBlock> blockchain = new ArrayList<LogBlock>();

	public static void main(String[] args) {
		SpringApplication.run(LogChainApplication.class, args);
		
		loadSampleData();
	}

	private static void loadSampleData() {
		// insert example data
		System.out.println(TimeZone.getAvailableIDs());
		LocalDateTime now = LocalDateTime.now(ZoneId.of("+01:00"));
		LocalDateTime anHourAgo = now.minusHours(1);
		LocalDateTime twoHoursAgo = now.minusHours(2);
				
		blockchain.add(new LogBlock("General Ortega", "There's a certain calmth in the air.", 51.3385, 3.2033, Date.from(twoHoursAgo.toInstant(ZoneOffset.of("+01:00"))), "1"));
		blockchain.add(new LogBlock("Colonel Sanders", "I feel a storm coming.", 52.001828, 3.967378, Date.from(anHourAgo.toInstant(ZoneOffset.of("+01:00"))), blockchain.get(blockchain.size()-1).hash));
		blockchain.add(new LogBlock("Captain Zork", "Aye matey's, hold on to your ankles! This storm is huge!", 52.961742, 4.787853, Date.from(now.toInstant(ZoneOffset.of("+01:00"))), blockchain.get(blockchain.size()-1).hash));
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

