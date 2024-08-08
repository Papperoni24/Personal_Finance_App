package com.papperoni.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Table(name = "Mortgages")
public class Mortgage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "MortgageID")
    private Long mortgageId;

    @ManyToOne
    @JoinColumn(name = "OwnerID", nullable = false)
    @NotNull(message = "Owner is required")
    private int ownerID;

    @NotBlank(message = "Account identifier is required")
    @Column(name = "AccountIdentifier", nullable = false, length = 100)
    private String accountIdentifier;

    @Column(name = "AccountName", length = 100)
    private String accountName;

    @DecimalMin(value = "0.0", inclusive = false, message = "Balance must be greater than 0")
    @Digits(integer = 15, fraction = 2, message = "Balance must be a valid monetary amount")
    @Column(name = "Balance", precision = 15, scale = 2, columnDefinition = "DECIMAL(15, 2) DEFAULT 0.00")
    private BigDecimal balance;

    @Min(value = 1, message = "Payment date must be between 1 and 31")
    @Max(value = 31, message = "Payment date must be between 1 and 31")
    @Column(name = "PaymentDate")
    private Integer paymentDate;

    @DecimalMin(value = "0.0", inclusive = false, message = "Minimum monthly payment must be greater than 0")
    @Digits(integer = 15, fraction = 2, message = "Minimum monthly payment must be a valid monetary amount")
    @Column(name = "MinMonthlyPayment", precision = 15, scale = 2)
    private BigDecimal minMonthlyPayment;

    @Column(name = "AutoPay", nullable = false)
    private Boolean autoPay = false;

    @Column(name = "DefaultPayment")
    private int defaultPaymentID;

    @NotNull(message = "Updated date is required")
    @Column(name = "Updated", nullable = false)
    private LocalDate updated;

    @DecimalMin(value = "0.0", inclusive = false, message = "APR must be greater than 0")
    @DecimalMax(value = "100.0", message = "APR must be less than or equal to 100")
    @Digits(integer = 5, fraction = 2, message = "APR must be a valid percentage")
    @Column(name = "APR", precision = 5, scale = 2)
    private BigDecimal apr;

    @NotNull(message = "Creation date is required")
    @Column(name = "CreatedAt", columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private LocalDateTime createdAt;

    @Size(max = 255, message = "Notes cannot exceed 255 characters")
    @Column(name = "Notes", length = 255)
    private String notes;

    public Mortgage() {
    }

    public Mortgage(Long mortgageId, int ownerID, String accountIdentifier, String accountName, BigDecimal balance, Integer paymentDate, BigDecimal minMonthlyPayment, Boolean autoPay, int defaultPaymentID, LocalDate updated, BigDecimal apr, LocalDateTime createdAt, String notes) {
        this.mortgageId = mortgageId;
        this.ownerID = ownerID;
        this.accountIdentifier = accountIdentifier;
        this.accountName = accountName;
        this.balance = balance;
        this.paymentDate = paymentDate;
        this.minMonthlyPayment = minMonthlyPayment;
        this.autoPay = autoPay;
        this.defaultPaymentID = defaultPaymentID;
        this.updated = updated;
        this.apr = apr;
        this.createdAt = createdAt;
        this.notes = notes;
    }

    public Long getMortgageId() {
        return mortgageId;
    }

    public void setMortgageId(Long mortgageId) {
        this.mortgageId = mortgageId;
    }

    public int getOwnerID() {
        return ownerID;
    }

    public void setOwnerID(int owner) {
        this.ownerID = owner;
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
        Mortgage mortgage = (Mortgage) o;
        return Objects.equals(mortgageId, mortgage.mortgageId) && Objects.equals(ownerID, mortgage.ownerID) && Objects.equals(accountIdentifier, mortgage.accountIdentifier) && Objects.equals(accountName, mortgage.accountName) && Objects.equals(balance, mortgage.balance) && Objects.equals(paymentDate, mortgage.paymentDate) && Objects.equals(minMonthlyPayment, mortgage.minMonthlyPayment) && Objects.equals(autoPay, mortgage.autoPay) && Objects.equals(defaultPaymentID, mortgage.defaultPaymentID) && Objects.equals(updated, mortgage.updated) && Objects.equals(apr, mortgage.apr) && Objects.equals(createdAt, mortgage.createdAt) && Objects.equals(notes, mortgage.notes);
    }

    @Override
    public int hashCode() {
        return Objects.hash(mortgageId, ownerID, accountIdentifier, accountName, balance, paymentDate, minMonthlyPayment, autoPay, defaultPaymentID, updated, apr, createdAt, notes);
    }

    @Override
    public String toString() {
        return "Mortgage{" +
                "mortgageId=" + mortgageId +
                ", owner=" + ownerID +
                ", accountIdentifier='" + accountIdentifier + '\'' +
                ", accountName='" + accountName + '\'' +
                ", balance=" + balance +
                ", paymentDate=" + paymentDate +
                ", minMonthlyPayment=" + minMonthlyPayment +
                ", autoPay=" + autoPay +
                ", defaultPayment='" + defaultPaymentID + '\'' +
                ", updated=" + updated +
                ", apr=" + apr +
                ", createdAt=" + createdAt +
                ", notes='" + notes + '\'' +
                '}';
    }
}
