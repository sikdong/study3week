<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<style>
    .root {
        margin: 20px 20px 20px 20px !important;
    }
    .searchBox {
        margin : 10px 5px 5px 4px !important;
    }
    .elementHeight {
        height : 80% !important;
    }
    .button {
        width: 100px !important;
    }
</style>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>게시판 목록</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-KK94CHFLLe+nY2dmCWGMq91rCGa5gtU4mk92HdvYe+M/SXH301p5ILy+dN9+nJOZ" crossorigin="anonymous">
</head>
<body>
<c:set value="${pageContext.request.contextPath }" var="path"></c:set>
<h3 class="root">자유 게시판 - 목록</h3>
<form action="" method="post">
    <div class="root" style="border : 1px solid black; display: flex">
        <div class="searchBox" style="height: 100%">등록일</div>
        <input type="date" name="startDate" class="searchBox elementHeight">
        <div class="searchBox">~</div>
        <input type="date" name="endDate" class="searchBox elementHeight">
        <div class="dropdown searchBox elementHeight">
            <button id="selectedCategory" class="btn btn-secondary dropdown-toggle" type="button" data-bs-toggle="dropdown" aria-expanded="false">
                전체 카테고리
            </button>
            <input type="hidden" id="categoryInput" name="category">
            <ul class="dropdown-menu">
                <c:forEach var="category" items="${categoryList}">
                    <li class='dropdown-item' onclick=insertValue(this)>${category.categoryName}</li>
                </c:forEach>
            </ul>
        </div>
        <div class="input-group mb-3 searchBox elementHeight" style="width : 600px !important;">
            <input type="text" name="condition" class="form-control" placeholder="검색어를 입력해 주세요.(제목 + 작성자 + 내용)" aria-label="Recipient's username" aria-describedby="button-addon2">
            <button class="btn btn-outline-secondary" type="submit" id="button-addon2">검색</button>
        </div>
    </div>
</form>
<div>
    총 ${listNum}건
</div>
<table class="table root">
    <thead>
    <tr>
        <th scope="col">카테고리</th>
        <th scope="col">제목</th>
        <th scope="col">작성자</th>
        <th scope="col">조회수</th>
        <th scope="col">등록 일시</th>
        <th scope="col">수정 일시</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="boards" items="${boards}">
        <tr>
            <td>${boards.category.categoryName}</td>
            <td>${boards.title}</td>
            <td>${boards.writer}</td>
            <td>${boards.viewCount}</td>
            <td>${boards.regDate}</td>
            <td>${boards.modDate}</td>
        </tr>
    </c:forEach>
    </tbody>
</table>
<br><br><br>
<div style="text-align: center">
    <c:if test="${pageInfo.leftPageNumber != 1}">
        <a href="">&laquo</a>
    </c:if>
    <a href="">&lt</a>
    <c:forEach var="pageNumber" begin="${pageInfo.leftPageNumber}" end="${pageInfo.rightPageNumber}">
        <a href="">${pageNumber}</a>
    </c:forEach>
    <a href="">&gt</a>
    <c:if test="${pageInfo.rightPageNumber < pageInfo.lastPageNumber}">
        <a href="">&raquo</a>
    </c:if>
</div>
<br><br>
<button onclick="location.href='${path}/boards/write.jsp'" class="btn btn-outline-primary" style="float : right; margin-right : 40px">등록</button>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ENjdO4Dr2bkBIFxQpeoTz1HIcje39Wm4jDKdf19U8gI4ddQ3GYNS7NTKfAdVQSZe" crossorigin="anonymous"></script>
<script>
    function insertValue(element){
        document.querySelector("#selectedCategory").innerHTML = element.innerHTML;
        document.querySelector("#categoryInput").value = element.innerHTML;
    }

</script>
</body>
</html>
