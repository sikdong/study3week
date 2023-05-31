package com.ebstudy.ebsoft.mvc.domain;

import com.ebstudy.ebsoft.mvc.repository.BoardRepository;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
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

    //3개를 따로 받다보니 이 방법 밖에 잘 모르겠다...다른 방법이 있나
    private MultipartFile firstFile;
    private MultipartFile secondFile;
    private MultipartFile thirdFile;

    /*public List<MultipartFile> getFileList(MultipartFile firstFile, MultipartFile secondFile, MultipartFile thirdFile){
        List<MultipartFile> fileList = new ArrayList<>();
        fileList.add(firstFile);
        fileList.add(secondFile);
        fileList.add(thirdFile);
        return fileList;
    }
*/
}
