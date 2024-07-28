package com.papperoni.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Table(name = "CarLoans")
public class CarLoan {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long carLoanId;

    @ManyToOne
    @JoinColumn(name = "ownerId", nullable = false)
    @NotNull(message = "Owner is mandatory")
    private OwnerOfAccount owner;

    @Size(max = 50, message = "Account identifier should not exceed 50 characters")
    private String accountIdentifier;

    @Size(max = 100, message = "Account name should not exceed 100 characters")
    private String accountName;

    @DecimalMin(value = "0.0", inclusive = false, message = "Balance must be positive")
    private BigDecimal balance;

    @Min(value = 1, message = "Payment date must be between 1 and 31")
    @Max(value = 31, message = "Payment date must be between 1 and 31")
    private Integer paymentDate;

    @DecimalMin(value = "0.0", inclusive = false, message = "Minimum monthly payment must be positive")
    private BigDecimal minMonthlyPayment;

    private Boolean autoPay;

    @Size(max = 50, message = "From account should not exceed 50 characters")
    private String fromAccount;

    @PastOrPresent(message = "Updated date cannot be in the future")
    private LocalDate updated;

    @DecimalMin(value = "0.0", inclusive = false, message = "APR must be positive")
    @DecimalMax(value = "100.0", message = "APR must be less than or equal to 100")
    private BigDecimal apr;

    @PastOrPresent(message = "Creation date cannot be in the future")
    private LocalDateTime createdAt;

    @Size(max = 255, message = "Notes should not exceed 255 characters")
    private String notes;

    // Constructors, getters, setters, equals, hashCode, and toString methods

    public CarLoan() {
    }

    public CarLoan(Long carLoanId, OwnerOfAccount owner, String accountIdentifier, String accountName, BigDecimal balance, Integer paymentDate, BigDecimal minMonthlyPayment, Boolean autoPay, String fromAccount, LocalDate updated, BigDecimal apr, LocalDateTime createdAt, String notes) {
        this.carLoanId = carLoanId;
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

    public Long getCarLoanId() {
        return carLoanId;
    }

    public void setCarLoanId(Long carLoanId) {
        this.carLoanId = carLoanId;
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
        CarLoan carLoan = (CarLoan) o;
        return Objects.equals(carLoanId, carLoan.carLoanId) && Objects.equals(owner, carLoan.owner) && Objects.equals(accountIdentifier, carLoan.accountIdentifier) && Objects.equals(accountName, carLoan.accountName) && Objects.equals(balance, carLoan.balance) && Objects.equals(paymentDate, carLoan.paymentDate) && Objects.equals(minMonthlyPayment, carLoan.minMonthlyPayment) && Objects.equals(autoPay, carLoan.autoPay) && Objects.equals(fromAccount, carLoan.fromAccount) && Objects.equals(updated, carLoan.updated) && Objects.equals(apr, carLoan.apr) && Objects.equals(createdAt, carLoan.createdAt) && Objects.equals(notes, carLoan.notes);
    }

    @Override
    public int hashCode() {
        return Objects.hash(carLoanId, owner, accountIdentifier, accountName, balance, paymentDate, minMonthlyPayment, autoPay, fromAccount, updated, apr, createdAt, notes);
    }

    @Override
    public String toString() {
        return "CarLoan{" +
                "carLoanId=" + carLoanId +
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
