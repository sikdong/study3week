package com.ebstudy.ebsoft.mvc.domain;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class Comment {
    private Long commentId;
    private String comment;
    private String regDate;
    private String modDate;
}
