package cn.xinill.ttms.pojo;

import java.util.List;

/**
 * @Author: Xinil
 * @Date: 2021/4/14 16:55
 */
public class VOMovieList {
    Integer sum;
    List<VOMovie> dataSource;

    public VOMovieList() {
    }

    public Integer getSum() {
        return sum;
    }

    public void setSum(Integer sum) {
        this.sum = sum;
    }

    public List<VOMovie> getDataSource() {
        return dataSource;
    }

    public void setDataSource(List<VOMovie> dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public String toString() {
        return "VOMovieList{" +
                "sum=" + sum +
                ", dataSource=" + dataSource +
                '}';
    }
}
