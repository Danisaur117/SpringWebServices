//
// Este archivo ha sido generado por la arquitectura JavaTM para la implantación de la referencia de enlace (JAXB) XML v2.2.7 
// Visite <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Todas las modificaciones realizadas en este archivo se perderán si se vuelve a compilar el esquema de origen. 
// Generado el: 2019.04.04 a las 05:54:22 PM CEST 
//


package com.daniel.belmonte.gs_ws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


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
 *         &lt;element name="actor_id" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="first_name" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="last_name" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="last_update" type="{http://www.w3.org/2001/XMLSchema}dateTime"/>
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
    "actorId",
    "firstName",
    "lastName",
    "lastUpdate"
})
@XmlRootElement(name = "updateActorsRequest")
public class UpdateActorsRequest {

    @XmlElement(name = "actor_id")
    protected int actorId;
    @XmlElement(name = "first_name", required = true)
    protected String firstName;
    @XmlElement(name = "last_name", required = true)
    protected String lastName;
    @XmlElement(name = "last_update", required = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar lastUpdate;

    /**
     * Obtiene el valor de la propiedad actorId.
     * 
     */
    public int getActorId() {
        return actorId;
    }

    /**
     * Define el valor de la propiedad actorId.
     * 
     */
    public void setActorId(int value) {
        this.actorId = value;
    }

    /**
     * Obtiene el valor de la propiedad firstName.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Define el valor de la propiedad firstName.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFirstName(String value) {
        this.firstName = value;
    }

    /**
     * Obtiene el valor de la propiedad lastName.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Define el valor de la propiedad lastName.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLastName(String value) {
        this.lastName = value;
    }

    /**
     * Obtiene el valor de la propiedad lastUpdate.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getLastUpdate() {
        return lastUpdate;
    }

    /**
     * Define el valor de la propiedad lastUpdate.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setLastUpdate(XMLGregorianCalendar value) {
        this.lastUpdate = value;
    }

}
