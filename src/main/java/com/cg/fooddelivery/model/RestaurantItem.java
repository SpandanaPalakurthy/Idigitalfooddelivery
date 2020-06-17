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
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "restaurant_item")
public class RestaurantItem {

	@Id
	@Column(name = "item_id")

	@GeneratedValue(strategy = GenerationType.AUTO)
	private int itemId;
	@NotNull(message= "itemname cannot be null")
	@Size(min=3, message= "min of 3 is required")
	@Pattern(regexp = "^[a-z A-Z]*$", message = "a-z and A-Zare allowed")
	@Column(name = "item_name")
	private String itemname;

	@NotNull(message= "itemdescription cannot be null")
	@Size(min=3, message= "min of 3 is required")
	@Pattern(regexp = "^[a-z A-Z]*$", message = "a-z and A-Zare allowed")
	@Column(name = "item_description")
	private String itemdescription;

	@Column(name = "item_price")
	private int itemPrice;

	
	@JsonIgnore
	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "restaurant_id")
	private Restaurant restaurant;

	/*
	 * @JsonIgnore
	 * 
	 * @OneToMany(mappedBy = "restaurantItem") private List<Orders> itemsOrders;
	 */
	
	
	public int getItemId() {
		return itemId;
	}

	

	public void setItemId(int itemId) {
		this.itemId = itemId;
	}

	public String getItemname() {
		return itemname;
	}

	public void setItemname(String itemname) {
		this.itemname = itemname;
	}

	public String getItemdescription() {
		return itemdescription;
	}

	public void setItemdescription(String itemdescription) {
		this.itemdescription = itemdescription;
	}

	public int getItemPrice() {
		return itemPrice;
	}

	public void setItemPrice(int itemPrice) {
		this.itemPrice = itemPrice;
	}

	public Restaurant getRestaurant() {
		return restaurant;
	}

	public void setRestaurant(Restaurant restaurant) {
		this.restaurant = restaurant;
	}

	@Override
	public String toString() {
		return "RestaurantItem [itemId=" + itemId + ", itemname=" + itemname + ", itemdescription=" + itemdescription
				+ ", itemPrice=" + itemPrice + ", restaurant=" + restaurant +  "]";
	}



	public RestaurantItem(int itemId,
			@NotNull(message = "itemname cannot be null") @Size(min = 3, message = "min of 3 is required") @Pattern(regexp = "^[a-z A-Z]*$", message = "a-z and A-Zare allowed") String itemname,
			@NotNull(message = "itemdescription cannot be null") @Size(min = 3, message = "min of 3 is required") @Pattern(regexp = "^[a-z A-Z]*$", message = "a-z and A-Zare allowed") String itemdescription,
			int itemPrice) {
		super();
		this.itemId = itemId;
		this.itemname = itemname;
		this.itemdescription = itemdescription;
		this.itemPrice = itemPrice;
	}



	public RestaurantItem() {
		// TODO Auto-generated constructor stub
	}

}
