package com.example.loanservice.controler;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.loanservice.dto.LoanRequestDTO;
import com.example.loanservice.dto.LoanResponseDTO;
import com.example.loanservice.model.Loan;
import com.example.loanservice.service.LoanService;

@RestController
@RequestMapping("/api/loans")
@CrossOrigin(origins = "http://localhost:3000") // Allow requests from localhost:3000
public class LoanController {
	
	 @Autowired
	    private LoanService loanService;
	 
	 @PostMapping
	    public ResponseEntity<String> createLoan(@RequestBody LoanRequestDTO loanDTO){
	    	loanService.createLoan(loanDTO);
	    	return ResponseEntity.status(HttpStatus.CREATED).body("Loan created successfully");
	    	
	    }
	 
	 @GetMapping("/loans")
	    public List<Loan> getAllLoans(){
	    	return loanService.getAllLoans();
	    	
	    }
	 
	 

}
