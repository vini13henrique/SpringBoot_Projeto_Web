package com.vinicius.projeto.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.vinicius.projeto.entities.Category;
import com.vinicius.projeto.entities.Order;
import com.vinicius.projeto.entities.Product;
import com.vinicius.projeto.entities.User;
import com.vinicius.projeto.entities.enums.OrderStatus;
import com.vinicius.projeto.repositories.CategoryRepository;
import com.vinicius.projeto.repositories.OrderRepository;
import com.vinicius.projeto.repositories.ProductRepository;
import com.vinicius.projeto.repositories.UserRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private OrderRepository orderRepository;

	@Autowired
	private CategoryRepository categoryRepository;

	@Autowired
	private ProductRepository productRepository;

	@Override
	public void run(String... args) throws Exception {
		
		Category produto1 = new Category(null, "eletronics");
		Category produto2 = new Category(null, "book");
		Category produto3 = new Category(null, "computers");

		Product p1 = new Product(null, "The Lord of the Rings", "Lorem ipsum dolor sit amet, consectetur.", 90.5, "");
		Product p2 = new Product(null, "Smart TV", "Nulla eu imperdiet purus. Maecenas ante.", 2190.0, "");
		Product p3 = new Product(null, "Macbook Pro", "Nam eleifend maximus tortor, at mollis.", 1250.0, "");
		Product p4 = new Product(null, "PC Gamer", "Donec aliquet odio ac rhoncus cursus.", 1200.0, "");
		Product p5 = new Product(null, "Rails for Dummies", "Cras fringilla convallis sem vel faucibus.", 100.99, "");

		

		User user1 = new User(null, "vinicius", "vini@", "5445", "321");
		User user2 = new User(null, "henrique", "henrique@", "876690", "123");

		Order o1 = new Order(null, Instant.parse("2019-06-20T19:53:07Z"), OrderStatus.WAITING_PAYMENT, user1);
		Order o2 = new Order(null, Instant.parse("2019-07-21T03:42:10Z"), OrderStatus.WAITING_PAYMENT, user2);
		Order o3 = new Order(null, Instant.parse("2019-07-22T15:21:22Z"), OrderStatus.WAITING_PAYMENT, user1);

		userRepository.saveAll(Arrays.asList(user1, user2));
		orderRepository.saveAll(Arrays.asList(o1, o2, o3));
		categoryRepository.saveAll(Arrays.asList(produto1, produto2,produto3));
		productRepository.saveAll(Arrays.asList(p1, p2, p3, p4, p5));
		
		p1.getCategories().add(produto2);
		p2.getCategories().add(produto1);
		p3.getCategories().add(produto3);
		p4.getCategories().add(produto3);
		p5.getCategories().add(produto2);
		
		productRepository.saveAll(Arrays.asList(p1,p2,p3,p4,p5));
		
	}
}
