package com.duyun.huihsou.housekepper.pc.controller;

import com.alibaba.fastjson.JSON;
import com.duyun.huihsou.housekepper.pc.service.banner.BannerConfigService;
import com.duyun.huishou.housekeeper.ApiResponse;
import com.duyun.huishou.housekeeper.constants.RetCode;
import com.duyun.huishou.housekeeper.po.BannerConfigEntity;
import com.duyun.huishou.housekeeper.po.CategoryEntity;
import com.duyun.huishou.housekeeper.po.OrderEntity;
import com.duyun.huishou.housekeeper.po.ProblemEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/pc/portal/banner")
public class BannerConfigController {

    @Autowired
    private BannerConfigService bannerConfigService;

    @RequestMapping(value = "/list", method = RequestMethod.POST, produces="application/json")
    public Object getList(@RequestBody BannerConfigEntity entity) {
        try {
            return JSON.toJSON(new ApiResponse(bannerConfigService.getBannerConfigByConfition(entity)));
        }catch(Exception e) {
            //System.out.println("异常信息为："+e.getMessage());
            return JSON.toJSON(new ApiResponse(RetCode.NOT_FOUND,"请求失败或没有数据"));
        }

    }


    @RequestMapping(value = "/getlist", method = RequestMethod.GET, produces="application/json")
    public Object getlist(
           Integer status,
           Integer channel,
           Integer start ,
           Integer size
    ) {
        try {
            Map map= new HashMap();
            if (status >2 || status <1){
                status=1;
            }
            map.put("status",status);
            if (channel <0 || channel >1){
                channel=1;
            }
            map.put("channel",channel);
            map.put("start",start);
            Integer problomCount=bannerConfigService.getCountbanner();
            map.put("size",size = size<= problomCount?size:problomCount);
            return JSON.toJSON(new ApiResponse(bannerConfigService.selectItem(map)));
        }catch(Exception e) {
            //System.out.println("异常信息为："+e.getMessage());
            return JSON.toJSON(new ApiResponse(RetCode.NOT_FOUND,"请求失败或没有数据"));
        }

    }

    @RequestMapping(value = "/delectbanner", method = RequestMethod.GET, produces="application/json")
    public Object delectbanner(Integer id){
        try {
            if (bannerConfigService.delectOneBanprom(id) == 1) {
                return JSON.toJSON(new ApiResponse(RetCode.OK, "删除数据成功"));
            } else {
                return JSON.toJSON(new ApiResponse(RetCode.NOT_FOUND, "删除数据失败"));
            }
        } catch (Exception e){
            return JSON.toJSON(new ApiResponse(RetCode.NOT_FOUND, "请求数据格式错误"));
        }
    }


    @RequestMapping(value = "/insertBanner", method = RequestMethod.POST, produces="application/json")
    public Object insertBanner(@RequestBody BannerConfigEntity bannerConfig){
        try {
            if (bannerConfigService.insert(bannerConfig) == 1) {
                return JSON.toJSON(new ApiResponse(RetCode.OK, "插入数据成功"));
            } else {
                return JSON.toJSON(new ApiResponse(RetCode.NOT_FOUND, "请求插入数据失败"));
            }
        } catch (Exception e){
            return JSON.toJSON(new ApiResponse(RetCode.NOT_FOUND, "POSt请求数据格式错误"));
        }
    }


    @RequestMapping(value = "/updateBanner", method = RequestMethod.POST, produces="application/json")
    public Object updateBanner(@RequestBody BannerConfigEntity bannerConfig){
        try {
            if (bannerConfigService.updateByPrimaryKeySelective(bannerConfig) == 1) {
                return JSON.toJSON(new ApiResponse(RetCode.OK, "更新数据成功"));
            } else {
                return JSON.toJSON(new ApiResponse(RetCode.NOT_FOUND, "更新数据失败"));
            }
        } catch (Exception e){
            return JSON.toJSON(new ApiResponse(RetCode.NOT_FOUND, "POSt请求数据格式错误"));
        }
    }

}
