package wpl.spring.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import wpl.spring.dao.IRegistryItemDAO;
import wpl.spring.entity.Inventory;
import wpl.spring.entity.Registry;
import wpl.spring.entity.User;
import wpl.spring.entity.registryItem;

@Service
public class IRegistryItemServiceImp implements IRegistryItemService {

	//inject additemdao 
	
	@Autowired
	private IRegistryItemDAO addItemDao;

	@Override
	@Transactional
	public void addItem(registryItem ri) {
		addItemDao.addItem(ri);
		
	}

	@Override
	@Transactional
	public int updateItem(registryItem update) {
		return addItemDao.updateItem(update);
		
	}

	@Override
	@Transactional
	public void removeItem(registryItem remove) {
		addItemDao.removeItem(remove);
		
	}

	@Override
	@Transactional
	public List<Inventory> searchItem(Inventory search) {
		return addItemDao.searchItem(search);
		
	}

	

	@Override
	@Transactional
	public registryItem getItem(int registryId, int itemId) {
		return addItemDao.getItem(registryId, itemId);
	}

	@Override
	@Transactional
	public List<registryItem> getallItem() {
		return addItemDao.getallItem();
	}

	
	
}
