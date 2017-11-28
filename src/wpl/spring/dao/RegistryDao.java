package wpl.spring.dao;

import java.util.List;

import wpl.spring.entity.Registry;

public interface RegistryDao {
	
	public void addRegistry(Registry registry);
	
	public Registry getRegistry(int registryId);
	
	public List<Registry> getallUserRegistry(String userEmail);
	
	public int updateRegistry(String url, Registry registry);
	
	public int removeRegistry(String url);


}