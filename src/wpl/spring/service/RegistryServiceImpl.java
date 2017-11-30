package wpl.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import wpl.spring.dao.RegistryDao;
import wpl.spring.entity.Registry;

@Service
public class RegistryServiceImpl implements RegistryService {
	
	@Autowired
	private RegistryDao registryDao;

	@Override
	@Transactional
	public void addRegistry(Registry registry) {
		registryDao.addRegistry(registry);
		
	}

	@Override
	@Transactional
	public Registry getRegistry(String url) {
		return registryDao.getRegistry(url);
	}

	@Override
	@Transactional
	public List<Registry> getAllRegistries(String userEmail) {

		return registryDao.getAllRegistries(userEmail);
	}

	@Override
	@Transactional
	public int updateRegistry(String url, Registry registry) {
		// TODO Auto-generated method stub
		return registryDao.updateRegistry(url, registry);
	}

	@Override
	@Transactional
	public int removeRegistry(String url) {
		// TODO Auto-generated method stub
		return registryDao.removeRegistry(url);
	}

}
