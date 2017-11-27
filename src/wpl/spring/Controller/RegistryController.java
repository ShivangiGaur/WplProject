package wpl.spring.Controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import wpl.spring.entity.User;
import wpl.spring.entity.registryItem;
import wpl.spring.service.IRegistryService;

@Controller
@RequestMapping("/item")
public class RegistryController {

	@Autowired
	private IRegistryService addToRegistryService;

	@RequestMapping(value = "/add/", method = RequestMethod.POST,
			consumes = org.springframework.http.MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<Void> add(@RequestBody registryItem ri)
	{
		System.out.println("itemid:" +ri.getItemId() + "Quantity: " +ri.getQuantity());
		addToRegistryService.addItem(ri);
		return new ResponseEntity<Void>(HttpStatus.CREATED);
	}
	
	//need to implement delete update getone getall

	
//	Get a Item
	
}
