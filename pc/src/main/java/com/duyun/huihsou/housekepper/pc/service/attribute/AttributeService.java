package com.duyun.huihsou.housekepper.pc.service.attribute;


import com.duyun.huihsou.housekepper.pc.service.IBaseService;
import com.duyun.huishou.housekeeper.po.AttributeDetailEntity;
import com.duyun.huishou.housekeeper.po.AttributeEntity;

import java.util.List;
import java.util.Map;

/**
 * @author albert
 * @package com.xianduankeji.ktv.portal.service.user
 * @email cn.lu.duke@gmail.com
 * @date January 10, 2018
 */
public interface AttributeService extends IBaseService<AttributeEntity> {

    List<AttributeEntity> getAttributeByCategoryId(Integer categoryId);

    List<AttributeDetailEntity> getAttributeDetailByCondetion(Map<String, Object> map);
}
