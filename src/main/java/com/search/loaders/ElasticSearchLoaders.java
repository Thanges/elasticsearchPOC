/**
 * 
 */
package com.search.loaders;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.elasticsearch.core.ElasticsearchOperations;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.search.model.Users;
import com.search.repo.SearchRepository;

/**
 * @author Thanges
 *
 */

/**
 * 
 * Thiis class is used to load the data for Elastic Search
 *
 */
@Component
public class ElasticSearchLoaders {
	
	
	private static final Logger log = org.slf4j.LoggerFactory.getLogger(ElasticSearchLoaders.class);
	//This is used to create the mappings for the users (Model class)
	@Autowired
	ElasticsearchOperations elasticsearchOperations ;
	
	// Injecting the repository which we created
	@Autowired
	SearchRepository repository;
	
	@PostConstruct
	@Transactional
	public void loadAll(){
		log.info("Elastic loader started");
		elasticsearchOperations.putMapping(Users.class);
		log.info("Data Saved Successfully");
		repository.save(getData());
	}

	private List<Users> getData() {
		List<Users> users =new ArrayList<>();
		users.add(new Users("Thanges", 101L, "xyz@gmail.com", "Sivakasi"));
		users.add(new Users("Nithya", 102L, "rrr@gmail.com", "Bangalore"));
		users.add(new Users("Kanishk", 103L, "mmm@gmail.com", "Bangalore"));
		return users;
	}

}
