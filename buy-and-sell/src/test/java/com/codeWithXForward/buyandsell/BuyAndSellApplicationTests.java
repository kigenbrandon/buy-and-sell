package com.codeWithXForward.buyandsell;

import com.codeWithXForward.buyandsell.product.Product;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpMethod;
import org.springframework.security.access.method.P;
import org.springframework.web.client.RestTemplate;

@SpringBootTest
class BuyAndSellApplicationTests {

	@Test
	void contextLoads() {
	}

	@Test
	public void check() {
		RestTemplate template = new RestTemplate();
		template.exchange("http://127.0.0.1:8081/api/v1/message", HttpMethod.GET,null, String.class);

		String body =template.exchange("http://127.0.0.1:8081/api/v1/message", HttpMethod.GET,null, String.class).getBody();
		System.out.println(body);
	}

}
