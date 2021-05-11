package cn.xinill.ttms.service;

import cn.xinill.ttms.pojo.VOMovie;
import cn.xinill.ttms.pojo.VOMovieList;

/**
 * @Author: Xinil
 * @Date: 2021/4/8 20:55
 */
public interface IMovieService {
    /**
     * 添加电影信息
     * @param voMovie
     * @return
     */
    int insertMovie(VOMovie voMovie);

    /**
     * 查询电影列表
     * @param sortType
     * @param sortRule
     * @param start
     * @param len
     * @return
     */
    VOMovieList getMovieList(String sortType, String sortRule, int start, int len);

    /**
     * 查询电影详细信息
     * @param mid
     * @return
     */
    VOMovie getMovie(int mid);

    /**
     * 删除指定电影
     * @param mid
     * @return
     */
    boolean deleteMovie(int mid);
}
