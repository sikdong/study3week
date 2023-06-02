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
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
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


    /**
     * 게시물 상세 보기
     * @param boardId 게시물 번호
     * @param model
     * @return 상세 보기 화면
     */
    @GetMapping("{boardId}")
    public String get(@PathVariable long boardId, Model model) {
        Board board = service.get(boardId);
        model.addAttribute("board", board);
        return "board/view";
    }

    /**
     * 게시물 등록 프로세스
     * @param board 게시물 등록 정보
     * @return 게시물 조회 화면
     */
    @PostMapping("save")
    public String save(@ModelAttribute Board board) {
        service.save(board);
        return "redirect:/board/list";
    }

    /**
     * 게시물 등록 화면
     */
    @GetMapping("write")
    public void write(Model model){
        List<Category> categoryList = service.getCategoryList();
        model.addAttribute("categoryList",categoryList);
    }


    @PostMapping("update")
    public void update(Board board) {
        service.update(board);
    }

    @DeleteMapping("delete")
    public void delete(@PathVariable long boardId) {
        service.delete(boardId);
    }


    /**
     * 파일 다운로드
     * @param file     파일명
     * @param response the response
     * @throws IOException 입출력 오류
     */
    @GetMapping("fileDownload")
    public void fileDownload(@RequestParam String fileUuidName,
                             HttpServletResponse response) throws IOException {
       service.fileDownload(fileUuidName, response);
    }
}
