package wpl.spring.dao;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import wpl.spring.entity.Registry;
import wpl.spring.entity.registryitem;

@Repository
public class RegistryDaoImpl implements RegistryDao {
	@Autowired 
	private SessionFactory sessionFactory;


	@Override
	public void addRegistry(Registry registry) {
		Session currentSession = sessionFactory.getCurrentSession();
		// add item
		currentSession.save(registry);
		
	}


	@Override
	public Registry getRegistry(String url) {
		Session currentSession = sessionFactory.getCurrentSession();
		String stringQuery = "FROM registry WHERE url = '" + url +"'";
		Query query = currentSession.createQuery(stringQuery);
		List<Registry> userReturned = query.getResultList();
		if(userReturned.size()>0)
			return userReturned.get(0);
		else
			return null;
	}


	@Override
	public List<Registry> getAllRegistries(String userEmail) {
		Session currentSession = sessionFactory.getCurrentSession();
		String stringQuery = "FROM registry WHERE userEmail = '" + userEmail +"'";
		Query query = currentSession.createQuery(stringQuery);
		List<Registry> userReturned = query.getResultList();
		if(userReturned.size()>0)
			return userReturned;
		else
			return null;
	}


	@Override
	public int updateRegistry(String url, Registry registry) {
		Session currentSession = sessionFactory.getCurrentSession();
		String stringQuery = "UPDATE registry SET RegistryName= :registryName, EventDate= :eventDate, Share= :share "
				+ "WHERE url= '"+url+"'";
		Query query = currentSession.createQuery(stringQuery);
		query.setParameter("registryName", registry.getRegistryName());
		query.setParameter("eventDate", registry.getEventDate());
		query.setParameter("share", registry.getShare());
	    return query.executeUpdate();
	}


	@Override
	public int removeRegistry(String url) {
		Session currentSession = sessionFactory.getCurrentSession();
		String stringQuery = "Delete from registry where url = '"+url+"'";
		Query query = currentSession.createQuery(stringQuery);
		int result = query.executeUpdate();
		return result;
	}


	


}
