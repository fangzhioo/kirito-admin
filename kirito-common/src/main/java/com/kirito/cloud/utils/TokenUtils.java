package com.kirito.cloud.utils;

import cn.hutool.core.date.DateUtil;
import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTDecodeException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.Claim;
import com.auth0.jwt.interfaces.DecodedJWT;

import java.util.Arrays;
import java.util.Date;
import java.util.Map;

/**
 * 代码千万行，注释第一行，
 * 注释不规范，同事泪两行。
 * <p>
 * 普通的 jwt
 * <p>
 * 头信息：
 * Header  Base64Url encoded
 * {
 * "alg": "Algorithm  加密方法：HS256",
 * "cty": "Content Type ",
 * "typ": "Type" ,
 * "kid": "Key Id"
 * }
 * <p>
 * 载体信息：数据包放在这里
 * Payload  Base64Url encoded
 * {
 * "iss": "Issuer JWT的签发者",
 * "aud": "Audience 接收JWT的一方",
 * "sub": "Subject JWT的主题",
 * "exp": "Expiration Time JWT的过期时间",
 * "nbf": "Not Before 在xxx之间，该JWT都是可用的",
 * "iat": "Issued At 该JWT签发的时间",
 * "jti": "JWT ID JWT的唯一身份标识",
 * "xxx": "自定义属性"
 * }
 * <p>
 * 签名信息，该签名信息是通过header和payload，加上secret，通过算法加密生成，用于校验token防篡改：
 * Signature  = 加密算法(header + "." + payload, 密钥)
 * <p>
 * 最终生成token 格式 base64(Header).base64(Payload).Signature
 *
 * @author YuLc
 * @version 1.0.0
 * @date 2019/11/25
 */
public class TokenUtils {

    /**
     * 签名秘钥
     */
    private static final String SECRET = "!@#$%YLC*&^%()95622SSxx";
    private static final String ISSUER = "kirito"; // 发布者
    private static final Integer Expires = 10080; // 过期时间 （分钟）
    /**
     * 创建token
     *
     * @param json 需要放入token的参数，多个参数可以封装成json或者map
     * @return token
     */
    public static String createToken(JSONObject json) {
        try {
            // 加密方式
            Algorithm algorithm = Algorithm.HMAC256(SECRET);
            return JWT.create()
                    .withSubject(json.toString())
                    .withIssuer(ISSUER)
                    // 设置过期时间为1分钟后
                    .withExpiresAt(DateUtil.offsetMinute(new Date(), Expires))
//                    .withClaim("customString", "自定义参数")
//                    .withArrayClaim("customArray", new Integer[]{1, 2, 3})
                    .sign(algorithm);
        } catch (JWTCreationException exception) {
            //Invalid Signing configuration / Couldn't convert Claims.
//            System.out.println(exception.getMessage());
            return null;
        }
    }

    /**
     * 校验token 合法性
     *
     * @param token to verify.
     */
    public static boolean verifyToke(String token) {
        try {
            Algorithm algorithm = Algorithm.HMAC256(SECRET);
            JWTVerifier verifier = JWT.require(algorithm)
                    // 验证签发人是否相同
                    .withIssuer(ISSUER)
                    .build();
            /*
             * 校验：
             * 格式校验：header.payload.signature
             * 加密方式校验 Header中的alg
             * 签名信息校验，防篡改
             * 载体Payload 中公有声明字段校验
             */
            verifier.verify(token);
            return true;
        } catch (JWTVerificationException exception) {
            //Invalid signature/claims
//            System.out.println(exception.getMessage());
            return false;
        }
    }

    /**
     * 解析token
     *
     * @param token to decode.
     */
    public static JSONObject decodeToken(String token) {
        try {
            DecodedJWT jwt = JWT.decode(token);
            Map<String, Claim> claims = jwt.getClaims();
//            Claim customStringClaim = claims.get("customString");
//            Claim customArrayClaim = claims.get("customArray");

//            String issuer = jwt.getIssuer();
            String subject = jwt.getSubject();

//            System.out.println(customStringClaim.asString());
//            System.out.println(Arrays.toString(customArrayClaim.asArray(Integer.class)));
//            System.out.println(issuer);
//            System.out.println(JSONUtil.parseObj(subject));
            return JSONUtil.parseObj(subject);
        } catch (JWTDecodeException exception) {
            //Invalid token
//            System.out.println(exception.getMessage());
            return null;
        }

    }

    public static void main(String[] args) {
        JSONObject subjectJson = new JSONObject();
        subjectJson.put("userId", "213123124123123");
        subjectJson.put("name", "方志");

        String token = createToken(subjectJson);
        System.out.println("token:" + token);
        System.out.println("==============================================");

        System.out.println("decode info:");
        JSONObject user = decodeToken(token);
        System.out.println("user:" + user);

        String expToken = "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJ7XCJuaWNrTmFtZVwiOlwi5qGQ5Lq6T19PXCIsXCJ1c2VyTmFtZVwiOlwia2lyaXRvXCIsXCJ1c2VySWRcIjoxLFwiZW1haWxcIjpcIktpcml0b0BnbWFpbC5jb21cIn0iLCJpc3MiOiJraXJpdG8iLCJleHAiOjE1OTY2MjM5NTF9.qqDEIKjrWsA0g_Ht_AONwMRyi5cMb_v-0MdpSI2Hnwk";
        JSONObject user1 = decodeToken(expToken);
        System.out.println("user1:" + user1);
    }


}
