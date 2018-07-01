package com.duyun.huihsou.housekepper.pc.service.problem;


import com.duyun.huihsou.housekepper.pc.service.AbstractBaseService;
import com.duyun.huishou.housekeeper.mapper.IBaseDao;
import com.duyun.huishou.housekeeper.mapper.ProblemEntityMapper;
import com.duyun.huishou.housekeeper.po.ProblemEntity;
import com.duyun.huishou.housekeeper.po.problem.problemItem;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author albert
 * @package com.xianduankeji.ktv.portal.service.user
 * @email cn.lu.duke@gmail.com
 * @date January 10, 2018
 */

@Service
@Slf4j
public class ProblemServiceImpl extends AbstractBaseService<ProblemEntity> implements ProblemService {

    @Autowired
    private ProblemEntityMapper problemEntityMapper;


    @Override
    public IBaseDao getMapper() {
        return null;
    }

    @Override
    public problemItem getProbleByID(Map map) {
        return problemEntityMapper.getProbleByID(map);
    }

    @Override
    public List<problemItem> getAllProblem(Map map) {
        return problemEntityMapper.getAllProblem(map);
    }

    @Override
    public Integer delectOneByProble(Integer id) {
        return problemEntityMapper.delectOneByProble(id);
    }

    @Override
    public Integer updateProble(Map map) {
        return problemEntityMapper.updateProble(map);
    }
    @Override
    public int insert(ProblemEntity entity){
        return  problemEntityMapper.insert(entity);
    }

    @Override
    public int getCountProblem() {
        return problemEntityMapper.getCountProblem();
    }

}
