package cn.xinill.ttms.controller;

import cn.xinill.ttms.common.ServerResponse;
import cn.xinill.ttms.pojo.VOIntegerId;
import cn.xinill.ttms.pojo.VOMovie;
import cn.xinill.ttms.pojo.VOMovieList;
import cn.xinill.ttms.service.IMovieService;
import cn.xinill.ttms.utils.ImgException;
import cn.xinill.ttms.utils.OSSClientUtil;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

/**
 * @Author: Xinil
 * @Date: 2021/4/8 21:07
 */
@Controller
@RequestMapping(value = "/movie")
public class MovieController {

    private IMovieService movieService;

    private OSSClientUtil ossClientUtil;

    @Autowired
    public void setMovieService(IMovieService movieService) {
        this.movieService = movieService;
    }

    @Autowired
    public void setOssClientUtil(OSSClientUtil ossClientUtil) {
        this.ossClientUtil = ossClientUtil;
    }


    @ResponseBody
    @RequestMapping(method = RequestMethod.POST, value = "/upload-cover")
    public ServerResponse<String> insertMovie(@RequestParam MultipartFile cover){
        try {
            String usrlFileName = ossClientUtil.uploadImg2Oss(cover);
            return ServerResponse.createBySuccessMsgData("上传图片成功", usrlFileName);
        } catch (ImgException e) {
            e.printStackTrace();
            return ServerResponse.createByErrorMsg("服务器异常");
        }
    }


    @ResponseBody
    @RequestMapping(method = RequestMethod.POST, value = "/insert")
    public ServerResponse<Boolean> insertMovie(@RequestBody VOMovie voMovie){
        try {
            if(movieService.insertMovie(voMovie) == 1){
                return ServerResponse.createBySuccessMsgData("成功添加",true);
            }else{
                return ServerResponse.createByErrorMsgData("添加失败", false);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return ServerResponse.createByErrorMsgData("服务器繁忙", false);
        }
    }



    @ResponseBody
    @RequestMapping(method = RequestMethod.GET, value = "/getList")
    public ServerResponse<VOMovieList> getMovieList(@RequestParam String sortType,
                                                    @RequestParam String sortRule,
                                                    @RequestParam int page,
                                                    @RequestParam int pageLimit){

        try {
            if(!sortType.equals("title") && !sortType.equals("releaseDate") && !sortType.equals("rate")){
                return ServerResponse.createByErrorMsg("排序参数不合法");
            }

            if(sortRule.equals("down")){
                sortRule = "DESC";
            }else{
                sortRule = "ASC";
            }

            int start = (page-1)*pageLimit;
            int len = pageLimit;

            VOMovieList movieList = movieService.getMovieList(sortType, sortRule, start, len);
            return ServerResponse.createBySuccessMsgData("查询电影成功",movieList);
        } catch (Exception e) {
            e.printStackTrace();
            return ServerResponse.createByErrorMsgData("服务器繁忙", null);
        }
    }


    @ResponseBody
    @RequestMapping(method = RequestMethod.GET, value = "/getMovie")
    public ServerResponse<VOMovie> getMovie(@RequestBody Integer id){
        try {
            VOMovie movie = movieService.getMovie(id);
            return ServerResponse.createBySuccessMsgData("查询电影成功", movie);
        } catch (Exception e) {
            e.printStackTrace();
            return ServerResponse.createByErrorMsgData("服务器繁忙", null);
        }
    }

    @ResponseBody
    @RequestMapping(method = RequestMethod.POST, value = "/delete")
    public ServerResponse<Boolean> deleteMovie(@RequestBody VOIntegerId voInteger){
        try {
            if(movieService.deleteMovie(voInteger.getId())){
                return ServerResponse.createBySuccessMsgData("电影删除成功", true);
            }
            return ServerResponse.createBySuccessMsgData("电影不存在", true);
        } catch (Exception e) {
            e.printStackTrace();
            return ServerResponse.createByErrorMsgData("服务器繁忙", false);
        }
    }
}
