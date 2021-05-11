package cn.xinill.ttms.service.impl;

import cn.xinill.ttms.mapper.ISeatMapper;
import cn.xinill.ttms.mapper.IStudioMapper;
import cn.xinill.ttms.pojo.Seat;
import cn.xinill.ttms.pojo.Studio;
import cn.xinill.ttms.service.IStudioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: Xinil
 * @Date: 2021/5/8 20:01
 */
@Service
public class StudioServiceImpl implements IStudioService {

    private IStudioMapper studioMapper;
    private ISeatMapper seatMapper;

    @Autowired(required = false)
    public void setStudioMapper(IStudioMapper studioMapper) {
        this.studioMapper = studioMapper;
    }

    @Autowired(required = false)
    public void setSeatMapper(ISeatMapper seatMapper) {
        this.seatMapper = seatMapper;
    }

    @Override
    public boolean insert(Studio studio) {
        System.out.println("[新增演出厅信息]："+studio);
        studioMapper.insert(studio.getName(), studio.getRow(), studio.getCol());

        int studioId = studioMapper.findIdByName(studio.getName());
        addStudioSeat(studioId, studio.getSeatStatus());
        return true;
    }

    @Override
    public boolean modifyStudio(Studio studio) {
        studioMapper.modifyStudio(studio);
        seatMapper.deleteByStudioId(studio.getId());
        addStudioSeat(studio.getId(), studio.getSeatStatus());
        return true;
    }

    @Override
    public boolean deleteStudio(int studioId) {
        studioMapper.deleteByStudioId(studioId);
        seatMapper.deleteByStudioId(studioId);
        return true;
    }

    @Override
    public List<Studio> findAllStudio() {
        List<Studio> list = studioMapper.findAllStudio();
        for(Studio studio: list){

            Integer[][] status = new Integer[studio.getRow()+1][studio.getCol()+1];

            List<Seat> seats = findSeatListByStudioId(studio.getId());
            for(Seat seat: seats){
                status[seat.getRow()][seat.getCol()] = seat.getStatus();
            }

            studio.setSeatStatus(status);
        }
        return list;
    }

    /**
     * 根据影厅 id 查找座位。
     */
    public List<Seat> findSeatListByStudioId(int studioId){
        return seatMapper.findSeatListByStudioId(studioId);
    }

    /**
     * 根据影厅和座位二维数组，添加座位
     */
    public boolean addStudioSeat(Integer studioId, Integer[][] seatStatus){
        for(int i=1; i<seatStatus.length; ++i){
            for(int j=1; j<seatStatus[0].length; ++j){
                if(1 != seatMapper.insert(studioId, i, j, seatStatus[i][j])){
                    System.out.println("[影厅id:"+studioId+"]: 第"+i+"行第"+j+"列添加座位失败");
                }
            }
        }
        return true;
    }
}
