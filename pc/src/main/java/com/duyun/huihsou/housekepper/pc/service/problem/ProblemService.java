package com.duyun.huihsou.housekepper.pc.service.problem;



import com.duyun.huihsou.housekepper.pc.request.BaseParams;
import com.duyun.huihsou.housekepper.pc.service.IBaseService;
import com.duyun.huishou.housekeeper.po.ProblemEntity;
import com.duyun.huishou.housekeeper.po.problem.problemItem;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;
import java.util.Map;

/**
 * @author albert
 * @package com.xianduankeji.ktv.portal.service.user
 * @email cn.lu.duke@gmail.com
 * @date January 10, 2018
 */
public interface ProblemService extends IBaseService<ProblemEntity> {

    //得到一篇 问题通过ID
    problemItem getProbleByID(Map map);

    //得到所有的问题分页
    List<problemItem> getAllProblem(Map map);

    //通过主键删除 问题
    Integer delectOneByProble(Integer id);

    //更新语句
    Integer updateProble(Map map);

    //插入一篇
    int insert(ProblemEntity entity);

    //获得problem 的总数
    int getCountProblem();

}
