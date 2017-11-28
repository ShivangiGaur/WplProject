package wpl.spring.dao;

import java.util.List;

import wpl.spring.entity.Inventory;
import wpl.spring.entity.Registry;
import wpl.spring.entity.registryItem;

public interface IRegistryItemDAO {

	public void addItem(registryItem ri);

	public int updateItem(registryItem update);

	public void removeItem(registryItem remove);
	
	public List<registryItem> getallItem();

	public List<Inventory> searchItem(Inventory search);

	public registryItem getItem(int registryId, int itemId);
	

}
