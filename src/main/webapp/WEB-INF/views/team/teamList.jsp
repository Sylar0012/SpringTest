<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../layout/header.jsp"%>

<div class="container mt-3">
  <h2 style="text-align: center">팀 목록</h2>           
  <table class="table table-bordered">
    <thead>
      <tr>
        <th>번호</th>
        <th>경기장 이름</th>
        <th>팀 이름</th>
        <th>개장일</th>
        <th>수정</th>
        <th>삭제</th>
      </tr>
    </thead>
    <tbody>
   	<c:forEach var="TeamListDto" items ="${teamList}">
      <tr>
        <td>${TeamListDto.id}</td>
        <td>${TeamListDto.stadiumName}</td>
        <td>${TeamListDto.name }</td>
        <td>${TeamListDto.createdAt }</td>
        <td>-</td>
        <td>-</td>
      </tr>
      </c:forEach>
    </tbody>
  </table>
</div>

<%@ include file="../layout/footer.jsp"%>
