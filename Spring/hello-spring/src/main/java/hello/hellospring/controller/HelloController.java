package hello.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {
    @GetMapping("hello")
    public String hello(Model model) {
        model.addAttribute("data", "hello!!");
        return "hello"; //resources:templates/의 hello.html를 렌더링
        //컨트롤러에서 리턴 값으로 문자를 반환하면 viewResolver가 화면을 찾아서 처리
    }

    //MVC 패턴과 템플릿 엔진
    //view는 화면을 그리는 데 집중
    //model은 비즈니스 로직과 관련이 있거나, 내부적인 처리에 집중

    @GetMapping("hello-mvc")
    public String helloMvc(@RequestParam(value = "name") String name, Model model){
        model.addAttribute("name", name); //name이 입력값으로 바뀌어서 모델에 담김
        return "hello-template";
    }

    @GetMapping("hello-string")
    @ResponseBody //응답 body부에 return한 값을 넣어주겠다는 뜻...
    public String helloString(@RequestParam("name") String name){
        return "hello " + name;
    }

    @GetMapping("hello-api")
    @ResponseBody
    public Hello helloApi(@RequestParam("name") String name ){
        Hello hello = new Hello();
        hello.setName(name);
        return hello; //객체는 JSON 방식으로 데이터를 만들어서 http 요청에 응답
    }

    static class Hello{
        private String name;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }

}
