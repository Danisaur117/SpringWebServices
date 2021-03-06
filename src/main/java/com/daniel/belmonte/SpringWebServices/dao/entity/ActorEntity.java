package com.daniel.belmonte.SpringWebServices.dao.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="actor")
public class ActorEntity implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -674819468802499845L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int actor_id;
	private String first_name;
	private String last_name;
	private Date last_update;
	
	public ActorEntity() {
		
	}
	
	public ActorEntity(String first_name, String last_name){
		this.first_name = first_name;
		this.last_name = last_name;
		this.last_update = new Date();
	}
	
	public int getActor_id() {
		return actor_id;
	}
	public void setActor_id(int actor_id) {
		this.actor_id = actor_id;
	}
	public String getFirst_name() {
		return first_name;
	}
	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}
	public String getLast_name() {
		return last_name;
	}
	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}
	public Date getLast_update() {
		return last_update;
	}
	public void setLast_update(Date last_update) {
		this.last_update = last_update;
	}
}
