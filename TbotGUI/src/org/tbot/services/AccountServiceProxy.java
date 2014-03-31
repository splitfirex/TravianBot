package org.tbot.services;

public class AccountServiceProxy implements org.tbot.services.AccountService {
  private String _endpoint = null;
  private org.tbot.services.AccountService accountService = null;
  
  public AccountServiceProxy() {
    _initAccountServiceProxy();
  }
  
  public AccountServiceProxy(String endpoint) {
    _endpoint = endpoint;
    _initAccountServiceProxy();
  }
  
  private void _initAccountServiceProxy() {
    try {
      accountService = (new org.tbot.services.AccountServiceServiceLocator()).getAccountService();
      if (accountService != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)accountService)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)accountService)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (accountService != null)
      ((javax.xml.rpc.Stub)accountService)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public org.tbot.services.AccountService getAccountService() {
    if (accountService == null)
      _initAccountServiceProxy();
    return accountService;
  }
  
  public java.lang.String initialize(java.lang.String login, java.lang.String pass, java.lang.String server) throws java.rmi.RemoteException{
    if (accountService == null)
      _initAccountServiceProxy();
    return accountService.initialize(login, pass, server);
  }
  
  public org.tbot.dto.Village[] obtenerVillas(java.lang.String hashLogin) throws java.rmi.RemoteException{
    if (accountService == null)
      _initAccountServiceProxy();
    return accountService.obtenerVillas(hashLogin);
  }
  
  public org.tbot.dto.Account obtenerCuenta(java.lang.String hashLogin) throws java.rmi.RemoteException{
    if (accountService == null)
      _initAccountServiceProxy();
    return accountService.obtenerCuenta(hashLogin);
  }
  
  
}