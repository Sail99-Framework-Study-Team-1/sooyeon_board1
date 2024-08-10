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

    public void write(Board board){
        boardRepository.save(board);


    }

    public List<Board> boardList(){
        return boardRepository.findAll();
    }
}
