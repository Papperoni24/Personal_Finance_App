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
    private Long creditCardId;

    @ManyToOne
    @JoinColumn(name = "ownerId", nullable = false)
    @NotNull(message = "Owner cannot be null")
    private OwnerOfAccount owner;

    @NotBlank(message = "Account Identifier cannot be blank")
    private String accountIdentifier;

    @NotBlank(message = "Account Name cannot be blank")
    private String accountName;

    @DecimalMin(value = "0.0", inclusive = true, message = "Credit Limit must be non-negative")
    @Digits(integer = 10, fraction = 2, message = "Credit Limit must be a valid monetary amount")
    private BigDecimal creditLimit;

    @DecimalMin(value = "0.0", inclusive = true, message = "Balance must be non-negative")
    @Digits(integer = 10, fraction = 2, message = "Balance must be a valid monetary amount")
    private BigDecimal balance;

    @Min(value = 1, message = "Payment Date must be between 1 and 31")
    @Max(value = 31, message = "Payment Date must be between 1 and 31")
    private Integer paymentDate;

    @DecimalMin(value = "0.0", inclusive = true, message = "Minimum Monthly Payment must be non-negative")
    @Digits(integer = 10, fraction = 2, message = "Minimum Monthly Payment must be a valid monetary amount")
    private BigDecimal minMonthlyPayment;

    private Boolean autoPay;

    private String fromAccount;

    @PastOrPresent(message = "Updated date cannot be in the future")
    private LocalDate updated;

    @DecimalMin(value = "0.0", inclusive = true, message = "APR must be non-negative")
    @Digits(integer = 5, fraction = 2, message = "APR must be a valid percentage")
    private BigDecimal apr;

    @DecimalMin(value = "0.0", inclusive = true, message = "Annual Fee must be non-negative")
    @Digits(integer = 10, fraction = 2, message = "Annual Fee must be a valid monetary amount")
    private BigDecimal annualFee;

    @PastOrPresent(message = "Creation date cannot be in the future")
    private LocalDateTime createdAt;

    private String notes;

    public CreditCard() {
    }

    public CreditCard(Long creditCardId, String notes, BigDecimal annualFee, LocalDateTime createdAt, BigDecimal apr, LocalDate updated, Boolean autoPay, String fromAccount, BigDecimal minMonthlyPayment, Integer paymentDate, BigDecimal balance, BigDecimal creditLimit, String accountName, String accountIdentifier, OwnerOfAccount owner) {
        this.creditCardId = creditCardId;
        this.notes = notes;
        this.annualFee = annualFee;
        this.createdAt = createdAt;
        this.apr = apr;
        this.updated = updated;
        this.autoPay = autoPay;
        this.fromAccount = fromAccount;
        this.minMonthlyPayment = minMonthlyPayment;
        this.paymentDate = paymentDate;
        this.balance = balance;
        this.creditLimit = creditLimit;
        this.accountName = accountName;
        this.accountIdentifier = accountIdentifier;
        this.owner = owner;
    }

    // Getters and Setters


    public Long getCreditCardId() {
        return creditCardId;
    }

    public void setCreditCardId(Long creditCardId) {
        this.creditCardId = creditCardId;
    }

    public @NotNull(message = "Owner cannot be null") OwnerOfAccount getOwner() {
        return owner;
    }

    public void setOwner(@NotNull(message = "Owner cannot be null") OwnerOfAccount owner) {
        this.owner = owner;
    }

    public @NotBlank(message = "Account Identifier cannot be blank") String getAccountIdentifier() {
        return accountIdentifier;
    }

    public void setAccountIdentifier(@NotBlank(message = "Account Identifier cannot be blank") String accountIdentifier) {
        this.accountIdentifier = accountIdentifier;
    }

    public @NotBlank(message = "Account Name cannot be blank") String getAccountName() {
        return accountName;
    }

    public void setAccountName(@NotBlank(message = "Account Name cannot be blank") String accountName) {
        this.accountName = accountName;
    }

    public @DecimalMin(value = "0.0", inclusive = true, message = "Credit Limit must be non-negative") @Digits(integer = 10, fraction = 2, message = "Credit Limit must be a valid monetary amount") BigDecimal getCreditLimit() {
        return creditLimit;
    }

    public void setCreditLimit(@DecimalMin(value = "0.0", inclusive = true, message = "Credit Limit must be non-negative") @Digits(integer = 10, fraction = 2, message = "Credit Limit must be a valid monetary amount") BigDecimal creditLimit) {
        this.creditLimit = creditLimit;
    }

    public @DecimalMin(value = "0.0", inclusive = true, message = "Balance must be non-negative") @Digits(integer = 10, fraction = 2, message = "Balance must be a valid monetary amount") BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(@DecimalMin(value = "0.0", inclusive = true, message = "Balance must be non-negative") @Digits(integer = 10, fraction = 2, message = "Balance must be a valid monetary amount") BigDecimal balance) {
        this.balance = balance;
    }

    public @Min(value = 1, message = "Payment Date must be between 1 and 31") @Max(value = 31, message = "Payment Date must be between 1 and 31") Integer getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(@Min(value = 1, message = "Payment Date must be between 1 and 31") @Max(value = 31, message = "Payment Date must be between 1 and 31") Integer paymentDate) {
        this.paymentDate = paymentDate;
    }

    public @DecimalMin(value = "0.0", inclusive = true, message = "Minimum Monthly Payment must be non-negative") @Digits(integer = 10, fraction = 2, message = "Minimum Monthly Payment must be a valid monetary amount") BigDecimal getMinMonthlyPayment() {
        return minMonthlyPayment;
    }

    public void setMinMonthlyPayment(@DecimalMin(value = "0.0", inclusive = true, message = "Minimum Monthly Payment must be non-negative") @Digits(integer = 10, fraction = 2, message = "Minimum Monthly Payment must be a valid monetary amount") BigDecimal minMonthlyPayment) {
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

    public @PastOrPresent(message = "Updated date cannot be in the future") LocalDate getUpdated() {
        return updated;
    }

    public void setUpdated(@PastOrPresent(message = "Updated date cannot be in the future") LocalDate updated) {
        this.updated = updated;
    }

    public @DecimalMin(value = "0.0", inclusive = true, message = "APR must be non-negative") @Digits(integer = 5, fraction = 2, message = "APR must be a valid percentage") BigDecimal getApr() {
        return apr;
    }

    public void setApr(@DecimalMin(value = "0.0", inclusive = true, message = "APR must be non-negative") @Digits(integer = 5, fraction = 2, message = "APR must be a valid percentage") BigDecimal apr) {
        this.apr = apr;
    }

    public @DecimalMin(value = "0.0", inclusive = true, message = "Annual Fee must be non-negative") @Digits(integer = 10, fraction = 2, message = "Annual Fee must be a valid monetary amount") BigDecimal getAnnualFee() {
        return annualFee;
    }

    public void setAnnualFee(@DecimalMin(value = "0.0", inclusive = true, message = "Annual Fee must be non-negative") @Digits(integer = 10, fraction = 2, message = "Annual Fee must be a valid monetary amount") BigDecimal annualFee) {
        this.annualFee = annualFee;
    }

    public @PastOrPresent(message = "Creation date cannot be in the future") LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(@PastOrPresent(message = "Creation date cannot be in the future") LocalDateTime createdAt) {
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
        return Objects.equals(creditCardId, that.creditCardId) && Objects.equals(owner, that.owner) && Objects.equals(accountIdentifier, that.accountIdentifier) && Objects.equals(accountName, that.accountName) && Objects.equals(creditLimit, that.creditLimit) && Objects.equals(balance, that.balance) && Objects.equals(paymentDate, that.paymentDate) && Objects.equals(minMonthlyPayment, that.minMonthlyPayment) && Objects.equals(autoPay, that.autoPay) && Objects.equals(fromAccount, that.fromAccount) && Objects.equals(updated, that.updated) && Objects.equals(apr, that.apr) && Objects.equals(annualFee, that.annualFee) && Objects.equals(createdAt, that.createdAt) && Objects.equals(notes, that.notes);
    }

    @Override
    public int hashCode() {
        return Objects.hash(creditCardId, owner, accountIdentifier, accountName, creditLimit, balance, paymentDate, minMonthlyPayment, autoPay, fromAccount, updated, apr, annualFee, createdAt, notes);
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
                ", fromAccount='" + fromAccount + '\'' +
                ", updated=" + updated +
                ", apr=" + apr +
                ", annualFee=" + annualFee +
                ", createdAt=" + createdAt +
                ", notes='" + notes + '\'' +
                '}';
    }
}
