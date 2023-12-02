package com.codeWithXForward.buyandsell.customer;

import com.codeWithXForward.buyandsell.product.Product;
import com.codeWithXForward.buyandsell.product.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.antlr.v4.runtime.misc.LogManager;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Configuration
@RequiredArgsConstructor
public class CustomerConfig  {
    public final CustomerRepository repository;
    private final ProductRepository productRepository;

    @Bean
    CommandLineRunner commandLineRunner(){
        return args -> {
            Customer othis = new Customer("Othis", "othis@mail.com", "password");
            Customer wairimu = new Customer("Wairimu", "wairimu@mail.com", "password");
            Customer faith = new Customer("Faith", "fff@gmail.com", "password");
            Customer fatuma = new Customer("Fatuma", "fati@yahoo.com", "password");
            repository.saveAll(
                    List.of(othis,wairimu,faith)
            );
            System.out.println("""
                    *******************
                    customer configured
                    *******************
                    """
            );

            var soap = new Product("soap","liquid concentrated",300.00);
            var cookingOil = new Product("CookingOil","no colestral",400.00);
            var flour = new Product("Flour","fortified",200.00);

            productRepository.save(soap);
            productRepository.save(cookingOil);
            productRepository.save(flour);
            System.out.println("""
                    *******************
                    product configured
                    *******************
                    """
            );
//            RestTemplate template = new RestTemplate();
//            template.getForObject("http://127.0.0.1/api/v1/customer/all",Customer.class);


        };
    }
}
