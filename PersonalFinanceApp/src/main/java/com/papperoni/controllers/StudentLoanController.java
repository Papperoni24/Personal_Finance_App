package com.papperoni.controllers;

import com.papperoni.models.StudentLoan;
import com.papperoni.services.StudentLoanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/student-loans")
public class StudentLoanController {

    private final StudentLoanService studentLoanService;

    @Autowired
    public StudentLoanController(StudentLoanService studentLoanService) {
        this.studentLoanService = studentLoanService;
    }

    @GetMapping
    public List<StudentLoan> getAllStudentLoans() {
        return studentLoanService.getAllStudentLoans();
    }

    @GetMapping("/{id}")
    public ResponseEntity<StudentLoan> getStudentLoanById(@PathVariable Long id) {
        StudentLoan studentLoan = studentLoanService.getStudentLoanById(id)
                .orElseThrow(() -> new RuntimeException("StudentLoan not found"));
        return ResponseEntity.ok(studentLoan);
    }

    @PostMapping
    public StudentLoan createStudentLoan(@RequestBody StudentLoan studentLoan) {
        return studentLoanService.saveStudentLoan(studentLoan);
    }

    @PutMapping("/{id}")
    public ResponseEntity<StudentLoan> updateStudentLoan(@PathVariable Long id, @RequestBody StudentLoan studentLoanDetails) {
        StudentLoan updatedStudentLoan = studentLoanService.updateStudentLoan(id, studentLoanDetails);
        return ResponseEntity.ok(updatedStudentLoan);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteStudentLoan(@PathVariable Long id) {
        studentLoanService.deleteStudentLoan(id);
        return ResponseEntity.noContent().build();
    }
}
