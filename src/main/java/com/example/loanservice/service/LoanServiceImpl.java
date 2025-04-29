package com.example.loanservice.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.loanservice.LoanMapper;
import com.example.loanservice.dto.LoanRequestDTO;
import com.example.loanservice.model.Loan;
import com.example.loanservice.repository.LoanRepository;

@Service
public class LoanServiceImpl implements LoanService {

	@Autowired
	private LoanMapper loanMapper;
	
	@Autowired
	private LoanRepository loanRepository;

	@Override
	public void createLoan(LoanRequestDTO loanRequestDTO) {
		Loan loan = loanMapper.toLoanEntity(loanRequestDTO);

		Loan savedLoan = loanRepository.save(loan);

	}
	
	public List<Loan> getAllLoans(){
		return loanRepository.findAll();
		
	}

}
