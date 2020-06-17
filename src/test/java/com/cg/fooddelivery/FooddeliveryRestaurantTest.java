package com.cg.fooddelivery;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
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
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;

import com.cg.fooddelivery.model.Admin;
import com.cg.fooddelivery.model.RestaurantItem;
import com.cg.fooddelivery.repository.RestaurantOwnerRepository;
import com.cg.fooddelivery.repository.RestaurantRepository;
import com.cg.fooddelivery.service.impl.CustomerService;
import com.cg.fooddelivery.service.impl.RestaurantService;

//@RunWith(MockitoJUnitRunner.Silent.class)
@SpringBootTest
public class FooddeliveryRestaurantTest extends FooddeliveryMainTests {

	@InjectMocks
	private RestaurantService restserviceimpl;
	@Mock
	private RestaurantOwnerRepository restOwnerRepository;

	@Mock
	private RestaurantRepository restaurantRepository;
	/*
	 * @Autowired private TestRestTemplate restTemplate;
	 * 
	 * @LocalServerPort private int port;
	 * 
	 * private String getRootUrl() { return "http://localhost:" + port;
	 */
    
	@Test
	public void addFoodItemsTest() {
		RestaurantItem restaurantitem = new RestaurantItem();
		restaurantitem.setItemId(101);
		restaurantitem.setItemname("panner");
		restaurantitem.setItemdescription("soft");
		restaurantitem.setItemPrice(200);
		when(restOwnerRepository.getOne(101)).thenReturn(restaurantitem);
		when(restOwnerRepository.save(restaurantitem)).thenReturn(restaurantitem);

		RestaurantItem expectedresult = restserviceimpl.addFoodItems(restaurantitem, 3);
		System.out.println("**" + restaurantitem.toString());
		System.out.println("--" + restaurantitem.toString());
		assertEquals(expectedresult, restaurantitem);
	}

	@Test
	public void getfooditemsTest() {

		when(restOwnerRepository.findAll()).thenReturn(
				Stream.of(new RestaurantItem(101, "dosa", "tasty", 100), new RestaurantItem(102, "tea", "drink", 10))
						.collect(Collectors.toList()));

		assertEquals(2, restserviceimpl.getFoodItems().size());
	}

	/*
	 * @Test public void getFoodDetailsTest() {
	 * 
	 * int itemId = 12;
	 * 
	 * when(restOwnerRepository.findById(itemId)).thenReturn(Stream .of(new
	 * RestaurantItem(101, "dosa", "tasty", 100)).collect(Collectors.toList()));
	 * 
	 */ 

	/*
	 * @Test public void updateItemsTest() { int itemId = 1; RestaurantItem restitem
	 * = restTemplate.getForObject(getRootUrl() + "/restaurantItems/{itemId}" +
	 * itemId, RestaurantItem.class); restitem.setItemname("cc");
	 * restitem.setItemdescription("aa"); restitem.setItemPrice(12);
	 * restitem.setItemId(1);
	 * 
	 * restTemplate.put(getRootUrl() + "/employees/" + itemId, restitem);
	 * RestaurantItem updatedRestaurantItem = restTemplate.getForObject(getRootUrl()
	 * + "/restaurantItems/{itemId}" + itemId, RestaurantItem.class);
	 * assertNotNull(updatedRestaurantItem); }
	 */
	
	@Test
	public void deleteFoodDetailsTest() {
		RestaurantItem restitem = new RestaurantItem(101, "milk", "drink", 20);
		restserviceimpl.deleteFoodItems(9);
		verify(restOwnerRepository, times(1)).deleteById(9);
	}

	
	/*
	 * @Test public void updateItemsTest() { int itemId = 12; RestaurantItem
	 * restitem = new RestaurantItem(); restitem.setItemname("coffe");
	 * restitem.setItemPrice(12); restitem.setItemdescription("drinks");
	 * restOwnerRepository.save(restitem);
	 * 
	 * RestaurantItem restexp = restserviceimpl.updateFoodItems(restitem, 28);
	 * assertThat(restexp.getItemId()).isEqualTo(restitem);
	 * 
	 * }
	 */
}
