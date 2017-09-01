package com.fuhuadata.outworker.jwt;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.apache.commons.lang3.StringUtils;

import javax.annotation.PostConstruct;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.KeySpec;
import java.util.Date;

/**
 * <p>User: wangjie
 * <p>Date: 7/24/2017
 */
public class JwtService {

    private String secret;

    private SecretKey secretKey = null;

    public void setSecret(String secret) {
        this.secret = secret;
    }

    public String getSecret() {
        return secret;
    }

    public SecretKey generateKey() {

        if (secretKey != null) {
            return secretKey;
        }

        insureSecret();

        try {
            KeySpec keySpec = new DESKeySpec(secret.getBytes());
            secretKey = SecretKeyFactory.getInstance("DES").generateSecret(keySpec);
            return secretKey;
        } catch (InvalidKeyException | NoSuchAlgorithmException | InvalidKeySpecException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 生成 jwt
     * @param id
     * @param subject
     * @param ttlMillis
     * @return
     */
    public String generateJwt(String id, String subject, long ttlMillis) {

        SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.HS512;

        long nowMillis = System.currentTimeMillis();
        Date now = new Date(nowMillis);

        SecretKey key = generateKey();
        JwtBuilder builder = Jwts.builder()
                .setId(id)
                .setIssuedAt(now)
                .setSubject(subject)
                .signWith(signatureAlgorithm, key);

        if (ttlMillis >= 0) {
            long expMillis = nowMillis + ttlMillis;
            Date exp = new Date(expMillis);
            builder.setExpiration(exp);
        }

        return builder.compact();
    }

    /**
     * 解析 jwt
     * @param jwt
     * @return
     * @throws Exception
     */
    public Claims parseJwt(String jwt) throws Exception {
        return Jwts.parser()
                .setSigningKey(generateKey())
                .parseClaimsJws(jwt)
                .getBody();
    }

    @PostConstruct
    private void insureSecret() {

        if (StringUtils.isEmpty(this.secret)) {
            throw new IllegalArgumentException("jwt密钥不能为空");
        }
    }
}
