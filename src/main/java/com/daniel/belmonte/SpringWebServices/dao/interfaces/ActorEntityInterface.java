package com.daniel.belmonte.SpringWebServices.dao.interfaces;

import java.util.List;

import com.daniel.belmonte.SpringWebServices.dao.entity.ActorEntity;

public interface ActorEntityInterface {
	public ActorEntity getEntityById(int id);
	public List<ActorEntity> getAllEntities();
	public ActorEntity addEntity(ActorEntity entity);
	public Boolean updateEntity(ActorEntity entity);
	public Boolean deleteEntity(int id);
}
