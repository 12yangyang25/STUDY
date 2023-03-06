package hello.hellospring.controller;

import hello.hellospring.domain.Member;
import hello.hellospring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class MemberController { //스프링 컨테이너가 뜰 때 멤버 컨트롤러도 자동 생성, 생성자도 호출
    //private final MemberService memberService = new MemberService();
    //new로 객체 생성하지 않는 이유: 하나 생성해두고 공유해서 사용하면 됨
    //스프링 컨테이너에 등록을 해두고 사용

    // 컨트롤러를 통해 외부 요청을 받고, 서비스에서 비즈니스 로직을 만들고, 리포지토리에서 데이터를 저장
    private final MemberService memberService;

    @Autowired //스프링 컨테이너에서 멤버 서비스를 가져와서 연결시켜줌
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    @GetMapping("/members/new")
    public String createForm(){
        return "members/createMemberForm";
    }

    @PostMapping("/members/new")
    public String create(MemberForm form){
        Member member = new Member();
        member.setName(form.getName());
        memberService.join(member);

        System.out.println(form.getName());
        System.out.println(member.getName());

        return "redirect:/";
    }

    @GetMapping("/members")
    public String list(Model model){
        List<Member> members = memberService.findMembers();
        //단축어 옵션커맨드V
        model.addAttribute("members", members);
        return "members/memberList";
    }

}
