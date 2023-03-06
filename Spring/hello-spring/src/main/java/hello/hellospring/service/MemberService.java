package hello.hellospring.service;

import hello.hellospring.domain.Member;
import hello.hellospring.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

//@Service
public class MemberService {

    private final MemberRepository memberRepo;

//    @Autowired //컴포넌트 스캔 방식
    public MemberService(MemberRepository memberRepo) {
        this.memberRepo = memberRepo;
    }

    public Long join(Member member){
        //이름이 동일한 중복 회원 불가

        isduplicated(member);

        memberRepo.save(member);
        return member.getId();

    }

    private void isduplicated(Member member) {
        memberRepo.findbyName(member.getName())
                .ifPresent(m -> { //null이 아니라 값이 있으면 중괄호 안의 로직이 실행, Optional 메소드
                throw new IllegalStateException("이미 존재하는 회원입니다.");
            });
    }

    public List<Member> findMembers(){
        return memberRepo.findAll();
    }

    public Optional<Member> findOne(Long memberId){
        return memberRepo.findById(memberId);
    }
}
