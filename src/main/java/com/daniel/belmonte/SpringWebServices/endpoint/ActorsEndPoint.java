package com.daniel.belmonte.SpringWebServices.endpoint;

import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import com.daniel.belmonte.com.gs_ws.UpdateActorsResponse;
import com.daniel.belmonte.gs_ws.GetActorByIdRequest;
import com.daniel.belmonte.gs_ws.GetActorByIdResponse;

@Endpoint
public class ActorsEndPoint {
	public static final String NAMESPACE_URI="http://dani.belmonte.com/actors-ws";
	
	public ActorsEndPoint() {
		
	}
	
	@PayloadRoot(namespace=NAMESPACE_URI, localPart="getActorByIdRequest")
	@ResponsePayload
	public GetActorByIdResponse getActorById(@RequestPayload GetActorByIdRequest request) {
		GetActorByIdResponse response = new GetActorByIdResponse();
		return response;
	}
	
	//REVISAR PARÁMETROS DEL MÉTODO. DEBE RECIBIR 4 PARÁMETROS, BUSCAR POR ID Y ACTUALIZAR EL
	//CONTENIDO DE LA RESPUESTA
	@PayloadRoot(namespace=NAMESPACE_URI, localPart="UpdateActorsRequest")
	@ResponsePayload
	public UpdateActorsResponse updateActors(@RequestPayload GetActorByIdRequest request) {
		UpdateActorsResponse response = new UpdateActorsResponse();
		return response;
	}
	
	//AÑADIR MÉTODO PARA BORRAR Y MÉTODO PARA INSERTAR
}
