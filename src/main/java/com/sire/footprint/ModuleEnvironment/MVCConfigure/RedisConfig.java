package com.sire.footprint.ModuleEnvironment.MVCConfigure;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CachingConfigurerSupport;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

/**
 * ==================================================
 * All Right Reserved
 * Date:2017/8/11
 * Author:Sire
 * Description:
 * ==================================================
 */
@Configuration
@EnableRedisHttpSession(maxInactiveIntervalInSeconds = 24*60*60)
public class RedisConfig extends CachingConfigurerSupport {
    Logger logger = LoggerFactory.getLogger(RedisConfig.class);
    @Autowired
    Environment environment;


    @Bean
    public JedisPool defaultJedisPool(){
        String host = environment.getProperty("spring.redis.host");
        int port = Integer.parseInt(environment.getProperty("spring.redis.port"));
        int timeout = Integer.parseInt(environment.getProperty("spring.redis.timeout"));
        int maxIdle = Integer.parseInt(environment.getProperty("spring.redis.jedis.pool.max-idle"));
        long maxWait = Long.parseLong(environment.getProperty("spring.redis.jedis.pool.max-wait"));
        int minIdle = Integer.parseInt(environment.getProperty("spring.redis.jedis.pool.min-idle"));
        String password = environment.getProperty("spring.redis.password");
        JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
        jedisPoolConfig.setMaxIdle(maxIdle);
        jedisPoolConfig.setMinIdle(minIdle);
        jedisPoolConfig.setMaxWaitMillis(maxWait);
        logger.debug("=======redis链接注册成功======");
        JedisPool jedisPool = new JedisPool(jedisPoolConfig, host, port, timeout);

        return  jedisPool;
    }
}
