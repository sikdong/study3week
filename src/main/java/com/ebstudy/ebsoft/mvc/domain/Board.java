package com.ebstudy.ebsoft.mvc.domain;

import com.ebstudy.ebsoft.mvc.repository.BoardRepository;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;
import java.util.List;

@Data
public class Board {

    private Long boardId;
    private String title;
    private String content;
    private String regDate;
    private String modDate;
    private String writer;
    private String password;
    private int viewCount;
    private Category category;
    private List<Comment> comment;
    private List<File> fileList;

}
