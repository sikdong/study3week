package com.ebstudy.ebsoft.mvc.service;

import com.ebstudy.ebsoft.mvc.domain.*;
import com.ebstudy.ebsoft.mvc.repository.BoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
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
     * @param search   검색 DTO
     * @param pageInfo 페이지네이션 위한 도메인
     * @return 게시물 목록
     */
    public List<Board> getList(Search search, PageInfo pageInfo){
        //현재 페이지 숫자
        int currentPageNumber = search.getPage();

        //화면에 보이는 페이지 개수, default = 5
        int pageLength = search.getPageLength();

        //검색 조건에 맞는 게시물 수
        int boardNum = repository.getListNum(search);

        // 총 건수의 맨 마지막 페이지 숫자
        int lastPageNumber;
        if(boardNum % pageLength == 0){
            lastPageNumber = boardNum / pageLength;
        } else {
            lastPageNumber = boardNum / pageLength + 1;
        }


        // 화면에서 보이는 마지막 페이지 숫자
        double rightPageNumber = Math.ceil((double)currentPageNumber / pageLength) * 5;
        if(rightPageNumber > lastPageNumber){
            rightPageNumber = lastPageNumber;
        }

        // 화면에서 보이는 처음 페이지 숫자
        int leftPageNumber;
        if(currentPageNumber % pageLength == 0){
            leftPageNumber = currentPageNumber - pageLength + 1  ;
        } else {
            leftPageNumber = (currentPageNumber / pageLength * pageLength) + 1;
        }

        // 5개 페이지 다음으로 이동하는 버튼이 보이는 유무
        boolean hasNextButton = currentPageNumber < lastPageNumber - pageLength;

        // 5개 페이지 전으로 이동하는 버튼이 보이는 유무
        boolean hasPrevButton = currentPageNumber > pageLength;

        //이전에는 빌더로 구축했으나 model로 값을 받지 못해서 setter 로 바꿈

        pageInfo.setCurrentPageNumber(currentPageNumber);
        pageInfo.setLastPageNumber(lastPageNumber);
        pageInfo.setRightPageNumber(rightPageNumber);
        pageInfo.setLeftPageNumber(leftPageNumber);
        pageInfo.setHasPrevButton(hasPrevButton);
        pageInfo.setHasNextButton(hasNextButton);

        return repository.getList(search);
    }
    public Board get(long boardId) {
        return repository.get(boardId);
    }
    public void save(Board board) {
        String uploadFolder = "C:\\upload";
        File folder = new File(uploadFolder, getFolder());
        if(!folder.exists()){
            folder.mkdir();
        }
        transferToFile(uploadFolder, board.getFirstFile());
        transferToFile(uploadFolder, board.getSecondFile());
        transferToFile(uploadFolder, board.getThirdFile());

        repository.save(board);
    }

    /**
     * 업로드 된 파일 저장하는 메소드
     * @param path 파일 저장하는 경로
     * @param file 업로드 된 파일
     */
    public void transferToFile(String path, MultipartFile file){
        //파일 null 체크
        if(!file.isEmpty()){
            File saveFile = new File(path, file.getOriginalFilename());
            try {
                file.transferTo(saveFile);
            }catch (Exception e){
                e.printStackTrace();
            }
        } else {
            return;
        }
    }

    /**
     * 파일 경로에 년/월/일 포함하는 파일 경로 생성
     * @return 년\\월\\일
     */
    public String getFolder() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date date = new Date(0);
        String str = sdf.format(date);
        return str.replace("-", File.separator);
    }
    public void update(Board board) {
        repository.update(board);
    }
    public void delete(long boardId) {
        repository.delete(boardId);
    }
    /**
     * 게시글 수 카운팅
     * @return 게시글 수
     */
    public int getListNum(Search search){
        return repository.getListNum(search);
    }

    /**
     * 카테고리 전체 조회
     * @return 카테고리 전체 목록
     */
    public List<Category> getCategoryList() {
        return repository.getCategoryList();
    }

}
