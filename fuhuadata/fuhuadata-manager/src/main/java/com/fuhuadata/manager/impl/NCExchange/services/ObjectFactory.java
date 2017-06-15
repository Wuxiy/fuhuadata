
package com.fuhuadata.manager.impl.NCExchange.services;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.fuhuadata.manager.impl.NCExchange.services package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _CrmExchangeFileToNCResponseReturn_QNAME = new QName("", "return");
    private final static QName _CrmExchangeFileToNCByteItem_QNAME = new QName("", "byteItem");
    private final static QName _CrmExchangeFileToNCString_QNAME = new QName("", "string");
    private final static QName _CrmExchangeFileToNCString1_QNAME = new QName("", "string1");
    private final static QName _CrmExchangeFileToNCString2_QNAME = new QName("", "string2");
    private final static QName _CrmExchangeFileToNCLong_QNAME = new QName("", "long");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.fuhuadata.manager.impl.NCExchange.services
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link CrmExchangeFileToNC }
     * 
     */
    public CrmExchangeFileToNC createCrmExchangeFileToNC() {
        return new CrmExchangeFileToNC();
    }

    /**
     * Create an instance of {@link CrmExchangeFileToNCResponse }
     * 
     */
    public CrmExchangeFileToNCResponse createCrmExchangeFileToNCResponse() {
        return new CrmExchangeFileToNCResponse();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "return", scope = CrmExchangeFileToNCResponse.class)
    public JAXBElement<String> createCrmExchangeFileToNCResponseReturn(String value) {
        return new JAXBElement<String>(_CrmExchangeFileToNCResponseReturn_QNAME, String.class, CrmExchangeFileToNCResponse.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link byte[]}{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "byteItem", scope = CrmExchangeFileToNC.class)
    public JAXBElement<byte[]> createCrmExchangeFileToNCByteItem(byte[] value) {
        return new JAXBElement<byte[]>(_CrmExchangeFileToNCByteItem_QNAME, byte[].class, CrmExchangeFileToNC.class, ((byte[]) value));
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "string", scope = CrmExchangeFileToNC.class)
    public JAXBElement<String> createCrmExchangeFileToNCString(String value) {
        return new JAXBElement<String>(_CrmExchangeFileToNCString_QNAME, String.class, CrmExchangeFileToNC.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "string1", scope = CrmExchangeFileToNC.class)
    public JAXBElement<String> createCrmExchangeFileToNCString1(String value) {
        return new JAXBElement<String>(_CrmExchangeFileToNCString1_QNAME, String.class, CrmExchangeFileToNC.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "string2", scope = CrmExchangeFileToNC.class)
    public JAXBElement<String> createCrmExchangeFileToNCString2(String value) {
        return new JAXBElement<String>(_CrmExchangeFileToNCString2_QNAME, String.class, CrmExchangeFileToNC.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Long }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "long", scope = CrmExchangeFileToNC.class)
    public JAXBElement<Long> createCrmExchangeFileToNCLong(Long value) {
        return new JAXBElement<Long>(_CrmExchangeFileToNCLong_QNAME, Long.class, CrmExchangeFileToNC.class, value);
    }

}
