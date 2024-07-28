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
    private Long otherCreditAccountId;

    @ManyToOne
    @JoinColumn(name = "ownerId", nullable = false)
    @NotNull(message = "Owner cannot be null")
    private OwnerOfAccount owner;

    @NotBlank(message = "Account identifier cannot be blank")
    private String accountIdentifier;

    @NotBlank(message = "Account name cannot be blank")
    private String accountName;

    @DecimalMin(value = "0.0", inclusive = true, message = "Credit limit must be positive")
    private BigDecimal creditLimit;

    @DecimalMin(value = "0.0", inclusive = true, message = "Balance must be positive")
    private BigDecimal balance;

    @Min(value = 1, message = "Payment date must be between 1 and 31")
    @Max(value = 31, message = "Payment date must be between 1 and 31")
    private Integer paymentDate;

    @DecimalMin(value = "0.0", inclusive = true, message = "Minimum monthly payment must be positive")
    private BigDecimal minMonthlyPayment;

    private Boolean autoPay;

    private String fromAccount;

    @PastOrPresent(message = "Updated date cannot be in the future")
    private LocalDate updated;

    @DecimalMin(value = "0.0", inclusive = true, message = "APR must be positive")
    private BigDecimal apr;

    @DecimalMin(value = "0.0", inclusive = true, message = "Annual fee must be positive")
    private BigDecimal annualFee;

    @PastOrPresent(message = "Created date cannot be in the future")
    private LocalDateTime createdAt;

    private String notes;

    public OtherCreditAccount() {
    }

    public OtherCreditAccount(Long otherCreditAccountId, OwnerOfAccount owner, String accountIdentifier, String accountName, BigDecimal creditLimit, BigDecimal balance, Integer paymentDate, BigDecimal minMonthlyPayment, String fromAccount, Boolean autoPay, LocalDate updated, BigDecimal apr, BigDecimal annualFee, LocalDateTime createdAt, String notes) {
        this.otherCreditAccountId = otherCreditAccountId;
        this.owner = owner;
        this.accountIdentifier = accountIdentifier;
        this.accountName = accountName;
        this.creditLimit = creditLimit;
        this.balance = balance;
        this.paymentDate = paymentDate;
        this.minMonthlyPayment = minMonthlyPayment;
        this.fromAccount = fromAccount;
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

    public String getFromAccount() {
        return fromAccount;
    }

    public void setFromAccount(String fromAccount) {
        this.fromAccount = fromAccount;
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
        return Objects.equals(otherCreditAccountId, that.otherCreditAccountId) && Objects.equals(owner, that.owner) && Objects.equals(accountIdentifier, that.accountIdentifier) && Objects.equals(accountName, that.accountName) && Objects.equals(creditLimit, that.creditLimit) && Objects.equals(balance, that.balance) && Objects.equals(paymentDate, that.paymentDate) && Objects.equals(minMonthlyPayment, that.minMonthlyPayment) && Objects.equals(autoPay, that.autoPay) && Objects.equals(fromAccount, that.fromAccount) && Objects.equals(updated, that.updated) && Objects.equals(apr, that.apr) && Objects.equals(annualFee, that.annualFee) && Objects.equals(createdAt, that.createdAt) && Objects.equals(notes, that.notes);
    }

    @Override
    public int hashCode() {
        return Objects.hash(otherCreditAccountId, owner, accountIdentifier, accountName, creditLimit, balance, paymentDate, minMonthlyPayment, autoPay, fromAccount, updated, apr, annualFee, createdAt, notes);
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
                ", fromAccount='" + fromAccount + '\'' +
                ", updated=" + updated +
                ", apr=" + apr +
                ", annualFee=" + annualFee +
                ", createdAt=" + createdAt +
                ", notes='" + notes + '\'' +
                '}';
    }
}