package hello.practicespring.repository;

import hello.practicespring.domain.Member;

import java.util.List;
import java.util.Optional;

public interface MemberRepository {
    Member save(Member member);
    //Optional<Member> 만약 Id나 Name이 없을 때 Null을 반환할 수 있도록 Optional로 감싸서 반환
    Optional<Member> findById(Long id);

    Optional<Member> findByName(String name);

    List<Member> findAll();
}
