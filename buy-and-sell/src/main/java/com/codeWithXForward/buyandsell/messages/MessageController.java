package com.codeWithXForward.buyandsell.messages;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/message")
public class MessageController {
    @GetMapping
    public String hello(){
        return "fooo";
    }
}
