package com.ebstudy.ebsoft.mvc.domain;

import lombok.Data;

@Data
public class FileUnit {
    private Long boardId;
    private Long fileId;
    private String fileOriginPath;
    private String fileName;
}
