package com.example.board_sooyeon01.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class BoardController {
    @GetMapping("/")
    @ResponseBody
    public String main(){
        return "최수연 테스트중";
    }
}
