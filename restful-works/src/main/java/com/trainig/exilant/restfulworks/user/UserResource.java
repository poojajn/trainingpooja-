package com.trainig.exilant.restfulworks.user;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.mvc.ControllerLinkBuilder;
import org.springframework.hateoas.mvc.ControllerLinkBuilderFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

//user-given users-GET
//user/{userId} -given 1 users-GET
//users -POST -insert a user
@RestController
public class UserResource {
	@Autowired
	private UserDaoService userService;

	@GetMapping("/users")
	public List<User> getAllUsers() {
		return userService.getAllUsers();
	}

	@GetMapping("user/{userId}")
	public User getOneUser(@PathVariable int userId) {
		return userService.getUser(userId);
	}

	@GetMapping("user1/{userId}")
	public User getOneUser1(@PathVariable int userId) {
		User getUser = userService.getUser(userId);
		if (getUser == null) {
			throw new UserNotFoundException("id" + userId);
		}

		return getUser;
	}

	@PostMapping(path = "/saveusers")
	public void createUsers(@RequestBody User user) {
		System.out.println("dsfadsf");
		User save = userService.saveUsers(user);
		System.out.println(save);
	}

	@RequestMapping("/user-response")
	public ResponseEntity<Object> createUserResponseCode(@RequestBody User user) {
		User saveUser = userService.saveUsers(user);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{userId}")
				.buildAndExpand(saveUser.getUserId()).toUri();
		return ResponseEntity.created(location).build();

	}

	@GetMapping("delete/{userId}")
	public User deleteUser(@PathVariable int userId) {
		return userService.deleteUser(userId);
	}

	@PostMapping("update")
	public User updateUser(@RequestBody User user) {
		return userService.updateUser(user);
	}

	// will give user + give the referance lik=nk to the caller with additional
	// likns
	@GetMapping("user2/{userId}")
	public Resource<User> getOneUser2(@PathVariable int userId) {
		User getUser = userService.getUser(userId);
		if (getUser == null) {
			throw new UserNotFoundException("id" + userId);
		}
		// give the link for getting all users
		// with meta data "all=users
		// server=path+"/users"
		org.springframework.hateoas.Resource<User> resource = new org.springframework.hateoas.Resource<User>(getUser);
		ControllerLinkBuilder linkTo1 = new ControllerLinkBuilderFactory()
				.linkTo(methodOn(this.getClass()).getAllUsers());

		ControllerLinkBuilder linkTo2 = new ControllerLinkBuilderFactory()
				.linkTo(methodOn(this.getClass()).getOneUser(userId));

		resource.add(linkTo1.withRel("all-users"));
		resource.add(linkTo2.withRel("one-users"));
		return resource;
	}

	@PostMapping(path = "/saveusers1")
	public Resource<User> createUsers1(@RequestBody User user) {

		User save = userService.saveUsers(user);

		Resource<User> res = new Resource<User>(save);
		ControllerLinkBuilder linkTo2 = new ControllerLinkBuilderFactory()
				.linkTo(methodOn(this.getClass()).getOneUser2(save.getUserId()));
		res.add(linkTo2.withRel("users"));

		return res;

	}

}
