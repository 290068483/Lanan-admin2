package com.ruoyi.web.controller.system;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Redis连接测试控制器
 */
@RestController
@RequestMapping("/test/redis")
public class RedisTestController {
    
    @Autowired
    private StringRedisTemplate stringRedisTemplate;
    
    /**
     * 测试Redis连接
     * @return
     */
    @GetMapping("/connect")
    public String testConnection() {
        try {
            stringRedisTemplate.opsForValue().set("testKey", "testValue");
            String value = stringRedisTemplate.opsForValue().get("testKey");
            return "Redis连接成功，测试值: " + value;
        } catch (Exception e) {
            return "Redis连接失败: " + e.getMessage();
        }
    }
}