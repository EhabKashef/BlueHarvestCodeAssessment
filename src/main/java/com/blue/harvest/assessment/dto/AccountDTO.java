package com.blue.harvest.assessment.dto;

import java.io.Serializable;

import javax.validation.constraints.NotNull;

public class AccountDTO implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@NotNull
	private double initialCredit;
	@NotNull
	private long customerID;
	public double getInitialCredit() {
		return initialCredit;
	}
	public void setInitialCredit(double initialCredit) {
		this.initialCredit = initialCredit;
	}
	public long getCustomerID() {
		return customerID;
	}
	public void setCustomerID(long customerID) {
		this.customerID = customerID;
	}
	@Override
	public String toString() {
		return "AccountDTO [initialCredit=" + initialCredit + ", customerID=" + customerID + "]";
	}
	
	
	
}
