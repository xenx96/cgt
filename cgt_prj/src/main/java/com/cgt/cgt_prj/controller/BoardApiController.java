package com.cgt.cgt_prj.controller;

import com.cgt.cgt_prj.domain.Board;
import com.cgt.cgt_prj.domain.UserDTO;
import com.cgt.cgt_prj.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class BoardApiController {

    @Autowired
    BoardService boardservice;

    @PostMapping("/api/board")
    public boolean save(@RequestBody Board board) {
        boardservice.writePost(board);
        return true;
    }

    @DeleteMapping("/api/board/{id}")
    public void deleteById(@PathVariable String id) {
        boardservice.deletePost(id);
    }

    @PutMapping("/api/board/{id}")
    public void update(@PathVariable String id, @RequestBody Board board) {
        boardservice.editPost(id, board);
    }
}
