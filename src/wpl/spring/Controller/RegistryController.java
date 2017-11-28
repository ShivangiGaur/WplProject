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

import wpl.spring.entity.Registry;
import wpl.spring.entity.User;
import wpl.spring.entity.registryItem;
import wpl.spring.service.RegistryService;

@Controller
@RequestMapping("/registry")
public class RegistryController {

	@Autowired
	private RegistryService registryService;

	//------------------------------------------------------
	@CrossOrigin
	@RequestMapping(value = "/add/", method = RequestMethod.POST,
	consumes = org.springframework.http.MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<Void> add(@RequestBody Registry registry)
	{
		System.out.println("RegistryId:" +registry.getRegistryId() + "RegistryName: " +registry.getRegistryName());
		registryService.addRegistry(registry);
		return new ResponseEntity<Void>(HttpStatus.CREATED);
	}
	//-------------------------------------------------------------
	@CrossOrigin
	@RequestMapping(value = "/getregistry/", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<Registry> getUser(@RequestParam("url") String url) {
		//	        System.out.println("Fetching User with email " + email);
		Registry registry = registryService.getRegistry(url);
		if (registry == null) {
			System.out.println("Registry having url " + url + " not found");
			return new ResponseEntity<Registry>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Registry>(registry, HttpStatus.OK);
	}

	//-------------------------------------------------------------
	@CrossOrigin
	@RequestMapping(value = "/getallregistry/", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<List<Registry>> getallUser(@RequestParam("userEmail") String email) {
		System.out.println("Fetching User with email " + email);
		List<Registry> registry = registryService.getallUserRegistry(email);
		if (registry == null) {
			System.out.println("Registry having id " + email + " not found");
			return new ResponseEntity<List<Registry>>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<List<Registry>>(registry, HttpStatus.OK);
	}
	
	//----------------------------------------------------------------------
	
	@CrossOrigin
	@RequestMapping(value = "/updateregistry/", method = RequestMethod.PUT)
    public ResponseEntity<Registry> updateUser(@RequestParam("url") String url, @RequestBody Registry registry) {
        System.out.println("Updating registry with url  " + url);
         

         
        int result = registryService.updateRegistry(url, registry);
        if(result>0)
        	return new ResponseEntity<Registry>(registry, HttpStatus.OK);
        else
        	return new ResponseEntity<Registry>(HttpStatus.NOT_FOUND);
    }	


	@CrossOrigin
	@RequestMapping(value = "/removeregistry", method = RequestMethod.DELETE)
	public ResponseEntity<Registry> removeRegistry(@RequestParam("url") String url) {
		System.out.println("Fetching & Deleting registry with url" + url);

		int result = registryService.removeRegistry(url);
		if(result>0)
			return new ResponseEntity<Registry>(HttpStatus.NO_CONTENT);
		else
			return new ResponseEntity<Registry>(HttpStatus.NOT_FOUND);
	}

}
