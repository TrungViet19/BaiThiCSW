/**
 * ProductServiceServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package t1708e.serviceclient.service;

public class ProductServiceServiceLocator extends org.apache.axis.client.Service implements t1708e.serviceclient.service.ProductServiceService {

    public ProductServiceServiceLocator() {
    }


    public ProductServiceServiceLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public ProductServiceServiceLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for ProductServicePort
    private java.lang.String ProductServicePort_address = "http://localhost:9000/product-service";

    public java.lang.String getProductServicePortAddress() {
        return ProductServicePort_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String ProductServicePortWSDDServiceName = "ProductServicePort";

    public java.lang.String getProductServicePortWSDDServiceName() {
        return ProductServicePortWSDDServiceName;
    }

    public void setProductServicePortWSDDServiceName(java.lang.String name) {
        ProductServicePortWSDDServiceName = name;
    }

    public t1708e.serviceclient.service.ProductService getProductServicePort() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(ProductServicePort_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getProductServicePort(endpoint);
    }

    public t1708e.serviceclient.service.ProductService getProductServicePort(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            t1708e.serviceclient.service.ProductServicePortBindingStub _stub = new t1708e.serviceclient.service.ProductServicePortBindingStub(portAddress, this);
            _stub.setPortName(getProductServicePortWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setProductServicePortEndpointAddress(java.lang.String address) {
        ProductServicePort_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (t1708e.serviceclient.service.ProductService.class.isAssignableFrom(serviceEndpointInterface)) {
                t1708e.serviceclient.service.ProductServicePortBindingStub _stub = new t1708e.serviceclient.service.ProductServicePortBindingStub(new java.net.URL(ProductServicePort_address), this);
                _stub.setPortName(getProductServicePortWSDDServiceName());
                return _stub;
            }
        }
        catch (java.lang.Throwable t) {
            throw new javax.xml.rpc.ServiceException(t);
        }
        throw new javax.xml.rpc.ServiceException("There is no stub implementation for the interface:  " + (serviceEndpointInterface == null ? "null" : serviceEndpointInterface.getName()));
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(javax.xml.namespace.QName portName, Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        if (portName == null) {
            return getPort(serviceEndpointInterface);
        }
        java.lang.String inputPortName = portName.getLocalPart();
        if ("ProductServicePort".equals(inputPortName)) {
            return getProductServicePort();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://service/", "ProductServiceService");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://service/", "ProductServicePort"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("ProductServicePort".equals(portName)) {
            setProductServicePortEndpointAddress(address);
        }
        else 
{ // Unknown Port Name
            throw new javax.xml.rpc.ServiceException(" Cannot set Endpoint Address for Unknown Port" + portName);
        }
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(javax.xml.namespace.QName portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        setEndpointAddress(portName.getLocalPart(), address);
    }

}
