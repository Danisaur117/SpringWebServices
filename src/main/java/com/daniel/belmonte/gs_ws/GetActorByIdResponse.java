//
// Este archivo ha sido generado por la arquitectura JavaTM para la implantación de la referencia de enlace (JAXB) XML v2.2.7 
// Visite <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Todas las modificaciones realizadas en este archivo se perderán si se vuelve a compilar el esquema de origen. 
// Generado el: 2019.04.08 a las 04:03:21 PM CEST 
//


package com.daniel.belmonte.gs_ws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para anonymous complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="actorType" type="{http://www.daniel.belmonte.com/actors-ws}actorType"/>
 *         &lt;element name="serviceStatus" type="{http://www.daniel.belmonte.com/actors-ws}serviceStatus"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "actorType",
    "serviceStatus"
})
@XmlRootElement(name = "getActorByIdResponse")
public class GetActorByIdResponse {

    @XmlElement(required = true)
    protected ActorType actorType;
    @XmlElement(required = true)
    protected ServiceStatus serviceStatus;

    /**
     * Obtiene el valor de la propiedad actorType.
     * 
     * @return
     *     possible object is
     *     {@link ActorType }
     *     
     */
    public ActorType getActorType() {
        return actorType;
    }

    /**
     * Define el valor de la propiedad actorType.
     * 
     * @param value
     *     allowed object is
     *     {@link ActorType }
     *     
     */
    public void setActorType(ActorType value) {
        this.actorType = value;
    }

    /**
     * Obtiene el valor de la propiedad serviceStatus.
     * 
     * @return
     *     possible object is
     *     {@link ServiceStatus }
     *     
     */
    public ServiceStatus getServiceStatus() {
        return serviceStatus;
    }

    /**
     * Define el valor de la propiedad serviceStatus.
     * 
     * @param value
     *     allowed object is
     *     {@link ServiceStatus }
     *     
     */
    public void setServiceStatus(ServiceStatus value) {
        this.serviceStatus = value;
    }

}
