package hello.practicespring.controller;

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
        return "hello";
    }

    //MVC
    //@RequestParam(value = "name", required = false), 즉 @RequestParam("name")는 required = ture 이므로 무조건 localhost:8080/hello-mvc?name={name}으로 request
    @GetMapping("hello-mvc")
    public String helloMvc(@RequestParam("name") String name, Model model) {
        model.addAttribute("name", name);
        return "hello-template";
    }

    @GetMapping("hello-string")
    @ResponseBody
    public String helloString(@RequestParam("name") String name) {
        return "hello " + name; //html 파일 없이 문자 그대로 "hello spring" 다음과 같이 출력
    }

    // @ResponseBody ==> HttpMessageConverter ==> 기본 문자 처리(StringHttpMessageConverter) , 기본 객체 처리(MappingJackson2HttpMessageConverter) => json 형식
    @GetMapping("hello-api")
    @ResponseBody
    public Hello helloApi(@RequestParam("name") String name) {
        Hello hello = new Hello();
        hello.setName(name);
        return hello;
    }

    static class Hello {
        private String name;

        // cmd + N >> Getter and Setter == Java Bean(자바빈)
        // Setter == 데이터는 외부에서 접근하지 않도록 막고, 메소드는 공개해서 외부에서 메소드를 통해 데이터에 접근하도록 유도
        // Getter == 객체 외부에서 객체 필드값을 사용하기 부적절한 경우가 있는데 이 경우 메소드로 필드 값을 가공 한 뒤에 외부로 전달
        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}

