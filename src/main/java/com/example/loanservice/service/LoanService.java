package com.example.loanservice.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.loanservice.dto.LoanRequestDTO;
import com.example.loanservice.model.Loan;

@Service
public interface LoanService {

	
	public void createLoan(LoanRequestDTO loanRequest);

	public List<Loan> getAllLoans();

}
