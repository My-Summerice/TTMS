package cn.xinill.ttms.mapper;

import cn.xinill.ttms.pojo.Studio;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @Author: Xinil
 * @Date: 2021/5/8 20:00
 */
@Mapper
public interface IStudioMapper {

    /**
     * 添加影厅信息
     */
    int insert(String name, int row, int col);

    /**
     * 获取根据影厅名称获取影厅id
     */
    int findIdByName(String name);

    /**
     * 根据影厅id 删除影厅
     */
    int deleteByStudioId(int studioId);

    /**
     * 查询所有演出厅信息
     */
    List<Studio> findAllStudio();

    /**
     * 修改影厅信息
     */
    int modifyStudio(Studio studio);
}
