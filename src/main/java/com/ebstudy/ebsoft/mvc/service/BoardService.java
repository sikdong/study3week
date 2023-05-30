package com.ebstudy.ebsoft.mvc.service;

import com.ebstudy.ebsoft.mvc.domain.Board;
import com.ebstudy.ebsoft.mvc.domain.Category;
import com.ebstudy.ebsoft.mvc.domain.PageInfo;
import com.ebstudy.ebsoft.mvc.domain.Search;
import com.ebstudy.ebsoft.mvc.repository.BoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 게시판 서비스
 */
@Service
@RequiredArgsConstructor
public class BoardService {

    private final BoardRepository repository;

    /**
     * 게시물 목록 조회
     *
     * @param search   검색DTO
     * @param pageInfo 페이지네이션DTO
     * @return 게시물 목록
     */
    public List<Board> getList(Search search, PageInfo pageInfo){
        //현재 페이지 숫자
        int currentPageNumber = search.getPage();
        //화면에서 보이는 페이지 숫자 개수
        int pageLength = search.getPageLength();
        // 마지막 페이지 숫자
        int lastPageNumber = repository.getListNum() / pageLength;
        System.out.println("마지막 페이지 숫자" + lastPageNumber);
        // 화면에서 보이는 마지막 페이지 숫자
        int rightPageNumber = (currentPageNumber / pageLength + 1) * pageLength;
        // 화면에서 보이는 처음 페이지 숫자
        int leftPageNumber = rightPageNumber - 4;
        // 5개 페이지 다음으로 이동하는 버튼이 보이는 유무
        boolean hasNextButton = currentPageNumber < lastPageNumber - pageLength;
        // 5개 페이지 전으로 이동하는 버튼이 보이는 유무
        boolean hasPrevButton = currentPageNumber > 1 * pageLength;

        pageInfo.setCurrentPageNumber(currentPageNumber);
        pageInfo.setLastPageNumber(lastPageNumber);
        pageInfo.setRightPageNumber(rightPageNumber);
        pageInfo.setLeftPageNumber(leftPageNumber);
        pageInfo.setHasPrevButton(hasPrevButton);
        pageInfo.setHasNextButton(hasNextButton);
        return repository.getList(search);
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
    /**
     * 게시글 수 카운팅
     * @return 게시글 수
     */
    public int getListNum(){
        return repository.getListNum();
    };

    /**
     * 카테고리 전체 조회
     * @return 카테고리 전체 목록
     */
    public List<Category> getCategoryList() {
        return repository.getCategoryList();
    }

}
