
package com.fuhuadata.manager.impl.NCExchange.services;

import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceException;
import javax.xml.ws.WebServiceFeature;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.9-b130926.1035
 * Generated source version: 2.2
 * 
 */
@WebServiceClient(name = "M5715FileManagerWs", targetNamespace = "http://et.itf.nc/M5715FileManagerWs", wsdlLocation = "http://192.168.30.30:8200/uapws/service/FileManagerToNC?wsdl")
public class M5715FileManagerWs
    extends Service
{

    private final static URL M5715FILEMANAGERWS_WSDL_LOCATION;
    private final static WebServiceException M5715FILEMANAGERWS_EXCEPTION;
    private final static QName M5715FILEMANAGERWS_QNAME = new QName("http://et.itf.nc/M5715FileManagerWs", "M5715FileManagerWs");

    static {
        URL url = null;
        WebServiceException e = null;
        try {
            url = new URL("http://192.168.30.30:8200/uapws/service/FileManagerToNC?wsdl");
        } catch (MalformedURLException ex) {
            e = new WebServiceException(ex);
        }
        M5715FILEMANAGERWS_WSDL_LOCATION = url;
        M5715FILEMANAGERWS_EXCEPTION = e;
    }

    public M5715FileManagerWs() {
        super(__getWsdlLocation(), M5715FILEMANAGERWS_QNAME);
    }

    public M5715FileManagerWs(WebServiceFeature... features) {
        super(__getWsdlLocation(), M5715FILEMANAGERWS_QNAME, features);
    }

    public M5715FileManagerWs(URL wsdlLocation) {
        super(wsdlLocation, M5715FILEMANAGERWS_QNAME);
    }

    public M5715FileManagerWs(URL wsdlLocation, WebServiceFeature... features) {
        super(wsdlLocation, M5715FILEMANAGERWS_QNAME, features);
    }

    public M5715FileManagerWs(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public M5715FileManagerWs(URL wsdlLocation, QName serviceName, WebServiceFeature... features) {
        super(wsdlLocation, serviceName, features);
    }

    /**
     * 
     * @return
     *     returns M5715FileManagerWsPortType
     */
    @WebEndpoint(name = "M5715FileManagerWsSOAP11port_http")
    public M5715FileManagerWsPortType getM5715FileManagerWsSOAP11PortHttp() {
        return super.getPort(new QName("http://et.itf.nc/M5715FileManagerWs", "M5715FileManagerWsSOAP11port_http"), M5715FileManagerWsPortType.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns M5715FileManagerWsPortType
     */
    @WebEndpoint(name = "M5715FileManagerWsSOAP11port_http")
    public M5715FileManagerWsPortType getM5715FileManagerWsSOAP11PortHttp(WebServiceFeature... features) {
        return super.getPort(new QName("http://et.itf.nc/M5715FileManagerWs", "M5715FileManagerWsSOAP11port_http"), M5715FileManagerWsPortType.class, features);
    }

    private static URL __getWsdlLocation() {
        if (M5715FILEMANAGERWS_EXCEPTION!= null) {
            throw M5715FILEMANAGERWS_EXCEPTION;
        }
        return M5715FILEMANAGERWS_WSDL_LOCATION;
    }

}
