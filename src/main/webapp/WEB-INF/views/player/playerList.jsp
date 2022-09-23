<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../layout/header.jsp"%>

<div class="container mt-3">
	<h2 style="text-align: center">선수 목록</h2>
	<table class="table table-bordered">
		<thead>
			<tr>
				<th>번호</th>
				<th>이름</th>
				<th>소속팀</th>
				<th>포지션</th>
				<th>소속일</th>
				<th>수정</th>
				<th>삭제</th>
			</tr>
		</thead>
		<tbody>
			<form>
				<c:forEach var="player" items="${playerList}">
					<tr>
						<td>${player.id }</td>
						<td>${player.name }</td>
						<td>${player.teamname}</td>
						<td>${player.position}</td>
						<td>${player.createdAt }</td>
						<td><a href="/player/updateForm/${player.id}"><i
								class="fa-solid fa-gears"></i></a></td>
						<td><label> <input id="stadiumId" type="checkbox"
								value="${player.id}">
						</label></td>
					</tr>
				</c:forEach>
				<button style="float: right; margin-right: 40px;" id="btnDelete"
					type="button" class="btn btn-primary">삭제</button>
			</form>
		</tbody>

	</table>
</div>

<%@ include file="../layout/footer.jsp"%>
