package com.example.demo.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.CacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheConfiguration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.RedisSerializationContext;
import org.springframework.data.redis.serializer.RedisSerializer;

@Configuration
public class RedisCacheConfig {
    @Autowired
    private RedisConnectionFactory redisConnectionFactory;
/**
 * 配置并创建Redis CacheManager
 * CacheManager是Spring框架中用于管理多个缓存组件的核心接口
 * 该方法主要负责设置Redis作为缓存的默认配置，包括序列化方式等
 *
 * @return CacheManager对象，用于管理Redis缓存
 */
@Bean
public CacheManager cacheManager(){
    //创建封装redis缓存配置的对象
    RedisCacheConfiguration cfg = RedisCacheConfiguration.defaultCacheConfig();

    //设置缓存值的序列化方式为JSON
    cfg=cfg.serializeValuesWith(RedisSerializationContext
            .SerializationPair.fromSerializer(RedisSerializer.json()));

    //构建并返回RedisCacheManager对象，使用默认配置
    return RedisCacheManager.builder(redisConnectionFactory).cacheDefaults(cfg).build();
}

}
