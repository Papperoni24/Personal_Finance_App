package com.papperoni.services;

import com.papperoni.models.StudentLoan;

import java.util.List;
import java.util.Optional;

public interface StudentLoanService {

    List<StudentLoan> getAllStudentLoans();

    Optional<StudentLoan> getStudentLoanById(Long id);

    StudentLoan saveStudentLoan(StudentLoan studentLoan);

    void deleteStudentLoan(Long id);

    StudentLoan updateStudentLoan(Long id, StudentLoan studentLoanDetails);
}

