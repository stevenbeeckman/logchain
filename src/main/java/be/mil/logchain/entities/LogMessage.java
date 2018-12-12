package be.mil.logchain.entities;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * An entity wrapped around a LogMessage
 * @author stevenbeeckman
 *
 */

@Entity
public class LogMessage {

	@Id
	@GeneratedValue
	private Long id;
	
	private String author;
	
	private String message;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date creationDate;
	
	public LogMessage() {
	}
	
	public LogMessage(String author, String message, long time) {
		this.author = author;
		this.message = message;
		this.creationDate = new Date(time);
	}
	
	public String toString() {
		return author + message + creationDate.toString();
	}
}
