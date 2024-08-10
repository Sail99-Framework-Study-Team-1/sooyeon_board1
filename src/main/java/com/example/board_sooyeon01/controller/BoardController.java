package com.example.board_sooyeon01.controller;

import org.springframework.ui.Model;
import com.example.board_sooyeon01.entity.Board;
import com.example.board_sooyeon01.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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

    @PostMapping("/board/writepro")
    public String boardWritePro(Board board){

        boardService.write(board);
        return "redirect:/board/list";
    }

    @GetMapping("/board/list")
    public String boardList(Model model){
        model.addAttribute("list",boardService.boardList() );

        return "boardlist";

    }

    @GetMapping("/board/view")//localhost:8080/board/view?id=1 (파라미터 겟방식)
    public String boardView(Model model,int id){
        model.addAttribute("board",boardService.boardView(id) );
        return "boardview";
    }

    @GetMapping("/board/delete")//localhost:8080/board/view?id=1 (파라미터 겟방식)
    public String boarddelete(int id){
        boardService.boardDelete(id);

        return "redirect:/board/list";
    }

    @GetMapping("/board/modify/{id}")
    public String boardmodify(@PathVariable("id") Integer id, Model model){
        model.addAttribute("board",boardService.boardView(id));

        return "boardmodify";
    }

    @PostMapping("/board/update/{id}")
    public String boardUpate(@PathVariable("id") Integer id, Board board){

        Board boardTemp = boardService.boardView(id);
        boardTemp.setTitle(board.getTitle());
        boardTemp.setContent(board.getContent());  //덮어씌움

        boardService.write(boardTemp);
        return "redirect:/board/list";
    }
}
