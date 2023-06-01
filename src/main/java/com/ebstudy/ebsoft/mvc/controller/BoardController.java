package com.ebstudy.ebsoft.mvc.controller;

import com.ebstudy.ebsoft.mvc.domain.Board;
import com.ebstudy.ebsoft.mvc.domain.Category;
import com.ebstudy.ebsoft.mvc.domain.PageInfo;
import com.ebstudy.ebsoft.mvc.domain.Search;
import com.ebstudy.ebsoft.mvc.service.BoardService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j;
import org.springframework.boot.Banner;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import java.io.File;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 * 게시판 컨트롤러
 */
@Controller
@RequiredArgsConstructor
@RequestMapping("board")
public class BoardController {

    private final BoardService service;

    @GetMapping("list")
    public void getList(@ModelAttribute("search") Search search
                        ,Model model
                        ,@ModelAttribute("pageInfo") PageInfo pageInfo){
        List<Board> boards = service.getList(search, pageInfo);

        int listNum = service.getListNum(search);
        List<Category> categoryList = service.getCategoryList();
        model.addAttribute("boards", boards);
        model.addAttribute("listNum", listNum);
        model.addAttribute("categoryList", categoryList);
    };


    @GetMapping("{boardId}")
    public String get(@PathVariable long boardId, Model model) {
        Board board = service.get(boardId);
        model.addAttribute("board", board);
        return "board/view";
    }

    @PostMapping("save")
    public String save(@ModelAttribute Board board) {
        service.save(board);
        return "redirect:/board/list";
    };

    /**
     * 게시물 등록
     */
    @GetMapping("write")
    public void write(Model model){
        List<Category> categoryList = service.getCategoryList();
        model.addAttribute("categoryList",categoryList);
    }


    @PostMapping("update")
    public void update(Board board) {
        service.update(board);
    };

    @DeleteMapping("delete")
    public void delete(@PathVariable long boardId) {
        service.delete(boardId);
    };
}
