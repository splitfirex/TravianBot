/**
 * Village.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package org.tbot.dto;

public class Village  implements java.io.Serializable {
    private java.lang.Long finishTime;

    private java.lang.String id;

    private java.lang.String name;

    private org.tbot.dto.Resources totalResources;

    private java.lang.String x;

    private java.lang.String y;

    public Village() {
    }

    public Village(
           java.lang.Long finishTime,
           java.lang.String id,
           java.lang.String name,
           org.tbot.dto.Resources totalResources,
           java.lang.String x,
           java.lang.String y) {
           this.finishTime = finishTime;
           this.id = id;
           this.name = name;
           this.totalResources = totalResources;
           this.x = x;
           this.y = y;
    }


    /**
     * Gets the finishTime value for this Village.
     * 
     * @return finishTime
     */
    public java.lang.Long getFinishTime() {
        return finishTime;
    }


    /**
     * Sets the finishTime value for this Village.
     * 
     * @param finishTime
     */
    public void setFinishTime(java.lang.Long finishTime) {
        this.finishTime = finishTime;
    }


    /**
     * Gets the id value for this Village.
     * 
     * @return id
     */
    public java.lang.String getId() {
        return id;
    }


    /**
     * Sets the id value for this Village.
     * 
     * @param id
     */
    public void setId(java.lang.String id) {
        this.id = id;
    }


    /**
     * Gets the name value for this Village.
     * 
     * @return name
     */
    public java.lang.String getName() {
        return name;
    }


    /**
     * Sets the name value for this Village.
     * 
     * @param name
     */
    public void setName(java.lang.String name) {
        this.name = name;
    }


    /**
     * Gets the totalResources value for this Village.
     * 
     * @return totalResources
     */
    public org.tbot.dto.Resources getTotalResources() {
        return totalResources;
    }


    /**
     * Sets the totalResources value for this Village.
     * 
     * @param totalResources
     */
    public void setTotalResources(org.tbot.dto.Resources totalResources) {
        this.totalResources = totalResources;
    }


    /**
     * Gets the x value for this Village.
     * 
     * @return x
     */
    public java.lang.String getX() {
        return x;
    }


    /**
     * Sets the x value for this Village.
     * 
     * @param x
     */
    public void setX(java.lang.String x) {
        this.x = x;
    }


    /**
     * Gets the y value for this Village.
     * 
     * @return y
     */
    public java.lang.String getY() {
        return y;
    }


    /**
     * Sets the y value for this Village.
     * 
     * @param y
     */
    public void setY(java.lang.String y) {
        this.y = y;
    }

}
