//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.3.0 
// See <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2020.09.10 at 10:29:13 PM EEST 
//


package lt.michalkropa.fxrates.client.gen;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for anonymous complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="tp" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="ccy" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="dtFrom" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="dtTo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
        "tp",
        "ccy",
        "dtFrom",
        "dtTo"
})
@XmlRootElement(name = "getFxRatesForCurrency")
public class GetFxRatesForCurrency {

    protected String tp;
    protected String ccy;
    protected String dtFrom;
    protected String dtTo;

    /**
     * Gets the value of the tp property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getTp() {
        return tp;
    }

    /**
     * Sets the value of the tp property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setTp(String value) {
        this.tp = value;
    }

    /**
     * Gets the value of the ccy property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getCcy() {
        return ccy;
    }

    /**
     * Sets the value of the ccy property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setCcy(String value) {
        this.ccy = value;
    }

    /**
     * Gets the value of the dtFrom property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getDtFrom() {
        return dtFrom;
    }

    /**
     * Sets the value of the dtFrom property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setDtFrom(String value) {
        this.dtFrom = value;
    }

    /**
     * Gets the value of the dtTo property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getDtTo() {
        return dtTo;
    }

    /**
     * Sets the value of the dtTo property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setDtTo(String value) {
        this.dtTo = value;
    }

}
