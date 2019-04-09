package com.daniel.belmonte.SpringWebServices.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.daniel.belmonte.SpringWebServices.dao.entity.ActorEntity;
import com.daniel.belmonte.SpringWebServices.dao.interfaces.ActorEntityInterface;
import com.daniel.belmonte.SpringWebServices.dao.service.ActorEntityService;
import com.daniel.belmonte.gs_ws.ActorType;
import com.daniel.belmonte.gs_ws.InsertActorRequest;
import com.daniel.belmonte.gs_ws.UpdateActorRequest;

@Controller
public class ActorController {
	private ActorEntityInterface service;
	
	@Autowired
	public ActorController(ActorEntityService service) {
		this.service = service;
	}
	
	public ActorType getActorById(int id) {
		ActorEntity actorEntity = service.getEntityById(id);
		ActorType actorType = new ActorType();
		
		if(actorEntity == null) {
			return null;
		}
		
		actorType.setActorId(actorEntity.getActor_id());
		actorType.setFirstName(actorEntity.getFirst_name());
		actorType.setLastName(actorEntity.getLast_name());
		actorType.setLastUpdate(actorEntity.getLast_update());
		
		return actorType;
	}
	
	public List<ActorType> getAllActors(){
		List<ActorType> actorTypeList = new ArrayList<ActorType>();
		List<ActorEntity> actorEntityList = service.getAllEntities();
		
		for(ActorEntity actorEntity : actorEntityList) {
			ActorType actorType = new ActorType();
			
			actorType.setActorId(actorEntity.getActor_id());
			actorType.setFirstName(actorEntity.getFirst_name());
			actorType.setLastName(actorEntity.getLast_name());
			actorType.setLastUpdate(actorEntity.getLast_update());
			
			actorTypeList.add(actorType);
		}
		
		return actorTypeList;
	}
	
	public ActorType addActor(InsertActorRequest request) {
		ActorEntity actorEntity = new ActorEntity(request.getFirstName(), request.getLastName());
		ActorType actorType = new ActorType();
		ActorEntity saved = service.addEntity(actorEntity);
		
		if(saved == null) return null;

		actorType.setActorId(saved.getActor_id());
		actorType.setFirstName(saved.getFirst_name());
		actorType.setLastName(saved.getLast_name());
		actorType.setLastUpdate(saved.getLast_update());

		return actorType;
	}
	
	public Boolean updateActor(UpdateActorRequest request) {
		ActorEntity actorEntity = service.getEntityById(request.getActorId());
		
		if(actorEntity == null) return null;
		
		actorEntity.setFirst_name(request.getFirstName());
		actorEntity.setLast_name(request.getLastName());
		actorEntity.setLast_update(new Date());
		boolean updated = service.updateEntity(actorEntity);
		
		if(updated == false) return false;
		
		return true;
	}
	
	public Boolean deleteActor(int id) {
		ActorEntity actorEntity = service.getEntityById(id);
		
		if(actorEntity == null) return null;
		
		return service.deleteEntity(actorEntity.getActor_id());
	}
}
