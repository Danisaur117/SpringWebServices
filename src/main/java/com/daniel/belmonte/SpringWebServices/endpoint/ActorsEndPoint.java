package com.daniel.belmonte.SpringWebServices.endpoint;

import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import com.daniel.belmonte.com.gs_ws.GetActorByFirstNameRequest;
import com.daniel.belmonte.com.gs_ws.GetActorByFirstNameResponse;
import com.daniel.belmonte.com.gs_ws.GetActorByLastNameRequest;
import com.daniel.belmonte.com.gs_ws.GetActorByLastNameResponse;
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
	
	@PayloadRoot(namespace=NAMESPACE_URI, localPart="getActorByFirstNameRequest")
	@ResponsePayload
	public GetActorByFirstNameResponse getActorByFirstName(@RequestPayload GetActorByFirstNameRequest request) {
		GetActorByFirstNameResponse response = new GetActorByFirstNameResponse();
		return response;
	}
	
	@PayloadRoot(namespace=NAMESPACE_URI, localPart="getActorByLastNameRequest")
	@ResponsePayload
	public GetActorByLastNameResponse getActorByLastName(@RequestPayload GetActorByLastNameRequest request) {
		GetActorByLastNameResponse response = new GetActorByLastNameResponse();
		return response;
	}
}
