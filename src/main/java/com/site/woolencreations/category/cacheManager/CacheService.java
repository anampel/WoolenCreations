package com.site.woolencreations.category.cacheManager;

import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cache.CacheManager;
import org.springframework.stereotype.Service;

@Log4j2
@Service
public class CacheService {


    @Qualifier("CacheManager")
    private CacheManager cacheManager;

    public CacheService(CacheManager cacheManager) {
        this.cacheManager = cacheManager;
    }

    public void clearCache() {

        this.cacheManager
                .getCacheNames()
                .stream()
                .forEach(cacheName -> {
                            log.debug("Clearing cache {} ...", () -> cacheName);
                            cacheManager
                                    .getCache(cacheName)
                                    .clear();
                        }
                );
    }

}

