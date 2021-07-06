//package com.naive.Utils;
//
//import com.naive.domain.Admin;
//import com.naive.domain.Student;
//import com.naive.domain.Teacher;
//import io.jsonwebtoken.Claims;
//import io.jsonwebtoken.Jwts;
//import io.jsonwebtoken.SignatureAlgorithm;
//
//import java.util.Date;
//
///**
// * @author YechenGu
// * @date 2021/7/5 9:16 上午
// */
//public class JWTUtils {
//    private static long EXPIRE = 1000*60*60*24;
//
//    private static String SUBJECT = "naive";
//
//    private static String SECRET = "naive";
//
//    private static String TOKEN_PREFIX = "user";
//
//    public static String geneJsonWebToken(Object user){
//        String token;
//        if (user instanceof Student){
//            token = Jwts.builder().setSubject(SUBJECT)
//                    .claim("id",((Student) user).getStuNo())
//                    .claim("name",((Student) user).getStuName())
//                    .setIssuedAt(new Date())
//                    .setExpiration(new Date(System.currentTimeMillis() + EXPIRE))
//                    .signWith(SignatureAlgorithm.HS256,SECRET).compact();
//        } else if(user instanceof Teacher){
//            token = Jwts.builder().setSubject(SUBJECT)
//                    .claim("id",((Teacher) user).getTeaNo())
//                    .claim("name",((Teacher) user).getTeaName())
//                    .setIssuedAt(new Date())
//                    .setExpiration(new Date(System.currentTimeMillis() + EXPIRE))
//                    .signWith(SignatureAlgorithm.HS256,SECRET).compact();
//        } else if(user instanceof Admin){
//            token = Jwts.builder().setSubject(SUBJECT)
//                    .claim("id",((Admin) user).getAdNo())
//                    .claim("name",((Admin) user).getAdName())
//                    .setIssuedAt(new Date())
//                    .setExpiration(new Date(System.currentTimeMillis() + EXPIRE))
//                    .signWith(SignatureAlgorithm.HS256,SECRET).compact();
//        } else {
//            token = "error";
//        }
//        token = TOKEN_PREFIX + token;
//        return token;
//    }
//
//    public static Claims checkJWT(String token){
//        try{
//            final  Claims claims = Jwts.parser().setSigningKey(SECRET)
//                    .parseClaimsJws(token.replace(TOKEN_PREFIX,"")).getBody();
//            return claims;
//        }catch (Exception e){
//            return null;
//        }
//    }
//}
