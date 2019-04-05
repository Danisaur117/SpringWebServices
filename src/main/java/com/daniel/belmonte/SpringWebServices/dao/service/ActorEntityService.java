package com.daniel.belmonte.SpringWebServices.dao.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.daniel.belmonte.SpringWebServices.dao.entity.ActorEntity;
import com.daniel.belmonte.SpringWebServices.dao.interfaces.ActorEntityInterface;
import com.daniel.belmonte.SpringWebServices.dao.repository.ActorEntityRepository;

@Service
@Transactional
public class ActorEntityService implements ActorEntityInterface {
	private ActorEntityRepository repository;
	
	public ActorEntityService() {
		
	}
	
	@Autowired
	public ActorEntityService(ActorEntityRepository repository) {
		this.repository = repository;
	}
	
	@Override
	public ActorEntity getEntityById(int id) {
		return this.repository.findById(id).get();
	}

	@Override
	public List<ActorEntity> getAllEntities() {
		List<ActorEntity> list = new ArrayList<>();
		this.repository.findAll().forEach(e -> list.add(e));
		return list;
	}

	@Override
	public ActorEntity addEntity(ActorEntity entity) {
		// TODO Apéndice de método generado automáticamente
		return null;
	}

	@Override
	public Boolean updateEntity(ActorEntity entity) {
		// TODO Apéndice de método generado automáticamente
		return null;
	}

	@Override
	public Boolean deleteEntity(int id) {
		// TODO Apéndice de método generado automáticamente
		return null;
	}

}
