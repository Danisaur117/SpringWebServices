package com.daniel.belmonte.SpringWebServices.endpoint;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import com.daniel.belmonte.SpringWebServices.dao.entity.ActorEntity;
import com.daniel.belmonte.SpringWebServices.dao.interfaces.ActorEntityInterface;
import com.daniel.belmonte.gs_ws.DelActorRequest;
import com.daniel.belmonte.gs_ws.DelActorResponse;
import com.daniel.belmonte.gs_ws.InsertActorRequest;
import com.daniel.belmonte.gs_ws.InsertActorResponse;
import com.daniel.belmonte.gs_ws.ServiceStatus;
import com.daniel.belmonte.gs_ws.UpdateActorRequest;
import com.daniel.belmonte.gs_ws.UpdateActorResponse;
import com.daniel.belmonte.gs_ws.ActorType;
import com.daniel.belmonte.gs_ws.GetActorByIdRequest;
import com.daniel.belmonte.gs_ws.GetActorByIdResponse;
import com.daniel.belmonte.gs_ws.GetAllActorsRequest;
import com.daniel.belmonte.gs_ws.GetAllActorsResponse;

@Endpoint
public class ActorsEndPoint {
	public static final String NAMESPACE_URI="http://www.daniel.belmonte.com/actors-ws";
	private ActorEntityInterface service;
	
	public ActorsEndPoint() {
		
	}
	
	@Autowired
	public ActorsEndPoint(ActorEntityInterface service) {
		this.service = service;
	}
	
	@PayloadRoot(namespace=NAMESPACE_URI, localPart="getActorByIdRequest")
	@ResponsePayload
	public GetActorByIdResponse getActorById(@RequestPayload GetActorByIdRequest request) {
		GetActorByIdResponse response = new GetActorByIdResponse();
		ActorEntity actorEntity = service.getEntityById(request.getActorId());
		ActorType actorType = new ActorType();
		ServiceStatus serviceStatus = new ServiceStatus();
		
		if(actorEntity == null) {
			serviceStatus.setStatusCode("NOT FOUND");
			serviceStatus.setMessage("Error al buscar la entidad");
			
			response.setServiceStatus(serviceStatus);
			response.setActorType(null);
			
			return response;
		}
		
		actorType.setActorId(actorEntity.getActor_id());
		actorType.setFirstName(actorEntity.getFirst_name());
		actorType.setLastName(actorEntity.getLast_name());
		actorType.setLastUpdate(actorEntity.getLast_update());
		
		serviceStatus.setStatusCode("SUCCESS");
		serviceStatus.setMessage("Entidad encontrada correctamente");
		
		response.setServiceStatus(serviceStatus);
		response.setActorType(actorType);
		
		return response;
	}
	
	@PayloadRoot(namespace=NAMESPACE_URI, localPart="getAllActorsRequest")
	@ResponsePayload
	public GetAllActorsResponse getAllActors(@RequestPayload GetAllActorsRequest request) {
		GetAllActorsResponse response = new GetAllActorsResponse();
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
		
		response.getActorType().addAll(actorTypeList);
		
		return response;
	}

	@PayloadRoot(namespace=NAMESPACE_URI, localPart="updateActorRequest")
	@ResponsePayload
	public UpdateActorResponse updateActors(@RequestPayload UpdateActorRequest request) {
		UpdateActorResponse response = new UpdateActorResponse();
		ActorEntity actorEntity = service.getEntityById(request.getActorId());
		ServiceStatus serviceStatus = new ServiceStatus();
		
		if(actorEntity == null) {
			serviceStatus.setStatusCode("NOT FOUND");
			serviceStatus.setMessage("Error al buscar la entidad");
			
			response.setUpdated(false);
			response.setServiceStatus(serviceStatus);
			
			return response;
		}
		
		actorEntity.setFirst_name(request.getFirstName());
		actorEntity.setLast_name(request.getLastName());
		actorEntity.setLast_update(new Date());
		boolean updated = service.updateEntity(actorEntity);
		
		if(updated == false) {
			serviceStatus.setStatusCode("CONFLICT");
			serviceStatus.setMessage("Error al actualizar la entidad");
			
			response.setUpdated(false);
			response.setServiceStatus(serviceStatus);
			
			return response;
		}
		
		serviceStatus.setStatusCode("SUCCESS");
		serviceStatus.setMessage("Entidad actualizada correctamente");
		
		response.setUpdated(true);
		response.setServiceStatus(serviceStatus);
		
		return response;
	}
	
	@PayloadRoot(namespace=NAMESPACE_URI, localPart="insertActorRequest")
	@ResponsePayload
	public InsertActorResponse insertActor(@RequestPayload InsertActorRequest request) {
		InsertActorResponse response = new InsertActorResponse();
		ActorEntity actorEntity = new ActorEntity(request.getFirstName(), request.getLastName());
		ActorType actorType = new ActorType();
		ServiceStatus serviceStatus = new ServiceStatus();
		
		ActorEntity saved = service.addEntity(actorEntity);
		
		if(saved == null) {
			serviceStatus.setStatusCode("CONFLICT");
			serviceStatus.setMessage("Error al añadir la entidad");
			
			response.setActorType(null);
			response.setServiceStatus(serviceStatus);
			
			return response;
		}

		actorType.setActorId(saved.getActor_id());
		actorType.setFirstName(saved.getFirst_name());
		actorType.setLastName(saved.getLast_name());
		actorType.setLastUpdate(saved.getLast_update());
		
		serviceStatus.setStatusCode("SUCCESS");
		serviceStatus.setMessage("Entidad añadida correctamente");
		
		response.setActorType(actorType);
		response.setServiceStatus(serviceStatus);
		
		return response;
	}
	
	@PayloadRoot(namespace=NAMESPACE_URI, localPart="delActorRequest")
	@ResponsePayload
	public DelActorResponse delActor(@RequestPayload DelActorRequest request) {
		DelActorResponse response = new DelActorResponse();
		ActorEntity actorEntity = service.getEntityById(request.getActorId());
		ServiceStatus serviceStatus = new ServiceStatus();
		
		if(actorEntity == null) {
			serviceStatus.setStatusCode("NOT FOUND");
			serviceStatus.setMessage("Error al buscar la entidad");
			
			response.setServiceStatus(serviceStatus);
			response.setDeleted(false);
			
			return response;
		}
		
		boolean deleted = service.deleteEntity(actorEntity.getActor_id());
		
		if(deleted == false) {
			serviceStatus.setStatusCode("CONFLICT");
			serviceStatus.setMessage("Error al borrar la entidad");
			
			response.setServiceStatus(serviceStatus);
			response.setDeleted(deleted);
			
			return response;
		}
		
		serviceStatus.setStatusCode("SUCCESS");
		serviceStatus.setMessage("Entidad borrada correctamente");
		
		response.setServiceStatus(serviceStatus);
		response.setDeleted(deleted);
		
		return response;
	}
}
