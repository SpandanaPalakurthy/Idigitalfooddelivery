package com.cg.fooddelivery.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
@Table(name= "payment")
public class Payment {
	
	@Id
	@Column(name="payment_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int paymentId;
	
	
	@NotNull(message= "cardNumber cannot be null")
	@Size(min=5, message= "min of 5 is required")
	@Pattern(regexp = "^[0-9]*$", message = "0-9 are allowed")
	@Column(name="card_number")
	private String cardNumber;
	
	
	@Column(name="expiration_date")
	private String expirationDate;
	
	 
	@Column(name="cv_code")
	 private int cvCode;
	
	@NotNull(message= "cardOwner cannot be null")
	@Size(min=3, message= "min of 3 is required")
	@Pattern(regexp = "^[a-z A-Z]*$", message = "a-z and A-Zare allowed")
	@Column(name="card_Owner")
	 private String cardOwner;

	/*
	 * @Column(name="payment_date") private String paymentDate;
	 * 
	 * @Column(name="payment_price") private int paymentPrice;
	 */
	@JsonIgnore
	@OneToOne(fetch=FetchType.LAZY,cascade=CascadeType.ALL)
	@JoinColumn(name="order_id")
	private Orders paymentOrder;

	public int getPaymentId() {
		return paymentId;
	}

	
	public void setPaymentId(int paymentId) {
		this.paymentId = paymentId;
	}

	 /* public String getPaymentDate() { return paymentDate; }
	 * 
	 * public void setPaymentDate(String paymentDate) { this.paymentDate =
	 * paymentDate; }
	 * 
	 * public int getPaymentPrice() { return paymentPrice; }
	 * 
	 * public void setPaymentPrice(int paymentPrice) { this.paymentPrice =
	 * paymentPrice; }
	 */
	public Orders getPaymentOrder() {
		return paymentOrder;
	}

	public void setPaymentOrder(Orders paymentOrder) {
		this.paymentOrder = paymentOrder;
	}
	public String getCardNumber() {
		return cardNumber;
	}

	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}

	public String getExpirationDate() {
		return expirationDate;
	}

	public void setExpirationDate(String expirationDate) {
		this.expirationDate = expirationDate;
	}

	public int getCvCode() {
		return cvCode;
	}

	public void setCvCode(int cvCode) {
		this.cvCode = cvCode;
	}

	public String getCardOwner() {
		return cardOwner;
	}

	public void setCardOwner(String cardOwner) {
		this.cardOwner = cardOwner;
	}


	@Override
	public String toString() {
		return "Payment [paymentId=" + paymentId + ", cardNumber=" + cardNumber + ", expirationDate=" + expirationDate
				+ ", cvCode=" + cvCode + ", cardOwner=" + cardOwner + ", paymentOrder=" + paymentOrder + "]";
	}


	public Payment(int paymentId,
			@NotNull(message = "cardNumber cannot be null") @Size(min = 5, message = "min of 5 is required") @Pattern(regexp = "^[0-9]*$", message = "0-9 are allowed") String cardNumber,
			String expirationDate, int cvCode,
			@NotNull(message = "cardOwner cannot be null") @Size(min = 3, message = "min of 3 is required") @Pattern(regexp = "^[a-z A-Z]*$", message = "a-z and A-Zare allowed") String cardOwner) {
		super();
		this.paymentId = paymentId;
		this.cardNumber = cardNumber;
		this.expirationDate = expirationDate;
		this.cvCode = cvCode;
		this.cardOwner = cardOwner;
	}


	public Payment() {
		// TODO Auto-generated constructor stub
	}

	
	
	
	/*
	 * @Override public String toString() { return "Payment [paymentId=" + paymentId
	 * + ", paymentDate=" + paymentDate + ", paymentPrice=" + paymentPrice +
	 * ", paymentOrder=" + paymentOrder + "]"; }
	 */
	
	

}
