package hello.practicespring.service;

import hello.practicespring.domain.Member;
import hello.practicespring.repository.MemberRepository;
import hello.practicespring.repository.MemoryMemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

//@Service //자동으로 spring bean으로 등록
public class MemberService {

    /*// Test와 같은 Repository를 사용하기 위해 외부에서 Repository를 생생하여 들고와서 사용한다.
    private final MemberRepository memberRepository = new MemoryMemberRepository();*/
    private final MemberRepository memberRepository;

    //@Autowired //자동으로 spring bean으로 등록
    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    /**
     * 회원가입
     **/
    public Long join(Member member) {
        //같은 이름 있는 중복 회원 X
        /*
        //memberRepository.findByName(member.getName()) 작성후 cmd + opt + v 하면 "Optional<Member> result = memberRepository.findByName(member.getName());" 로 생성
        Optional<Member> result = memberRepository.findByName(member.getName());
        result.ifPresent(m -> {
            throw new IllegalStateException("이미 존재하는 회원입니다.");
        });
        */
        validateDuplicateMember(member); //중복 회원 검증
        /*
         // 아래 주석 작성후 cmd + opt + M 누르면 그 부분 추출되어 "validateDuplicateMember(member);"로 정리
         memberRepository.findByName(member.getName())
                         .ifPresent(m -> {
                             throw new IllegalStateException("이미 존재하는 회원입니다.");
                         });
         */
        memberRepository.save(member);
        return member.getId();
    }

    private void validateDuplicateMember(Member member) {
        memberRepository.findByName(member.getName())
                .ifPresent(m -> {
                    throw new IllegalStateException("이미 존재하는 회원입니다.");
                });
    }

    /**
     * 전체 회원 조회
     **/
    public List<Member> findMembers() {
        return memberRepository.findAll();
    }

    public Optional<Member> findOne(Long memberId) {
        return memberRepository.findById(memberId);
    }
}
