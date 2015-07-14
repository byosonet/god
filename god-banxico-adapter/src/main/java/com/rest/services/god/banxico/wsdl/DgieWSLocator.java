/**
 * DgieWSLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.rest.services.god.banxico.wsdl;

public class DgieWSLocator extends org.apache.axis.client.Service implements com.rest.services.god.banxico.wsdl.DgieWS {

    public DgieWSLocator() {
    }


    public DgieWSLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public DgieWSLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for DgieWSPort
    private java.lang.String DgieWSPort_address = "http://www.banxico.org.mx/DgieWSWeb/DgieWS";

    public java.lang.String getDgieWSPortAddress() {
        return DgieWSPort_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String DgieWSPortWSDDServiceName = "DgieWSPort";

    public java.lang.String getDgieWSPortWSDDServiceName() {
        return DgieWSPortWSDDServiceName;
    }

    public void setDgieWSPortWSDDServiceName(java.lang.String name) {
        DgieWSPortWSDDServiceName = name;
    }

    public com.rest.services.god.banxico.wsdl.DgieWSPort_PortType getDgieWSPort() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(DgieWSPort_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getDgieWSPort(endpoint);
    }

    public com.rest.services.god.banxico.wsdl.DgieWSPort_PortType getDgieWSPort(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            com.rest.services.god.banxico.wsdl.DgieWSPortSoapBindingStub _stub = new com.rest.services.god.banxico.wsdl.DgieWSPortSoapBindingStub(portAddress, this);
            _stub.setPortName(getDgieWSPortWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setDgieWSPortEndpointAddress(java.lang.String address) {
        DgieWSPort_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (com.rest.services.god.banxico.wsdl.DgieWSPort_PortType.class.isAssignableFrom(serviceEndpointInterface)) {
                com.rest.services.god.banxico.wsdl.DgieWSPortSoapBindingStub _stub = new com.rest.services.god.banxico.wsdl.DgieWSPortSoapBindingStub(new java.net.URL(DgieWSPort_address), this);
                _stub.setPortName(getDgieWSPortWSDDServiceName());
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
        if ("DgieWSPort".equals(inputPortName)) {
            return getDgieWSPort();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://ws.dgie.banxico.org.mx", "DgieWS");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://ws.dgie.banxico.org.mx", "DgieWSPort"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("DgieWSPort".equals(portName)) {
            setDgieWSPortEndpointAddress(address);
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
