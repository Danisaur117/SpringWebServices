package com.daniel.belmonte.SpringWebServices.dao.repository;

import com.daniel.belmonte.SpringWebServices.dao.entity.ActorEntity;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ActorEntityRepository extends CrudRepository<ActorEntity, Integer> {
	
}
