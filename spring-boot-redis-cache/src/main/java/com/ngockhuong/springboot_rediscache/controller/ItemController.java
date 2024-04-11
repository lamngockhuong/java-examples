package com.ngockhuong.springboot_rediscache.controller;

import com.ngockhuong.springboot_rediscache.entity.Item;
import com.ngockhuong.springboot_rediscache.service.ItemService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class ItemController {
    private final ItemService itemService;

    @GetMapping("/items/{id}")
    public Item getItem(@PathVariable String id) {
        return itemService.getItem(id);
    }
}
