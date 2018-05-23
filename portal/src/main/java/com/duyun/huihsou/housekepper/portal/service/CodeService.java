package com.duyun.huihsou.housekepper.portal.service;

import com.duyun.huihsou.housekepper.portal.constants.Constants;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import java.util.Random;
import java.util.concurrent.TimeUnit;


@Service
public class CodeService {

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    public String getCode(String phone, int type) {
        String key = Constants.PHONE_CODE + "." + type;
        if (StringUtils.isNotEmpty(phone)) {
            String code = stringRedisTemplate.opsForValue().get(key);
            if (StringUtils.isNotEmpty(code)) {
                return code;
            }
            //TODO
            code = getRandomCode(6);
            stringRedisTemplate.opsForValue().set(key,code);
            stringRedisTemplate.expire(key,4, TimeUnit.SECONDS);
            return code;
        }
        return "";
    }


    private static String getRandomCode(int length) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < length; i++) {
            int data = new Random().nextInt(10);
            sb.append(data);
        }
        return sb.toString();
    }

}
