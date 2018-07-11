package com.duyun.huihsou.housekepper.admin.service.problem;


import com.duyun.huihsou.housekepper.admin.request.BaseParams;
import com.duyun.huihsou.housekepper.admin.service.IBaseService;
import com.duyun.huishou.housekeeper.po.ProblemEntity;

import java.util.List;

/**
 * @author albert
 * @package com.xianduankeji.ktv.portal.service.user
 * @email cn.lu.duke@gmail.com
 * @date January 10, 2018
 */
public interface ProblemService extends IBaseService<ProblemEntity> {

    List<ProblemEntity> getAll(BaseParams params);
}
