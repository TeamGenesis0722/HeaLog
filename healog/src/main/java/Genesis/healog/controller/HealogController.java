package Genesis.healog.controller;

import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HealogController {
    @GetMapping("hello-string")
    @ResponseBody   // 응답 body 부에 직접 넣어주겠다
    public String helloString(@RequestParam("name") String name, Model model) {
        return "hello" + name;
    }


    @GetMapping("hello-api")
    @ResponseBody
    public String helloApi(@RequestParam("name") String name, Model model) {
        Hello hello = new Hello();
        hello.setName(name);
        return hello.toString();
    }

    static class Hello {
        private String name;
        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }


}

