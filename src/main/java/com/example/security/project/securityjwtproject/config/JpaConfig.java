package com.example.security.project.securityjwtproject.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import java.security.Principal;
import java.util.Optional;
import java.util.UUID;

/* @EnableJpaAuditing : 메임 함수에 있을 경우, @WebMvcTest 에 의해 스캔된다.
 * 스캔되면 안되는 이유 : @EnableJpaAuditing 를 사용하기 위해서는 최소 하나의 @Entity 클래스가 필요하지만, test 환경에서는 설정해줄 이유가 없기 때문 */
@Configuration
@EnableJpaAuditing // JPA Auditing 활성화
public class JpaConfig {

    @Bean
    public AuditorAware<String> auditorProvider() {
        return () -> {
//            if(SecurityContextHolder.getContext().getAuthentication() != null){
//                return Optional.ofNullable(SecurityContextHolder.getContext().getAuthentication().getName());
//            } else {
//                return Optional.empty();
//            }
            Optional<Authentication> authentication = Optional.ofNullable(SecurityContextHolder.getContext().getAuthentication());
            return authentication.map(Principal::getName);
        };
    }


}
