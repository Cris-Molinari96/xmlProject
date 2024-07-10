//
// Questo file è stato generato dall'architettura JavaTM per XML Binding (JAXB) Reference Implementation, v2.3.2 
// Vedere <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a> 
// Qualsiasi modifica a questo file andrà persa durante la ricompilazione dello schema di origine. 
// Generato il: 2024.07.04 alle 04:34:07 PM CEST 
//


package xml.and.mb2g.jaxb;

import java.math.BigDecimal;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java per PaymentType complex type.
 * 
 * <p>Il seguente frammento di schema specifica il contenuto previsto contenuto in questa classe.
 * 
 * <pre>
 * &lt;complexType name="PaymentType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;choice&gt;
 *         &lt;element name="cash" type="{http://www.w3.org/2001/XMLSchema}decimal"/&gt;
 *         &lt;element name="insurance" type="{http://www.primaS.com/Patient}Insurance"/&gt;
 *       &lt;/choice&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PaymentType", propOrder = {
    "cash",
    "insurance"
})
public class PaymentType {

    protected BigDecimal cash;
    protected Insurance insurance;

    /**
     * Recupera il valore della proprietà cash.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getCash() {
        return cash;
    }

    /**
     * Imposta il valore della proprietà cash.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setCash(BigDecimal value) {
        this.cash = value;
    }

    /**
     * Recupera il valore della proprietà insurance.
     * 
     * @return
     *     possible object is
     *     {@link Insurance }
     *     
     */
    public Insurance getInsurance() {
        return insurance;
    }

    /**
     * Imposta il valore della proprietà insurance.
     * 
     * @param value
     *     allowed object is
     *     {@link Insurance }
     *     
     */
    public void setInsurance(Insurance value) {
        this.insurance = value;
    }

}
