package com.ebstudy.ebsoft.mvc.controller;

import com.ebstudy.ebsoft.mvc.domain.Board;
import com.ebstudy.ebsoft.mvc.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 게시판 컨트롤러
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("/board")
public class BoardController {

    private final BoardService service;

    @GetMapping("/list")
    public List<Board> getList(){
        return service.getList();
    };

    @GetMapping("/{boardId}")
    public Board get(@PathVariable long boardId) {
        return service.get(boardId);
    };

    @PostMapping("/save")
    public void save(Board board) {
        service.save(board);
    };

    @PostMapping("/update")
    public void update(Board board) {
        service.update(board);
    };

    @DeleteMapping("/delete")
    public void delete(@PathVariable long boardId) {
        service.delete(boardId);
    };
}
