package wpl.spring.dao;

import java.util.List;

import wpl.spring.entity.Registry;

public interface RegistryDao {
	
	public void addRegistry(Registry registry);
	
	public Registry getRegistry(String url);
	
	public List<Registry> getAllRegistries(String userEmail);
	
	public int updateRegistry(String url, Registry registry);
	
	public int removeRegistry(String url);


}
