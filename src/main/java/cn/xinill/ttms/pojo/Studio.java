package cn.xinill.ttms.pojo;

import java.util.Arrays;

/**
 * @Author: Xinil
 * @Date: 2021/5/8 19:49
 */
public class Studio {
    private Integer id;
    private String name;
    private Integer row;
    private Integer col;
    private Integer status;
    private Integer[][] seatStatus;

    public Studio() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getRow() {
        return row;
    }

    public void setRow(Integer row) {
        this.row = row;
    }

    public Integer getCol() {
        return col;
    }

    public void setCol(Integer col) {
        this.col = col;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer[][] getSeatStatus() {
        return seatStatus;
    }

    public void setSeatStatus(Integer[][] seatStatus) {
        this.seatStatus = seatStatus;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Studio{" + "id=")
                .append(id)
                .append(", name='")
                .append(name)
                .append('\'')
                .append(", row=")
                .append(row)
                .append(", col=")
                .append(col)
                .append(", status=")
                .append(status);
        for(Integer[] integers: seatStatus){
            sb.append(Arrays.toString(integers));
        }
        sb.append('}');
        return sb.toString();
    }
}
