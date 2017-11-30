package wpl.spring.service;

import java.util.List;


import wpl.spring.entity.Inventory;
import wpl.spring.entity.Registry;
import wpl.spring.entity.User;
import wpl.spring.entity.registryitem;

public interface IRegistryItemService {

	public int addItem(registryitem ri, String registryUrl) ;
	public registryitem getItem(String registryId, int itemId);
	public List<registryitem> getallItem(String registryUrl);
	public int updateItem(registryitem update, String registryUrl);
	public int removeItem(registryitem remove, String registryUrl);
	//public User getItem(int item);
	public List<Inventory> searchItem(Inventory search);
		

}
