package hello.practicespring.service;

import hello.practicespring.domain.Member;
import hello.practicespring.repository.MemberRepository;
import hello.practicespring.repository.MemoryMemberRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Commit;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional  //test를 실행할 때 가장 먼저 실행되서 commit 안되고 rollback되어 db에 반영되지 않고 반복적으로 test가 실행된다.
public class MemberServiceIntegrationTest {
    @Autowired MemberService memberService;
    @Autowired MemberRepository memberRepository;

    /*@BeforeEach
    public void beforeEach() {
        memberRepository = new MemoryMemberRepository();
        memberService = new MemberService(memberRepository);
    }

    @AfterEach
    public void afterEach() {
        memberRepository.clearStore();
    }*/


    @Test
    //@Commit
    void 회원가입() {
        //given
        Member member = new Member();
        member.setName("springspring");

        //when
        Long saveId = memberService.join(member);

        //then
        Member findMember = memberService.findOne(saveId).get();
        assertThat(member.getName()).isEqualTo(findMember.getName());
    }

    @Test
    void 중복_회원_예외() {
        Member member1 = new Member();
        member1.setName("springspring");

        Member member2 = new Member();
        member2.setName("springspring");

        memberService.join(member1);
        // IllegalStateException이 잘 수행이 되는지 Test
        //assertThrows(IllegalStateException.class, () -> memberService.join(member2));
        //
        IllegalStateException e = assertThrows(IllegalStateException.class, () -> memberService.join(member2));

        assertThat(e.getMessage()).isEqualTo("이미 존재하는 회원입니다.");
    }
}