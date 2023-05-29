package com.ebstudy.ebsoft.mvc.service;

import com.ebstudy.ebsoft.mvc.domain.Board;
import com.ebstudy.ebsoft.mvc.repository.BoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 게시판 서비스
 */
@Service
@RequiredArgsConstructor
public class BoardService {

    private final BoardRepository repository;

    public List<Board> getList(){
        return repository.getList();
    };
    public Board get(long boardId) {
        return repository.get(boardId);
    };
    public void save(Board board) {
        repository.save(board);
    };
    public void update(Board board) {
        repository.update(board);
    };
    public void delete(long boardId) {
        repository.delete(boardId);
    };



}
