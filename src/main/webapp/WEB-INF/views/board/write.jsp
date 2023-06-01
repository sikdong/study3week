<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
  <style>
    .root {
      margin: 20px 20px 20px 20px !important;
    }
    .borderline {
      border-top: 1px solid black !important;
      border-bottom: 1px solid grey !important;
      display: flex;
    }
    .button {
      width: 100px !important;
    }
    .mlTen {
      margin-left: 10px;
    }
    .green {
      color : green;
    }
    .red {
      color : red;
    }
  </style>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <title>게시판 등록</title>
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-KK94CHFLLe+nY2dmCWGMq91rCGa5gtU4mk92HdvYe+M/SXH301p5ILy+dN9+nJOZ" crossorigin="anonymous">
</head>
<body>
<h3 class="root">게시판 - 등록</h3>
<form action="${paht}/board/save" method="post" enctype="multipart/form-data">
  <div class="root">
    <div class="borderline">
      <div>카테고리 *</div>
      <div>
        <button class="btn btn-secondary dropdown-toggle" id="selectedCategory" type="button" data-bs-toggle="dropdown" aria-expanded="false">
          카테고리 선택
        </button>
        <ul class="dropdown-menu">
          <c:forEach var="category" items="${categoryList}">
            <li><a class="dropdown-item" data-id="${category.categoryId}" onclick="insertValue(this)">${category.categoryName}</a></li>
          </c:forEach>
        </ul>
      </div>
      <input required type="hidden" id="categoryInput" name="categoryNum">
    </div>
    <div class="borderline">
      <div>작성자 *</div>
      <input required type="text" name="writer" minlength="3" maxlength="4">
    </div>
    <div class="borderline" id="confirmMessage">
      <div>비밀번호 *</div>
      <input required type="password" class="password" placeholder="비밀번호" minlength="4" maxlength="15" onchange="checkPassword(this)">
      <input required class="mlTen" class="confirmPassword" onkeyup="confirmPwd(this)" minlength="4" maxlength="15" name="password" type="password" placeholder="비밀번호 확인">
      <p id="message"></p>
    </div>
    <div class="borderline">
      <div>제목 *</div>
      <input type="text" name="title" required minlength="4" maxlength="99">
    </div>
    <div class="borderline">
      <div>내용 *</div>
      <textarea class="content" name="content" required minlength="4" maxlength="1999"></textarea>
    </div>
    <div class="borderline">
      <div>파일 첨부</div>
      <div>
        <input type="file" name="firstFile">
        <input type="file" name="secondFile">
        <input type="file" name="thirdFile">
      </div>
    </div>
  </div>
  <div class="root" style="display: flex; margin-top: 100px !important; justify-content: space-between">
    <button class="button btn btn-outline-secondary" onclick="location.href='/board/list'">취소</button>
    <input type="submit" class="button btn btn-outline-secondary enroll" disabled value="등록"></input>
  </div>
</form>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ENjdO4Dr2bkBIFxQpeoTz1HIcje39Wm4jDKdf19U8gI4ddQ3GYNS7NTKfAdVQSZe" crossorigin="anonymous"></script>
<script>
  function insertValue(element){
    document.querySelector("#selectedCategory").innerHTML = element.innerHTML;
    document.querySelector("#categoryInput").value = element.dataset.id;
  }

  //비밀번호 확인하는 메소드
  function confirmPwd(el){
    let pwd = document.querySelector(".password").value;
    let confirmedPwd = el.value;
    let message = document.querySelector("#message");
    if(confirmedPwd === pwd){
      message.style.color ="green";
      message.innerHTML = "비밀번호가 일치합니다"
      document.querySelector(".enroll").disabled=false;
    } else {
      message.style.color="red";
      message.innerHTML = "비밀번호가 일치하지 않습니다"
      document.querySelector(".enroll").disabled=true;
    }
    document.querySelector('#confirmMessage').appendChild(message);
  }

  function checkPassword(password) {
    if (!/^(?=.*[a-zA-Z])(?=.*[!@#$%^*+=-])(?=.*[0-9]).{4,25}$/.test(password.value)) {
      alert('숫자+영문자+특수문자 조합으로 4자리 이상 사용해야 합니다.');
      document.querySelector(".password").value="";
      document.querySelector(".password").value.focus();
      return false;
    }
  }

const form = document.querySelector('form');
  form.addEventListener("submit", (event) => {
    if(document.querySelector('input[name="category"]').value ===""){
      event.preventDefault();
      alert('카테고리를 선택해주세요');
    }
  });

  //게시물 등록 메소드
/*  document.querySelector(".enroll").addEventListener("click", function(){
    let category = document.querySelector("#categoryInput").value;
    let writer = document.querySelector('input[name="writer"]').value;
    let password = document.querySelector('input[name="password"]').value;
    let title = document.querySelector('input[name="title"]').value;
    let content = document.querySelector('.content').value;
    const files = [];
    document.querySelectorAll('input[name="fileName"]').forEach((e) => {
      files.push(e.value)
    });
    const data = {
      category,
      writer,
      password,
      title,
      content,
      files
    }
    fetch("${page}/board/save", {
      method : "POST",
      headers : {
        "Content-Type" : false
      },
      body : JSON.stringify(data)
    })
  })*/
</script>
</body>
</html>
