package com.duyun.huihsou.housekepper.portal.service;

import com.duyun.huishou.housekeeper.mapper.IBaseMapper;
import org.springframework.beans.factory.annotation.Autowired;

public abstract class AbstractBaseService<T> implements IBaseService<T> {
    @Autowired
    private IBaseMapper iBaseMapper;

    @Override
    public int insert(T entity) {
        return iBaseMapper.insert(entity);
    }

    @Override
    public int updateByPrimaryKeySelective(T entity) {
        return iBaseMapper.updateByPrimaryKeySelective(entity);
    }

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return iBaseMapper.deleteByPrimaryKey(id);
    }

    @Override
    public T selectByPrimaryKey(Integer id) {
        return (T)iBaseMapper.selectByPrimaryKey(id);
    }
}
