
package com.fuhuadata.manager.impl.NCExchange.services;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>anonymous complex type�� Java �ࡣ
 * 
 * <p>����ģʽƬ��ָ�������ڴ����е�Ԥ�����ݡ�
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="byteItem" type="{http://www.w3.org/2001/XMLSchema}base64Binary" minOccurs="0"/>
 *         &lt;element name="string" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="long" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="string1" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="string2" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "byteItem",
    "string",
    "_long",
    "string1",
    "string2"
})
@XmlRootElement(name = "crmExchangeFileToNC")
public class CrmExchangeFileToNC {

    @XmlElementRef(name = "byteItem", type = JAXBElement.class, required = false)
    protected JAXBElement<byte[]> byteItem;
    @XmlElementRef(name = "string", type = JAXBElement.class, required = false)
    protected JAXBElement<String> string;
    @XmlElementRef(name = "long", type = JAXBElement.class, required = false)
    protected JAXBElement<Long> _long;
    @XmlElementRef(name = "string1", type = JAXBElement.class, required = false)
    protected JAXBElement<String> string1;
    @XmlElementRef(name = "string2", type = JAXBElement.class, required = false)
    protected JAXBElement<String> string2;

    /**
     * ��ȡbyteItem���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link byte[]}{@code >}
     *     
     */
    public JAXBElement<byte[]> getByteItem() {
        return byteItem;
    }

    /**
     * ����byteItem���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link byte[]}{@code >}
     *     
     */
    public void setByteItem(JAXBElement<byte[]> value) {
        this.byteItem = value;
    }

    /**
     * ��ȡstring���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getString() {
        return string;
    }

    /**
     * ����string���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setString(JAXBElement<String> value) {
        this.string = value;
    }

    /**
     * ��ȡlong���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link Long }{@code >}
     *     
     */
    public JAXBElement<Long> getLong() {
        return _long;
    }

    /**
     * ����long���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link Long }{@code >}
     *     
     */
    public void setLong(JAXBElement<Long> value) {
        this._long = value;
    }

    /**
     * ��ȡstring1���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getString1() {
        return string1;
    }

    /**
     * ����string1���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setString1(JAXBElement<String> value) {
        this.string1 = value;
    }

    /**
     * ��ȡstring2���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getString2() {
        return string2;
    }

    /**
     * ����string2���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setString2(JAXBElement<String> value) {
        this.string2 = value;
    }

}
