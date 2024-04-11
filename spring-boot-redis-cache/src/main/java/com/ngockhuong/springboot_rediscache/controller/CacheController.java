package com.ngockhuong.springboot_rediscache.controller;

import com.ngockhuong.springboot_rediscache.service.CacheService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class CacheController {
    private final CacheService cacheService;

    @GetMapping("/caches/clear")
    public void clearAllCaches() {
        cacheService.clearCache();
    }

    @GetMapping("/caches/clear/{name}")
    public void clearCache(@PathVariable String name) {
        cacheService.clearCache(name);
    }

    @GetMapping("/caches/clear/{name}/{key}")
    public void clearCache(@PathVariable String name, @PathVariable String key) {
        cacheService.clearCache(name, key);
    }
}
