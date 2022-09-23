<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../layout/header.jsp"%>

<div class="container mt-3">
  <h2 style="text-align: center">팀 목록</h2>           
  <table class="table table-bordered">
    <thead>
      <tr>
        <th>포지션</th>
        <th>두산</th>
        <th>nc</th>
        <th>롯데</th>
      </tr>
    </thead>
    <tbody>
   	<c:forEach var="teamPosition" items ="${teamPositionList}">
      <tr>
    	<td>${teamPosition.POSITION}</td>
        <td>${teamPosition.dosan}</td>
        <td>${teamPosition.nc}</td>
        <td>${teamPosition.lotte}</td>
      </tr>
      </c:forEach>
    </tbody>
  </table>
</div>


<%@ include file="../layout/footer.jsp"%>
