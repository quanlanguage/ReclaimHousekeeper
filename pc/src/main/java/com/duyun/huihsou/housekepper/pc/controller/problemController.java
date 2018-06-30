package com.duyun.huihsou.housekepper.pc.controller;



import com.alibaba.fastjson.JSON;
import com.duyun.huihsou.housekepper.pc.service.problem.ProblemService;
import com.duyun.huihsou.housekepper.pc.tool.HTMLSpirit;
import com.duyun.huishou.housekeeper.ApiResponse;
import com.duyun.huishou.housekeeper.constants.RetCode;
import com.duyun.huishou.housekeeper.po.ProblemEntity;
import com.duyun.huishou.housekeeper.po.problem.problemItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/pc/portal/problem")
public class problemController {
    @Autowired
    private ProblemService problemService;

    @RequestMapping(value = "/getproblem", method = RequestMethod.GET)
    public Object getNewShowlist(Integer id) {
        try {
          return JSON.toJSON(new ApiResponse<>(problemService.delectOneByProble(id)));
        }catch(Exception e) {
            //System.out.println("异常信息为："+e.getMessage());
            return JSON.toJSON(new ApiResponse(RetCode.NOT_FOUND,"请求失败或没有数据"));
        }
    }

    @RequestMapping(value = "/getAllproblem", method = RequestMethod.GET)
    public Object getAllProblem(Integer start,Integer newsPageSize,Integer cutoutLength){

        try {
            Map map = new HashMap();
            map.put("start", start <= 0 ? 0 : start);
            map.put("size", newsPageSize < 0 ? 10 : newsPageSize);
            //得到所有的
            List<problemItem> problemItemList=problemService.getAllProblem(map);
            if (cutoutLength != -1){
                int size = problemItemList.size();
                for(int i=0;i<size;i++){
                    //截取字符串
                    problemItemList.get(i).setAnswer(HTMLSpirit.delHTMLTag(problemItemList.get(i).getAnswer(),cutoutLength));
                }
            }
            //获取所有的页面
            Integer pageNumber= problemService.getCountProblem();
            HashMap reMap=new HashMap();
            // 页数
            reMap.put("PageNumber",pageNumber%newsPageSize>0?pageNumber/newsPageSize +1 :pageNumber/newsPageSize);
            reMap.put("list",problemItemList);
            return JSON.toJSON(new  ApiResponse(reMap));
        }
        catch(Exception e) {
            //System.out.println("异常信息为："+e.getMessage());
            return JSON.toJSON(new ApiResponse(RetCode.NOT_FOUND,"请求失败或没有数据"));
        }
    }

    @RequestMapping(value = "/getAllproblem", method = RequestMethod.POST)
    public Object instertOneProble(String name,
                                   String answer,
                                   Long insertTime){
        try {
            if (problemService.insert(new ProblemEntity(name, answer, insertTime, insertTime)) == 1) {
                return JSON.toJSON(new ApiResponse(RetCode.OK, "插入数据成功"));
            } else {
                return JSON.toJSON(new ApiResponse(RetCode.NOT_FOUND, "请求插入数据失败"));
            }
        } catch (Exception e){
            return JSON.toJSON(new ApiResponse(RetCode.NOT_FOUND, "POSt请求数据格式错误"));
        }
    }

    @RequestMapping(value = "/updateProblem", method = RequestMethod.POST)
    public Object updateProblem(            Integer id,
                                            String name,
                                             String answer,
                                            Long lastUpdateTime){
        try{
            Map map= new HashMap();
            map.put("id",id);
            map.put("name",name =name.equals(null)?"":name);
            map.put("answer",answer=answer.equals(null)?"":answer);
            map.put("lastUpdateTime",lastUpdateTime=lastUpdateTime.equals(null)?0:lastUpdateTime);
            if (problemService.updateProble(map)==1){
                return JSON.toJSON(new ApiResponse(RetCode.OK, "更新数据成功"));
            } else {
                return JSON.toJSON(new ApiResponse(RetCode.NOT_FOUND, "更新数据失败"));
            }
        } catch (Exception e){
            return JSON.toJSON(new ApiResponse(RetCode.NOT_FOUND, "更新数据格式错误"));
        }
    }

    @RequestMapping(value = "/delectprobleById", method = RequestMethod.POST)
    public Object delectprobleById(Integer id){
        try {
            if (problemService.delectOneByProble(id) == 1) {
                return JSON.toJSON(new ApiResponse(RetCode.OK, "删除数据成功"));
            } else {
                return JSON.toJSON(new ApiResponse(RetCode.NOT_FOUND, "删除数据失败"));
            }
        } catch (Exception e){
            return JSON.toJSON(new ApiResponse(RetCode.NOT_FOUND, "请求数据格式错误"));
        }
    }

}
