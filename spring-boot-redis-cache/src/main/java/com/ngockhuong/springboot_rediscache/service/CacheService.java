package com.ngockhuong.springboot_rediscache.service;

import lombok.AllArgsConstructor;
import org.springframework.cache.CacheManager;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
@AllArgsConstructor
public class CacheService {
    private final CacheManager cacheManager;

    /**
     * Clear all caches
     */
    public void clearCache() {
        cacheManager.getCacheNames().forEach(cacheName -> Objects.requireNonNull(cacheManager.getCache(cacheName)).clear());
    }

    /**
     * Clear cache by name
     *
     * @param cacheName cache name
     */
    public void clearCache(String cacheName) {
        Objects.requireNonNull(cacheManager.getCache(cacheName)).clear();
    }

    /**
     * Clear cache by name and key
     *
     * @param cacheName cache name
     * @param key       cache key
     */
    public void clearCache(String cacheName, String key) {
        Objects.requireNonNull(cacheManager.getCache(cacheName)).evict(key);
    }
}
