package com.example.board_sooyeon01.service;

import com.example.board_sooyeon01.entity.Board;
import com.example.board_sooyeon01.repository.BoardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BoardService {
    @Autowired
    private BoardRepository boardRepository;

    //글 작성 처리.
    public void write(Board board){
        boardRepository.save(board);
    }

    //게시글 리스트 처리.
    public List<Board> boardList(){
        return boardRepository.findAll();
    }
    //특정 게시글 불러오기
    public Board boardView(int id){
        return boardRepository.findById(id).get();
    }

    //특정 게시글 삭제
    public void boardDelete(int id){
        //return boardRepository.findById(id).get();
        boardRepository.deleteById(id);
    }
}
