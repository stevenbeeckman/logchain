package be.mil.logchain.entities;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import be.mil.logchain.util.HashUtil;

/**
 * @author stevenbeeckman
 *	A LogBlock contains a hash, a previousHash, data, and a timestamp.
 */
@Entity
@Table(name = "logblock")
public class LogBlock {
	
	@Id
	public String hash;
	public String previousHash;
	private String author;
	private String message;
	private Date createdDate;
	
	public LogBlock() {
		
	}
	
	public LogBlock(String author, String message, String previousHash) {
		this.createdDate = new Date();
		this.author = author;
		this.message = message;
		this.previousHash = previousHash;
		this.hash = hash();
	}
	
	public String getAuthor() {
		return this.author;
	}
	
	public String getMessage() {
		return this.message;
	}
	
	public Date getCreatedDate() {
		return this.createdDate;
	}
	
	public String getHash() {
		return hash;
	}

	public String getPreviousHash() {
		return previousHash;
	}

	public String hash() {
		String calculatedHash = HashUtil.hashSha256(
					previousHash
					+ Long.toString(createdDate.getTime())
					+ author
					+ message
				);
		return calculatedHash;
	}

}
