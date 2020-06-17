package com.cg.fooddelivery;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.web.context.WebApplicationContext;

import com.cg.fooddelivery.controller.AdminController;
import com.cg.fooddelivery.model.Admin;
import com.cg.fooddelivery.model.Restaurant;
import com.cg.fooddelivery.repository.AdminRepository;
import com.cg.fooddelivery.repository.RestaurantRepository;
import com.cg.fooddelivery.service.impl.AdminService;

//@RunWith(MockitoJUnitRunner.class)
@SpringBootTest
public class FooddeliveryAdminTest extends FooddeliveryMainTests {

	@InjectMocks
	private AdminService adminServiceimpl;

	@Mock
	private AdminRepository adminRepository;

	@Mock
	private RestaurantRepository restaruntRepository;

	@Test
	public void addAdminTest() {
		Admin admin = new Admin();
		admin.setAdminId(12);
		admin.setAdminUsername("spandy");
		admin.setAdminPassword("spandy12");
		when(adminRepository.getOne(12)).thenReturn(admin);

		when(adminRepository.save(admin)).thenReturn(admin);

		Admin expectedAdmin = adminServiceimpl.addAdmin(admin);
		System.out.println("**" + admin.toString());
		System.out.println("--" + expectedAdmin.toString());
		assertEquals(expectedAdmin, admin);
	}

	@Test
	public void loggingAdminTest() {
		String adminUsername = "spandy";
		String adminPassword = "spandy1";
		when(adminRepository.findDetails(adminUsername, adminPassword))
				.thenReturn(Stream.of(new Admin(11, "spandy", "spandy1")).collect(Collectors.toList()));
		assertEquals(1, adminServiceimpl.loggingAdmin(adminUsername, adminPassword).size());
	}

	@Test
	public void getAdminsTest() {

		when(adminRepository.findAll()).thenReturn(Stream
				.of(new Admin(11, "spandy", "spandy1"), new Admin(12, "sai", "sai12")).collect(Collectors.toList()));
		assertEquals(2, adminServiceimpl.getAdmins().size());

	}

	@Test
	public void addRestaurantTest() {
		Restaurant restaurant = new Restaurant();

		restaurant.setRestaurantId(10);
		restaurant.setRestaurantName("swagath");
		restaurant.setRestaurantAddress("hyd");
		restaurant.setRestaurantEmail("swa@gmail.com");
		when(restaruntRepository.getOne(10)).thenReturn(restaurant);
		when(restaruntRepository.save(restaurant)).thenReturn(restaurant);

		Restaurant expectedrestaurant = adminServiceimpl.addRestaurant(restaurant, 1);
		System.out.println("**" + restaurant.toString());
		System.out.println("--" + restaurant.toString());
		assertEquals(expectedrestaurant, restaurant);
	}

	/*
	 * public void getAdminDetailsTest() { int adminId = 12;
	 * when(adminRepository.findById(adminId)) .thenReturn (Stream.of(new Admin(11,
	 * "spandy", "spandy1")).collect(Collectors.toList())); }
	 */
}
