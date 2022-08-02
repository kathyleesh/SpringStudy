package hello.practicespring.repository;

import hello.practicespring.domain.Member;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

//원래는 매번 "Assertions.assertThat(member).isEqualTo(result); " 이렇게 쳐야하지만 option + enter로 Assertions을 static으로 만들어두면 앞으로는 "assertThat(member).isEqualTo(result);"만 작성하면 된다!
import java.util.List;

import static org.assertj.core.api.Assertions.*;

class MemoryMemberRepositoryTest {
    MemoryMemberRepository repository = new MemoryMemberRepository();

    //Test를 한번에 돌릴 때 findAll() -> findByName() -> save() 순이기에 findAll에서 spring1과 spring2가 저장이 되어있으므로 findByName()을 돌리면 error가 난다. 따라서 afterEach를 통해 하나씩 끝날 때마다 다음의 store 클리어 함수를 실행시켜 Reset 시켜준다.
    @AfterEach
    public void afterEach() {
        repository.clearStore();
    }

    @Test
    public void save() {
        Member member = new Member();
        member.setName("spring");

        repository.save(member);

        Member result = repository.findById(member.getId()).get();
        assertThat(member).isEqualTo(result);   //(최근에 많이 사용)Assertions => assertj.core.api(Library)
        //Assertions.assertEquals(member, result);         //Assertions => junit.jupiter.api(Library)
        //System.out.println("result = " + (result == member));
    }

    @Test
    public void findByName() {
        Member member1 = new Member();
        member1.setName("spring1");
        repository.save(member1);

        Member member2 = new Member();
        member2.setName("spring2");
        repository.save(member2);

        Member result = repository.findByName("spring1").get();

        assertThat(result).isEqualTo(member1);
    }

    @Test
    public void findAll() {
        Member member1 = new Member();
        member1.setName("spring1");

        repository.save(member1);

        Member member2 = new Member();
        member2.setName("spring2");

        repository.save(member2);

        List<Member> result = repository.findAll();

        assertThat(result.size()).isEqualTo(2);
    }
}
