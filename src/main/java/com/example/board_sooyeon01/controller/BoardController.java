package com.example.board_sooyeon01.controller;

import org.springframework.ui.Model;
import com.example.board_sooyeon01.entity.Board;
import com.example.board_sooyeon01.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class BoardController {

    @Autowired
    private BoardService boardService;

    /*
        @GetMapping("/")
        @ResponseBody
        public String main(){
            return "최수연 테스트중";
        }
        */
    @GetMapping("/board/write")//localhost:8080/board/write
    public String boardWriteForm(){

        return "boardwrite";
    }

    @PostMapping("/board/writedopro")
    public String boardWritePro(Board board){

        //System.out.println(board.getTitle());
        boardService.write(board);
        return "";
    }

    @GetMapping("/board/list")
    public String boardList(Model model){
        model.addAttribute("list",boardService.boardList() );

        return "boardlist";

    }
}
