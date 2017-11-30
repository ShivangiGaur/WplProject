package wpl.spring.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.util.UriComponentsBuilder;

import wpl.spring.entity.Inventory;
import wpl.spring.entity.User;
import wpl.spring.entity.registryitem;
import wpl.spring.service.IRegistryItemService;
import wpl.spring.service.IUserService;

@Controller
@RequestMapping("/user")
@EnableWebMvc


public class UserController {

	@Autowired
	private IUserService addUserService;
	
//	Add a User
	@CrossOrigin
	@RequestMapping(value = "/add/", method = RequestMethod.POST,
			consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<Void> add(@RequestBody User user)
	{
		System.out.println("firstName:" +user.getFirstName() + "lastName: " +user.getLastName() + "emaiID:" +user.getEmail());
		addUserService.addUser(user);
		return new ResponseEntity<Void>(HttpStatus.CREATED);
	}

//	Get a User
	@CrossOrigin
	@RequestMapping(value = "/getuser/", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<User> getUser(@RequestParam("email") String email) {
		System.out.println("Fetching User with id " + email);
		User user = addUserService.getUser(email);
		if (user == null) {
			System.out.println("User with id " + email + " not found");
			return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<User>(user, HttpStatus.OK);
	}

//	Update a User
	@CrossOrigin
	@RequestMapping(value = "/updateuser/", method = RequestMethod.PUT)
	public ResponseEntity<User> updateUser(@RequestParam("email") String email, @RequestBody User user) {
		System.out.println("Updating User " + email);
		User currentUser = addUserService.getUser(email);

		if (currentUser==null) {
			System.out.println("User with id " + email + " not found");
			return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
		}

		currentUser.setFirstName(user.getFirstName());
		currentUser.setLastName(user.getLastName());
		currentUser.setPassword(user.getPassword());

		int result = addUserService.updateUser(currentUser);
		if(result>0)
			return new ResponseEntity<User>(currentUser, HttpStatus.OK);
		else
			return new ResponseEntity<User>(currentUser, HttpStatus.NOT_FOUND);
	}

//	Remove a User
	@CrossOrigin
	@RequestMapping(value = "/removeUser", method = RequestMethod.DELETE)
	public ResponseEntity<User> removeUser(@RequestParam("email") String email) {
		System.out.println("Fetching & Deleting User with id " + email);

		int result = addUserService.removeUser(email);
		if(result>0)
			return new ResponseEntity<User>(HttpStatus.NO_CONTENT);
		else
			return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
	}
	
//	Get All User
	  @CrossOrigin
	  @RequestMapping(value = "/user/", method = RequestMethod.GET)
	    public ResponseEntity<List<User>> listAllUsers() {
	        List<User> users = addUserService.getallUser();
	        if(users.isEmpty()){
	            return new ResponseEntity<List<User>>(HttpStatus.NO_CONTENT);//You many decide to return HttpStatus.NOT_FOUND
	        }
	        return new ResponseEntity<List<User>>(users, HttpStatus.OK);
	    }
	  
// Authenticate User
	  @CrossOrigin
		@RequestMapping(value = "/authenticateuser/", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
		public ResponseEntity<String> authenticateUser(@RequestParam("email") String email,@RequestParam("password") String password) {
			System.out.println("Fetching User with id " + email);
			String userEmail = addUserService.authenticateUser(email, password);
			if (userEmail == null) {
				System.out.println("User with id " + email + " not found");
				return new ResponseEntity<String>(HttpStatus.NOT_FOUND);
			}
			return new ResponseEntity<String>(userEmail, HttpStatus.OK);
		}  
}

