package hello.practicespring.controller;

import hello.practicespring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;



/*
Bean이란? 스프링 컨테이너가 관리하는 자바 객체를 빈이라고 한다.
@Controller, @Service, @Repository를 통해 자동으로 스프링 빈으로 자동 등록한다.
Controller >> Service >> Repository
+ main package에 하위 page들만 component가 작동한다.
*/
@Controller //자동으로 spring bean으로 등록
public class MemberController {

    private final MemberService memberService;

    /*
    @Autowired를 사용하면 스프링이 연관된 객체를 스크링 컨테이너세어 찾아서 넣어준다.
    == DI(Dependency Injection, 의존성 주입) : 객체 의존 관계를 외부에서 넣어주는 것
    */
    @Autowired //자동으로 spring bean으로 등록
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }
}
