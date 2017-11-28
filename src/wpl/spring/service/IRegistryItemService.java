package wpl.spring.service;

import java.util.List;


import wpl.spring.entity.Inventory;
import wpl.spring.entity.Registry;
import wpl.spring.entity.User;
import wpl.spring.entity.registryItem;

public interface IRegistryItemService {

	public void addItem(registryItem ri) ;
	public int updateItem(registryItem update);
	public void removeItem(registryItem remove);
	//public User getItem(int item);
	public registryItem getItem(int registryId, int itemId);
	public List<registryItem> getallItem();
	public List<Inventory> searchItem(Inventory search);
		

}
