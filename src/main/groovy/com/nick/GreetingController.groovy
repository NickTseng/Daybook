package com.nick

import com.nick.domain.User
import com.nick.service.UserRepository

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.ui.Model

/**
 * Created by nick on 2016/1/3.
 */


@Controller
class GreetingController {

    @Autowired
    private UserRepository userRepository

    @RequestMapping("/")
    public @ResponseBody String index() {
        "Greetings from Spring Boot!";
    }

    @RequestMapping("/greeting")
    public String greeting(@RequestParam(value="name", required=false, defaultValue="World") String name, Model model) {
        model.addAttribute("name", name);
        return "greeting";
    }


    @RequestMapping("/users")
    public @ResponseBody List<User> findAll(Model model) {

        model.addAttribute("name", 'nick');
        userRepository.findAll()
    }
}
