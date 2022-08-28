
查看ehcache的数据深度(属性层次)
```java
// 已debug方式启动服务,计算ehCacheCacheManager,得到以下结果
EhCacheCacheManager ehCacheCacheManager = context.getBean(EhCacheCacheManager.class);
```

ehCacheCacheManager-->cacheMap("books配置到存储空间")-->value:EhCacheCache-->compoundStore:MemoryStore-->

-->map:SelectableConcurrentHashMap-->segments:SelectableConcurrentHashMap$Segment
segments中128个Segment,对应到数据就存储在Segment中的table:SelectableConcurrentHashMap$HashEntry
```shell
ehCacheCacheManager = {EhCacheCacheManager@5044} 
 cacheManager = {CacheManager@5011} "__DEFAULT__"
 transactionAware = false
 cacheMap = {ConcurrentHashMap@5047}  size = 1
  "books" -> {EhCacheCache@4947} 
   key = "books"
   value = {EhCacheCache@4947} 
    cache = {Cache@4948} "[ name = books status = STATUS_ALIVE eternal = false overflowToDisk = false maxEntriesLocalHeap = 1000 maxEntriesLocalDisk = 0 memoryStoreEvictionPolicy = LRU timeToLiveSeconds = 1000 timeToIdleSeconds = 0 persistence = none diskExpiryThreadIntervalSeconds = 120 cacheEventListeners: ; orderedCacheEventListeners:  maxBytesLocalHeap = 0 overflowToOffHeap = false maxBytesLocalOffHeap = 0 maxBytesLocalDisk = 0 pinned = false ]"
     disabled = false
     useClassicLru = false
     cacheStatus = {Cache$CacheStatus@5006} 
     configuration = {CacheConfiguration@5007} 
     compoundStore = {MemoryStore@4952} 
      evictionObserver = {GeneralOperationStatistic@4955} "{SUCCESS=0}"
      cache = {Cache@4948} "[ name = books status = STATUS_ALIVE eternal = false overflowToDisk = false maxEntriesLocalHeap = 1000 maxEntriesLocalDisk = 0 memoryStoreEvictionPolicy = LRU timeToLiveSeconds = 1000 timeToIdleSeconds = 0 persistence = none diskExpiryThreadIntervalSeconds = 120 cacheEventListeners: ; orderedCacheEventListeners:  maxBytesLocalHeap = 0 overflowToOffHeap = false maxBytesLocalOffHeap = 0 maxBytesLocalDisk = 0 pinned = false ]"
      map = {SelectableConcurrentHashMap@4954} 
       segmentMask = 127
       segmentShift = 25
       segments = {SelectableConcurrentHashMap$Segment[128]@5060} 
        .......
        84 = {SelectableConcurrentHashMap$Segment@5149} "net.sf.ehcache.store.chm.SelectableConcurrentHashMap$Segment@48c40605[Write locks = 0, Read locks = 0]"
        85 = {SelectableConcurrentHashMap$Segment@5150} "net.sf.ehcache.store.chm.SelectableConcurrentHashMap$Segment@54107f42[Write locks = 0, Read locks = 0]"
         count = 1
         modCount = 1
         threshold = 0
         table = {SelectableConcurrentHashMap$HashEntry[1]@5301} 
          0 = {SelectableConcurrentHashMap$HashEntry@5307} 
           key = "isbn-1234 =============="
           hash = -1442192378
           next = null
           value = {Element@5309} "[ key = isbn-1234 ==============, value=Book{isbn='isbn-1234 ==============', title='Some book'}, version=1, hitCount=3, CreationTime = 1661656699851, LastAccessTime = 1661656699886 ]"
           sizeOf = 0
           accessed = true
         loadFactor = 0.75
         evictionIterator = null
         this$0 = {SelectableConcurrentHashMap@4954} 
         readerLock = {ReentrantReadWriteLock$ReadLock@5302} "java.util.concurrent.locks.ReentrantReadWriteLock$ReadLock@61a002b1[Read locks = 0]"
         writerLock = {ReentrantReadWriteLock$WriteLock@5303} "java.util.concurrent.locks.ReentrantReadWriteLock$WriteLock@4eeea57d[Unlocked]"
         sync = {ReentrantReadWriteLock$NonfairSync@5304} "java.util.concurrent.locks.ReentrantReadWriteLock$NonfairSync@780ec4a5[State = 0, empty queue]"
        86 = {SelectableConcurrentHashMap$Segment@5151} "net.sf.ehcache.store.chm.SelectableConcurrentHashMap$Segment@1b11ef33[Write locks = 0, Read locks = 0]"
```