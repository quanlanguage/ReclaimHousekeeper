package com.duyun.huihsou.housekepper.admin.controller.category;

import com.duyun.huihsou.housekepper.admin.inteceptor.VisitorAccessible;
import com.duyun.huihsou.housekepper.admin.service.category.CategoryService;
import com.duyun.huihsou.housekepper.admin.vo.CategoryVO;
import com.duyun.huishou.housekeeper.ApiResponse;
import com.duyun.huishou.housekeeper.constants.RetCode;
import com.duyun.huishou.housekeeper.po.CategoryEntity;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author haoshijing
 * @version 2018年05月08日 21:13
 **/
@RestController
@RequestMapping("/h5/api/category")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @VisitorAccessible
    @RequestMapping(value = "/list", method = RequestMethod.POST, produces="application/json")
    public ApiResponse<List<CategoryEntity>> getList(@RequestBody Map<String, Object> map) {
        Integer parentId = (Integer) map.get("parentId");
        if (parentId==null) {
            return  new ApiResponse(RetCode.ERROR_PARAMS, "必填参数不能为空！");
        }
        List<CategoryEntity> listEntity = categoryService.getCategoryByParentId(parentId);
        List<CategoryVO> list = new ArrayList<>();
        listEntity.forEach(obj->{
            CategoryVO vo = new CategoryVO();
            BeanUtils.copyProperties(obj,vo);
            list.add(vo);
        });
        return new ApiResponse(list);
    }
}
