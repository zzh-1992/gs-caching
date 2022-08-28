/*
 *Copyright @2022 Grapefruit. All rights reserved.
 */

package com.example.caching;

import com.example.caching.cache.LocalHashMapCacheManager;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.ehcache.EhCacheCacheManager;
import org.springframework.cache.interceptor.CacheInterceptor;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;

@SpringBootApplication
@EnableCaching
public class CachingApplication {

	@Primary
	@Bean
	EhCacheCacheManager ehCacheCacheManager() {
		return new EhCacheCacheManager();
	}

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(CachingApplication.class, args);
		CacheInterceptor interceptor = context.getBean(CacheInterceptor.class);

		//ConcurrentMapCacheManager cacheManager = context.getBean(ConcurrentMapCacheManager.class);
		LocalHashMapCacheManager localHashMapCacheManager = context.getBean(LocalHashMapCacheManager.class);
		EhCacheCacheManager ehCacheCacheManager = context.getBean(EhCacheCacheManager.class);
		System.out.println();
	}
}
