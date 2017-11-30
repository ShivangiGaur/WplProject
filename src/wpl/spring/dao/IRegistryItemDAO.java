package wpl.spring.dao;

import java.util.List;

import wpl.spring.entity.Inventory;
import wpl.spring.entity.Registry;
import wpl.spring.entity.registryitem;

public interface IRegistryItemDAO {

	public int addItem(registryitem ri, String registryUrl);

	public registryitem getItem(String registryUrl, int itemId);
	
	public List<registryitem> getallItem(String registryUrl);

	public int updateItem(registryitem update, String registryUrl);

	public int removeItem(registryitem remove, String registryUrl);

	public List<Inventory> searchItem(Inventory search);
	

}
