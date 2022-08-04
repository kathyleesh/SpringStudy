package hello.practicespring;

import hello.practicespring.repository.MemberRepository;
import hello.practicespring.repository.MemoryMemberRepository;
import hello.practicespring.service.MemberService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//spring bean을 @Service와 @Repository로 자동 등록 하지 않고 그대신 직접 등록 해주는 방법
//controller는 자동 등록으로 해주면 됨
@Configuration
public class SpringConfig {

    @Bean
    public MemberService memberService() {
        return new MemberService(memberRepository());
    }

    @Bean
    public MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }
}
