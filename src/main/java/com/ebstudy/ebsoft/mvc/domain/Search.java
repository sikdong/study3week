package com.ebstudy.ebsoft.mvc.domain;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
public class Search {

    private Integer page;         //현재 페이지 번호
    private Integer recordSize;    //페이지당 출력할 데이터 개수
    private Integer pageLength;     //화면 하단에 출력할 페이지 사이즈
    private String keyword;             //검색 키워드
    private String category;            //검색 카테고리

    public Search(Integer page, Integer recordSize, Integer pageLength) {
        this.page = 1;
        this.recordSize = 5;
        this.pageLength = 5;
    }
    //Limit 쿼리의 처음
    public int getOffset(){
        return (page -1) * recordSize;
    }
}
