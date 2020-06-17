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
import org.springframework.boot.test.context.SpringBootTest;

import com.cg.fooddelivery.model.Admin;
import com.cg.fooddelivery.model.Customer;
import com.cg.fooddelivery.model.Payment;
import com.cg.fooddelivery.model.Restaurant;
import com.cg.fooddelivery.repository.CustomerRepository;
import com.cg.fooddelivery.repository.OrdersRepository;
import com.cg.fooddelivery.repository.PaymentRepository;
import com.cg.fooddelivery.repository.RestaurantRepository;
import com.cg.fooddelivery.service.impl.CustomerService;

//@RunWith(MockitoJUnitRunner.Silent.class)
@SpringBootTest
public class FooddeliveryCustomerTest extends FooddeliveryMainTests {
	@InjectMocks
	private CustomerService customerserviceimpl;
	@Mock
	private CustomerRepository customerRepository;
	@Mock
	private OrdersRepository ordersRepository;

	@Mock
	private RestaurantRepository restaruntRepository;

	@Mock
	private PaymentRepository paymentRepository;

	@Test
	public void addCustomerTest() {
		Customer customer = new Customer();
		customer.setCustomerId(12);
		customer.setFirstName("spandana");
		customer.setLastName("spandy");
		customer.setCustomerPassword("spandy12");
		customer.setCustAddress("hyd");
		customer.setCustmobileNumber("9098987876");
		customer.setCustEmailId("spandy@gmail.com");
		when(customerRepository.getOne(12)).thenReturn(customer);
		when(customerRepository.save(customer)).thenReturn(customer);

		Customer customerExpected = customerserviceimpl.createCustomer(customer);
		System.out.println("**" + customer.toString());
		System.out.println("--" + customer.toString());
		assertEquals(customerExpected, customer);
	}

	@Test
	public void loggingCustomerTest() {
		String firstName = "spandana";
		String customerPassword = "spandy12";
		when(customerRepository.findDetails(firstName, customerPassword)).thenReturn(
				Stream.of(new Customer(11, "spandana", "spandy", "spandy12", "hyd", "9098987876", "spandy@gmail.com"))
						.collect(Collectors.toList()));
		assertEquals(1, customerserviceimpl.loggingCustomer(firstName, customerPassword).size());
	}

	@Test
	public void getCustomerDetailsTest() {
		when(customerRepository.findAll()).thenReturn(Stream
				.of(new Customer(11, "spandana", "spandy", "spandy12", "hyd", "9098987876", "spandy@gmail.com"),
						new Customer(11, "sai", "sai", "sai12", "blr", "9887875757", "sai@gmail.com"))
				.collect(Collectors.toList()));
		assertEquals(2, customerserviceimpl.getCustomerDetails().size());
	}

	@Test
	public void getRestaurantDetailsTest() {
		when(restaruntRepository.findAll())
				.thenReturn(Stream
						.of(new Restaurant(11, "abc", "abc@gmail.com", "hyd"),
								new Restaurant(11, "paradise", "paa@gmail.com", "chennai"))
						.collect(Collectors.toList()));
		assertEquals(2, customerserviceimpl.getRestaurantDetails().size());

	}
	/*
	 * @Test public void getRestaurantbyIdTest() { int restaurantId =12;
	 * when(restaruntRepository.findById(restaurantId)) .thenReturn(Stream.of(new
	 * Restaurant(11, "abc", "abc@gmail.com", "hyd"
	 * )).collect(Collectors.toList()));
	 * assertEquals(1,customerserviceimpl.getRestaurantbyId(restaurantId).size()); }
	 */

	@Test
	public void makepaymentTest() {
		Payment payment = new Payment();
		payment.setPaymentId(100);
		payment.setCardNumber("1234567810");
		payment.setExpirationDate("02/2020");
		payment.setCvCode(111);
		payment.setCardOwner("spandana");
		when(paymentRepository.getOne(100)).thenReturn(payment);
		when(paymentRepository.save(payment)).thenReturn(payment);

		Payment paymentExpected = customerserviceimpl.makepayment(payment, 11);
		System.out.println("**" + payment.toString());
		System.out.println("--" + payment.toString());
		assertEquals(paymentExpected, payment);
	}

	@Test
	public void getPaymentDetailsTest() {
		when(paymentRepository.findAll()).thenReturn(Stream.of(new Payment(11, "1654126632", "12/2020", 222, "spandy"),
				new Payment(11, "1654126632", "12/2020", 111, "spandy")).collect(Collectors.toList()));
		assertEquals(2, customerserviceimpl.getPaymentDetails().size());
	}
}
