package com.ebstudy.ebsoft.mvc.repository;

import com.ebstudy.ebsoft.mvc.domain.Board;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 게시판 repository
 */
@Repository
public interface BoardRepository {
    List<Board> getList();
    Board get(long boardId);
    void save(Board board);
    void update(Board board);
    void delete(long boardId);



}
