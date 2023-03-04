package hello.hellospring.repository;

import hello.hellospring.domain.Member;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

class MemoryMemberRepositoryTest {
    MemoryMemberRepository repo = new MemoryMemberRepository();

    //테스트는 순서와 상관 없이, 의존 관계 없이 작성 되어야 함
    //이를 위해, 공용 데이터 관리가 필요
    @AfterEach //메서드 실행이 끝날 때마다 동작하는 콜백 메서드
    public void afterEach(){
        repo.clearStore();
    }

    @Test
    public void save() {
        Member member = new Member();
        member.setName("spring");
        repo.save(member);
        Member result = repo.findById(member.getId()).get();
        assertThat(member).isEqualTo(result);
    }
    @Test
    public void findByName(){
        Member member1 = new Member();
        member1.setName("spring1");
        repo.save(member1);

        Member member2 = new Member();
        member2.setName("spring2");
        repo.save(member2);

        Member result = repo.findbyName("spring1").get();
        assertThat(result).isEqualTo(member1);
    }
    
    @Test 
    public void findAll(){
        Member member1 = new Member();
        member1.setName("spring1");
        repo.save(member1);

        Member member2 = new Member();
        member2.setName("spring2");
        repo.save(member2);

        List<Member> result = repo.findAll();
        assertThat(result.size()).isEqualTo(2);
    }
}
