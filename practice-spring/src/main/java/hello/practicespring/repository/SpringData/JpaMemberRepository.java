package hello.practicespring.repository.SpringData;

import hello.practicespring.domain.Member;
import hello.practicespring.repository.MemberRepository;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

//JpaRepository에 기본 method , CRUD, paging, 등 모든 기능이 다 제공 그러나 id를 제외한 costom한 column들은 findByName, findByEmail과 같이 구현
public interface JpaMemberRepository extends JpaRepository<Member, Long>, MemberRepository {

    @Override
    Optional<Member> findByName(String name);
}
