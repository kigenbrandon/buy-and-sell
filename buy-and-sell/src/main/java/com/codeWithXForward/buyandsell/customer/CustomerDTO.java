package com.codeWithXForward.buyandsell.customer;


import com.codeWithXForward.buyandsell.product.Product;

public record CustomerDTO(
        String name,
        String email,
        Role role
) {
}
