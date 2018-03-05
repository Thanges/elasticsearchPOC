/**
 * 
 */
package com.search.controller;

import java.util.ArrayList;
import java.util.List;

import org.elasticsearch.ResourceNotFoundException;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.search.model.Users;
import com.search.repo.SearchRepository;

/**
 * @author Thanges
 *
 */

@RestController
@RequestMapping("/rest/search")
public class SearchController  {
	
	private static final Logger log = org.slf4j.LoggerFactory.getLogger(SearchController.class);
	
	@Autowired
	SearchRepository repository;
	
	@GetMapping(value ="/name/{text}")
	public List<Users> searchName(@PathVariable final String text){
		log.info("Calling searchName URI");
		List<Users> user =repository.findByName(text);
		if (user == null || user.isEmpty()){
			throw new ResourceNotFoundException("User Not Available");
		}
		return user;
	}
	
	@GetMapping(value ="/id/{id}")
	public List<Users> searchById(@PathVariable final Long id){
		log.info("Calling searchById URI");
		List<Users> user = repository.findById(id);
		if (user == null || user.isEmpty()){
			throw new ResourceNotFoundException("User Not Available");
		}
		return user;
	}
	
	@GetMapping(value ="/all")
	public List<Users> searchAll(){
		log.info("Calling searchAll URI");
		List<Users> userList = new ArrayList<>();
		Iterable<Users> users = repository.findAll();
		if (users == null){
			log.debug("The Requested User has no value : " , users);
			throw new ResourceNotFoundException("User Not Available");
		}
		users.forEach(userList::add);
		return userList;
		}
}
