package com.colak.springtutorial.service;

import lombok.RequiredArgsConstructor;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class HyperLogLogService {

    private final RedisTemplate<String, String> redisTemplate;

    private static final String HLL_KEY = "my-hyperloglog";

    // Add elements to the HyperLogLog
    public void addToHyperLogLog(String... elements) {
        redisTemplate.opsForHyperLogLog().add(HLL_KEY, elements);
    }

    // Get the approximate count of unique elements
    public long getHyperLogLogCount() {
        return redisTemplate.opsForHyperLogLog().size(HLL_KEY);
    }
}

