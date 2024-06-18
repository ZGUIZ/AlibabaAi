package com.zguiz.ai.controller;

import com.zguiz.ai.service.TongYiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/common")
public class CommonController {

    @Value("${alibaba.key:null}")
    private String userName;

    private String age = "18";

    @Autowired
    private TongYiService tongYiService;

    //登录
    @RequestMapping("/index")
    public String login(){
        //String completion = tongYiService.completion("如何将大象关进冰箱？");
        String msg =" I am " + userName + ",I am" + age + "years old! result:";
        //System.out.println(completion);
        return msg;
    }


}
