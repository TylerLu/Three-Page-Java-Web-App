package com.example.fabrikam.HotelCoupon.data;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Coupon {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private long id;
    private String title;
    private String description;
    private String companyName;
    private String addressLine1;
    private String addressLine2;
    private Date redeemableFrom;
    private Date redeemableTo;
    @Lob
    @Column(columnDefinition="MEDIUMTEXT")
    private String image;
    @Lob
    @Column(columnDefinition="MEDIUMTEXT")
    private String qrCodeImage;

    private static final String base64StrPrefix="data:image/png;base64,";

    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getAddressLine1() {
        return addressLine1;
    }

    public void setAddressLine1(String addressLine1) {
        this.addressLine1 = addressLine1;
    }

    public String getAddressLine2() {
        return addressLine2;
    }

    public void setAddressLine2(String addressLine2) {
        this.addressLine2 = addressLine2;
    }

    public Date getRedeemableFrom() {
        return redeemableFrom;
    }

    public void setRedeemableFrom(Date redeemableFrom) {
        this.redeemableFrom = redeemableFrom;
    }

    public Date getRedeemableTo() {
        return redeemableTo;
    }

    public void setRedeemableTo(Date redeemableTo) {
        this.redeemableTo = redeemableTo;
    }

    public String getImage() {
        return image;
    }
    public void setImage(String image) {
        this.image = image;
    }
    public String getImgSrc(){
        return base64StrPrefix + this.image;
    }

    public String getQrCodeImage() {
        return qrCodeImage;
    }
    public void setQrCodeImage(String qrCodeImage) {
        this.qrCodeImage = qrCodeImage;
    }
}
