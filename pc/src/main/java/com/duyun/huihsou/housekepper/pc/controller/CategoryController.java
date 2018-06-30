package com.duyun.huihsou.housekepper.pc.controller;

import com.alibaba.fastjson.JSON;
import com.duyun.huihsou.housekepper.pc.service.category.CategoryService;
import com.duyun.huishou.housekeeper.ApiResponse;
import com.duyun.huishou.housekeeper.constants.RetCode;
import com.duyun.huishou.housekeeper.po.BannerConfigEntity;
import com.duyun.huishou.housekeeper.po.CategoryEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author haoshijing
 * @version 2018年05月23日 20:54
 **/

@RestController
@RequestMapping("/pc/portal/category")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @RequestMapping(value = "/getCateorylist", method = RequestMethod.GET, produces="application/json")
    public Object getList(Integer parent_id,Integer start,Integer size) {
        try{
            Map map= new HashMap();
            map.put("parent_id",parent_id);
            map.put("start",start);
            Integer parent_idCount=categoryService.getCountFromParent(parent_id);
            if (size <= -1){
                size=parent_idCount;
            }
            map.put("size",size=size<=parent_idCount?size:parent_idCount);

            return  JSON.toJSON(new ApiResponse(categoryService.getCategoryList(map)));
        }catch(Exception e) {
            //System.out.println("异常信息为："+e.getMessage());
            return JSON.toJSON(new ApiResponse(RetCode.NOT_FOUND,"请求失败或没有数据"));
        }
    }

    @RequestMapping(value = "/InsterOneCateory", method = RequestMethod.GET, produces="application/json")
    public Object InsterOneCateory(@RequestBody CategoryEntity categoryEntity) {
        try {
            if (categoryService.insert(categoryEntity) == 1) {
                return JSON.toJSON(new ApiResponse(RetCode.OK, "插入数据成功"));
            } else {
                return JSON.toJSON(new ApiResponse(RetCode.NOT_FOUND, "请求插入数据失败"));
            }
        }catch(Exception e) {
            //System.out.println("异常信息为："+e.getMessage());
            return JSON.toJSON(new ApiResponse(RetCode.NOT_FOUND,"请求失败或没有数据"));
        }
    }


    @RequestMapping(value = "/updateCateory", method = RequestMethod.POST, produces="application/json")
    public Object updateBanner(@RequestBody CategoryEntity categoryEntity){
        try {
            if (categoryService.updateByPrimaryKeySelective(categoryEntity) == 1) {
                return JSON.toJSON(new ApiResponse(RetCode.OK, "更新数据成功"));
            } else {
                return JSON.toJSON(new ApiResponse(RetCode.NOT_FOUND, "更新数据失败"));
            }
        }catch(Exception e) {
            //System.out.println("异常信息为："+e.getMessage());
            return JSON.toJSON(new ApiResponse(RetCode.NOT_FOUND,"请求失败或没有数据"));
        }
    }


    @RequestMapping(value = "/delectCateorybyid", method = RequestMethod.GET, produces="application/json")
    public Object delectbanner(Integer id){
        try {
            if (categoryService.deleteByPrimaryKey(id) == 1) {
                return JSON.toJSON(new ApiResponse(RetCode.OK, "删除数据成功"));
            } else {
                return JSON.toJSON(new ApiResponse(RetCode.NOT_FOUND, "删除数据失败"));
            }
        } catch (Exception e){
            return JSON.toJSON(new ApiResponse(RetCode.NOT_FOUND, "请求数据格式错误"));
        }
    }








}
