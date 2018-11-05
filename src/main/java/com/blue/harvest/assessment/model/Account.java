package com.blue.harvest.assessment.model;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.hibernate.validator.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

import java.io.Serializable;
import java.util.List;

@Entity
@Table(name="ACCOUNT")
public class Account implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public Account() {
		super();
	}

	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	private Long id;

	@NotNull
	@Column(name="initialCredit", nullable=false)
	private double initialCredit;

	@JsonBackReference
	 @ManyToOne()
	 @JoinColumn(name = "customerID")  
	private User user ;

	
	
	@JsonManagedReference
	@OneToMany(fetch = FetchType.EAGER,cascade = CascadeType.ALL,mappedBy = "account")
	private List<Transaction> transactions;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

 

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public double getInitialCredit() {
		return initialCredit;
	}

	public void setInitialCredit(double initialCredit) {
		this.initialCredit = initialCredit;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		long temp;
		temp = Double.doubleToLongBits(initialCredit);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((user == null) ? 0 : user.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Account other = (Account) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (Double.doubleToLongBits(initialCredit) != Double.doubleToLongBits(other.initialCredit))
			return false;
		if (user == null) {
			if (other.user != null)
				return false;
		} else if (!user.equals(other.user))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Account [id=" + id + ", initialCredit=" + initialCredit + ", user=" + user + "]";
	}

 
 


}
