//
// Este archivo ha sido generado por la arquitectura JavaTM para la implantación de la referencia de enlace (JAXB) XML v2.2.7 
// Visite <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Todas las modificaciones realizadas en este archivo se perderán si se vuelve a compilar el esquema de origen. 
// Generado el: 2019.04.04 a las 05:54:22 PM CEST 
//


package com.daniel.belmonte.gs_ws;

import javax.xml.bind.annotation.XmlRegistry;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.daniel.belmonte.com.gs_ws package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {


    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.daniel.belmonte.com.gs_ws
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link GetActorByIdRequest }
     * 
     */
    public GetActorByIdRequest createGetActorByIdRequest() {
        return new GetActorByIdRequest();
    }

    /**
     * Create an instance of {@link UpdateActorsResponse }
     * 
     */
    public UpdateActorsResponse createUpdateActorsResponse() {
        return new UpdateActorsResponse();
    }

    /**
     * Create an instance of {@link UpdateActorsRequest }
     * 
     */
    public UpdateActorsRequest createUpdateActorsRequest() {
        return new UpdateActorsRequest();
    }

    /**
     * Create an instance of {@link GetActorByIdResponse }
     * 
     */
    public GetActorByIdResponse createGetActorByIdResponse() {
        return new GetActorByIdResponse();
    }

    /**
     * Create an instance of {@link ActorType }
     * 
     */
    public ActorType createActorType() {
        return new ActorType();
    }

}
