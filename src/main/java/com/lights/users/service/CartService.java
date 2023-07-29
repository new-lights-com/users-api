package com.lights.users.service;

import com.lights.users.model.entity.CartEntity;
import com.lights.users.model.request.Cart;
import com.lights.users.repository.CartRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class CartService {

    @Autowired
    private CartRepository cartRepository;

    public void addToCart(Cart cart) {
    }

    public Page<CartEntity> displayCart(Integer pageNumber, Integer pageSize) {
        return null;
    }

    public void removeFromCart(Long id) {
    }
}
