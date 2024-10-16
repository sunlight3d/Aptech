/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author sunli
 */
@Entity
@Table(name = "tblmobile", catalog = "c2108g3", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Mobile.findAll", query = "SELECT m FROM Mobile m")
    , @NamedQuery(name = "Mobile.findByMobileId", query = "SELECT m FROM Mobile m WHERE m.mobileId = :mobileId")
    , @NamedQuery(name = "Mobile.findByMobileName", query = "SELECT m FROM Mobile m WHERE m.mobileName = :mobileName")
    , @NamedQuery(name = "Mobile.findByWarranty", query = "SELECT m FROM Mobile m WHERE m.warranty = :warranty")
    , @NamedQuery(name = "Mobile.findByInOutStock", query = "SELECT m FROM Mobile m WHERE m.inOutStock = :inOutStock")
    , @NamedQuery(name = "Mobile.findByPrice", query = "SELECT m FROM Mobile m WHERE m.price = :price")
    , @NamedQuery(name = "Mobile.findByAccessories", query = "SELECT m FROM Mobile m WHERE m.accessories = :accessories")
    , @NamedQuery(name = "Mobile.findByImageSrc", query = "SELECT m FROM Mobile m WHERE m.imageSrc = :imageSrc")})
public class Mobile implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "mobile_id", nullable = false)
    private Integer mobileId;
    @Basic(optional = false)
    @Column(name = "mobile_name", nullable = false, length = 100)
    private String mobileName;
    @Column(name = "warranty", length = 200)
    private String warranty;
    @Column(name = "in_out_stock")
    private Short inOutStock;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "price", precision = 12)
    private Float price;
    @Column(name = "accessories", length = 100)
    private String accessories;
    @Column(name = "image_src", length = 100)
    private String imageSrc;

    public Mobile() {
    }

    public Mobile(Integer mobileId) {
        this.mobileId = mobileId;
    }

    public Mobile(Integer mobileId, String mobileName) {
        this.mobileId = mobileId;
        this.mobileName = mobileName;
    }

    public Integer getMobileId() {
        return mobileId;
    }

    public void setMobileId(Integer mobileId) {
        this.mobileId = mobileId;
    }

    public String getMobileName() {
        return mobileName;
    }

    public void setMobileName(String mobileName) {
        this.mobileName = mobileName;
    }

    public String getWarranty() {
        return warranty;
    }

    public void setWarranty(String warranty) {
        this.warranty = warranty;
    }

    public Short getInOutStock() {
        return inOutStock;
    }

    public void setInOutStock(Short inOutStock) {
        this.inOutStock = inOutStock;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public String getAccessories() {
        return accessories;
    }

    public void setAccessories(String accessories) {
        this.accessories = accessories;
    }

    public String getImageSrc() {
        return imageSrc;
    }

    public void setImageSrc(String imageSrc) {
        this.imageSrc = imageSrc;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (mobileId != null ? mobileId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Mobile)) {
            return false;
        }
        Mobile other = (Mobile) object;
        if ((this.mobileId == null && other.mobileId != null) || (this.mobileId != null && !this.mobileId.equals(other.mobileId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "models.Mobile[ mobileId=" + mobileId + " ]";
    }
    
}
