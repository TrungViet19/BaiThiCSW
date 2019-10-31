/**
 * ProductServiceService.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package t1708e.serviceclient.service;

public interface ProductServiceService extends javax.xml.rpc.Service {
    public java.lang.String getProductServicePortAddress();

    public t1708e.serviceclient.service.ProductService getProductServicePort() throws javax.xml.rpc.ServiceException;

    public t1708e.serviceclient.service.ProductService getProductServicePort(java.net.URL portAddress) throws javax.xml.rpc.ServiceException;
}
