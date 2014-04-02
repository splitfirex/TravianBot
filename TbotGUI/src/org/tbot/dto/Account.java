/**
 * Account.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package org.tbot.dto;

public class Account  implements java.io.Serializable {
    private java.lang.String idlogin;

    private java.lang.String tipoLegion;

    private org.tbot.dto.Village[] villages;

    public Account() {
    }

    public Account(
           java.lang.String idlogin,
           java.lang.String tipoLegion,
           org.tbot.dto.Village[] villages) {
           this.idlogin = idlogin;
           this.tipoLegion = tipoLegion;
           this.villages = villages;
    }


    /**
     * Gets the idlogin value for this Account.
     * 
     * @return idlogin
     */
    public java.lang.String getIdlogin() {
        return idlogin;
    }


    /**
     * Sets the idlogin value for this Account.
     * 
     * @param idlogin
     */
    public void setIdlogin(java.lang.String idlogin) {
        this.idlogin = idlogin;
    }


    /**
     * Gets the tipoLegion value for this Account.
     * 
     * @return tipoLegion
     */
    public java.lang.String getTipoLegion() {
        return tipoLegion;
    }


    /**
     * Sets the tipoLegion value for this Account.
     * 
     * @param tipoLegion
     */
    public void setTipoLegion(java.lang.String tipoLegion) {
        this.tipoLegion = tipoLegion;
    }


    /**
     * Gets the villages value for this Account.
     * 
     * @return villages
     */
    public org.tbot.dto.Village[] getVillages() {
        return villages;
    }


    /**
     * Sets the villages value for this Account.
     * 
     * @param villages
     */
    public void setVillages(org.tbot.dto.Village[] villages) {
        this.villages = villages;
    }

  
}
