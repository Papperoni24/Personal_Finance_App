package com.papperoni.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Objects;
import java.time.format.DateTimeFormatter;

@Entity
@Table(name = "Transaction")
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "TransactionId")
    private int transactionId;

    @Getter
    @NotNull(message = "Amount must not be null")
    @DecimalMin(value = "0.00", inclusive = false, message = "Amount must be greater than zero")
    @Column(name = "Amount", nullable = false)
    private BigDecimal amount;

    @Column(name = "Description")
    private String description;

    @NotNull(message = "Account ID must not be null") // Add this annotation
    @Column(name = "AccountID", nullable = false)
    private Integer accountId;

    @ManyToOne
    @JoinColumn(name = "PlaceOfBusinessID")
    private PlaceOfBusiness placeOfBusiness;

    @ManyToOne
    @JoinColumn(name = "TransactionTypeID")
    private TransactionType transactionType;

    @Column(name = "AssociatedAccountID")
    private Integer associatedAccountId;

    @Column(name = "AssociatedAccountType", length = 50)
    private String associatedAccountType;

    @NotNull(message = "TransactionDate must not be null")
    @Column(name = "TransactionDate", nullable = false)
    private LocalDateTime transactionDate;

    @NotNull(message = "UploadDate must not be null")
    @Column(name = "UploadDate", updatable = false, nullable = false)
    private LocalDateTime uploadDate;

    @Column(name = "LastUpdated")
    private LocalDateTime lastUpdated;

    @Column(name = "IsRecurring")
    private Boolean isRecurring;

    public Transaction() {
        this.uploadDate = LocalDateTime.now(); // Set uploadDate on creation
    }

    // Getters and Setters
    public int getTransactionID() {
        return transactionId;
    }

    public void setTransactionId(int transactionId) {
        this.transactionId = transactionId;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getAccountId() {
        return accountId;
    }

    public void setAccountId(Integer accountId) {
        this.accountId = accountId;
    }

    public PlaceOfBusiness getPlaceOfBusiness() {
        return placeOfBusiness;
    }

    public void setPlaceOfBusiness(PlaceOfBusiness placeOfBusiness) {
        this.placeOfBusiness = placeOfBusiness;
    }

    public TransactionType getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(TransactionType transactionType) {
        this.transactionType = transactionType;
    }

    public Integer getAssociatedAccountId() {
        return associatedAccountId;
    }

    public void setAssociatedAccountId(Integer associatedAccountId) {
        this.associatedAccountId = associatedAccountId;
    }

    public String getAssociatedAccountType() {
        return associatedAccountType;
    }

    public void setAssociatedAccountType(String associatedAccountType) {
        this.associatedAccountType = associatedAccountType;
    }

    public LocalDateTime getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(LocalDateTime transactionDate) {
        this.transactionDate = transactionDate;
    }

    public LocalDateTime getUploadDate() {
        return uploadDate;
    }

    public void setUploadDate(LocalDateTime uploadDate) {
        this.uploadDate = uploadDate;
    }

    public LocalDateTime getLastUpdated() {
        return lastUpdated;
    }

    public void setLastUpdated(LocalDateTime lastUpdated) {
        this.lastUpdated = lastUpdated;
    }

    public Boolean getIsRecurring() {
        return isRecurring;
    }

    public void setIsRecurring(Boolean isRecurring) {
        this.isRecurring = isRecurring;
    }

    @PreUpdate
    protected void onUpdate() {
        this.lastUpdated = LocalDateTime.now();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Transaction that = (Transaction) o;
        return Objects.equals(transactionId, that.transactionId) &&
                Objects.equals(amount, that.amount) &&
                Objects.equals(description, that.description) &&
                Objects.equals(accountId, that.accountId) &&
                Objects.equals(placeOfBusiness, that.placeOfBusiness) &&
                Objects.equals(transactionType, that.transactionType) &&
                Objects.equals(associatedAccountId, that.associatedAccountId) &&
                Objects.equals(associatedAccountType, that.associatedAccountType) &&
                Objects.equals(transactionDate, that.transactionDate) &&
                Objects.equals(uploadDate, that.uploadDate) &&
                Objects.equals(lastUpdated, that.lastUpdated) &&
                Objects.equals(isRecurring, that.isRecurring);
    }

    @Override
    public int hashCode() {
        return Objects.hash(transactionId, amount, description, accountId, placeOfBusiness, transactionType, associatedAccountId, associatedAccountType, transactionDate, uploadDate, lastUpdated, isRecurring);
    }

    // Add this formatter to the class
    private static final DateTimeFormatter DATE_TIME_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss");

    @Override
    public String toString() {
        return "Transaction{" +
                "transactionId=" + transactionId +
                ", amount=" + amount +
                ", description='" + description + '\'' +
                ", accountId=" + accountId +
                ", placeOfBusiness=" + (placeOfBusiness != null ? placeOfBusiness : "null") +
                ", transactionType=" + (transactionType != null ? transactionType : "null") +
                ", associatedAccountId=" + associatedAccountId +
                ", associatedAccountType=" + (associatedAccountType != null ? associatedAccountType : "null") +
                ", transactionDate=" + (transactionDate != null ? transactionDate.format(DATE_TIME_FORMATTER) : "null") +
                ", uploadDate=" + (uploadDate != null ? uploadDate.format(DATE_TIME_FORMATTER) : "null") +
                ", lastUpdated=" + (lastUpdated != null ? lastUpdated.format(DATE_TIME_FORMATTER) : "null") +
                ", isRecurring=" + (isRecurring != null ? isRecurring : "null") +
                '}';
    }

}
