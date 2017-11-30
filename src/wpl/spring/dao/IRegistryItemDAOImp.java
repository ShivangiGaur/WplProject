package wpl.spring.dao;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import wpl.spring.entity.Inventory;
import wpl.spring.entity.Registry;
import wpl.spring.entity.registryitem;

@Repository
public class IRegistryItemDAOImp implements IRegistryItemDAO {

	//Inject session factory
	@Autowired 
	private SessionFactory sessionFactory;
	
	public int addItem(registryitem ri, String registryUrl) {
		
		Session currentSession = sessionFactory.getCurrentSession();
	    Query query = currentSession.createSQLQuery("INSERT INTO registryitem (url, ItemId, Quantity) VALUES (:u, :i, :q)");
	    query.setParameter("u", registryUrl);
	    query.setParameter("i", ri.getItemId());
	    query.setParameter("q", ri.getQuantity());
	    return query.executeUpdate();
	}

	
	@Override
	public registryitem getItem(String registryUrl, int itemId) {
		Session currentSession = sessionFactory.getCurrentSession();
		String stringQuery = "FROM registryitem WHERE url = '" + registryUrl + "' and ItemId = " + itemId;
		Query query = currentSession.createQuery(stringQuery);
		@SuppressWarnings("unchecked")
		List<registryitem> userReturned = query.getResultList();
		if(userReturned.size()>0)
			return userReturned.get(0);
		else
			return null;
	}
	

	@Override
	public List<registryitem> getallItem(String registryUrl) {
		Session currentSession = sessionFactory.getCurrentSession();
		String stringQuery = "FROM registryitem WHERE url = '"+registryUrl+"'";
		Query query = currentSession.createQuery(stringQuery);
		@SuppressWarnings("unchecked")
		List<registryitem> itemList = query.getResultList();
		if(itemList.size()>0)
			return itemList;
		else
			return null;
	}

	public int updateItem(registryitem update, String registryUrl) {
		
		Session currentSession = sessionFactory.getCurrentSession();
    	System.out.println(update.getUrl());
	    String stringQuery = "UPDATE registryitem SET Quantity= :quantity WHERE url= '"+update.getUrl()+"' AND ItemId = '"+update.getItemId()+"'";
	    Query query = currentSession.createQuery(stringQuery);
	    query.setParameter("quantity", update.getQuantity());
	    return query.executeUpdate();
	    
		
	}

	public int removeItem(registryitem remove, String registryUrl) {
		Session currentSession = sessionFactory.getCurrentSession();
		String stringQuery = "DELETE from registryItem WHERE url= '"+remove.getUrl()+"' AND ItemId = '"+remove.getItemId()+"'";
	    Query query = currentSession.createQuery(stringQuery);
	    return query.executeUpdate();
	}

//	
	public List<Inventory> searchItem(Inventory search) {
		Session currentSession = sessionFactory.getCurrentSession();
		String stringQuery = "FROM Inventory WHERE itemName='" + search.getItemName() + "'";
	    Query query = currentSession.createQuery(stringQuery);
	    List<Inventory> items = query.getResultList();
	
	    if (items.size() != 0)
	    {
	    	return items;
	    } else {
	    	return null;
	    }
		
	}

}
