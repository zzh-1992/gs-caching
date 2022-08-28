# spring cache

> Plugging-in Different Back-end Caches
官方文档:

https://docs.spring.io/spring-framework/docs/current/reference/html/integration.html#cache-plug

## 8.6. Plugging-in Different Back-end Caches 自定义缓存
Clearly, there are plenty of caching products out there that you can use as a backing store. For those that do not
support JSR-107 you need to provide a CacheManager and a Cache implementation. This may sound harder than it is, since,
in practice, the classes tend to be simple [adapters](https://en.wikipedia.org/wiki/Adapter_pattern) that map the caching abstraction framework on top of the storage
API, as the ehcache classes do. Most CacheManager classes can use the classes in the org.springframework.cache.support
package (such as AbstractCacheManager which takes care of the boiler-plate code, leaving only the actual mapping to be
completed).