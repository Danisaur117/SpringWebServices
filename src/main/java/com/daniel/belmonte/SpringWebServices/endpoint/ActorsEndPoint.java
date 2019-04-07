package com.daniel.belmonte.SpringWebServices.endpoint;

import java.util.Date;

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
import com.daniel.belmonte.gs_ws.UpdateActorRequest;
import com.daniel.belmonte.gs_ws.UpdateActorResponse;
import com.daniel.belmonte.gs_ws.ActorType;
import com.daniel.belmonte.gs_ws.GetActorByIdRequest;
import com.daniel.belmonte.gs_ws.GetActorByIdResponse;

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
		
		actorType.setActorId(actorEntity.getActor_id());
		actorType.setFirstName(actorEntity.getFirst_name());
		actorType.setLastName(actorEntity.getLast_name());
		actorType.setLastUpdate(actorEntity.getLast_update());
		
		response.setActorType(actorType);
		
		return response;
	}

	//El objeto UpdateActorsRequest tiene 4 atributos, del cual usaremos el actors_id para
	//buscar el registro que queremos actualizar. Los datos con los que actualizaremos el
	//registro serán los otros 3 atributos del objeto. Devolveremos un objeto UpdateActorsResponse
	//con los atributos que se deben actualizar
	@PayloadRoot(namespace=NAMESPACE_URI, localPart="updateActorRequest")
	@ResponsePayload
	public UpdateActorResponse updateActors(@RequestPayload UpdateActorRequest request) {
		Boolean updated;
		UpdateActorResponse response = new UpdateActorResponse();
		ActorType actorType = new ActorType();
		ActorEntity actorEntity = new ActorEntity();
		System.out.println("Rellenando actorEntity");
		actorEntity.setActor_id(request.getActorId());
		actorEntity.setFirst_name(request.getFirstName());
		actorEntity.setLast_name(request.getLastName());
		actorEntity.setLast_update(new Date());
		System.out.println("Rellenando actorType");
		actorType.setActorId(request.getActorId());
		actorType.setFirstName(request.getFirstName());
		actorType.setLastName(request.getLastName());
		actorType.setLastUpdate(new Date());
		System.out.println("Rellenando response");
		response.setActorType(actorType);
		System.out.println("Ejecutando updateEntity");
		updated = service.updateEntity(actorEntity);
		if(updated) {
			System.out.println("Actualizado");
			response.setUpdated(updated);
		}
		else {
			System.out.println("ERROR");
		}
		
		return response;
	}
	
	//AÑADIR MÉTODO PARA BORRAR Y MÉTODO PARA INSERTAR
	@PayloadRoot(namespace=NAMESPACE_URI, localPart="insertActorRequest")
	@ResponsePayload
	public InsertActorResponse insertActor(@RequestPayload InsertActorRequest request) {
		InsertActorResponse response = new InsertActorResponse();
		return response;
	}
	
	@PayloadRoot(namespace=NAMESPACE_URI, localPart="delActorRequest")
	@ResponsePayload
	public DelActorResponse delActor(@RequestPayload DelActorRequest request) {
		DelActorResponse response = new DelActorResponse();
		return response;
	}
}
