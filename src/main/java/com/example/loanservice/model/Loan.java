package com.example.loanservice.model;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

/**
 * Represents a Loan entity in the loan service.
 */
@Entity
public class Loan {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private Long fileNumber; // Unique Identifier

    @Column(precision = 10, scale = 2)
    private BigDecimal loanAmount;

    @Column(precision = 10, scale = 2)
    private BigDecimal interestRate;

    @Column(precision = 10, scale = 2)
    private BigDecimal emi;

    private Integer tenure;

    @Temporal(TemporalType.DATE)
    private Date loanCreationDate;

    private Integer paidEmiCount = 0;
    private Integer remainingEmiCount;

    @Column(precision = 10, scale = 2)
    private BigDecimal overdueAmount;

    @Column(precision = 10, scale = 2)
    private BigDecimal totalPendingEmiAmount;

    private Long pendingDays;

    private LocalDate lastUpdated;

    @Column(nullable = false, columnDefinition = "BOOLEAN DEFAULT true")
    private Boolean status = true;

    // Foreign key references
    @Column(name = "customer_id")
    private Long customerId;

    @Column(name = "vehicle_id")
    private Long vehicleId;

    @Column(name = "guarantor_id")
    private Long guarantorId;

    // Default constructor
    public Loan() {}

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getFileNumber() {
        return fileNumber;
    }

    public void setFileNumber(Long fileNumber) {
        this.fileNumber = fileNumber;
    }

    public BigDecimal getLoanAmount() {
        return loanAmount;
    }

    public void setLoanAmount(BigDecimal loanAmount) {
        this.loanAmount = loanAmount;
    }

    public BigDecimal getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(BigDecimal interestRate) {
        this.interestRate = interestRate;
    }

    public BigDecimal getEmi() {
        return emi;
    }

    public void setEmi(BigDecimal emi) {
        this.emi = emi;
    }

    public Integer getTenure() {
        return tenure;
    }

    public void setTenure(Integer tenure) {
        this.tenure = tenure;
    }

    public Date getLoanCreationDate() {
        return loanCreationDate;
    }

    public void setLoanCreationDate(Date loanCreationDate) {
        this.loanCreationDate = loanCreationDate;
    }

    public Integer getPaidEmiCount() {
        return paidEmiCount;
    }

    public void setPaidEmiCount(Integer paidEmiCount) {
        this.paidEmiCount = paidEmiCount;
    }

    public Integer getRemainingEmiCount() {
        return remainingEmiCount;
    }

    public void setRemainingEmiCount(Integer remainingEmiCount) {
        this.remainingEmiCount = remainingEmiCount;
    }

    public BigDecimal getOverdueAmount() {
        return overdueAmount;
    }

    public void setOverdueAmount(BigDecimal overdueAmount) {
        this.overdueAmount = overdueAmount;
    }

    public BigDecimal getTotalPendingEmiAmount() {
        return totalPendingEmiAmount;
    }

    public void setTotalPendingEmiAmount(BigDecimal totalPendingEmiAmount) {
        this.totalPendingEmiAmount = totalPendingEmiAmount;
    }

    public Long getPendingDays() {
        return pendingDays;
    }

    public void setPendingDays(Long pendingDays) {
        this.pendingDays = pendingDays;
    }

    public LocalDate getLastUpdated() {
        return lastUpdated;
    }

    public void setLastUpdated(LocalDate lastUpdated) {
        this.lastUpdated = lastUpdated;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public Long getVehicleId() {
        return vehicleId;
    }

    public void setVehicleId(Long vehicleId) {
        this.vehicleId = vehicleId;
    }

    public Long getGuarantorId() {
        return guarantorId;
    }

    public void setGuarantorId(Long guarantorId) {
        this.guarantorId = guarantorId;
    }

    @PrePersist
    public void setLastUpdatedBeforeSave() {
        if (this.lastUpdated == null) {
            this.lastUpdated = LocalDate.now();
        }
    }
}
