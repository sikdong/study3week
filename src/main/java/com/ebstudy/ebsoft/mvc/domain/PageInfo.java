package com.ebstudy.ebsoft.mvc.domain;

import lombok.Builder;
import lombok.Data;


@Data
public class PageInfo {
    private Integer currentPageNumber;
    private Boolean hasPrevButton;
    private Boolean hasNextButton;
    private Integer lastPageNumber;
    private Integer firstPageNumber;
    private Integer rightPageNumber;
    private Integer leftPageNumber;

    @Builder
    public PageInfo(Integer currentPageNumber, Boolean hasPrevButton, Boolean hasNextButton, Integer lastPageNumber, Integer firstPageNumber, Integer rightPageNumber, Integer leftPageNumber) {
        this.currentPageNumber = currentPageNumber;
        this.hasPrevButton = hasPrevButton;
        this.hasNextButton = hasNextButton;
        this.lastPageNumber = lastPageNumber;
        this.firstPageNumber = firstPageNumber;
        this.rightPageNumber = rightPageNumber;
        this.leftPageNumber = leftPageNumber;
    }



}
