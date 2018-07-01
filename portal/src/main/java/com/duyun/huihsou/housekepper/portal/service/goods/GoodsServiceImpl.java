package com.duyun.huihsou.housekepper.portal.service.goods;

import com.duyun.huihsou.housekepper.portal.service.attribute.AttributeService;
import com.duyun.huishou.housekeeper.po.AttributeDetailEntity;
import com.duyun.huishou.housekeeper.po.ItemSkuEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class GoodsServiceImpl implements GoodsService {

    @Autowired
    private ItemSkuService itemSkuService;

    @Autowired
    private AttributeService attributeService;
    @Override
    public Integer save(ItemSkuEntity itemSkuEntity) {
        getPrice(itemSkuEntity);
        if (itemSkuEntity.getId() == null){
            itemSkuEntity.setInsertTime(System.currentTimeMillis());
            itemSkuEntity.setLastUpdateTime(System.currentTimeMillis());
            itemSkuService.insert(itemSkuEntity);
        } else {
            itemSkuEntity.setLastUpdateTime(System.currentTimeMillis());
            itemSkuService.updateByPrimaryKeySelective(itemSkuEntity);
        }
        return itemSkuEntity.getId();
    }

    private void getPrice(ItemSkuEntity itemSkuEntity) {
        String[] attributeDetailArr = itemSkuEntity.getAttributeDetailids().split(",");
        if (attributeDetailArr.length <= 0) {
            return;
        }
        final BigDecimal[] price = {new BigDecimal("0")};
        Arrays.asList(attributeDetailArr).forEach(obj->{
            Map<String,Object> map = new HashMap<>();
            map.put("id", Integer.valueOf(obj));
            List<AttributeDetailEntity> entityList = attributeService.getAttributeDetailByCondetion(map);
            price[0] = price[0].add(entityList.get(0).getPrice());
        });
        itemSkuEntity.setPrice(price[0]);
    }
}
