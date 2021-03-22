package com.mju.zjj.auth.utils;


import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
//import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Value;

import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.util.Base64;
import java.util.Date;


/**
 * @author Lolo
 */

public class JwtUtil implements IJwtUtil {
    //过期时间
    @Value("${config.jwt.expire}")
    private Long EXPIRE_TIME;
 
    //密钥
    @Value("${config.jwt.secret}")
    private String SECRET;

    @Override
    public String createToken (Integer userId){
        Date nowDate = new Date();
        Date expireDate = new Date(nowDate.getTime() + EXPIRE_TIME);
 
        // 可添加自定义私有的payload的key-value。若与已有的重名会覆盖
        // Map<String, String> claims = new HashMap();
        // claims.put("key1", "value1");
 
        return Jwts.builder()
                .setAudience(userId.toString())
                .setIssuedAt(nowDate)
                .setExpiration(expireDate)
                // .setClaims(claims)
                .signWith(SignatureAlgorithm.HS512, generalKey())
                .compact();
    }

    @Override
    public Integer getUserIdByToken(String token) {
        return Integer.valueOf(getTokenClaim(token).getAudience());
    }

    @Override
    public String getUserNameByToken(String token) {
        return getTokenClaim(token).getSubject();
    }
 
    @Override
    public boolean verifyToken(String token) {
        try {
            Jwts.parser().setSigningKey(generalKey()).parseClaimsJws(token);
            return true;
        }catch (Exception e){
            return false;
        }
    }

    private Claims getTokenClaim (String token) {
        try {
            return Jwts.parser().setSigningKey(generalKey()).parseClaimsJws(token).getBody();
        }catch (Exception e){
            return null;
        }
    }

    public SecretKey generalKey(){
        byte[] encodedKey = Base64.getDecoder().decode(SECRET);
        return new SecretKeySpec(encodedKey, 0, encodedKey.length, "AES");
    }
}