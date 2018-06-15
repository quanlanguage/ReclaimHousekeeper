//package com.duyun.huishou.housekeeper.util;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.data.redis.core.RedisTemplate;
//import org.springframework.data.redis.core.ValueOperations;
//import org.springframework.stereotype.Component;
//import org.springframework.util.StringUtils;
//
//import java.util.List;
//import java.util.Set;
//import java.util.concurrent.TimeUnit;
//import java.util.stream.Collectors;
//
///**
// * @author albert
// * @package com.xianduankeji.ktv.base.util
// * @email cn.lu.duke@gmail.com
// * @date January 10, 2018
// */
//
//@Component
//public class RedisTool {
//
//    @Autowired
//    RedisTemplate<String, String> redisTemplate;
//
//    public String get(String key){
//        if (StringUtils.isEmpty(key)){
//            return null;
//        }
//        return redisTemplate.opsForValue().get(key);
//    }
//
//    /**
//     * 判断key是否存在
//     *
//     * @param key
//     * @return
//     */
//    public boolean isExist(final String key) {
//        if (StringUtils.isEmpty(key)) {
//            return false;
//        }
//        return redisTemplate.hasKey(key);
//    }
//
//    /**
//     * 模糊匹配
//     * @param pattern
//     * @return
//     */
//    public List<String> like(String pattern){
//        Set<String> keySet = redisTemplate.keys(pattern);
//        return keySet.stream().collect(Collectors.toList());
//    }
//
//    /**
//     * 设置键值对
//     *
//     * @param key
//     * @param value
//     * @return
//     */
//    public boolean set(String key, String value) {
//        ValueOperations<String, String> oper = redisTemplate.opsForValue();
//        oper.set(key, value);
//        return true;
//
//    }
//
//    /**
//     * 设置键值对，同时设定有效时间
//     *
//     * @param key
//     * @param value
//     * @param expire
//     * @return
//     */
//    public boolean update(String key, String value, Integer expire, TimeUnit timeUnit) {
//        if (isExist(key)) {
//            ValueOperations<String , String> oper = redisTemplate.opsForValue();
//            oper.set(key, value, expire, timeUnit);
//            return true;
//        }
//        return false;
//    }
//
//    /**
//     * 设置键值对
//     * @param key
//     * @param value
//     * @param expire
//     * @param timeUnit
//     * @return
//     */
//    public boolean set(String key, String value, Integer expire, TimeUnit timeUnit){
//        ValueOperations<String, String> oper = redisTemplate.opsForValue();
//        oper.set(key, value, expire, timeUnit);
//        return true;
//    }
//
//    /**
//     * 删除单条数据
//     *
//     * @param key
//     * @return
//     */
//    public boolean remove(String key) {
//        if (isExist(key)) {
//            redisTemplate.delete(key);
//            return true;
//        }
//        return false;
//    }
//
//    /**
//     * 批量删除
//     *
//     * @param keys
//     */
//    public void remove(List<String> keys) {
//        for (String key : keys) {
//            if (isExist(key)) {
//                redisTemplate.delete(key);
//            }
//        }
//    }
//}
