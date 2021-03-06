package com.ranyell.testes.controller;

import com.github.benmanes.caffeine.cache.Caffeine;
import com.github.benmanes.caffeine.cache.Ticker;
import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.cache.caffeine.CaffeineCache;
import org.springframework.cache.support.SimpleCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

@Configuration
public class ConfigurationCache {


    @Bean
    public CacheManager cacheManagerTicker(Ticker ticker) {

        List<Cache> caches = new ArrayList<>();

        // Cache A
        caches.add(this.buildCache("ceps", ticker, 10L, 10L, TimeUnit.SECONDS));

        // Cache B
        caches.add(this.buildCache("cep", ticker, 30L, 30L, TimeUnit.SECONDS));

        SimpleCacheManager cacheManager = new SimpleCacheManager();
        cacheManager.setCaches(caches);
        return cacheManager;
    }

    private CaffeineCache buildCache(String cacheName, Ticker ticker, Long maxSize, Long ttl, TimeUnit ttlUnit){

        Caffeine<Object, Object> cacheBuilder = Caffeine.newBuilder();

        // TTL
        if (ttl != null && ttl > 0 && ttlUnit != null){
            cacheBuilder.expireAfterWrite(ttl, ttlUnit);
        }

        // Max size
        if (maxSize != null && maxSize > 0){
            cacheBuilder.maximumSize(maxSize);
        }

        // Ticker
        cacheBuilder.ticker(ticker);

        return new CaffeineCache(cacheName, cacheBuilder.build());
    }

    @Bean
    public Ticker ticker() {
        return Ticker.systemTicker();
    }
}
