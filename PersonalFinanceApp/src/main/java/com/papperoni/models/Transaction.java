package com.papperoni.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import jakarta.validation.constraints.Size;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Table(name = "Transaction")
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long transactionId;

    @ManyToOne
    @JoinColumn(name = "ownerId", nullable = false)
    @NotNull
    private OwnerOfAccount owner;

    private Long depositId;
    private Long creditCardId;
    private Long otherCreditAccountId;
    private Long studentLoanId;
    private Long personalLoanId;
    private Long carLoanId;
    private Long mortgageId;

    @NotNull
    @PositiveOrZero
    private BigDecimal amount;

    @ManyToOne
    @JoinColumn(name = "transactionTypeId")
    private TransactionType transactionType;

    @ManyToOne
    @JoinColumn(name = "transactionDescriptionId")
    private TransactionDescription transactionDescription;

    @ManyToOne
    @JoinColumn(name = "expenseCategoryId")
    private ExpenseCategory expenseCategory;

    private Long associatedAccountId;

    @Size(max = 50)
    private String associatedAccountType;

    @NotNull
    private LocalDateTime transactionDate;

    @Size(max = 500)
    private String notes;

    public Transaction() {
    }

    public Transaction(Long transactionId, OwnerOfAccount owner, Long depositId, Long creditCardId, Long otherCreditAccountId, Long studentLoanId, Long personalLoanId, Long carLoanId, Long mortgageId, BigDecimal amount, TransactionType transactionType, TransactionDescription transactionDescription, ExpenseCategory expenseCategory, Long associatedAccountId, String associatedAccountType, LocalDateTime transactionDate, String notes) {
        this.transactionId = transactionId;
        this.owner = owner;
        this.depositId = depositId;
        this.creditCardId = creditCardId;
        this.otherCreditAccountId = otherCreditAccountId;
        this.studentLoanId = studentLoanId;
        this.personalLoanId = personalLoanId;
        this.carLoanId = carLoanId;
        this.mortgageId = mortgageId;
        this.amount = amount;
        this.transactionType = transactionType;
        this.transactionDescription = transactionDescription;
        this.expenseCategory = expenseCategory;
        this.associatedAccountId = associatedAccountId;
        this.associatedAccountType = associatedAccountType;
        this.transactionDate = transactionDate;
        this.notes = notes;
    }

    public Long getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(Long transactionId) {
        this.transactionId = transactionId;
    }

    public OwnerOfAccount getOwner() {
        return owner;
    }

    public void setOwner(OwnerOfAccount owner) {
        this.owner = owner;
    }

    public Long getDepositId() {
        return depositId;
    }

    public void setDepositId(Long depositId) {
        this.depositId = depositId;
    }

    public Long getCreditCardId() {
        return creditCardId;
    }

    public void setCreditCardId(Long creditCardId) {
        this.creditCardId = creditCardId;
    }

    public Long getOtherCreditAccountId() {
        return otherCreditAccountId;
    }

    public void setOtherCreditAccountId(Long otherCreditAccountId) {
        this.otherCreditAccountId = otherCreditAccountId;
    }

    public Long getStudentLoanId() {
        return studentLoanId;
    }

    public void setStudentLoanId(Long studentLoanId) {
        this.studentLoanId = studentLoanId;
    }

    public Long getPersonalLoanId() {
        return personalLoanId;
    }

    public void setPersonalLoanId(Long personalLoanId) {
        this.personalLoanId = personalLoanId;
    }

    public Long getCarLoanId() {
        return carLoanId;
    }

    public void setCarLoanId(Long carLoanId) {
        this.carLoanId = carLoanId;
    }

    public Long getMortgageId() {
        return mortgageId;
    }

    public void setMortgageId(Long mortgageId) {
        this.mortgageId = mortgageId;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public TransactionType getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(TransactionType transactionType) {
        this.transactionType = transactionType;
    }

    public TransactionDescription getTransactionDescription() {
        return transactionDescription;
    }

    public void setTransactionDescription(TransactionDescription transactionDescription) {
        this.transactionDescription = transactionDescription;
    }

    public ExpenseCategory getExpenseCategory() {
        return expenseCategory;
    }

    public void setExpenseCategory(ExpenseCategory expenseCategory) {
        this.expenseCategory = expenseCategory;
    }

    public Long getAssociatedAccountId() {
        return associatedAccountId;
    }

    public void setAssociatedAccountId(Long associatedAccountId) {
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
        Transaction that = (Transaction) o;
        return Objects.equals(transactionId, that.transactionId) && Objects.equals(owner, that.owner) && Objects.equals(depositId, that.depositId) && Objects.equals(creditCardId, that.creditCardId) && Objects.equals(otherCreditAccountId, that.otherCreditAccountId) && Objects.equals(studentLoanId, that.studentLoanId) && Objects.equals(personalLoanId, that.personalLoanId) && Objects.equals(carLoanId, that.carLoanId) && Objects.equals(mortgageId, that.mortgageId) && Objects.equals(amount, that.amount) && Objects.equals(transactionType, that.transactionType) && Objects.equals(transactionDescription, that.transactionDescription) && Objects.equals(expenseCategory, that.expenseCategory) && Objects.equals(associatedAccountId, that.associatedAccountId) && Objects.equals(associatedAccountType, that.associatedAccountType) && Objects.equals(transactionDate, that.transactionDate) && Objects.equals(notes, that.notes);
    }

    @Override
    public int hashCode() {
        return Objects.hash(transactionId, owner, depositId, creditCardId, otherCreditAccountId, studentLoanId, personalLoanId, carLoanId, mortgageId, amount, transactionType, transactionDescription, expenseCategory, associatedAccountId, associatedAccountType, transactionDate, notes);
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "transactionId=" + transactionId +
                ", owner=" + owner +
                ", depositId=" + depositId +
                ", creditCardId=" + creditCardId +
                ", otherCreditAccountId=" + otherCreditAccountId +
                ", studentLoanId=" + studentLoanId +
                ", personalLoanId=" + personalLoanId +
                ", carLoanId=" + carLoanId +
                ", mortgageId=" + mortgageId +
                ", amount=" + amount +
                ", transactionType=" + transactionType +
                ", transactionDescription=" + transactionDescription +
                ", expenseCategory=" + expenseCategory +
                ", associatedAccountId=" + associatedAccountId +
                ", associatedAccountType='" + associatedAccountType + '\'' +
                ", transactionDate=" + transactionDate +
                ", notes='" + notes + '\'' +
                '}';
    }
}
