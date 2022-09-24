<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../layout/header.jsp"%>

<div class="container mt-3" style="text-align: center;">
	<h2 style="text-align: center">선수 목록</h2>

	<div class="d-flex justify-content-center">
		<ul class="pagination">
			<a  class="page-link" href="/outPlayer/list/1">두산</a>
		<a  class="page-link" href="/outPlayer/list/2">NC</a>
		<a  class="page-link" href="/outPlayer/list/3">롯데</a>
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
					<c:set var ="count" value="${count+1}"/>
					<td>${count }</td>
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


<script>
$("#btnDusan").click(()=>{

	dosanOutPlayerList();
})

function dosanOutPlayerList(){
	
	$.ajax("/player/outPlayerList/"+id, {
		type: "POST",
		dataType: "json"
	}).done((res) => {
		if (res.code == 1) {
			renderLoves();
			let count = $("#countLove").text();
			$("#countLove").text(Number(count) + 1);
			$("#lovesId").val(res.data.id);
		} else {
			alert("좋아요 실패했습니다");
		}
	});
}
</script>
<%@ include file="../layout/footer.jsp"%>
