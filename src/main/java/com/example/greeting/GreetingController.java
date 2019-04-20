package com.example.greeting;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/greeting")
public class GreetingController {

    @RequestMapping("")       
    public String greeting() {
        return "ss";
    }
}
