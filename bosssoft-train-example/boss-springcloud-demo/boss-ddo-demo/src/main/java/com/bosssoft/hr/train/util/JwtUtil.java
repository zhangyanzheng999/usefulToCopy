package com.bosssoft.hr.train.util;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import lombok.extern.slf4j.Slf4j;

import java.util.Date;
import java.util.HashMap;

/**
 * @description:
 * @author:zyz
 * @time:2020/6/17-12:19
 */
@Slf4j
public class JwtUtil {
    //过期时间
    private static final long EXPIRE_TIME = 15 * 60 * 1000L;
    //私钥
    private static final String TOKEN_SECRET = "privateKey";

    /**
     * 生成token，15分钟过期
     *
     * @param userId
     * @return
     */
    public static String sign(Long userId) {
        try {
            //设置过期时间
            Date date = new Date(System.currentTimeMillis() + EXPIRE_TIME);
            //私钥和加密算法
            Algorithm algorithm = Algorithm.HMAC256(TOKEN_SECRET);
            //设置头部信息
            HashMap<String, Object> header = new HashMap<>(2);
            header.put("typ", "jwt");
            header.put("alg", "HS256");
            //返回token字符串
            return JWT.create()
                    .withHeader(header)
                    .withClaim("userId", userId)
                    .withExpiresAt(date)
                    .sign(algorithm);
        } catch (Exception e) {
            log.error("发生了错误{}", e);
            return null;
        }
    }

    /**
     * 验证token是否正确
     *
     * @param token
     * @return
     */
    public static Long verify(String token) {
        try {
            Algorithm algorithm = Algorithm.HMAC256(TOKEN_SECRET);
            JWTVerifier verifier = JWT.require(algorithm).build();
            DecodedJWT jwt = verifier.verify(token);

            return jwt.getClaim("userId").asLong();
        } catch (Exception e) {
            return 0L;
        }
    }

    public static void main(String[] args) {
        sign(12345L);
    }
}
