package cn.xinill.ttms.mapper;

import cn.xinill.ttms.pojo.Movie;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @Author: Xinil
 * @Date: 2021/4/8 20:51
 */
@Mapper
public interface IMovieMapper {

    /**
     * 统计在映电影个数
     */
    int countMovie();

    /**
     * 新增电影信息
     */
    int insertMovie(Movie movie);

    /**
     * 获取电影列表
     */
    List<Movie> getMovieList(String sortType, String sortRule, int start, int len);

    /**
     * 查询电影详细信息
     */
    Movie getMovie(int mid);

    /**
     * 删除电影信息
     */
    int deleteMovie(int mid);
}
