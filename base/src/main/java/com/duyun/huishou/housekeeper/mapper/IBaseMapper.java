package com.duyun.huishou.housekeeper.mapper;



import org.apache.ibatis.annotations.Mapper;

/**
 * @author haoshijing
 * @version 2018年01月09日 17:33
 **/

@Mapper
public interface IBaseMapper<T>{

    int insertPo(T entity);

    int updatePo(T entity);

    int deletePo(T entity);

    T selectPo(T entity);

    T selectById(Integer id);

    /**
     * 确认提交提现终态
     * tans：status=2 -> status=3
     * @param entity
     * @return
     */
    int submit(T entity);

}
