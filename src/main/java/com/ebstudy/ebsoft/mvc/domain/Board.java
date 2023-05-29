package com.ebstudy.ebsoft.mvc.domain;

import lombok.Builder;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class Board {
    private Long boardId;
    private String title;
    private String content;
    private Date regDate;
    private String modDate;
    private String writer;
    private String password;
    private int view_count;
    private Category category;
    private List<Comment> comment;
    private List<File> fileList;
}
