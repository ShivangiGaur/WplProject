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
import wpl.spring.entity.registryItem;
import wpl.spring.service.IRegistryItemService;

@Controller
@RequestMapping("/item")
public class RegistryItemController {

	@Autowired
	private IRegistryItemService registryitemService;

	@RequestMapping(value = "/add/", method = RequestMethod.POST,
			consumes = org.springframework.http.MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<Void> add(@RequestBody registryItem ri)
	{
		System.out.println("itemid:" +ri.getItemId() + "Quantity: " +ri.getQuantity());
		registryitemService.addItem(ri);
		return new ResponseEntity<Void>(HttpStatus.CREATED);
	}
	
	//need to implement delete update getone registry id  getall user email

	
//	Get a Item
	@CrossOrigin
	@RequestMapping(value = "/getitem/", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<registryItem> getUser(@RequestParam("registryId") int registryId, @RequestParam("itemId") int itemId) {
//        System.out.println("Fetching User with email " + email);
        registryItem registryitem = registryitemService.getItem(registryId, itemId);
        if (registryitem == null) {
            System.out.println("item having item id " + itemId + " not found");
            return new ResponseEntity<registryItem>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<registryItem>(registryitem, HttpStatus.OK);
    }
	
	//---------------------------------------------------------------------
	@CrossOrigin
	 @RequestMapping(value = "/itemlist/", method = RequestMethod.GET)
	    public ResponseEntity<List<registryItem>> getAllitems() {
	        List<registryItem> items = registryitemService.getallItem();
	        if(items.isEmpty()){
	            return new ResponseEntity<List<registryItem>>(HttpStatus.NO_CONTENT);//You many decide to return HttpStatus.NOT_FOUND
	        }
	        return new ResponseEntity<List<registryItem>>(items, HttpStatus.OK);
	    }
	//----------------------------------------------------------------------
	
	@CrossOrigin
	@RequestMapping(value = "/updateitem/", method = RequestMethod.PUT)
    public ResponseEntity<registryItem> updateUser(@RequestParam("registryId") int registryId, @RequestParam("itemId") int itemId, @RequestBody registryItem registryItem) {
        System.out.println("Updating item with item  " + itemId);
         
        registryItem registryItemUpdate = registryitemService.getItem(registryId, itemId);
         
        if (registryItemUpdate==null) {
            System.out.println("Item with id " + itemId + " not found");
            return new ResponseEntity<registryItem>(HttpStatus.NOT_FOUND);
        }
 
        registryItemUpdate.setQuantity(registryItem.getQuantity());
         
        int result = registryitemService.updateItem(registryItemUpdate);
        if(result>0)
        	return new ResponseEntity<registryItem>(registryItemUpdate, HttpStatus.OK);
        else
        	return new ResponseEntity<registryItem>(HttpStatus.NOT_FOUND);
    }
	
	//---------------------------------------------------------------------------
	@CrossOrigin
	 @RequestMapping(value = "/removeitem/", method = RequestMethod.DELETE)
	    public ResponseEntity<registryItem> deleteItem(@RequestParam("registryId") int registryId, @RequestParam("itemId") int itemId) {
	        System.out.println("Fetching & Deleting Item with id " + itemId);
	 
	        registryItem deleteRegistryItem = registryitemService.getItem(registryId, itemId);
	        if (deleteRegistryItem == null) {
	            System.out.println("Unable to delete. Item with id " + itemId + " not found");
	            return new ResponseEntity<registryItem>(HttpStatus.NOT_FOUND);
	        }
	 
	        registryitemService.removeItem(deleteRegistryItem);
	        return new ResponseEntity<registryItem>(HttpStatus.NO_CONTENT);
	    }
	
}
