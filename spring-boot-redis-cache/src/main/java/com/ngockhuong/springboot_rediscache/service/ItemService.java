package com.ngockhuong.springboot_rediscache.service;

import com.ngockhuong.springboot_rediscache.entity.Item;
import com.ngockhuong.springboot_rediscache.repository.ItemRepository;
import lombok.AllArgsConstructor;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.Caching;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ItemService {
    private final ItemRepository itemRepository;

    /**
     * Get item by id
     *
     * @param id item id
     * @return item
     */
    @Cacheable(value = "itemCache", key = "#id", unless = "#result == null")
    public Item getItem(Long id) {
        return itemRepository.findById(id).orElse(null);
    }

    /**
     * Get all items
     *
     * @return list of items
     */
    @Cacheable(value = "itemsCache")
    public List<Item> getItems() {
        return itemRepository.findAll();
    }

    /**
     * Delete item by id
     *
     * @param id item id
     */
    @Caching(evict = {
            @CacheEvict(value = "itemCache", key = "#id"),
            @CacheEvict(value = "itemsCache", allEntries = true)
    })
    public void deleteItem(Long id) {
        itemRepository.deleteById(id);
    }

    /**
     * Add item
     *
     * @param item item
     * @return item
     */
    public Item addItem(Item item) {
        return itemRepository.save(item);
    }

    /**
     * Update item
     *
     * @param item item
     * @return item
     */
    @CachePut(value = "itemCache", key = "#item.id")
    public Item updateItem(Item item) {
        return itemRepository.save(item);
    }
}
