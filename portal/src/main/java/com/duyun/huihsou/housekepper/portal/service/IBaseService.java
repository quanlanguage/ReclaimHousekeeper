package com.duyun.huihsou.housekepper.portal.service;


/**
 * @author albert
 * @package com.xianduankeji.ktv.portal.service
 * @email cn.lu.duke@gmail.com
 * @date January 10, 2018
 */
public interface IBaseService<T> {

    int insertPo(T entity);

    int updatePo(T entity);

    int deletePo(T entity);

    T selectPo(T entity);
}
