package com.papperoni.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Table(name = "PersonalLoans")
public class PersonalLoan {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "PersonalLoanID")
    private Long personalLoanId;

    @ManyToOne
    @JoinColumn(name = "OwnerID", nullable = false)
    @NotNull(message = "Owner cannot be null")
    private int ownerID;

    @NotBlank(message = "Account identifier cannot be blank")
    @Column(name = "AccountIdentifier", nullable = false, length = 100)
    private String accountIdentifier;

    @Column(name = "AccountName", length = 100)
    private String accountName;

    @NotNull(message = "Balance cannot be null")
    @DecimalMin(value = "0.0", inclusive = true, message = "Balance must be positive")
    @Digits(integer = 15, fraction = 2, message = "Balance must be a valid monetary amount")
    @Column(name = "Balance", precision = 15, scale = 2, columnDefinition = "DECIMAL(15, 2) DEFAULT 0.00")
    private BigDecimal balance;

    @NotNull(message = "Payment date cannot be null")
    @Min(value = 1, message = "Payment date must be between 1 and 31")
    @Max(value = 31, message = "Payment date must be between 1 and 31")
    @Column(name = "PaymentDate")
    private Integer paymentDate;

    @NotNull(message = "Minimum monthly payment cannot be null")
    @DecimalMin(value = "0.0", inclusive = true, message = "Minimum monthly payment must be positive")
    @Digits(integer = 15, fraction = 2, message = "Minimum monthly payment must be a valid monetary amount")
    @Column(name = "MinMonthlyPayment", precision = 15, scale = 2)
    private BigDecimal minMonthlyPayment;

    @Column(name = "AutoPay", nullable = false)
    private Boolean autoPay = false;

    @Column(name = "DefaultPaymentID", length = 100)
    private int defaultPaymentID;

    @NotNull(message = "Updated date is required")
    @Column(name = "Updated", nullable = false)
    private LocalDate updated;

    @NotNull(message = "APR cannot be null")
    @DecimalMin(value = "0.0", inclusive = true, message = "APR must be positive")
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

    public PersonalLoan() {
    }

    public PersonalLoan(Long personalLoanId, int ownerID, String accountIdentifier, String accountName, BigDecimal balance, Integer paymentDate, BigDecimal minMonthlyPayment, Boolean autoPay, int defaultPaymentID, LocalDate updated, BigDecimal apr, LocalDateTime createdAt, String notes) {
        this.personalLoanId = personalLoanId;
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

    public Long getPersonalLoanId() {
        return personalLoanId;
    }

    public void setPersonalLoanId(Long personalLoanId) {
        this.personalLoanId = personalLoanId;
    }

    public int getOwnerID() {
        return ownerID;
    }

    public void setOwner(int ownerID) {
        this.ownerID = ownerID;
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

    public void setDefaultPaymentID(int defaultPaymentID) {
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
        PersonalLoan that = (PersonalLoan) o;
        return Objects.equals(personalLoanId, that.personalLoanId) && Objects.equals(ownerID, that.ownerID) && Objects.equals(accountIdentifier, that.accountIdentifier) && Objects.equals(accountName, that.accountName) && Objects.equals(balance, that.balance) && Objects.equals(paymentDate, that.paymentDate) && Objects.equals(minMonthlyPayment, that.minMonthlyPayment) && Objects.equals(autoPay, that.autoPay) && Objects.equals(defaultPaymentID, that.defaultPaymentID) && Objects.equals(updated, that.updated) && Objects.equals(apr, that.apr) && Objects.equals(createdAt, that.createdAt) && Objects.equals(notes, that.notes);
    }

    @Override
    public int hashCode() {
        return Objects.hash(personalLoanId, ownerID, accountIdentifier, accountName, balance, paymentDate, minMonthlyPayment, autoPay, defaultPaymentID, updated, apr, createdAt, notes);
    }

    @Override
    public String toString() {
        return "PersonalLoan{" +
                "personalLoanId=" + personalLoanId +
                ", ownerID=" + ownerID +
                ", accountIdentifier='" + accountIdentifier + '\'' +
                ", accountName='" + accountName + '\'' +
                ", balance=" + balance +
                ", paymentDate=" + paymentDate +
                ", minMonthlyPayment=" + minMonthlyPayment +
                ", autoPay=" + autoPay +
                ", defaultPaymentID=" + defaultPaymentID +
                ", updated=" + updated +
                ", apr=" + apr +
                ", createdAt=" + createdAt +
                ", notes='" + notes + '\'' +
                '}';
    }
}
