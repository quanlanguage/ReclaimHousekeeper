package com.duyun.huihsou.housekepper.pc.service.category;



import com.duyun.huihsou.housekepper.pc.service.IBaseService;
import com.duyun.huishou.housekeeper.po.CategoryEntity;
import com.duyun.huishou.housekeeper.po.category.category;

import java.util.List;
import java.util.Map;

/**
 * @author albert
 * @package com.xianduankeji.ktv.portal.service.user
 * @email cn.lu.duke@gmail.com
 * @date January 10, 2018
 */
public interface CategoryService extends IBaseService<CategoryEntity> {

    List<CategoryEntity> getCategoryByParentId(Integer parentId);

    List<category> getCategoryList(Map map);

    Integer getCountFromParent(Integer id);

}
