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
    private Long mortgageId;

    @ManyToOne
    @JoinColumn(name = "ownerId", nullable = false)
    @NotNull(message = "Owner is required")
    private OwnerOfAccount owner;

    @NotBlank(message = "Account identifier is required")
    private String accountIdentifier;

    @NotBlank(message = "Account name is required")
    private String accountName;

    @NotNull(message = "Balance is required")
    @DecimalMin(value = "0.0", inclusive = false, message = "Balance must be greater than 0")
    private BigDecimal balance;

    @NotNull(message = "Payment date is required")
    @Min(value = 1, message = "Payment date must be between 1 and 31")
    @Max(value = 31, message = "Payment date must be between 1 and 31")
    private Integer paymentDate;

    @NotNull(message = "Minimum monthly payment is required")
    @DecimalMin(value = "0.0", inclusive = false, message = "Minimum monthly payment must be greater than 0")
    private BigDecimal minMonthlyPayment;

    @NotNull(message = "AutoPay setting is required")
    private Boolean autoPay;

    private String fromAccount;

    @NotNull(message = "Updated date is required")
    private LocalDate updated;

    @NotNull(message = "APR is required")
    @DecimalMin(value = "0.0", inclusive = false, message = "APR must be greater than 0")
    private BigDecimal apr;

    @NotNull(message = "Creation date is required")
    private LocalDateTime createdAt;

    @Size(max = 255, message = "Notes cannot exceed 255 characters")
    private String notes;

    public Mortgage() {
    }

    public Mortgage(Long mortgageId, OwnerOfAccount owner, String accountIdentifier, String accountName, BigDecimal balance, Integer paymentDate, BigDecimal minMonthlyPayment, Boolean autoPay, String fromAccount, LocalDate updated, BigDecimal apr, LocalDateTime createdAt, String notes) {
        this.mortgageId = mortgageId;
        this.owner = owner;
        this.accountIdentifier = accountIdentifier;
        this.accountName = accountName;
        this.balance = balance;
        this.paymentDate = paymentDate;
        this.minMonthlyPayment = minMonthlyPayment;
        this.autoPay = autoPay;
        this.fromAccount = fromAccount;
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
        return Objects.equals(mortgageId, mortgage.mortgageId) && Objects.equals(owner, mortgage.owner) && Objects.equals(accountIdentifier, mortgage.accountIdentifier) && Objects.equals(accountName, mortgage.accountName) && Objects.equals(balance, mortgage.balance) && Objects.equals(paymentDate, mortgage.paymentDate) && Objects.equals(minMonthlyPayment, mortgage.minMonthlyPayment) && Objects.equals(autoPay, mortgage.autoPay) && Objects.equals(fromAccount, mortgage.fromAccount) && Objects.equals(updated, mortgage.updated) && Objects.equals(apr, mortgage.apr) && Objects.equals(createdAt, mortgage.createdAt) && Objects.equals(notes, mortgage.notes);
    }

    @Override
    public int hashCode() {
        return Objects.hash(mortgageId, owner, accountIdentifier, accountName, balance, paymentDate, minMonthlyPayment, autoPay, fromAccount, updated, apr, createdAt, notes);
    }

    @Override
    public String toString() {
        return "Mortgage{" +
                "mortgageId=" + mortgageId +
                ", owner=" + owner +
                ", accountIdentifier='" + accountIdentifier + '\'' +
                ", accountName='" + accountName + '\'' +
                ", balance=" + balance +
                ", paymentDate=" + paymentDate +
                ", minMonthlyPayment=" + minMonthlyPayment +
                ", autoPay=" + autoPay +
                ", fromAccount='" + fromAccount + '\'' +
                ", updated=" + updated +
                ", apr=" + apr +
                ", createdAt=" + createdAt +
                ", notes='" + notes + '\'' +
                '}';
    }
}
