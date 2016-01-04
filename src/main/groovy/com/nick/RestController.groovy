package com.nick

import com.nick.domain.*
import com.nick.service.*

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
class RestController {

    @Autowired
    private UserRepository userRepository
    @Autowired
    private RecordRepository recordRepository

    @RequestMapping("/")
    public @ResponseBody String index() {
        "Greetings from Spring Boot!";
    }


    // daily report
    @RequestMapping("/daily")
    public @ResponseBody List<User> queryDaily(Model model) {
        Date startDate = new Date()
        Date endDate = new Date()
        startDate.set(hourOfDay: 0, minute: 0, second: 0)
        endDate.set(hourOfDay: 23, minute: 59, second: 59)

        recordRepository.findByRecordDateBetween(startDate, endDate)
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
