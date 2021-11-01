package com.cgt.cgt_prj.controller;

import com.cgt.cgt_prj.domain.Board;
import com.cgt.cgt_prj.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    public void deleteById(@PathVariable Long id) {
        boardservice.deletePost(id);
    }

    @PutMapping("/api/board/{id}")
    public void update(@PathVariable Long id, @RequestBody Board board) {
        boardservice.editPost(id, board);
    }


    @GetMapping("/api/board/all")
    public List<Board> getAllPost(){return boardservice.getAllPost(); }

    @GetMapping("/api/board/view/{id}")
    public Board getPost(@PathVariable Long id){return boardservice.getPost(id);}
}
