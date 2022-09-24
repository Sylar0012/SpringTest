<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../layout/header.jsp"%>

<div class="container mt-3" style="text-align: center;">
	<h2 style="text-align: center">경기장 목록</h2>
	<table class="table table-bordered">
		<thead>
			<tr style="text-align: center;">
				<th>번호</th>
				<th>이름</th>
				<th>개장일</th>
				<th>수정</th>
				<th>삭제</th>
			</tr>
		</thead>
		<tbody>
			<form>
				<c:forEach var="stadium" items="${stadiumList}">
					<tr>
						<td>${stadium.id }</td>
						<td>${stadium.name }</td>
						<td>${stadium.createdAt }</td>
						<td><a href="/stadium/updateForm/${stadium.id}"><i class="fa-solid fa-gears"></i></a></td>
						<td><label> <input id="stadiumId" type="checkbox"
								value="${stadium.id}">
						</label></td>
					</tr>
				</c:forEach>
				<button onclick="getCheckboxValue()" style="float: right; margin-right: 40px;" id="btnDelete"
					type="button" class="btn btn-primary">삭제</button>
				<br />
			</form>
		</tbody>
	</table>
</div>


<%@ include file="../layout/footer.jsp"%>
