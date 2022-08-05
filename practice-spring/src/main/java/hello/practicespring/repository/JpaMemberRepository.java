package hello.practicespring.repository;

import hello.practicespring.domain.Member;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;
import java.util.Optional;

public class JpaMemberRepository implements MemberRepository{

    private final EntityManager em;

    public JpaMemberRepository(EntityManager em) {
        this.em = em;
    }

    @Override
    public Member save(Member member) {
        em.persist(member);
        return member;
    }

    @Override
    public Optional<Member> findById(Long id) {
        Member member = em.find(Member.class, id);
        return Optional.ofNullable(member);
    }

    @Override
    public Optional<Member> findByName(String name) {
        List<Member> result = em.createQuery("select m from Member m where m.name = :name", Member.class)
                .setParameter("name", name)
                .getResultList();
        return result.stream().findAny();
    }

    @Override
    public List<Member> findAll() {
        /*
        List<Member> result = em.createQuery("select m from member m", Member.class)
                .getResultList();
        return result;
        */
        // cmd + opt + N을 하면 inline을 사용하여 아래와 같이 간결해짐
        //"select m from member m" 객체를 대상으로 Query를 날림
        return em.createQuery("select m from member m", Member.class)
                .getResultList();
    }
}
