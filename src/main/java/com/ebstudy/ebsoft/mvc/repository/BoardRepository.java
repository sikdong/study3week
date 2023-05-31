package com.ebstudy.ebsoft.mvc.repository;

import com.ebstudy.ebsoft.mvc.domain.Board;
import com.ebstudy.ebsoft.mvc.domain.Category;
import com.ebstudy.ebsoft.mvc.domain.Search;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 게시판 repository
 */
@Repository
public interface BoardRepository {
    List<Board> getList(Search search);
    Board get(long boardId);
    void save(Board board);
    void update(Board board);
    void delete(long boardId);

    /**
     * 게시글 수 카운팅
     * @return 게시글 수
     */
    int getListNum(Search search);


    /**
     * 카테고리 전체 조회
     * @return 카테고리 전체 목록
     */
    List<Category> getCategoryList();
}
