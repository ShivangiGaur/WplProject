package wpl.spring.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity(name = "registry")
@Table(name = "registry")
public class Registry {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "RegistryID")
	private int registryId;
	
	@Column(name = "registryName")
	private String registryName;
	
	@Column(name = "EventDate")
	private String eventDate;
	
	@Column(name = "Share")
	private int share;

	@Column(name = "userEmail")
	private String userEmail;

	@Column(name = "url")
	private String url;
	
	public Registry(int registryId, String registryName, String eventDate, int share, String userEmail,
			String url) {
		super();
		this.registryId = registryId;
		this.registryName = registryName;
		this.eventDate = eventDate;
		this.share = share;
		this.userEmail = userEmail;
		this.url = url;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public Registry() {
		
	}

	public int getRegistryId() {
		return registryId;
	}

	public void setRegistryId(int registryId) {
		this.registryId = registryId;
	}

	public String getRegistryName() {
		return registryName;
	}

	public void setRegistryName(String registryName) {
		this.registryName = registryName;
	}

	public String getEventDate() {
		return eventDate;
	}

	public void setEventDate(String eventDate) {
		this.eventDate = eventDate;
	}

	public int getShare() {
		return share;
	}

	public void setShare(int share) {
		this.share = share;
	}

}
