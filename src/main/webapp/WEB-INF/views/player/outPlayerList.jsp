<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../layout/header.jsp"%>

<div class="container mt-3">
	<h2 style="text-align: center">선수 목록</h2>

	<div class="d-flex justify-content-center">
		<ul class="pagination">
			<a class="page-link" href='/player/outPlayerList/1'>두산</a>
			<a class="page-link" href='/player/outPlayerList/2'>NC</a>
			<a class="page-link" href='/player/outPlayerList/3'>롯데</a>
		</ul>
	</div>
	<br />
	<table class="table table-bordered">
		<thead>
			<tr>
				<th>번호</th>
				<th>소속팀</th>
				<th>포지션</th>
				<th>이름</th>
				<th>사유</th>
				<th>퇴출일</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="outPlayer" items="${outPlayerList}">
				<tr>
					<td>${outPlayer.id }</td>
					<td>${outPlayer.teamname}</td>
					<td>${outPlayer.position}</td>
					<td>${outPlayer.name }</td>
					<td>${outPlayer.reason }</td>
					<td>${outPlayer.createdAt }</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</div>

<%@ include file="../layout/footer.jsp"%>
