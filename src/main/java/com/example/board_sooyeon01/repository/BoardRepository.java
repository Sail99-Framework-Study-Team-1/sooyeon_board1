package com.example.board_sooyeon01.repository;

import com.example.board_sooyeon01.entity.Board;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.ResponseBody;

@Repository
public interface BoardRepository  extends JpaRepository<Board, Integer> {
}
