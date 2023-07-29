package com.lights.users.conroller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.lights.users.model.request.Cart;
import com.lights.users.model.entity.CartEntity;
import com.lights.users.model.response.CartSaveSuccessResponse;
import com.lights.users.service.CartService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Slf4j
@RestController
@RequestMapping("/api")
public class CartController {

    @Autowired
    private CartService cartService;
    private final ObjectMapper objectMapper = new ObjectMapper();

    @PostMapping(value = "/carts", consumes = {"application/json"})
    @CrossOrigin(origins = "*")
    public ResponseEntity<?> addToCart(@RequestBody @Valid Cart cart) {
        log.info("event=addToCart");
        cartService.addToCart(cart);
        return ResponseEntity.status(HttpStatus.CREATED).body(new CartSaveSuccessResponse("Products successfully added to cart"));
    }

    @GetMapping(value = "/carts")
    @CrossOrigin(origins = "*")
    public ResponseEntity<?>  displayCart(@RequestParam Integer pageNumber, @RequestParam Integer pageSize) {
        log.info("event=displayCart PageNumber={} PageSize={}", pageNumber, pageSize);
        Page<CartEntity> cartlist = cartService.displayCart(pageNumber, pageSize);
        return ResponseEntity.status(HttpStatus.OK).body(cartlist);
    }

    @GetMapping(value = "/carts/{id}")
    @CrossOrigin(origins = "*")
    public ResponseEntity<?> removeFromCart(@PathVariable Long id) {
         log.info("event=removeFromCart productId={}", id);
         cartService.removeFromCart(id);
         return ResponseEntity.ok().build();
    }

}
