/*
 *Copyright @2022 Grapefruit. All rights reserved.
 */

package com.example.caching;

import com.example.caching.cache.LocalHashMapCacheManager;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.interceptor.CacheInterceptor;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
@EnableCaching
public class CachingApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(CachingApplication.class, args);
		CacheInterceptor interceptor = context.getBean(CacheInterceptor.class);

		//ConcurrentMapCacheManager cacheManager = context.getBean(ConcurrentMapCacheManager.class);
		LocalHashMapCacheManager localHashMapCacheManager = context.getBean(LocalHashMapCacheManager.class);
		System.out.println();
	}
}
