/**
 * AccountServiceService.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package org.tbot.services;

public interface AccountServiceService extends javax.xml.rpc.Service {
    public java.lang.String getAccountServiceAddress();

    public org.tbot.services.AccountService getAccountService() throws javax.xml.rpc.ServiceException;

    public org.tbot.services.AccountService getAccountService(java.net.URL portAddress) throws javax.xml.rpc.ServiceException;
}
