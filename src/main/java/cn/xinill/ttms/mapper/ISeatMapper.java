package cn.xinill.ttms.mapper;

import cn.xinill.ttms.pojo.Seat;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @Author: Xinil
 * @Date: 2021/5/8 20:20
 */
@Mapper
public interface ISeatMapper {

    /**
     * 添加座位信息
     */
    int insert(int studioId, int row, int col, int status);

    /**
     * 删除影厅所有座位
     */
    int deleteByStudioId(int studioId);

    /**
     * 查询影厅所有座位
     */
    List<Seat> findSeatListByStudioId(int studioId);
}
