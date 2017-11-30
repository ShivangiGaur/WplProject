package wpl.spring.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import wpl.spring.dao.IRegistryItemDAO;
import wpl.spring.entity.Inventory;
import wpl.spring.entity.Registry;
import wpl.spring.entity.User;
import wpl.spring.entity.registryitem;

@Service
public class IRegistryItemServiceImp implements IRegistryItemService {

	//inject additemdao 
	
	@Autowired
	private IRegistryItemDAO addItemDao;

	@Override
	@Transactional
	public int addItem(registryitem ri, String registryUrl) {
		return addItemDao.addItem(ri, registryUrl);
	}
	

	@Override
	@Transactional
	public registryitem getItem(String registryUrl, int itemId) {
		return addItemDao.getItem(registryUrl, itemId);
	}


	@Override
	@Transactional
	public List<registryitem> getallItem(String registryUrl) {
		return addItemDao.getallItem(registryUrl);
	}
	
	@Override
	@Transactional
	public int updateItem(registryitem update, String registryUrl) {
		return addItemDao.updateItem(update, registryUrl);
		
	}

	@Override
	@Transactional
	public int removeItem(registryitem remove, String registryUrl) {
		return addItemDao.removeItem(remove, registryUrl);
	}

	@Override
	@Transactional
	public List<Inventory> searchItem(Inventory search) {
		return addItemDao.searchItem(search);
		
	}	
	
}
