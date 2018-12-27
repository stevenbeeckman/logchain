package be.mil.logchain.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

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
	@DateTimeFormat(iso=DateTimeFormat.ISO.DATE_TIME)
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
	
	public LogMessage(String author, String message, Date time, double latitude, double longitude) {
		this.author = author;
		this.message = message;
		this.creationDate = time;
		System.out.println(creationDate);
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

	public void setId(Long id) {
		this.id = id;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}

	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}
	
	
}
