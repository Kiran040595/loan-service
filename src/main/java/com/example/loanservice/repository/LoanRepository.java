package com.example.loanservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.example.loanservice.model.Loan;

public interface LoanRepository extends JpaRepository<Loan, Long>, JpaSpecificationExecutor<Loan> {

}
