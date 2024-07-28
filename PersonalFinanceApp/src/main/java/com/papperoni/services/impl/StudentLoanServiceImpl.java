package com.papperoni.services.impl;

import com.papperoni.models.StudentLoan;
import com.papperoni.repositories.StudentLoanRepo;
import com.papperoni.services.StudentLoanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentLoanServiceImpl implements StudentLoanService {

    private final StudentLoanRepo studentLoanRepository;

    @Autowired
    public StudentLoanServiceImpl(StudentLoanRepo studentLoanRepository) {
        this.studentLoanRepository = studentLoanRepository;
    }

    @Override
    public List<StudentLoan> getAllStudentLoans() {
        return studentLoanRepository.findAll();
    }

    @Override
    public Optional<StudentLoan> getStudentLoanById(Long id) {
        return studentLoanRepository.findById(id);
    }

    @Override
    public StudentLoan saveStudentLoan(StudentLoan studentLoan) {
        return studentLoanRepository.save(studentLoan);
    }

    @Override
    public void deleteStudentLoan(Long id) {
        studentLoanRepository.deleteById(id);
    }

    @Override
    public StudentLoan updateStudentLoan(Long id, StudentLoan studentLoanDetails) {
        StudentLoan studentLoan = studentLoanRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("StudentLoan not found"));

        studentLoan.setAccountIdentifier(studentLoanDetails.getAccountIdentifier());
        studentLoan.setAccountName(studentLoanDetails.getAccountName());
        studentLoan.setBalance(studentLoanDetails.getBalance());
        studentLoan.setPaymentDate(studentLoanDetails.getPaymentDate());
        studentLoan.setMinMonthlyPayment(studentLoanDetails.getMinMonthlyPayment());
        studentLoan.setAutoPay(studentLoanDetails.getAutoPay());
        studentLoan.setFromAccount(studentLoanDetails.getFromAccount());
        studentLoan.setUpdated(studentLoanDetails.getUpdated());
        studentLoan.setApr(studentLoanDetails.getApr());
        studentLoan.setCreatedAt(studentLoanDetails.getCreatedAt());
        studentLoan.setNotes(studentLoanDetails.getNotes());

        return studentLoanRepository.save(studentLoan);
    }
}
