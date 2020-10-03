package com.example.security.project.securityjwtproject.config.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;

@RequiredArgsConstructor
@Component
public class JwtTokenProvider {

    private final String secretKey = "webfirewood";
    private final String TOKEN_PREFIX = "Bearer ";
    private final String HEADER_STRING = "Authorization";
    private final long tokenValidTime = 30 * 60 * 1000L;

    private final CustomUserDetailService customUserDetailService;

    // JWT 토큰 생성
    public String createToken(String email, String name) {
        Claims claims = Jwts.claims();
        claims.put("email",email);
        claims.put("name", name); // 정보는 key / value 쌍으로 저장된다.
        Date now = new Date();
        return TOKEN_PREFIX + Jwts.builder()
                .setClaims(claims) // 정보 저장
                .setIssuedAt(now) // 토큰 발행 시간 정보
                .setExpiration(new Date(now.getTime() + tokenValidTime)) // set Expire Time
                .signWith(SignatureAlgorithm.HS256, secretKey)
                .compact();
    }

    // JWT 토큰에서 인증 정보 조회
    public Authentication getAuthentication(String token) {
        UserDetails userDetails = customUserDetailService.loadUserByUsername(this.getEmailFromToken(token));
        return new UsernamePasswordAuthenticationToken(userDetails, "", userDetails.getAuthorities());
    }

    public String getEmailFromToken(String token) {
        return (String)Jwts.parser().setSigningKey(secretKey).parseClaimsJws(token.replace(TOKEN_PREFIX, "")).getBody().get("email");
    }

    // Request의 Header에서 token 추출
    public String resolveToken(HttpServletRequest request) {
        System.out.println("호출2");
        return request.getHeader(HEADER_STRING);
    }

    // 토큰의 유효성 + 만료일자 확인
    public boolean validateToken(String token) {
        try {
            Jws<Claims> claims = Jwts.parser().setSigningKey(secretKey).parseClaimsJws(token.replace(TOKEN_PREFIX, ""));
            return !claims.getBody().getExpiration().before(new Date());
        } catch (Exception e) {
            return false;
        }
    }

}
