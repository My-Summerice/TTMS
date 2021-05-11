package cn.xinill.ttms.service;

/**
 * @Author: Xinil
 * @Date: 2021/5/9 16:43
 */
public interface ITokenService {
    /**
     * 由id生成token
     * @param id
     * @return
     */
    String creatUserToken(int id);

    /**
     * 由token转为id
     * @param token
     * @return
     */
    int verifyUserToken(String token);
}
