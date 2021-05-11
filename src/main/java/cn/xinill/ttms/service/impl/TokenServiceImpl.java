package cn.xinill.ttms.service.impl;

import cn.xinill.ttms.service.ITokenService;
import cn.xinill.ttms.utils.JWTTokenUtil;
import cn.xinill.ttms.utils.RedisUtil;
import com.auth0.jwt.interfaces.Claim;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.Random;

/**
 * @Author: Xinil
 * @Date: 2021/5/9 16:43
 */
@Service
public class TokenServiceImpl implements ITokenService {


    private static RedisUtil redisUtil;

    @Autowired
    public void setRedisUtil(RedisUtil redisUtil) {
        TokenServiceImpl.redisUtil = redisUtil;
    }

    @Override
    public String creatUserToken(int id) {
        String token = JWTTokenUtil.createToken(id);
        token = token + System.currentTimeMillis() + (new Random().nextInt(899999)+100000);
        if(redisUtil.set(""+id, token, -1)){
            return token;
        }else{
            return null;
        }
    }

    @Override
    public int verifyUserToken(String token) {
        try {
            //token解密id，是否过期。
            Map<String, Claim> map = JWTTokenUtil.verifyToken(token);
            if(map == null){
                return -1;
            }
            int empId = map.get("userId").asInt();


            //通过id查找token，查看是否被覆盖。
            Object value = redisUtil.get(""+empId);
            if(value.equals(token)){
                return empId;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
        return -1;
    }
}
