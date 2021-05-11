package cn.xinill.ttms.pojo;

/**
 * @Author: Xinil
 * @Date: 2021/5/9 15:41
 */
public class Seat {
    private Integer seatId;
    private Integer studioId;
    private Integer row;
    private Integer col;
    private Integer status;

    public Seat() {
    }

    public Integer getSeatId() {
        return seatId;
    }

    public void setSeatId(Integer seatId) {
        this.seatId = seatId;
    }

    public Integer getStudioId() {
        return studioId;
    }

    public void setStudioId(Integer studioId) {
        this.studioId = studioId;
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

    @Override
    public String toString() {
        return "Seat{" +
                "seatId=" + seatId +
                ", studioId=" + studioId +
                ", row=" + row +
                ", col=" + col +
                ", status=" + status +
                '}';
    }
}
