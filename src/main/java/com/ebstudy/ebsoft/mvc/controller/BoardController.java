package com.ebstudy.ebsoft.mvc.controller;

import com.ebstudy.ebsoft.mvc.domain.Board;
import com.ebstudy.ebsoft.mvc.domain.Category;
import com.ebstudy.ebsoft.mvc.domain.PageInfo;
import com.ebstudy.ebsoft.mvc.domain.Search;
import com.ebstudy.ebsoft.mvc.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 게시판 컨트롤러
 */
@Controller
@RequiredArgsConstructor
@RequestMapping("board")
public class BoardController {

    private final BoardService service;

    @GetMapping("list")
    public void getList(@ModelAttribute("search") Search search, Model model
            ,@ModelAttribute("pageInfo") PageInfo pageInfo){
        List<Board> boards = service.getList(search, pageInfo);

        int listNum = service.getListNum();
        List<Category> categoryList = service.getCategoryList();
        model.addAttribute("boards", boards);
        model.addAttribute("listNum", listNum);
        model.addAttribute("categoryList", categoryList);
    };

    @GetMapping("{boardId}")
    public Board get(@PathVariable long boardId) {
        return service.get(boardId);
    };

    @PostMapping("save")
    public void save(Board board) {
        service.save(board);
    };

    @PostMapping("update")
    public void update(Board board) {
        service.update(board);
    };

    @DeleteMapping("delete")
    public void delete(@PathVariable long boardId) {
        service.delete(boardId);
    };
}
