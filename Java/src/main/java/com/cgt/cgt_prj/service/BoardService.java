package com.cgt.cgt_prj.service;

import com.cgt.cgt_prj.domain.Board;
import com.cgt.cgt_prj.repositories.BoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BoardService {

    private final BoardRepository boardRepository;

    @Transactional
    public void writePost(Board board) {
        boardRepository.insert(board);
    }

    @Transactional
    public void deletePost(Long id) {
        boardRepository.deleteById(id);
    }

    @Transactional
    public void editPost(Long id, Board requestBoard) {
        Board board = boardRepository.findById(id)
            .orElseThrow(() -> {
                return new IllegalArgumentException("글 찾기 실패: 아이디를 찾을 수 없습니다.");
            });
        board.setCT(requestBoard.getCT());
        board.setCS(requestBoard.getCS());
        //해당 함수 종료시에(서비스가 종료될 때)트랜잭션이 종료된다. 이때 더티체킹 - 자동업데이트가 됨. flush
    }

    @Transactional
    public Board getPost(Long id){
        Board board = boardRepository.findById(id)
                .orElseThrow(() -> {
                    return new IllegalArgumentException("글 찾기 실패: 아이디를 찾을 수 없습니다.");
                });
        return board;
    }

    @Transactional
    public List<Board> getAllPost(){return boardRepository.findAll();}
}
