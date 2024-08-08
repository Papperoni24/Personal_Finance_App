package com.papperoni.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Table(name = "CreditCards")
public class CreditCard {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CreditCardID")
    private Long creditCardId;

    @ManyToOne
    @JoinColumn(name = "OwnerID", nullable = false)
    @NotNull(message = "Owner cannot be null")
    private OwnerOfAccount owner;

    @NotBlank(message = "Account Identifier cannot be blank")
    @Column(name = "AccountIdentifier", nullable = false, length = 100)
    private String accountIdentifier;

    @Column(name = "AccountName", length = 100)
    private String accountName;

    @DecimalMin(value = "0.0", inclusive = true, message = "Credit Limit must be non-negative")
    @Digits(integer = 15, fraction = 2, message = "Credit Limit must be a valid monetary amount")
    @Column(name = "CreditLimit", precision = 15, scale = 2)
    private BigDecimal creditLimit;

    @DecimalMin(value = "0.0", inclusive = true, message = "Balance must be non-negative")
    @Digits(integer = 15, fraction = 2, message = "Balance must be a valid monetary amount")
    @Column(name = "Balance", precision = 15, scale = 2, columnDefinition = "DECIMAL(15, 2) DEFAULT 0.00")
    private BigDecimal balance;

    @Min(value = 1, message = "Payment Date must be between 1 and 31")
    @Max(value = 31, message = "Payment Date must be between 1 and 31")
    @Column(name = "PaymentDate")
    private Integer paymentDate;

    @DecimalMin(value = "0.0", inclusive = true, message = "Minimum Monthly Payment must be non-negative")
    @Digits(integer = 15, fraction = 2, message = "Minimum Monthly Payment must be a valid monetary amount")
    @Column(name = "MinMonthlyPayment", precision = 15, scale = 2)
    private BigDecimal minMonthlyPayment;

    @Column(name = "AutoPay", nullable = false)
    private Boolean autoPay = false;

    @Column(name = "DefaultPayment")
    private int defaultPaymentID;

    @PastOrPresent(message = "Updated date cannot be in the future")
    @Column(name = "Updated", nullable = false)
    private LocalDate updated;

    @DecimalMin(value = "0.0", inclusive = true, message = "APR must be non-negative")
    @DecimalMax(value = "100.0", message = "APR must be less than or equal to 100")
    @Digits(integer = 5, fraction = 2, message = "APR must be a valid percentage")
    @Column(name = "APR", precision = 5, scale = 2)
    private BigDecimal apr;

    @DecimalMin(value = "0.0", inclusive = true, message = "Annual Fee must be non-negative")
    @Digits(integer = 15, fraction = 2, message = "Annual Fee must be a valid monetary amount")
    @Column(name = "AnnualFee", precision = 15, scale = 2)
    private BigDecimal annualFee;

    @PastOrPresent(message = "Creation date cannot be in the future")
    @Column(name = "CreatedAt", columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private LocalDateTime createdAt;

    @Column(name = "Notes", length = 255)
    private String notes;

    public CreditCard() {
    }

    public CreditCard(Long creditCardId, OwnerOfAccount owner, String accountIdentifier, String accountName, BigDecimal creditLimit, BigDecimal balance, Integer paymentDate, BigDecimal minMonthlyPayment, Boolean autoPay, String defaultPayment, LocalDate updated, BigDecimal apr, BigDecimal annualFee, LocalDateTime createdAt, String notes) {
        this.creditCardId = creditCardId;
        this.owner = owner;
        this.accountIdentifier = accountIdentifier;
        this.accountName = accountName;
        this.creditLimit = creditLimit;
        this.balance = balance;
        this.paymentDate = paymentDate;
        this.minMonthlyPayment = minMonthlyPayment;
        this.autoPay = autoPay;
        this.defaultPaymentID = defaultPaymentID;
        this.updated = updated;
        this.apr = apr;
        this.annualFee = annualFee;
        this.createdAt = createdAt;
        this.notes = notes;
    }

    public Long getCreditCardId() {
        return creditCardId;
    }

    public void setCreditCardId(Long creditCardId) {
        this.creditCardId = creditCardId;
    }

    public OwnerOfAccount getOwner() {
        return owner;
    }

    public void setOwner(OwnerOfAccount owner) {
        this.owner = owner;
    }

    public String getAccountIdentifier() {
        return accountIdentifier;
    }

    public void setAccountIdentifier(String accountIdentifier) {
        this.accountIdentifier = accountIdentifier;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public BigDecimal getCreditLimit() {
        return creditLimit;
    }

    public void setCreditLimit(BigDecimal creditLimit) {
        this.creditLimit = creditLimit;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public Integer getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(Integer paymentDate) {
        this.paymentDate = paymentDate;
    }

    public BigDecimal getMinMonthlyPayment() {
        return minMonthlyPayment;
    }

    public void setMinMonthlyPayment(BigDecimal minMonthlyPayment) {
        this.minMonthlyPayment = minMonthlyPayment;
    }

    public Boolean getAutoPay() {
        return autoPay;
    }

    public void setAutoPay(Boolean autoPay) {
        this.autoPay = autoPay;
    }

    public int getDefaultPaymentID() {
        return defaultPaymentID;
    }

    public void setDefaultPaymentID(int defaultPayment) {
        this.defaultPaymentID = defaultPaymentID;
    }

    public LocalDate getUpdated() {
        return updated;
    }

    public void setUpdated(LocalDate updated) {
        this.updated = updated;
    }

    public BigDecimal getApr() {
        return apr;
    }

    public void setApr(BigDecimal apr) {
        this.apr = apr;
    }

    public BigDecimal getAnnualFee() {
        return annualFee;
    }

    public void setAnnualFee(BigDecimal annualFee) {
        this.annualFee = annualFee;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CreditCard that = (CreditCard) o;
        return Objects.equals(creditCardId, that.creditCardId) && Objects.equals(owner, that.owner) && Objects.equals(accountIdentifier, that.accountIdentifier) && Objects.equals(accountName, that.accountName) && Objects.equals(creditLimit, that.creditLimit) && Objects.equals(balance, that.balance) && Objects.equals(paymentDate, that.paymentDate) && Objects.equals(minMonthlyPayment, that.minMonthlyPayment) && Objects.equals(autoPay, that.autoPay) && Objects.equals(defaultPaymentID, that.defaultPaymentID) && Objects.equals(updated, that.updated) && Objects.equals(apr, that.apr) && Objects.equals(annualFee, that.annualFee) && Objects.equals(createdAt, that.createdAt) && Objects.equals(notes, that.notes);
    }

    @Override
    public int hashCode() {
        return Objects.hash(creditCardId, owner, accountIdentifier, accountName, creditLimit, balance, paymentDate, minMonthlyPayment, autoPay, defaultPaymentID, updated, apr, annualFee, createdAt, notes);
    }

    @Override
    public String toString() {
        return "CreditCard{" +
                "creditCardId=" + creditCardId +
                ", owner=" + owner +
                ", accountIdentifier='" + accountIdentifier + '\'' +
                ", accountName='" + accountName + '\'' +
                ", creditLimit=" + creditLimit +
                ", balance=" + balance +
                ", paymentDate=" + paymentDate +
                ", minMonthlyPayment=" + minMonthlyPayment +
                ", autoPay=" + autoPay +
                ", defaultPayment='" + defaultPaymentID + '\'' +
                ", updated=" + updated +
                ", apr=" + apr +
                ", annualFee=" + annualFee +
                ", createdAt=" + createdAt +
                ", notes='" + notes + '\'' +
                '}';
    }
}
