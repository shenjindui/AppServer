package com.xingcheng.appserver.utils.util;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.Claim;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.xingcheng.appserver.utils.exception.ExceptionFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

import java.io.UnsupportedEncodingException;
import java.util.*;

@Component
public class JwtTokenUtils {
    //密钥
    public static final String SECRET = "xingchengyuanzhengappserverbysjd;o160225";
    //token过期时间:秒  30分钟
    public static final int EXPIRE = 30*60*60;

    /**
     * 生成Token
     * @param userid
     * @param username
     * @return
     * @throws Exception
     */
    public  String createToken(String userid, String username) {
        Calendar nowTime = Calendar.getInstance();
        nowTime.add(Calendar.SECOND, EXPIRE);
        Date expireDate = nowTime.getTime();

        Map<String, Object> map = new HashMap<>();
        map.put("algorithm", "HS256");
        map.put("type", "JWT");

        String token = null;//签名
        try {
            token = JWT.create()
                    .withHeader(map)//头
                    .withClaim("userid", userid)
                    .withClaim("username", username)
                    .withSubject("星程远征appserver")//
                    .withIssuedAt(new Date())//签名时间
                    .withExpiresAt(expireDate)//过期时间
                    .sign(Algorithm.HMAC256(SECRET));
        } catch (UnsupportedEncodingException e) {
            throw ExceptionFactory.getBizException("Token创建失败");
        }
        return token;
    }

    /**
     * 验证Token
     * @param token
     * @return
     * @throws Exception
     */
    public  Map<String, Claim> verifyToken(String token){
        JWTVerifier verifier =null;
        DecodedJWT jwt = null;
        try {
            verifier =JWT.require(Algorithm.HMAC256(SECRET)).build();
            jwt = verifier.verify(token);
        }catch (Exception e){
            throw ExceptionFactory.getBizException("凭证已过期，请重新登录",token);
        }
        return jwt.getClaims();
    }

    /**
     * 解析Token
     * @param token
     * @return
     */
    public  Map<String, Claim> parseToken(String token){
        DecodedJWT decodedJWT = JWT.decode(token);
        return decodedJWT.getClaims();
    }


    public static void main(String[] args) {
        JwtTokenUtils JwtTokenUtils =new JwtTokenUtils();
        try {
            String token = "";
            System.out.println("token=" + token);
            String text="eyJ0eXAiOiJKV1QiLCJ0eXBlIjoiSldUIiwiYWxnIjoiSFMyNTYiLCJhbGdvcml0aG0iOiJIUzI1NiJ9.eyJzdWIiOiLmmJ_nqIvov5zlvoFhcHBzZXJ2ZXIiLCJleHAiOjE1OTYyMjI3NzEsInVzZXJpZCI6IjEiLCJpYXQiOjE1OTYxMTQ3NzEsInVzZXJuYW1lIjoic2hlbmppbmR1aSJ9.23hMIvx445T26xkec5GKjkd1R5rUc1IHfiU5GwYWs2I";
            Map<String, Claim> map = JwtTokenUtils.verifyToken(text);//验证Token
            //遍历
            for (Map.Entry<String, Claim> entry : map.entrySet()) {
                if (entry.getValue().asString() != null) {
                    System.out.println(entry.getKey() + "===" + entry.getValue().asString());
                } else {
                    System.out.println(entry.getKey() + "===" + entry.getValue().asDate());
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
