package com.example.loanservice;


import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.example.loanservice.dto.LoanDTO;
import com.example.loanservice.dto.LoanRequestDTO;
import com.example.loanservice.model.Loan;

@Mapper(componentModel = "spring")
public interface LoanMapper {

	Loan toEntity(LoanDTO loanDTO);
	
	@Mapping(source = "loanAmount", target = "loanAmount")
    @Mapping(source = "interestRate", target = "interestRate")
    @Mapping(source = "tenure", target = "tenure")
	@Mapping(source="loanCreationDate", target="loanCreationDate")
    Loan toLoanEntity(LoanRequestDTO loanRequest);
}
