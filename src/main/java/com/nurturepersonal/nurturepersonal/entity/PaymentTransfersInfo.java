package com.nurturepersonal.nurturepersonal.entity;

import com.nurturepersonal.nurturepersonal.enums.RazorpayTransferStatus;
import com.nurturepersonal.nurturepersonal.enums.TransferType;

import javax.persistence.*;

import java.io.Serializable;
import java.time.Instant;

/**
 * A PaymentTransfersInfo.
 */
@Entity
@Table(name = "payment_transfers_info")
public class PaymentTransfersInfo extends AbstractAuditingEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "transfer_id")
    private String transferId;

    @Column(name = "payment_id")
    private String paymentId;

    @Column(name = "account_id")
    private String accountId;

    @Column(name = "app_order_id")
    private String appOrderId;

    @Column(name = "enterprise_id")
    private Long enterpriseId;

    @Column(name = "transfer_charge")
    private Double transferCharge;

    @Column(name = "transfer_tax")
    private Double transferTax;

    @Column(name = "amount_transferred")
    private Double amountTransferred;

    @Column(name = "transfer_response")
    private String transferResponse;

    @Column(name = "is_deleted")
    private Boolean isDeleted;

    @Column(name = "payment_type")
    private Integer paymentType;

    @Column(name = "status")
    @Enumerated(EnumType.STRING)
    private RazorpayTransferStatus status;

    @Column(name = "settlement_id")
    private String settlementId;

    @Column(name = "reversal_against_id")
    private String reversalAgainstId;

    @Column(name = "reference_id")
    private String referenceId = "ref";

    public String getReferenceId() {
        return referenceId;
    }

    public void setReferenceId(String referenceId) {
        this.referenceId = referenceId;
    }

    @Column(name = "transfer_type")
    @Enumerated(EnumType.STRING)
    private TransferType transferType = TransferType.Payout;

    @Column(name = "transfer_date")
    private Instant transferDate = Instant.now();

    @Column(name = "reversal_request_id")
    private Long reversalRequestId;

    // jhipster-needle-entity-add-field - JHipster will add fields here
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTransferId() {
        return transferId;
    }

    public PaymentTransfersInfo transferId(String transferId) {
        this.transferId = transferId;
        return this;
    }

    public void setTransferId(String transferId) {
        this.transferId = transferId;
    }

    public String getPaymentId() {
        return paymentId;
    }

    public PaymentTransfersInfo paymentId(String paymentId) {
        this.paymentId = paymentId;
        return this;
    }

    public void setPaymentId(String paymentId) {
        this.paymentId = paymentId;
    }

    public String getAccountId() {
        return accountId;
    }

    public PaymentTransfersInfo accountId(String accountId) {
        this.accountId = accountId;
        return this;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public String getAppOrderId() {
        return appOrderId;
    }

    public PaymentTransfersInfo appOrderId(String appOrderId) {
        this.appOrderId = appOrderId;
        return this;
    }

    public void setAppOrderId(String appOrderId) {
        this.appOrderId = appOrderId;
    }

    public Long getEnterpriseId() {
        return enterpriseId;
    }

    public PaymentTransfersInfo enterpriseId(Long enterpriseId) {
        this.enterpriseId = enterpriseId;
        return this;
    }

    public void setEnterpriseId(Long enterpriseId) {
        this.enterpriseId = enterpriseId;
    }

    public Double getTransferCharge() {
        return transferCharge;
    }

    public PaymentTransfersInfo transferCharge(Double transferCharge) {
        this.transferCharge = transferCharge;
        return this;
    }

    public void setTransferCharge(Double transferCharge) {
        this.transferCharge = transferCharge;
    }

    public Double getTransferTax() {
        return transferTax;
    }

    public PaymentTransfersInfo transferTax(Double transferTax) {
        this.transferTax = transferTax;
        return this;
    }

    public void setTransferTax(Double transferTax) {
        this.transferTax = transferTax;
    }

    public Double getAmountTransferred() {
        return amountTransferred;
    }

    public PaymentTransfersInfo amountTransferred(Double amountTransferred) {
        this.amountTransferred = amountTransferred;
        return this;
    }

    public void setAmountTransferred(Double amountTransferred) {
        this.amountTransferred = amountTransferred;
    }

    public String getTransferResponse() {
        return transferResponse;
    }

    public PaymentTransfersInfo transferResponse(String transferResponse) {
        this.transferResponse = transferResponse;
        return this;
    }

    public void setTransferResponse(String transferResponse) {
        this.transferResponse = transferResponse;
    }

    public Boolean isIsDeleted() {
        return isDeleted;
    }

    public PaymentTransfersInfo isDeleted(Boolean isDeleted) {
        this.isDeleted = isDeleted;
        return this;
    }

    public void setIsDeleted(Boolean isDeleted) {
        this.isDeleted = isDeleted;
    }

    public Integer getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(Integer paymentType) {
        this.paymentType = paymentType;
    }

    public RazorpayTransferStatus getStatus() {
        return status;
    }

    public void setStatus(RazorpayTransferStatus status) {
        this.status = status;
    }

    public String getSettlementId() {
        return settlementId;
    }

    public void setSettlementId(String settlementId) {
        this.settlementId = settlementId;
    }
    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here

    public String getReversalAgainstId() {
        return reversalAgainstId;
    }

    public void setReversalAgainstId(String reversalAgainstId) {
        this.reversalAgainstId = reversalAgainstId;
    }

    public TransferType getTransferType() {
        return transferType;
    }

    public void setTransferType(TransferType transferType) {
        this.transferType = transferType;
    }

    public Instant getTransferDate() {
        return transferDate;
    }

    public void setTransferDate(Instant transferDate) {
        this.transferDate = transferDate;
    }

    public Long getReversalRequestId() {
        return reversalRequestId;
    }

    public void setReversalRequestId(Long reversalRequestId) {
        this.reversalRequestId = reversalRequestId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof PaymentTransfersInfo)) {
            return false;
        }
        return id != null && id.equals(((PaymentTransfersInfo) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    @Override
    public String toString() {
        return "PaymentTransfersInfo{" +
                "id=" + id +
                ", transferId='" + transferId + '\'' +
                ", paymentId='" + paymentId + '\'' +
                ", accountId='" + accountId + '\'' +
                ", appOrderId='" + appOrderId + '\'' +
                ", enterpriseId=" + enterpriseId +
                ", transferCharge=" + transferCharge +
                ", transferTax=" + transferTax +
                ", amountTransferred=" + amountTransferred +
                ", transferResponse='" + transferResponse + '\'' +
                ", isDeleted=" + isDeleted +
                ", paymentType=" + paymentType +
                ", status=" + status +
                ", settlementId=" + settlementId +
                '}';
    }

}
