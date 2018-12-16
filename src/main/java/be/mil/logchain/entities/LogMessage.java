package be.mil.logchain.entities;

import java.util.Date;

import javax.persistence.Column;
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
	
	@Column(nullable=true)
	private double latitude;
	@Column(nullable=true)
	private double longitude;
	
	public LogMessage() {
	}
	
	public LogMessage(String author, String message, long time) {
		this.author = author;
		this.message = message;
		this.creationDate = new Date(time);
	}
	
	public LogMessage(String author, String message, long time, double latitude, double longitude) {
		this.author = author;
		this.message = message;
		this.creationDate = new Date(time);
		this.latitude = latitude;
		this.longitude = longitude;
	}
	
	public String toString() {
		return author + message + creationDate.toString();
	}

	public Long getId() {
		return id;
	}

	public String getAuthor() {
		return author;
	}

	public String getMessage() {
		return message;
	}

	public Date getCreationDate() {
		return creationDate;
	}

	public double getLatitude() {
		return latitude;
	}

	public double getLongitude() {
		return longitude;
	}
	
	
}
