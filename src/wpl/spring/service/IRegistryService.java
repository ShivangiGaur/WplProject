package wpl.spring.service;

import java.util.List;


import wpl.spring.entity.Inventory;
import wpl.spring.entity.User;
import wpl.spring.entity.registryItem;

public interface IRegistryService {

	public void addItem(registryItem ri) ;
	public void updateItem(registryItem update);
	public void removeItem(registryItem remove);
	public User getItem(int item);
//	public List<Item> getallItem();
	public List<Inventory> searchItem(Inventory search);
		

}
