package com.cg.fooddelivery.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})

@Entity
@Table(name= "restaurant")
public class Restaurant {

	@Id
	@Column(name = "restaurant_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int restaurantId;

	@NotNull(message= "restaurantname cannot be null")
	@Size(min=3, message= "min of 3 is required")
	@Pattern(regexp = "^[a-z A-Z]*$", message = "a-z and A-Zare allowed")
	@Column(name = "restaurant_name")
	private String restaurantName;

	@NotNull(message= "restaurantaddress cannot be null")
	@Size(min=3, message= "min of 3 is required")
	@Pattern(regexp = "^[a-z A-Z]*$", message = "a-z and A-Zare allowed")
	@Column(name = "restaurant_address")
	private String restaurantAddress;

	@NotNull(message= "Email cannot be null")
	@Size(min=3, message= "min of 3 is required")
	@Email
	@Column(name = "restaurant_email")
	private String restaurantEmail;

	@JsonIgnore	
	@OneToMany(mappedBy="restaurant")
	private List<RestaurantItem> restaurantItems;

	@JsonIgnore
	@ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
	@JoinColumn(name = "admin_Id")
	private Admin admin;
	
	/*
	 * @JsonIgnore
	 * 
	 * @OneToOne(mappedBy= "restaurant") private Customer customer;
	 */
	public int getRestaurantId() {
		return restaurantId;
	}

	public void setRestaurantId(int restaurantId) {
		this.restaurantId = restaurantId;
	}

	public String getRestaurantName() {
		return restaurantName;
	}

	public void setRestaurantName(String restaurantName) {
		this.restaurantName = restaurantName;
	}

	public String getRestaurantAddress() {
		return restaurantAddress;
	}

	public void setRestaurantAddress(String restaurantAddress) {
		this.restaurantAddress = restaurantAddress;
	}

	public String getRestaurantEmail() {
		return restaurantEmail;
	}

	public void setRestaurantEmail(String restaurantEmail) {
		this.restaurantEmail = restaurantEmail;
	}

	public List<RestaurantItem> getRestaurantItems() {
		return restaurantItems;
	}

	public void setRestaurantItems(List<RestaurantItem> restaurantItems) {
		this.restaurantItems = restaurantItems;
	}

	public Admin getAdmin() {
		return admin;
	}

	public void setAdmin(Admin admin) {
		this.admin = admin;
	}

	@Override
	public String toString() {
		return "Restaurant [restaurantId=" + restaurantId + ", restaurantName=" + restaurantName
				+ ", restaurantAddress=" + restaurantAddress + ", restaurantEmail=" + restaurantEmail
				+ ", restaurantItems=" + restaurantItems + ", admin=" + admin + "]";
	}

	public Restaurant(int restaurantId,
			@NotNull(message = "restaurantname cannot be null") @Size(min = 3, message = "min of 3 is required") @Pattern(regexp = "^[a-z A-Z]*$", message = "a-z and A-Zare allowed") String restaurantName,
			@NotNull(message = "restaurantaddress cannot be null") @Size(min = 3, message = "min of 3 is required") @Pattern(regexp = "^[a-z A-Z]*$", message = "a-z and A-Zare allowed") String restaurantAddress,
			@NotNull(message = "Email cannot be null") @Size(min = 3, message = "min of 3 is required") @Email String restaurantEmail) {
		super();
		this.restaurantId = restaurantId;
		this.restaurantName = restaurantName;
		this.restaurantAddress = restaurantAddress;
		this.restaurantEmail = restaurantEmail;
	}

	public Restaurant() {
		// TODO Auto-generated constructor stub
	}

	

	
}
