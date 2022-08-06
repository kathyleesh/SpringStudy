package hello.practicespring;

import hello.practicespring.aop.TimeTraceAop;
import hello.practicespring.repository.MemberRepository;
import hello.practicespring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//spring bean을 @Service와 @Repository로 자동 등록 하지 않고 그대신 직접 등록 해주는 방법
//controller는 자동 등록으로 해주면 됨
@Configuration
public class SpringConfig {

    /* jdbc
    private DataSource dataSource;


    @Autowired
    public SpringConfig(DataSource dataSource) {
        this.dataSource = dataSource;
    }
     */

    /*jpa
    private EntityManager em;

    public SpringConfig(EntityManager em) {
        this.em = em;
    }*/

    private final MemberRepository memberRepository;

    @Autowired
    public SpringConfig(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Bean
    public MemberService memberService() {
        return new MemberService(memberRepository);
    }

    /* before spring data jpa
    @Bean
    public MemberService memberService() {
        return new MemberService(memberRepository());
    }*/

    /* before spring data jpa
    @Bean
    public MemberRepository memberRepository() {
        //return new MemoryMemberRepository();            //base memory repository
        //return new JdbcMemberRepository(dataSource);    //use Jdbc
        //return new JdbcTemplateMemberRepository(dataSource);      //use Jdbc templates
        //return new JpaMemberRepository(em); //use Jpa
    }
    */

    /* AOP 사용
    @Bean
    public TimeTraceAop timeTraceAop() {
        return new TimeTraceAop();
    }*/
}
