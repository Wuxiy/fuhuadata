
package com.fuhuadata.manager.impl.NCExchange.services;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>anonymous complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
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
     * 获取byteItem属性的值。
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
     * 设置byteItem属性的值。
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
     * 获取string属性的值。
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
     * 设置string属性的值。
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
     * 获取long属性的值。
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
     * 设置long属性的值。
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
     * 获取string1属性的值。
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
     * 设置string1属性的值。
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
     * 获取string2属性的值。
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
     * 设置string2属性的值。
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
