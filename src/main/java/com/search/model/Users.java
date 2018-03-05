/**
 * 
 */
package com.search.model;

import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.stereotype.Component;

/**
 * @author Thanges
 *
 */

/*
 * Model class for the users
 */
@Component
@Document(indexName = "contacts",  type = "people", shards =1)
public class Users {
	
	private String name;
	private Long id;
	private String email;
	private String location;
	
	public Users(){
		
	}
	
	/**
	 * @param name
	 * @param id
	 * @param email
	 * @param location
	 */
	public Users(String name, Long id, String email, String location) {
		super();
		this.name = name;
		this.id = id;
		this.email = email;
		this.location = location;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Users [name=" + name + ", id=" + id + ", email=" + email + ", location=" + location + "]";
	}
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}
	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}
	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	/**
	 * @return the location
	 */
	public String getLocation() {
		return location;
	}
	/**
	 * @param location the location to set
	 */
	public void setLocation(String location) {
		this.location = location;
	}
	
	

}
