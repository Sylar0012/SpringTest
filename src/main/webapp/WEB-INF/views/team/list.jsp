<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../layout/header.jsp"%>

<div class="container mt-3" style="text-align: center;">
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
			<form>
				<c:forEach var="TeamListDto" items="${teamList}">
					<tr>
						<c:set var="count" value="${count+1}" />
						<td>${count }</td>
						<td>${TeamListDto.stadiumName}</td>
						<td>${TeamListDto.name }</td>
						<td>${TeamListDto.createdAt }</td>
						<td><a href="/team/updateForm/${TeamListDto.id}"><i
								class="fa-solid fa-gears"></i></a></td>
						<td><label> <input id="teamId" type="checkbox"
								value="${TeamListDto.id}">
						</label></td>
					</tr>
				</c:forEach>
				<button style="float: right; margin-right: 40px;" id="btnDelete"
					type="button" class="btn btn-primary">삭제</button>
			</form>
		</tbody>
	</table>
</div>

<script>

$("#btnDelete").click(()=>{
	teamDelete();	
})

function teamDelete(){
	let teamArr = [];
	$("input:checkbox[id='teamId']:checked").each(function() {
		teamArr.push($(this).val()); 
	})
	
	for(let i =0; i<teamArr.length; i++){
		let id = teamArr[i];
		console.log(id);
		
	$.ajax("/team/delete/"+id, {
		type : "DELETE",
		dataType : "json"
	}).done((res) =>{
		if(res.code == 1){
			alert("팀 삭제 성공");
			location.href = "/team/list";
		}
	});
	}
}
</script>

<%@ include file="../layout/footer.jsp"%>
