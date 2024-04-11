package com.ngockhuong.springboot_rediscache.service;

import com.ngockhuong.springboot_rediscache.entity.Item;
import com.ngockhuong.springboot_rediscache.repository.ItemRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ItemService {
    private final ItemRepository itemRepository;

    public Item getItem(String id) {
        return itemRepository.findById(id).orElse(null);
    }
}
