package com.cg.fooddelivery.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
@Table(name= "customer")
public class Customer {
	
	@Id
	@Column(name="customer_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int customerId;
	
	
	@NotNull(message= "firstName cannot be null")
	@Size(min=3, message= "min of 3 is required")
	@Pattern(regexp = "^[a-z A-Z]*$", message = "a-z and A-Zare allowed")
	@Column(name="first_name")
	private String firstName;
	
	@NotNull(message= "lastName cannot be null")
	@Size(min=3, message= "min of 3 is required")
	@Pattern(regexp = "^[a-z A-Z]*$", message = "a-z and A-Zare allowed")
	@Column(name="last_name")
	private String lastName;
	
	@NotNull(message= "custEmailId cannot be null")
	@Size(min=3, message= "min of 3 is required")
	@Email
	@Column(name="customer_emailid")
	private String custEmailId;
	
	@NotNull(message= "custAddress cannot be null")
	@Size(min=3, message= "min of 3 is required")
	@Pattern(regexp = "^[a-z A-Z]*$", message = "a-z and A-Zare allowed")
	@Column(name="customer_address")
	private String custAddress;
	
	@NotNull(message= "custmobileNumber cannot be null")
	@Size(min=10, message= "min of 10 is required")
	@Pattern(regexp = "^[0-9]*$", message = "0-9 are allowed")
	@Column(name="customer_mobilenumber")
	private String custmobileNumber;
	
	@NotNull(message= "customerPassword cannot be null")
	@Size(min=3, message= "min of 3 is required")
	@Pattern(regexp = "^(?=.*\\d)(?=.*[a-z])(?=.*[A-Z]).{3,8}$", message = "Password with one uppercase and one lowercase and a digitdigit and min of 4 characters is allowed")
	@Column(name="customer_password")
	private String customerPassword;
	
	@JsonIgnore
	@OneToMany(mappedBy = "orderCustomer")
	private List<Orders> customerOrder;
	
	/*
	 * @JsonIgnore
	 * 
	 * @OneToOne(fetch=FetchType.LAZY,cascade=CascadeType.ALL)
	 * 
	 * @JoinColumn(name= "restaurant_id") private Restaurant restaurant;
	 */

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getCustEmailId() {
		return custEmailId;
	}

	public void setCustEmailId(String custEmailId) {
		this.custEmailId = custEmailId;
	}

	public String getCustAddress() {
		return custAddress;
	}

	public void setCustAddress(String custAddress) {
		this.custAddress = custAddress;
	}

	public String getCustmobileNumber() {
		return custmobileNumber;
	}

	public void setCustmobileNumber(String custmobileNumber) {
		this.custmobileNumber = custmobileNumber;
	}

	public List<Orders> getCustomerOrder() {
		return customerOrder;
	}

	public void setCustomerOrder(List<Orders> customerOrder) {
		this.customerOrder = customerOrder;
	}

	public String getCustomerPassword() {
		return customerPassword;
	}

	public void setCustomerPassword(String customerPassword) {
		this.customerPassword = customerPassword;
	}

	@Override
	public String toString() {
		return "Customer [customerId=" + customerId + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", custEmailId=" + custEmailId + ", custAddress=" + custAddress + ", custmobileNumber="
				+ custmobileNumber + ", customerPassword=" + customerPassword + ", customerOrder=" + customerOrder
				+ "]";
	}

	public Customer(int customerId,
			@NotNull(message = "firstName cannot be null") @Size(min = 3, message = "min of 3 is required") @Pattern(regexp = "^[a-z A-Z]*$", message = "a-z and A-Zare allowed") String firstName,
			@NotNull(message = "lastName cannot be null") @Size(min = 3, message = "min of 3 is required") @Pattern(regexp = "^[a-z A-Z]*$", message = "a-z and A-Zare allowed") String lastName,
			@NotNull(message = "custEmailId cannot be null") @Size(min = 3, message = "min of 3 is required") @Email String custEmailId,
			@NotNull(message = "custAddress cannot be null") @Size(min = 3, message = "min of 3 is required") @Pattern(regexp = "^[a-z A-Z]*$", message = "a-z and A-Zare allowed") String custAddress,
			@NotNull(message = "custmobileNumber cannot be null") @Size(min = 10, message = "min of 10 is required") @Pattern(regexp = "^[0-9]*$", message = "0-9 are allowed") String custmobileNumber,
			@NotNull(message = "customerPassword cannot be null") @Size(min = 3, message = "min of 3 is required") @Pattern(regexp = "^(?=.*\\d)(?=.*[a-z])(?=.*[A-Z]).{3,8}$", message = "Password with one uppercase and one lowercase and a digitdigit and min of 4 characters is allowed") String customerPassword) {
		super();
		this.customerId = customerId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.custEmailId = custEmailId;
		this.custAddress = custAddress;
		this.custmobileNumber = custmobileNumber;
		this.customerPassword = customerPassword;
	}

	public Customer() {
		// TODO Auto-generated constructor stub
	}

}
