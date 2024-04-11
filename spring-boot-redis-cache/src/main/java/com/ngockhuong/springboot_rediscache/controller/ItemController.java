package com.ngockhuong.springboot_rediscache.controller;

import com.ngockhuong.springboot_rediscache.entity.Item;
import com.ngockhuong.springboot_rediscache.service.ItemService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
public class ItemController {
    private final ItemService itemService;

    @GetMapping("/items")
    public List<Item> getItems() {
        return itemService.getItems();
    }

    @GetMapping("/items/{id}")
    public Item getItem(@PathVariable Long id) {
        return itemService.getItem(id);
    }

    @PutMapping("/items")
    public Item updateItem(@RequestBody Item item) {
        return itemService.updateItem(item);
    }

    @PostMapping("/items")
    public Item addItem(@RequestBody Item item) {
        return itemService.addItem(item);
    }

    @DeleteMapping("/items/{id}")
    public void deleteItem(@PathVariable Long id) {
        itemService.deleteItem(id);
    }
}
