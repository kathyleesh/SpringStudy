package hello.practicespring.repository;

import hello.practicespring.domain.Member;
import org.springframework.stereotype.Repository;

import java.util.*;

//@Repository //자동으로 spring bean으로 등록
//implements MemberRepository 추가 후 option + enter 후 implements methods 전체 생성
public class MemoryMemberRepository implements MemberRepository{

    private static Map<Long, Member> store = new HashMap<>();
    private static Long squence = 0L;

    //squence값을 하나 올려주고 store에 ID를 저장
    @Override
    public Member save(Member member) {
        member.setId(++squence);
        store.put(member.getId(), member);
        return member;
    }

    //Optional을 통해 id가 null이더라도 반환되도록 설정
    @Override
    public Optional<Member> findById(Long id) {
        return Optional.ofNullable(store.get(id));
    }

    //name을 찾아 반환하도록 설정
    @Override
    public Optional<Member> findByName(String name) {
        return store.values().stream()
                .filter(member -> member.getName().equals(name))
                .findAny();
    }

    //Map을 사용하지만 List이므로 new ArrayList 사용
    @Override
    public List<Member> findAll() {
        return new ArrayList<>(store.values());
    }

    public void clearStore() {
        store.clear();
    }
}
