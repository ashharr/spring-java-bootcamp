package com.springboot.rest.webservices.restfulwebservices.user;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;
import java.net.URI;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.springboot.rest.webservices.restfulwebservices.jpa.PostJpaRepository;
import com.springboot.rest.webservices.restfulwebservices.jpa.UserJpaRepository;

import jakarta.validation.Valid;

@RestController
public class UserJpaResource {
	
	private UserJpaRepository repository;
	
	private PostJpaRepository postRepository;
	
	public UserJpaResource( UserJpaRepository repository,PostJpaRepository postRepository) {
		this.repository = repository;
		this.postRepository = postRepository;
	}

	@GetMapping(path = "/jpa/users")
	public List<User> getAllUsers() {
		return repository.findAll();
	}

	@GetMapping(path = "/jpa/users/{id}")
	public EntityModel<User> getUserById(@PathVariable int id) {
		Optional<User> user = repository.findById(id);
		
		if(user.isEmpty())
			throw new UserNotFoundException("id:"+id);
		
		EntityModel<User> entityModel = EntityModel.of(user.get());
		
		WebMvcLinkBuilder link =  linkTo(methodOn(this.getClass()).getAllUsers());
		entityModel.add(link.withRel("all-users"));
		
		return entityModel;
	}
	
	@DeleteMapping(path = "/jpa/users/{id}")
	public void deleteById(@PathVariable int id) {
		repository.deleteById(id);
	}
	
	
	@PostMapping(path = "/jpa/users")
	public ResponseEntity<User> createUser(@Valid @RequestBody User user) {
		User savedUser = repository.save(user);
		
		// To return the created user to the URI users/5/ where the new user was
		// created.
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(savedUser.getId())
				.toUri();

		return ResponseEntity.created(location).build();
	}
	
	@GetMapping(path = "/jpa/users/{id}/posts")
	public List<Post> getAllPostByUser(@PathVariable int id){
		Optional<User> user = repository.findById(id);
		return user.get().getPost();
	}
	
	@PostMapping(path = "/jpa/users/{id}/posts")
	public ResponseEntity<Object> createPostForUser(@PathVariable int id, @Valid @RequestBody Post post){
		Optional<User> user = repository.findById(id);
		
		if(user.isEmpty())
			throw new UserNotFoundException("id:"+id);
		
		post.setUser(user.get());
		Post savedPost = postRepository.save(post);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest()
												.path("/{id}").buildAndExpand(savedPost.getId())
												.toUri();

		
		return ResponseEntity.created(location).build();
	}
	
	@GetMapping(path = "/jpa/users/{userId}/posts/{postId}")
	public Post getPostByIdByUser(@PathVariable int userId, @PathVariable int postId){
		Optional<User> user = repository.findById(userId);
		List<Post> posts = user.get().getPost();
		Predicate<? super Post> predicate = post -> post.getId().equals(postId);
		return posts.stream().filter(predicate).findFirst().get();
	}
	
}
