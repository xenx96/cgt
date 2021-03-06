package com.cgt.cgt_prj.controller;

import com.cgt.cgt_prj.domain.Board;
import com.cgt.cgt_prj.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class BoardApiController {

    private final BoardService boardservice;

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
