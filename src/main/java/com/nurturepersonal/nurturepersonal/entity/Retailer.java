package com.nurturepersonal.nurturepersonal.entity;


import java.io.Serializable;
import java.util.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * A Retailer.
 */
@Entity
@Table(name = "retailer")
public class Retailer extends AbstractAuditingEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "customer_code")
    private String customerCode;

    @Column(name = "gst_number")
    private String gstNumber;

    @Column(name = "pan_number")
    private String panNumber;


    @Column(name = "firm_name")
    private String firmName;

    @Column(name = "state")
    private String state;

    @Column(name = "state_id")
    private Long stateId;

    @Column(name = "district")
    private String district;

    @Column(name = "district_id")
    private Long districtId;

    @Column(name = "tehsil")
    private String tehsil;

    @Column(name = "tehsil_id")
    private Long tehsilId;

    @Column(name = "village")
    private String village;

    @Column(name = "village_id")
    private Long villageId;

    @Column(name = "city")
    private String city;

    @Column(name = "street")
    private String street;

    @Column(name = "pin_code")
    private Integer pinCode;

    @Column(name = "sister_firm_name")
    private String sisterFirmName;

    @Column(name = "firm_type")
    private String firmType;

    @Column(name = "aadhaar_number")
    private String aadhaarNumber;

    @Column(name = "bank_account_number")
    private String bankAccountNumber;

    @Column(name = "bank_account_ifsc_code")
    private String bankAccountIfscCode;

    @Column(name = "cheque_number")
    private String chequeNumber;

    @Column(name = "company_officer_name")
    private String companyOfficerName;

    @Column(name = "company_officer_ugdn")
    private String companyOfficerUgdn;

    @Column(name = "bank_branch_city")
    private String bankBranchCity;

    @Column(name = "is_active")
    private Boolean isActive;

    @Column(name = "is_push_to_sap")
    private Boolean isPushToSap;

    @Column(name = "retry_count")
    private Integer retryCount;

    @Column(name = "is_neft_active")
    private Boolean isNeftActive;

    @Column(name = "is_cashback_allowed")
    private Boolean isCashbackAllowed;

    @Column(name = "is_wallet_allowed")
    private Boolean isWalletAllowed;

    @Column(name = "is_farmer_connect_allowed")
    private Boolean isFarmerConnectAllowed;

    @Column(name = "is_spray_service_allowed")
    private Boolean isSprayServiceAllowed;

    @Column(name = "customer_type")
    private String customerType;

    @Column(name = "self_declaration")
    private String selfDeclaration;

    @Column(name = "sfdc_status")
    private Integer sfdcStatus;


    @Column(name = "retailer_uuid")
    private String retailerUuid = UUID.randomUUID().toString();

    @Column(name = "verifier_id")
    private Long verifierId;


    @Column(name = "is_convenience_fee_applicable")
    private boolean isConvenienceFeeApplicable = true;

    @Column(name = "landmark")
    private String landmark;

    @Column(name = "other_details")
    private String otherDetails;

    public boolean getConvenienceFeeApplicable() {
        return isConvenienceFeeApplicable;
    }

    public void setConvenienceFeeApplicable(boolean convenienceFeeApplicable) {
        isConvenienceFeeApplicable = convenienceFeeApplicable;
    }


    // jhipster-needle-entity-add-field - JHipster will add fields here, do not remove
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCustomerCode() {
        return customerCode;
    }

    public Retailer customerCode(String customerCode) {
        this.customerCode = customerCode;
        return this;
    }

    public void setCustomerCode(String customerCode) {
        this.customerCode = customerCode;
    }

    public String getGstNumber() {
        return gstNumber;
    }

    public Retailer gstNumber(String gstNumber) {
        this.gstNumber = gstNumber;
        return this;
    }

    public void setGstNumber(String gstNumber) {
        this.gstNumber = gstNumber;
    }

    public String getPanNumber() {
        return panNumber;
    }

    public Retailer panNumber(String panNumber) {
        this.panNumber = panNumber;
        return this;
    }

    public void setPanNumber(String panNumber) {
        this.panNumber = panNumber;
    }


    public String getFirmName() {
        return firmName;
    }

    public Retailer firmName(String firmName) {
        this.firmName = firmName;
        return this;
    }

    public void setFirmName(String firmName) {
        this.firmName = firmName;
    }

    public String getState() {
        return state;
    }

    public Retailer state(String state) {
        this.state = state;
        return this;
    }

    public void setState(String state) {
        this.state = state;
    }

    public Long getStateId() {
        return stateId;
    }

    public Retailer stateId(Long stateId) {
        this.stateId = stateId;
        return this;
    }

    public void setStateId(Long stateId) {
        this.stateId = stateId;
    }

    public String getDistrict() {
        return district;
    }

    public Retailer district(String district) {
        this.district = district;
        return this;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public Long getDistrictId() {
        return districtId;
    }

    public Retailer districtId(Long districtId) {
        this.districtId = districtId;
        return this;
    }

    public void setDistrictId(Long districtId) {
        this.districtId = districtId;
    }

    public String getTehsil() {
        return tehsil;
    }

    public Retailer tehsil(String tehsil) {
        this.tehsil = tehsil;
        return this;
    }

    public void setTehsil(String tehsil) {
        this.tehsil = tehsil;
    }

    public Long getTehsilId() {
        return tehsilId;
    }

    public Retailer tehsilId(Long tehsilId) {
        this.tehsilId = tehsilId;
        return this;
    }

    public void setTehsilId(Long tehsilId) {
        this.tehsilId = tehsilId;
    }

    public String getVillage() {
        return village;
    }

    public Retailer village(String village) {
        this.village = village;
        return this;
    }

    public void setVillage(String village) {
        this.village = village;
    }

    public Long getVillageId() {
        return villageId;
    }

    public Retailer villageId(Long villageId) {
        this.villageId = villageId;
        return this;
    }

    public void setVillageId(Long villageId) {
        this.villageId = villageId;
    }

    public String getCity() {
        return city;
    }

    public Retailer city(String city) {
        this.city = city;
        return this;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public Retailer street(String street) {
        this.street = street;
        return this;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public Integer getPinCode() {
        return pinCode;
    }

    public Retailer pinCode(Integer pinCode) {
        this.pinCode = pinCode;
        return this;
    }

    public void setPinCode(Integer pinCode) {
        this.pinCode = pinCode;
    }

    public String getSisterFirmName() {
        return sisterFirmName;
    }

    public Retailer sisterFirmName(String sisterFirmName) {
        this.sisterFirmName = sisterFirmName;
        return this;
    }

    public void setSisterFirmName(String sisterFirmName) {
        this.sisterFirmName = sisterFirmName;
    }

    public String getFirmType() {
        return firmType;
    }

    public Retailer firmType(String firmType) {
        this.firmType = firmType;
        return this;
    }

    public void setFirmType(String firmType) {
        this.firmType = firmType;
    }

    public String getAadhaarNumber() {
        return aadhaarNumber;
    }

    public Retailer aadhaarNumber(String aadhaarNumber) {
        this.aadhaarNumber = aadhaarNumber;
        return this;
    }

    public void setAadhaarNumber(String aadhaarNumber) {
        this.aadhaarNumber = aadhaarNumber;
    }

    public String getBankAccountNumber() {
        return bankAccountNumber;
    }

    public Retailer bankAccountNumber(String bankAccountNumber) {
        this.bankAccountNumber = bankAccountNumber;
        return this;
    }

    public void setBankAccountNumber(String bankAccountNumber) {
        this.bankAccountNumber = bankAccountNumber;
    }

    public String getBankAccountIfscCode() {
        return bankAccountIfscCode;
    }

    public Retailer bankAccountIfscCode(String bankAccountIfscCode) {
        this.bankAccountIfscCode = bankAccountIfscCode;
        return this;
    }

    public void setBankAccountIfscCode(String bankAccountIfscCode) {
        this.bankAccountIfscCode = bankAccountIfscCode;
    }

    public String getChequeNumber() {
        return chequeNumber;
    }

    public Retailer chequeNumber(String chequeNumber) {
        this.chequeNumber = chequeNumber;
        return this;
    }

    public void setChequeNumber(String chequeNumber) {
        this.chequeNumber = chequeNumber;
    }

    public String getCompanyOfficerName() {
        return companyOfficerName;
    }

    public Retailer companyOfficerName(String companyOfficerName) {
        this.companyOfficerName = companyOfficerName;
        return this;
    }

    public void setCompanyOfficerName(String companyOfficerName) {
        this.companyOfficerName = companyOfficerName;
    }

    public String getCompanyOfficerUgdn() {
        return companyOfficerUgdn;
    }

    public Retailer companyOfficerUgdn(String companyOfficerUgdn) {
        this.companyOfficerUgdn = companyOfficerUgdn;
        return this;
    }

    public void setCompanyOfficerUgdn(String companyOfficerUgdn) {
        this.companyOfficerUgdn = companyOfficerUgdn;
    }

    public Boolean getIsPushToSap() {
        return isPushToSap;
    }

    public void setIsPushToSap(Boolean isPushToSap) {
        this.isPushToSap = isPushToSap;
    }

    public Boolean isPushToSap() {
        return isPushToSap;
    }

    public Retailer isPushToSap(Boolean isPushToSap) {
        this.isPushToSap = isPushToSap;
        return this;
    }

    public Integer getRetryCount() {
        return retryCount;
    }

    public void setRetryCount(Integer retryCount) {
        this.retryCount = retryCount;
    }

    public Boolean isIsActive() {
        return isActive;
    }

    public Retailer isActive(Boolean isActive) {
        this.isActive = isActive;
        return this;
    }

    public void setIsActive(Boolean isActive) {
        this.isActive = isActive;
    }

    public Long getVerifierId() {
        return verifierId;
    }

    public void setVerifierId(Long verifierId) {
        this.verifierId = verifierId;
    }

    @Override
    public String toString() {
        return "Retailer{" +
                "id=" + id +
                ", customerCode='" + customerCode + '\'' +
                ", gstNumber='" + gstNumber + '\'' +
                ", panNumber='" + panNumber + '\'' +
                ", firmName='" + firmName + '\'' +
                ", state='" + state + '\'' +
                ", stateId=" + stateId +
                ", district='" + district + '\'' +
                ", districtId=" + districtId +
                ", tehsil='" + tehsil + '\'' +
                ", tehsilId=" + tehsilId +
                ", village='" + village + '\'' +
                ", villageId=" + villageId +
                ", city='" + city + '\'' +
                ", street='" + street + '\'' +
                ", pinCode=" + pinCode +
                ", sisterFirmName='" + sisterFirmName + '\'' +
                ", firmType='" + firmType + '\'' +
                ", aadhaarNumber='" + aadhaarNumber + '\'' +
                ", bankAccountNumber='" + bankAccountNumber + '\'' +
                ", bankAccountIfscCode='" + bankAccountIfscCode + '\'' +
                ", chequeNumber='" + chequeNumber + '\'' +
                ", companyOfficerName='" + companyOfficerName + '\'' +
                ", companyOfficerUgdn='" + companyOfficerUgdn + '\'' +
                ", bankBranchCity='" + bankBranchCity + '\'' +
                ", isActive=" + isActive +
                ", isPushToSap=" + isPushToSap +
                ", retryCount=" + retryCount +
                ", isNeftActive=" + isNeftActive +
                ", isCashbackAllowed=" + isCashbackAllowed +
                ", isWalletAllowed=" + isWalletAllowed +
                ", isFarmerConnectAllowed=" + isFarmerConnectAllowed +
                ", isSprayServiceAllowed=" + isSprayServiceAllowed +
                ", customerType='" + customerType + '\'' +
                ", selfDeclaration='" + selfDeclaration + '\'' +
                ", sfdcStatus=" + sfdcStatus +
                ", retailerUuid='" + retailerUuid + '\'' +
                ", verifierId=" + verifierId +
                ", isConvenienceFeeApplicable=" + isConvenienceFeeApplicable +
                ", landmark='" + landmark + '\'' +
                ", otherDetails='" + otherDetails + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Retailer)) {
            return false;
        }
        return id != null && id.equals(((Retailer) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }


    public String getLandmark() {
        return landmark;
    }

    public void setLandmark(String landmark) {
        this.landmark = landmark;
    }

    public String getOtherDetails() {
        return otherDetails;
    }

    public void setOtherDetails(String otherDetails) {
        this.otherDetails = otherDetails;
    }
}
