package wpl.spring.Controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import wpl.spring.entity.User;
import wpl.spring.entity.registryitem;
import wpl.spring.service.IRegistryItemService;

@Controller
@RequestMapping("/item")
public class RegistryItemController {

	@Autowired
	private IRegistryItemService registryitemService;

	@RequestMapping(value = "/add/", method = RequestMethod.POST,
			consumes = org.springframework.http.MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<Void> addItem(@RequestBody registryitem ri, @RequestParam("registryUrl") String registryUrl)
	{
		System.out.println("itemid:" +ri.getItemId() + "Quantity: " +ri.getQuantity()+"url"+ri.getUrl());
		registryitemService.addItem(ri,registryUrl);
		return new ResponseEntity<Void>(HttpStatus.CREATED);
	}
	
//	Get a Item
	@CrossOrigin
	@RequestMapping(value = "/getitem/", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<registryitem> getItem(@RequestParam("registryUrl") String registryUrl, @RequestParam("itemId") int itemId) {
//        System.out.println("Fetching User with email " + email);
        registryitem registryitem = registryitemService.getItem(registryUrl, itemId);
        if (registryitem == null) {
            System.out.println("item having item id " + itemId + " not found");
            return new ResponseEntity<registryitem>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<registryitem>(registryitem, HttpStatus.OK);
    }
	
	//---------------------------------------------------------------------
	@CrossOrigin
	 @RequestMapping(value = "/itemlist/", method = RequestMethod.GET)
	    public ResponseEntity<List<registryitem>> getAllitems(@RequestParam("registryUrl") String registryUrl) {
	        List<registryitem> items = registryitemService.getallItem(registryUrl);
	        if(items.isEmpty()){
	            return new ResponseEntity<List<registryitem>>(HttpStatus.NO_CONTENT);//You many decide to return HttpStatus.NOT_FOUND
	        }
	        return new ResponseEntity<List<registryitem>>(items, HttpStatus.OK);
	    }
	//----------------------------------------------------------------------
	
	@CrossOrigin
	@RequestMapping(value = "/updateitem/", method = RequestMethod.PUT)
    public ResponseEntity<registryitem> updateItem(@RequestParam("registryUrl") String registryUrl, @RequestParam("itemId") int itemId, @RequestBody registryitem registryItem) {
        System.out.println("Updating item with item  " + itemId);
        registryitem registryItemUpdate = registryitemService.getItem(registryUrl, itemId);
         
        if (registryItemUpdate==null) {
            System.out.println("Item with id " + itemId + " not found");
            return new ResponseEntity<registryitem>(HttpStatus.NOT_FOUND);
        }
 
        registryItemUpdate.setQuantity(registryItem.getQuantity());
         
        int result = registryitemService.updateItem(registryItemUpdate,registryUrl);
        if(result>0)
        	return new ResponseEntity<registryitem>(registryItemUpdate, HttpStatus.OK);
        else
        	return new ResponseEntity<registryitem>(HttpStatus.NOT_FOUND);
    }
	
	//---------------------------------------------------------------------------
	@CrossOrigin
	 @RequestMapping(value = "/removeitem/", method = RequestMethod.DELETE)
	    public ResponseEntity<registryitem> deleteItem(@RequestParam("registryUrl") String registryUrl, @RequestParam("itemId") int itemId) {
	        System.out.println("Fetching & Deleting Item with id " + itemId);
	 
	        registryitem deleteRegistryItem = registryitemService.getItem(registryUrl, itemId);
	        if (deleteRegistryItem == null) {
	            System.out.println("Unable to delete. Item with id " + itemId + " not found");
	            return new ResponseEntity<registryitem>(HttpStatus.NOT_FOUND);
	        }
	 
	        registryitemService.removeItem(deleteRegistryItem, registryUrl);
	        return new ResponseEntity<registryitem>(HttpStatus.NO_CONTENT);
	    }
	
}
