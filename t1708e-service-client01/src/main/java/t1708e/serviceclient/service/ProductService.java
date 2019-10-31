/**
 * ProductService.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package t1708e.serviceclient.service;

public interface ProductService extends java.rmi.Remote {
    public boolean sellProduct(int arg0, int arg1) throws java.rmi.RemoteException;
    public boolean addProduct(t1708e.serviceclient.service.Product arg0) throws java.rmi.RemoteException;
    public java.lang.String getAllProduct() throws java.rmi.RemoteException;
}
