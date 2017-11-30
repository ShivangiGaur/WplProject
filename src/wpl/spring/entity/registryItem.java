package wpl.spring.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity(name="registryitem")
@Table(name="registryitem")
public class registryitem {
	@Id
	@Column(name = "url")
	private String url;
	
	@Column(name = "ItemId")
	private int itemId;
	
	@Column(name = "Quantity")
	private int quantity;

	public registryitem()
	{
		
	}
	public registryitem(String url, int itemId, int quantity) {
		super();
		this.url = url;
		this.itemId = itemId;
		this.quantity = quantity;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public int getItemId() {
		return itemId;
	}

	public void setItemId(int itemId) {
		this.itemId = itemId;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	
	
	
}
