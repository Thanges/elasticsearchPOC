/**
 * 
 */
package com.search.repo;

import java.util.List;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import com.search.model.Users;

/**
 * @author Thanges
 *
 */

/**
 * This class is used to get the data from JPA 
 */
public interface SearchRepository extends ElasticsearchRepository<Users, Long>{
	List<Users> findByName(String text);
	List<Users> findById(Long id);

}
