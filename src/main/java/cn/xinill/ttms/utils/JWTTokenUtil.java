package cn.xinill.ttms.utils;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.Claim;
import com.auth0.jwt.interfaces.DecodedJWT;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * 生成Token的工具类
 */
public class JWTTokenUtil {
    //设置过期时间
    private static final long EXPIRE_DATE=24*60*60*1000; //24小时过期
    //token秘钥
    private static final String TOKEN_SECRET = "uGuwu2020xinillBhuZCfasfaUUHufgQWE";

    /**
     * 生成token
     * @param userId
     * @return
     */
    public static String createToken(int userId){
        String token;
        try {
            //过期时间
            Date date = new Date(System.currentTimeMillis()+EXPIRE_DATE);
            //秘钥及加密算法
            Algorithm algorithm = Algorithm.HMAC256(TOKEN_SECRET);
            //设置头部信息
            Map<String,Object> header = new HashMap<>();
            header.put("typ","JWT");
            header.put("alg","HS256");

            //携带userId信息，生成签名
            token = JWT.create()
                    //添加头部信息
                    .withHeader(header)
                    .withClaim("userId",userId)
                    //设置过期时间
                    .withExpiresAt(date)
                    //秘钥及加密算法
                    .sign(algorithm);
        }catch (Exception e){
            e.printStackTrace();
            return  null;
        }
        return token;
    }

    /**
     * 验证token
     * @param token
     * @return
     */
    public static Map<String, Claim> verifyToken(String token){
        try {
            Algorithm algorithm = Algorithm.HMAC256(TOKEN_SECRET);
            JWTVerifier verifier = JWT.require(algorithm).build();
            DecodedJWT jwt = verifier.verify(token);
            return jwt.getClaims();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("token验证失败————token = " + token);
        }
        return null;
    }
}