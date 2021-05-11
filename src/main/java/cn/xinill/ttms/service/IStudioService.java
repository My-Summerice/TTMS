package cn.xinill.ttms.service;

import cn.xinill.ttms.pojo.Studio;

import java.util.List;

/**
 * @Author: Xinil
 * @Date: 2021/5/8 20:00
 */
public interface IStudioService {

    /**
     * 新增演出厅
     * @param studio
     * @return
     */
    boolean insert(Studio studio);


    /**
     * 修改演出厅
     * @param studio
     * @return
     */
    boolean modifyStudio(Studio studio);

    /**
     * 删除演出厅信息
     * @param studioId
     * @return
     */
    boolean deleteStudio(int studioId);

    /**
     * 查询所有演出厅信息
     * @return
     */
    List<Studio> findAllStudio();
}
