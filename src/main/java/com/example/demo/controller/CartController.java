package com.example.demo.controller;

import com.example.demo.model.Item;
import com.example.demo.service.ShoppingCartService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/shop")
@AllArgsConstructor
public class CartController {
    private ShoppingCartService cartService;

    @PostMapping("cart/add")
    public String addItem(@RequestParam Long itemId, @RequestParam String token){
        boolean added = cartService.addItem(itemId, token);
        if (added) {
            return "Item added";
        }else{
            return "Invalid token";
        }
    }

    @DeleteMapping("cart/remove")
    public String removeItem(@RequestParam Long itemId, @RequestParam String token){
        boolean added = cartService.deleteItem(itemId, token);
        if (added) {
            return "Item deleted";
        }else{
            return "Invalid token";
        }
    }

    @GetMapping("cart")
    public List<Item> showCart(@RequestParam String token){
        return cartService.showCart(token);
    }
}

