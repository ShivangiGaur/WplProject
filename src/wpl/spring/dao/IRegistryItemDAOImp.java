package wpl.spring.dao;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import wpl.spring.entity.Inventory;
import wpl.spring.entity.Registry;
import wpl.spring.entity.registryItem;

@Repository
public class IRegistryItemDAOImp implements IRegistryItemDAO {

	//Inject session factory
	@Autowired 
	private SessionFactory sessionFactory;
	
	public void addItem(registryItem ri) {
		//get current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		// add item
		currentSession.save(ri);
		
	}

	public int updateItem(registryItem update) {
		
		Session currentSession = sessionFactory.getCurrentSession();
    	System.out.println(update.getRegistrtyId());
	    String stringQuery = "UPDATE registryItem SET Quantity= :quantity WHERE RegistryID= '"+update.getRegistrtyId()+"' AND ItemId = '"+update.getItemId()+"'";
	    Query query = currentSession.createQuery(stringQuery);
	    query.setParameter("quantity", update.getQuantity());
	    return query.executeUpdate();
	    
		
	}

	public void removeItem(registryItem remove) {
		Session currentSession = sessionFactory.getCurrentSession();
		String stringQuery = "DELETE from registryItem WHERE RegistryID= '"+remove.getRegistrtyId()+"' AND ItemId = '"+remove.getItemId()+"'";
	    Query query = currentSession.createQuery(stringQuery);
	    query.executeUpdate();
		
	}

	
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
	
	@Override
	public registryItem getItem(int registryId, int itemId) {
		Session currentSession = sessionFactory.getCurrentSession();
		String stringQuery = "FROM registryitem WHERE RegistryId = " + registryId + " and ItemId = " + itemId;
		Query query = currentSession.createQuery(stringQuery);
		@SuppressWarnings("unchecked")
		List<registryItem> userReturned = query.getResultList();
		if(userReturned.size()>0)
			return userReturned.get(0);
		else
			return null;
	}

	@Override
	public List<registryItem> getallItem() {
		Session currentSession = sessionFactory.getCurrentSession();
		String stringQuery = "FROM registryitem";
		Query query = currentSession.createQuery(stringQuery);
		@SuppressWarnings("unchecked")
		List<registryItem> itemList = query.getResultList();
		if(itemList.size()>0)
			return itemList;
		else
			return null;
	}
}
