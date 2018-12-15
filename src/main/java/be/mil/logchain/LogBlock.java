package be.mil.logchain;

import java.util.Date;

import be.mil.logchain.entities.LogMessage;
import be.mil.logchain.util.HashUtil;

/**
 * @author stevenbeeckman
 *	A LogBlock contains a hash, a previousHash, data, and a timestamp.
 */
public class LogBlock {
	
	public String hash;
	public String previousHash;
	public LogMessage logMessage;
	private long timestamp;
	
	public LogBlock(String author, String message, String previousHash) {
		this.timestamp = new Date().getTime();
		this.logMessage = new LogMessage(author, message, this.timestamp);
		this.previousHash = previousHash;
		this.hash = hash();
	}
	
	public String getHash() {
		return hash;
	}

	public String getPreviousHash() {
		return previousHash;
	}

	public LogMessage getLogMessage() {
		return logMessage;
	}

	public long getTimestamp() {
		return timestamp;
	}

	public String hash() {
		String calculatedHash = HashUtil.hashSha256(
					previousHash
					+ Long.toString(timestamp)
					+ logMessage.toString()
				);
		return calculatedHash;
	}

}
