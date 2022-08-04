package hello.practicespring.repository;

import hello.practicespring.domain.Member;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

//@Repository //자동으로 spring bean으로 등록
public interface MemberRepository {
    Member save(Member member);
    //Optional<Member> 만약 Id나 Name이 없을 때 Null을 반환할 수 있도록 Optional로 감싸서 반환
    Optional<Member> findById(Long id);

    Optional<Member> findByName(String name);

    List<Member> findAll();
}
