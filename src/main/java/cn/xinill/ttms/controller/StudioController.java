package cn.xinill.ttms.controller;

import cn.xinill.ttms.common.ServerResponse;
import cn.xinill.ttms.pojo.Studio;
import cn.xinill.ttms.pojo.VOIntegerId;
import cn.xinill.ttms.service.IStudioService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Author: Xinil
 * @Date: 2021/5/8 19:59
 */
@Controller
@RequestMapping(value = "/studio")
public class StudioController {

    private IStudioService studioService;

    @Autowired
    public void setStudioService(IStudioService studioService) {
        this.studioService = studioService;
    }

    @ResponseBody
    @RequestMapping(method = RequestMethod.POST, value = "/insert", produces="application/json;charset=UTF-8")
    public ServerResponse<Boolean> insertStudio(@RequestBody Studio studio){
        try{

            if(studioService.insert(studio)){
                return ServerResponse.createBySuccessMsgData("新增演出厅成功", true);
            }
            return ServerResponse.createByErrorMsgData("新增演出厅失败", false);
        }catch(Exception e){
            e.printStackTrace();
            return ServerResponse.createByErrorMsgData("服务器异常", false);
        }
    }

    @ResponseBody
    @RequestMapping(method = RequestMethod.POST, value = "/modify")
    public ServerResponse<Boolean> modifyStudio(@RequestBody Studio studio){
        try{
            if(studioService.modifyStudio(studio)){
                return ServerResponse.createBySuccessMsgData("修改演出厅成功", true);
            }
            return ServerResponse.createByErrorMsgData("修改演出厅失败", false);
        }catch(Exception e){
            e.printStackTrace();
            return ServerResponse.createByErrorMsgData("服务器异常", false);
        }
    }

    @ResponseBody
    @RequestMapping(method = RequestMethod.GET, value = "/query-list")
    public ServerResponse<List<Studio>> findStudio(){
        try{
            List<Studio> list = studioService.findAllStudio();
            return ServerResponse.createBySuccessMsgData("查询演出厅成功", list);
        }catch(Exception e){
            e.printStackTrace();
            return ServerResponse.createByErrorMsgData("服务器异常", null);
        }
    }

    @ResponseBody
    @RequestMapping(method = RequestMethod.POST, value = "/delete")
    public ServerResponse<Boolean> delete(@RequestBody VOIntegerId studioId){
        try{
            if(studioService.deleteStudio(studioId.getId())){
                return ServerResponse.createBySuccessMsgData("删除演出厅成功", true);
            }else{
                return ServerResponse.createBySuccessMsgData("演出厅不存在", true);
            }
        }catch(Exception e){
            e.printStackTrace();
            return ServerResponse.createByErrorMsgData("服务器异常", null);
        }
    }
}
