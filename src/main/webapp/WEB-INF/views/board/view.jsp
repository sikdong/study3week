<%--
  Created by IntelliJ IDEA.
  User: Dongseok
  Date: 2023-05-14
  Time: 오후 11:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <title>게시판 보기</title>
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-KK94CHFLLe+nY2dmCWGMq91rCGa5gtU4mk92HdvYe+M/SXH301p5ILy+dN9+nJOZ" crossorigin="anonymous">
</head>
<body>
<h3 class="root">게시판 - 보기</h3>
  <div class="root">
    <div class="borderline">
      <div>카테고리 *</div>
      <div>
        ${board.category.categoryName}
      </div>
      <input required type="hidden" id="categoryInput" name="categoryNum">
    </div>
    <div class="borderline">
      <div>작성자 *</div>
      <input required value="${board.writer}" type="text" name="writer" minlength="3" maxlength="4">
    </div>
    <div class="borderline" id="confirmMessage">
      <div>비밀번호 *</div>
      <input require type="password" class="password" placeholder="비밀번호" minlength="4" maxlength="15" onchange="checkPassword(this)">
      <input required class="mlTen" class="confirmPassword" onkeyup="confirmPwd(this)" minlength="4" maxlength="15" name="password" type="password" placeholder="비밀번호 확인">
      <p id="message"></p>
    </div>
    <div class="borderline">
      <div>제목 *</div>
      <input type="text" value="${board.title}"name="title" required minlength="4" maxlength="99">
    </div>
    <div class="borderline">
      <div>내용 *</div>
      <textarea class="content" name="content" required minlength="4" maxlength="1999">${board.content}</textarea>
    </div>
    <div class="borderline">
      <div>파일 첨부</div>
        <c:forEach var="file" items="${board.fileUnits}">
          <c:url var="downloadLink" value="${path}/board/fileDownload">
            <c:param name="fileUuidName" value="${file.fileUuidName}"></c:param>
          </c:url>
          <div>${file.fileName}</div>
          <a href="${downloadLink}">파일 다운로드</a>
        </c:forEach>
    </div>
  </div>
  <div class="root" style="display: flex; margin-top: 100px !important; justify-content: space-between">
    <button class="button btn btn-outline-secondary" onclick="location.href='/board/list'">취소</button>
    <button>수정</button>
    <button>삭제</button>
  </div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ENjdO4Dr2bkBIFxQpeoTz1HIcje39Wm4jDKdf19U8gI4ddQ3GYNS7NTKfAdVQSZe" crossorigin="anonymous"></script>
</body>
</html>
