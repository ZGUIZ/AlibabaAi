package com.zguiz.ai.controller;

import com.zguiz.ai.service.TongYiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
@RequestMapping("/chat")
public class ChatController {

    @Autowired
    private TongYiService tongYiService;

    @RequestMapping("/chatPage")
    public String chatPage(){
        return "chat";
    }
}
