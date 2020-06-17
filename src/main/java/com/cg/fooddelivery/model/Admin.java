package com.cg.fooddelivery.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@Entity
//@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
@Table(name = "admin")
public class Admin {

	@Id
	@Column(name = "admin_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int adminId;
	@NotNull(message= "username cannot be null")
	@Size(min=3, message= "min of 3 is required")
	@Pattern(regexp = "^[a-z A-Z]*$", message = "a-z and A-Zare allowed")

	private String adminUsername;

	@NotNull(message= "password cannot be null")
	@Column(name = "admin_password")
	@Size(min=3, message= "min of 3 is required")
	@Pattern(regexp = "^(?=.*\\d)(?=.*[a-z])(?=.*[A-Z]).{3,8}$", message = "Password with one uppercase and one lowercase and a digitdigit and min of 4 characters is allowed")
	private String adminPassword;

	@JsonIgnore
	@OneToMany(mappedBy = "admin")
	private List<Restaurant> listOfRestaurants;

	public int getAdminId() {
		return adminId;
	}

	public void setAdminId(int adminId) {
		this.adminId = adminId;
	}

	public String getAdminUsername() {
		return adminUsername;
	}

	public void setAdminUsername(String adminUsername) {
		this.adminUsername = adminUsername;
	}

	public String getAdminPassword() {
		return adminPassword;
	}

	public void setAdminPassword(String adminPassword) {
		this.adminPassword = adminPassword;
	}

	public List<Restaurant> getListOfRestaurants() {
		return listOfRestaurants;
	}

	public void setListOfRestaurants(List<Restaurant> listOfRestaurants) {
		this.listOfRestaurants = listOfRestaurants;
	}

	@Override
	public String toString() {
		return "Admin [adminId=" + adminId + ", adminUsername=" + adminUsername + ", adminPassword=" + adminPassword
				+ ", listOfRestaurants=" + listOfRestaurants + "]";
	}

	

	public Admin(int adminId,
			@NotNull(message = "username cannot be null") @Size(min = 3, message = "min of 3 is required") @Pattern(regexp = "^[a-z A-Z]*$", message = "a-z and A-Zare allowed") String adminUsername,
			@NotNull(message = "password cannot be null") @Size(min = 3, message = "min of 3 is required") @Pattern(regexp = "^(?=.*\\d)(?=.*[a-z])(?=.*[A-Z]).{3,8}$", message = "Password with one uppercase and one lowercase and a digitdigit and min of 4 characters is allowed") String adminPassword) {
		super();
		this.adminId = adminId;
		this.adminUsername = adminUsername;
		this.adminPassword = adminPassword;
	}

	public Admin() {
		// TODO Auto-generated constructor stub
	}

	

}
