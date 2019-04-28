package be.mil.logchain;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import be.mil.logchain.entities.LogBlock;

@Repository
public interface LogChainRepository extends JpaRepository<LogBlock, String>{

	LogBlock findByHash(String hash);
	ArrayList<LogBlock> findAll();
	
	LogBlock save(LogBlock logBlock);
	
	long count();
}
