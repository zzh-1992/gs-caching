/*
 *Copyright @2022 Grapefruit. All rights reserved.
 */

package com.example.caching.cache;

import org.springframework.boot.autoconfigure.cache.CacheProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration(proxyBeanMethods = false)
class LocalSimpleCacheConfiguration {

    /**
     * 往容器里注入缓存配置
     *
     * @return cacheProperties
     */
    @Bean
    CacheProperties cacheProperties() {
        return new CacheProperties();
    }

    /**
     * 填充自定义缓存管理器(CacheManagerCustomizers cacheManagerCustomizers)
     *
     * @param cacheProperties cacheProperties
     * @return LocalHashMapCacheManager
     */
    @Bean
    LocalHashMapCacheManager localHashMapCacheManager(CacheProperties cacheProperties) {
        LocalHashMapCacheManager cacheManager = new LocalHashMapCacheManager();
        List<String> cacheNames = cacheProperties.getCacheNames();
        if (!cacheNames.isEmpty()) {
            cacheManager.setCacheNames(cacheNames);
        }
        //return cacheManagerCustomizers.customize(cacheManager);
        return cacheManager;
    }
}