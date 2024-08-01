package com.papperoni.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Table(name = "OtherCreditAccounts")
public class OtherCreditAccount {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "OtherCreditAccountID")
    private Long otherCreditAccountId;

    @ManyToOne
    @JoinColumn(name = "OwnerID", nullable = false)
    @NotNull(message = "Owner cannot be null")
    private OwnerOfAccount owner;

    @NotBlank(message = "Account identifier cannot be blank")
    @Column(name = "AccountIdentifier", nullable = false, length = 100)
    private String accountIdentifier;

    @Column(name = "AccountName", length = 100)
    private String accountName;

    @DecimalMin(value = "0.0", inclusive = true, message = "Credit limit must be positive")
    @Digits(integer = 15, fraction = 2, message = "Credit limit must be a valid monetary amount")
    @Column(name = "CreditLimit", precision = 15, scale = 2)
    private BigDecimal creditLimit;

    @DecimalMin(value = "0.0", inclusive = true, message = "Balance must be positive")
    @Digits(integer = 15, fraction = 2, message = "Balance must be a valid monetary amount")
    @Column(name = "Balance", precision = 15, scale = 2, columnDefinition = "DECIMAL(15, 2) DEFAULT 0.00")
    private BigDecimal balance;

    @Min(value = 1, message = "Payment date must be between 1 and 31")
    @Max(value = 31, message = "Payment date must be between 1 and 31")
    @Column(name = "PaymentDate")
    private Integer paymentDate;

    @DecimalMin(value = "0.0", inclusive = true, message = "Minimum monthly payment must be positive")
    @Digits(integer = 15, fraction = 2, message = "Minimum monthly payment must be a valid monetary amount")
    @Column(name = "MinMonthlyPayment", precision = 15, scale = 2)
    private BigDecimal minMonthlyPayment;

    @Column(name = "AutoPay", nullable = false)
    private Boolean autoPay = false;

    @Column(name = "DefaultPayment", length = 100)
    private String defaultPayment;

    @NotNull(message = "Updated date is required")
    @Column(name = "Updated", nullable = false)
    private LocalDate updated;

    @DecimalMin(value = "0.0", inclusive = true, message = "APR must be positive")
    @DecimalMax(value = "100.0", message = "APR must be less than or equal to 100")
    @Digits(integer = 5, fraction = 2, message = "APR must be a valid percentage")
    @Column(name = "APR", precision = 5, scale = 2)
    private BigDecimal apr;

    @DecimalMin(value = "0.0", inclusive = true, message = "Annual fee must be positive")
    @Digits(integer = 15, fraction = 2, message = "Annual fee must be a valid monetary amount")
    @Column(name = "AnnualFee", precision = 15, scale = 2)
    private BigDecimal annualFee;

    @NotNull(message = "Creation date is required")
    @Column(name = "CreatedAt", columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private LocalDateTime createdAt;

    @Size(max = 255, message = "Notes cannot exceed 255 characters")
    @Column(name = "Notes", length = 255)
    private String notes;

    public OtherCreditAccount() {
    }

    public OtherCreditAccount(Long otherCreditAccountId, OwnerOfAccount owner, String accountIdentifier, String accountName, BigDecimal creditLimit, BigDecimal balance, Integer paymentDate, BigDecimal minMonthlyPayment, String defaultPayment, Boolean autoPay, LocalDate updated, BigDecimal apr, BigDecimal annualFee, LocalDateTime createdAt, String notes) {
        this.otherCreditAccountId = otherCreditAccountId;
        this.owner = owner;
        this.accountIdentifier = accountIdentifier;
        this.accountName = accountName;
        this.creditLimit = creditLimit;
        this.balance = balance;
        this.paymentDate = paymentDate;
        this.minMonthlyPayment = minMonthlyPayment;
        this.defaultPayment = defaultPayment;
        this.autoPay = autoPay;
        this.updated = updated;
        this.apr = apr;
        this.annualFee = annualFee;
        this.createdAt = createdAt;
        this.notes = notes;
    }

    public Long getOtherCreditAccountId() {
        return otherCreditAccountId;
    }

    public void setOtherCreditAccountId(Long otherCreditAccountId) {
        this.otherCreditAccountId = otherCreditAccountId;
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

    public String getDefaultPayment() {
        return defaultPayment;
    }

    public void setDefaultPayment(String defaultPayment) {
        this.defaultPayment = defaultPayment;
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
        OtherCreditAccount that = (OtherCreditAccount) o;
        return Objects.equals(otherCreditAccountId, that.otherCreditAccountId) && Objects.equals(owner, that.owner) && Objects.equals(accountIdentifier, that.accountIdentifier) && Objects.equals(accountName, that.accountName) && Objects.equals(creditLimit, that.creditLimit) && Objects.equals(balance, that.balance) && Objects.equals(paymentDate, that.paymentDate) && Objects.equals(minMonthlyPayment, that.minMonthlyPayment) && Objects.equals(autoPay, that.autoPay) && Objects.equals(defaultPayment, that.defaultPayment) && Objects.equals(updated, that.updated) && Objects.equals(apr, that.apr) && Objects.equals(annualFee, that.annualFee) && Objects.equals(createdAt, that.createdAt) && Objects.equals(notes, that.notes);
    }

    @Override
    public int hashCode() {
        return Objects.hash(otherCreditAccountId, owner, accountIdentifier, accountName, creditLimit, balance, paymentDate, minMonthlyPayment, autoPay, defaultPayment, updated, apr, annualFee, createdAt, notes);
    }

    @Override
    public String toString() {
        return "OtherCreditAccount{" +
                "otherCreditAccountId=" + otherCreditAccountId +
                ", owner=" + owner +
                ", accountIdentifier='" + accountIdentifier + '\'' +
                ", accountName='" + accountName + '\'' +
                ", creditLimit=" + creditLimit +
                ", balance=" + balance +
                ", paymentDate=" + paymentDate +
                ", minMonthlyPayment=" + minMonthlyPayment +
                ", autoPay=" + autoPay +
                ", defaultPayment='" + defaultPayment + '\'' +
                ", updated=" + updated +
                ", apr=" + apr +
                ", annualFee=" + annualFee +
                ", createdAt=" + createdAt +
                ", notes='" + notes + '\'' +
                '}';
    }
}
