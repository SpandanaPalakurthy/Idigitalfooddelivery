package com.cg.fooddelivery.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name= "orders")
public class Orders {

	@Id
	@Column(name="order_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int orderId;
	
	@Column(name="order_date")
	private String orderDate;
	
	@Column(name="order_total_amount")
	private int orderTotalAmount;
	
	@JsonIgnore
	@ManyToOne(fetch=FetchType.LAZY,cascade=CascadeType.ALL)
	@JoinColumn(name="customer_id")
	private Customer orderCustomer;
	
	@Column(name="order_status")
	private String orderStatus;
	
	/*
	 * @JsonIgnore
	 * 
	 * @ManyToOne(fetch=FetchType.LAZY,cascade=CascadeType.ALL)
	 * 
	 * @JoinColumn(name="item_id") private RestaurantItem restaurantItem;
	 */
	
	@JsonIgnore
	@OneToOne(mappedBy = "paymentOrder")
	private Payment orderPayment;

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public String getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(String orderDate) {
		this.orderDate = orderDate;
	}

	public int getOrderTotalAmount() {
		return orderTotalAmount;
	}

	public void setOrderTotalAmount(int orderTotalAmount) {
		this.orderTotalAmount = orderTotalAmount;
	}

	public Customer getOrderCustomer() {
		return orderCustomer;
	}

	public void setOrderCustomer(Customer orderCustomer) {
		this.orderCustomer = orderCustomer;
	}

	public Payment getOrderPayment() {
		return orderPayment;
	}

	public void setOrderPayment(Payment orderPayment) {
		this.orderPayment = orderPayment;
	}

	public String getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}

	@Override
	public String toString() {
		return "Orders [orderId=" + orderId + ", orderDate=" + orderDate + ", orderTotalAmount=" + orderTotalAmount
				+ ", orderCustomer=" + orderCustomer + ", orderStatus=" + orderStatus + ", orderPayment=" + orderPayment
				+ "]";
	}

	
	
}
